package com.GenZVirus.AgeOfTitans.Client.Events.SDW;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;
import com.GenZVirus.AgeOfTitans.Common.Network.PacketHandlerCommon;
import com.GenZVirus.AgeOfTitans.Common.Network.SDW.SendPlayerHandPacket;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent.ClickInputEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class DualWieldingEventsHandler {

	public static boolean switcher = false;

	public static boolean left = false;
	public static Minecraft mc = Minecraft.getInstance();
	public static ItemStack itemStackOffHand;
	public static ItemStack itemStackMainHand;
	public static EntityRendererManager renderManager;
	public static ItemRenderer itemRenderer;
	public static RenderType MAP_BACKGROUND;
	public static RenderType MAP_BACKGROUND_CHECKERBOARD;
	public static FirstPersonRenderer firstPersonRenderer;
	private static float equippedProgressMainHand;
	private static float equippedProgressOffHand;

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void swingLeftHand(ClickInputEvent event) {
		if (!event.isAttack())
			return;
		PlayerEntity player = Minecraft.getInstance().player;
		if (player.getHeldItemOffhand().isEmpty()) {
			return;
		}
		if (left) {
			event.setSwingHand(false);
			player.swingArm(Hand.OFF_HAND);
			PacketHandlerCommon.INSTANCE.sendToServer(new SendPlayerHandPacket(player.getUniqueID(), 1));
			left = false;
		} else {
			PacketHandlerCommon.INSTANCE.sendToServer(new SendPlayerHandPacket(player.getUniqueID(), 0));
			left = true;
		}
	}

	public static void renderItemSide(LivingEntity livingEntityIn, ItemStack itemStackIn, ItemCameraTransforms.TransformType transformTypeIn, boolean leftHand, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn) {
		if (!itemStackIn.isEmpty()) {
			itemRenderer.renderItem(livingEntityIn, itemStackIn, transformTypeIn, leftHand, matrixStackIn, bufferIn, livingEntityIn.world, combinedLightIn, OverlayTexture.NO_OVERLAY);
		}
	}

	/**
	 * Return the angle to render the Map
	 */
	private static float getMapAngleFromPitch(float pitch) {
		float f = 1.0F - pitch / 45.0F + 0.1F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		return -MathHelper.cos(f * (float) Math.PI) * 0.5F + 0.5F;
	}

	private static void renderArm(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, HandSide side) {
		mc.getTextureManager().bindTexture(mc.player.getLocationSkin());
		PlayerRenderer playerrenderer = (PlayerRenderer) renderManager.<AbstractClientPlayerEntity>getRenderer(mc.player);
		matrixStackIn.push();
		float f = side == HandSide.RIGHT ? 1.0F : -1.0F;
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(92.0F));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(45.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f * -41.0F));
		matrixStackIn.translate((double) (f * 0.3F), (double) -1.1F, (double) 0.45F);
		if (side == HandSide.RIGHT) {
			playerrenderer.renderRightArm(matrixStackIn, bufferIn, combinedLightIn, mc.player);
		} else {
			playerrenderer.renderLeftArm(matrixStackIn, bufferIn, combinedLightIn, mc.player);
		}

		matrixStackIn.pop();
	}

	private static void renderMapFirstPersonSide(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, float equippedProgress, HandSide handIn, float swingProgress,
			ItemStack stack) {
		float f = handIn == HandSide.RIGHT ? 1.0F : -1.0F;
		matrixStackIn.translate((double) (f * 0.125F), -0.125D, 0.0D);
		if (!mc.player.isInvisible()) {
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f * 10.0F));
			renderArmFirstPerson(matrixStackIn, bufferIn, combinedLightIn, equippedProgress, swingProgress, handIn);
			matrixStackIn.pop();
		}

		matrixStackIn.push();
		matrixStackIn.translate((double) (f * 0.51F), (double) (-0.08F + equippedProgress * -1.2F), -0.75D);
		float f1 = MathHelper.sqrt(swingProgress);
		float f2 = MathHelper.sin(f1 * (float) Math.PI);
		float f3 = -0.5F * f2;
		float f4 = 0.4F * MathHelper.sin(f1 * ((float) Math.PI * 2F));
		float f5 = -0.3F * MathHelper.sin(swingProgress * (float) Math.PI);
		matrixStackIn.translate((double) (f * f3), (double) (f4 - 0.3F * f2), (double) f5);
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f2 * -45.0F));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f * f2 * -30.0F));
		renderMapFirstPerson(matrixStackIn, bufferIn, combinedLightIn, stack);
		matrixStackIn.pop();
	}

	private static void renderMapFirstPerson(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, float pitch, float equippedProgress, float swingProgress) {
		float f = MathHelper.sqrt(swingProgress);
		float f1 = -0.2F * MathHelper.sin(swingProgress * (float) Math.PI);
		float f2 = -0.4F * MathHelper.sin(f * (float) Math.PI);
		matrixStackIn.translate(0.0D, (double) (-f1 / 2.0F), (double) f2);
		float f3 = getMapAngleFromPitch(pitch);
		matrixStackIn.translate(0.0D, (double) (0.04F + equippedProgress * -1.2F + f3 * -0.5F), (double) -0.72F);
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f3 * -85.0F));
		if (!mc.player.isInvisible()) {
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
			renderArm(matrixStackIn, bufferIn, combinedLightIn, HandSide.RIGHT);
			renderArm(matrixStackIn, bufferIn, combinedLightIn, HandSide.LEFT);
			matrixStackIn.pop();
		}

		float f4 = MathHelper.sin(f * (float) Math.PI);
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f4 * 20.0F));
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
		renderMapFirstPerson(matrixStackIn, bufferIn, combinedLightIn, itemStackMainHand);
	}

	private static void renderMapFirstPerson(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, ItemStack stack) {
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
		matrixStackIn.scale(0.38F, 0.38F, 0.38F);
		matrixStackIn.translate(-0.5D, -0.5D, 0.0D);
		matrixStackIn.scale(0.0078125F, 0.0078125F, 0.0078125F);
		MapData mapdata = FilledMapItem.getMapData(stack, mc.world);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(mapdata == null ? MAP_BACKGROUND : MAP_BACKGROUND_CHECKERBOARD);
		Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
		ivertexbuilder.pos(matrix4f, -7.0F, 135.0F, 0.0F).color(255, 255, 255, 255).tex(0.0F, 1.0F).lightmap(combinedLightIn).endVertex();
		ivertexbuilder.pos(matrix4f, 135.0F, 135.0F, 0.0F).color(255, 255, 255, 255).tex(1.0F, 1.0F).lightmap(combinedLightIn).endVertex();
		ivertexbuilder.pos(matrix4f, 135.0F, -7.0F, 0.0F).color(255, 255, 255, 255).tex(1.0F, 0.0F).lightmap(combinedLightIn).endVertex();
		ivertexbuilder.pos(matrix4f, -7.0F, -7.0F, 0.0F).color(255, 255, 255, 255).tex(0.0F, 0.0F).lightmap(combinedLightIn).endVertex();
		if (mapdata != null) {
			mc.gameRenderer.getMapItemRenderer().renderMap(matrixStackIn, bufferIn, mapdata, false, combinedLightIn);
		}

	}

	private static void renderArmFirstPerson(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, float equippedProgress, float swingProgress, HandSide side) {
		boolean flag = side != HandSide.LEFT;
		float f = flag ? 1.0F : -1.0F;
		float f1 = MathHelper.sqrt(swingProgress);
		float f2 = -0.3F * MathHelper.sin(f1 * (float) Math.PI);
		float f3 = 0.4F * MathHelper.sin(f1 * ((float) Math.PI * 2F));
		float f4 = -0.4F * MathHelper.sin(swingProgress * (float) Math.PI);
		matrixStackIn.translate((double) (f * (f2 + 0.64000005F)), (double) (f3 + -0.6F + equippedProgress * -0.6F), (double) (f4 + -0.71999997F));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f * 45.0F));
		float f5 = MathHelper.sin(swingProgress * swingProgress * (float) Math.PI);
		float f6 = MathHelper.sin(f1 * (float) Math.PI);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f * f6 * 70.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f * f5 * -20.0F));
		AbstractClientPlayerEntity abstractclientplayerentity = mc.player;
		mc.getTextureManager().bindTexture(abstractclientplayerentity.getLocationSkin());
		matrixStackIn.translate((double) (f * -1.0F), (double) 3.6F, 3.5D);
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f * 120.0F));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(200.0F));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f * -135.0F));
		matrixStackIn.translate((double) (f * 5.6F), 0.0D, 0.0D);
		PlayerRenderer playerrenderer = (PlayerRenderer) renderManager.<AbstractClientPlayerEntity>getRenderer(abstractclientplayerentity);
		if (flag) {
			playerrenderer.renderRightArm(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity);
		} else {
			playerrenderer.renderLeftArm(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity);
		}

	}

	private static void transformEatFirstPerson(MatrixStack matrixStackIn, float partialTicks, HandSide handIn, ItemStack stack) {
		float f = (float) mc.player.getItemInUseCount() - partialTicks + 1.0F;
		float f1 = f / (float) stack.getUseDuration();
		if (f1 < 0.8F) {
			float f2 = MathHelper.abs(MathHelper.cos(f / 4.0F * (float) Math.PI) * 0.1F);
			matrixStackIn.translate(0.0D, (double) f2, 0.0D);
		}

		float f3 = 1.0F - (float) Math.pow((double) f1, 27.0D);
		int i = handIn == HandSide.RIGHT ? 1 : -1;
		matrixStackIn.translate((double) (f3 * 0.6F * (float) i), (double) (f3 * -0.5F), (double) (f3 * 0.0F));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) i * f3 * 90.0F));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f3 * 10.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) i * f3 * 30.0F));
	}

	private static void transformFirstPerson(MatrixStack matrixStackIn, HandSide handIn, float swingProgress) {
		int i = handIn == HandSide.RIGHT ? 1 : -1;
		float f = MathHelper.sin(swingProgress * swingProgress * (float) Math.PI);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) i * (45.0F + f * -20.0F)));
		float f1 = MathHelper.sin(MathHelper.sqrt(swingProgress) * (float) Math.PI);
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) i * f1 * -20.0F));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f1 * -80.0F));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) i * -45.0F));
	}

	private static void transformSideFirstPerson(MatrixStack matrixStackIn, HandSide handIn, float equippedProg) {
		int i = handIn == HandSide.RIGHT ? 1 : -1;
		matrixStackIn.translate((double) ((float) i * 0.56F), (double) (-0.52F + equippedProg * -0.6F), (double) -0.72F);
	}

	@SuppressWarnings("incomplete-switch")
	private static void renderItemInFirstPerson(AbstractClientPlayerEntity player, float partialTicks, float pitch, Hand handIn, float swingProgress, ItemStack stack, float equippedProgress,
			MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn) {
		boolean flag = handIn == Hand.MAIN_HAND;
		HandSide handside = flag ? player.getPrimaryHand() : player.getPrimaryHand().opposite();
		matrixStackIn.push();
		if (stack.isEmpty()) {
			if (flag && !player.isInvisible()) {
				renderArmFirstPerson(matrixStackIn, bufferIn, combinedLightIn, equippedProgress, swingProgress, handside);
			}
		} else if (stack.getItem() instanceof FilledMapItem) {
			if (flag && itemStackOffHand.isEmpty()) {
				renderMapFirstPerson(matrixStackIn, bufferIn, combinedLightIn, pitch, equippedProgress, swingProgress);
			} else {
				renderMapFirstPersonSide(matrixStackIn, bufferIn, combinedLightIn, equippedProgress, handside, swingProgress, stack);
			}
		} else if (stack.getItem() instanceof CrossbowItem) {
			boolean flag1 = CrossbowItem.isCharged(stack);
			boolean flag2 = handside == HandSide.RIGHT;
			int i = flag2 ? 1 : -1;
			if (player.isHandActive() && player.getItemInUseCount() > 0 && player.getActiveHand() == handIn) {
				transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
				matrixStackIn.translate((double) ((float) i * -0.4785682F), (double) -0.094387F, (double) 0.05731531F);
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-11.935F));
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) i * 65.3F));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) i * -9.785F));
				float f9 = (float) stack.getUseDuration() - ((float) mc.player.getItemInUseCount() - partialTicks + 1.0F);
				float f13 = f9 / (float) CrossbowItem.getChargeTime(stack);
				if (f13 > 1.0F) {
					f13 = 1.0F;
				}

				if (f13 > 0.1F) {
					float f16 = MathHelper.sin((f9 - 0.1F) * 1.3F);
					float f3 = f13 - 0.1F;
					float f4 = f16 * f3;
					matrixStackIn.translate((double) (f4 * 0.0F), (double) (f4 * 0.004F), (double) (f4 * 0.0F));
				}

				matrixStackIn.translate((double) (f13 * 0.0F), (double) (f13 * 0.0F), (double) (f13 * 0.04F));
				matrixStackIn.scale(1.0F, 1.0F, 1.0F + f13 * 0.2F);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) i * 45.0F));
			} else {
				float f = -0.4F * MathHelper.sin(MathHelper.sqrt(swingProgress) * (float) Math.PI);
				float f1 = 0.2F * MathHelper.sin(MathHelper.sqrt(swingProgress) * ((float) Math.PI * 2F));
				float f2 = -0.2F * MathHelper.sin(swingProgress * (float) Math.PI);
				matrixStackIn.translate((double) ((float) i * f), (double) f1, (double) f2);
				transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
				transformFirstPerson(matrixStackIn, handside, swingProgress);
				if (flag1 && swingProgress < 0.001F) {
					matrixStackIn.translate((double) ((float) i * -0.641864F), 0.0D, 0.0D);
					matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) i * 10.0F));
				}
			}

			renderItemSide(player, stack, flag2 ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !flag2, matrixStackIn,
					bufferIn, combinedLightIn);
		} else {
			boolean flag3 = handside == HandSide.RIGHT;
			if (player.isHandActive() && player.getItemInUseCount() > 0 && player.getActiveHand() == handIn) {
				int k = flag3 ? 1 : -1;
				switch (stack.getUseAction()) {
				case NONE:
					transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
					break;
				case EAT:
				case DRINK:
					transformEatFirstPerson(matrixStackIn, partialTicks, handside, stack);
					transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
					break;
				case BLOCK:
					transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
					break;
				case BOW:
					transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
					matrixStackIn.translate((double) ((float) k * -0.2785682F), (double) 0.18344387F, (double) 0.15731531F);
					matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-13.935F));
					matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) k * 35.3F));
					matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) k * -9.785F));
					float f8 = (float) stack.getUseDuration() - ((float) mc.player.getItemInUseCount() - partialTicks + 1.0F);
					float f12 = f8 / 20.0F;
					f12 = (f12 * f12 + f12 * 2.0F) / 3.0F;
					if (f12 > 1.0F) {
						f12 = 1.0F;
					}

					if (f12 > 0.1F) {
						float f15 = MathHelper.sin((f8 - 0.1F) * 1.3F);
						float f18 = f12 - 0.1F;
						float f20 = f15 * f18;
						matrixStackIn.translate((double) (f20 * 0.0F), (double) (f20 * 0.004F), (double) (f20 * 0.0F));
					}

					matrixStackIn.translate((double) (f12 * 0.0F), (double) (f12 * 0.0F), (double) (f12 * 0.04F));
					matrixStackIn.scale(1.0F, 1.0F, 1.0F + f12 * 0.2F);
					matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) k * 45.0F));
					break;
				case SPEAR:
					transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
					matrixStackIn.translate((double) ((float) k * -0.5F), (double) 0.7F, (double) 0.1F);
					matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-55.0F));
					matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) k * 35.3F));
					matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) k * -9.785F));
					float f7 = (float) stack.getUseDuration() - ((float) mc.player.getItemInUseCount() - partialTicks + 1.0F);
					float f11 = f7 / 10.0F;
					if (f11 > 1.0F) {
						f11 = 1.0F;
					}

					if (f11 > 0.1F) {
						float f14 = MathHelper.sin((f7 - 0.1F) * 1.3F);
						float f17 = f11 - 0.1F;
						float f19 = f14 * f17;
						matrixStackIn.translate((double) (f19 * 0.0F), (double) (f19 * 0.004F), (double) (f19 * 0.0F));
					}

					matrixStackIn.translate(0.0D, 0.0D, (double) (f11 * 0.2F));
					matrixStackIn.scale(1.0F, 1.0F, 1.0F + f11 * 0.2F);
					matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) k * 45.0F));
				}
			} else if (player.isSpinAttacking()) {
				transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
				int j = flag3 ? 1 : -1;
				matrixStackIn.translate((double) ((float) j * -0.4F), (double) 0.8F, (double) 0.3F);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) j * 65.0F));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) j * -85.0F));
			} else {
				float f5 = -0.4F * MathHelper.sin(MathHelper.sqrt(swingProgress) * (float) Math.PI);
				float f6 = 0.2F * MathHelper.sin(MathHelper.sqrt(swingProgress) * ((float) Math.PI * 2F));
				float f10 = -0.2F * MathHelper.sin(swingProgress * (float) Math.PI);
				int l = flag3 ? 1 : -1;
				matrixStackIn.translate((double) ((float) l * f5), (double) f6, (double) f10);
				transformSideFirstPerson(matrixStackIn, handside, equippedProgress);
				transformFirstPerson(matrixStackIn, handside, swingProgress);
			}

			renderItemSide(player, stack, flag3 ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !flag3, matrixStackIn,
					bufferIn, combinedLightIn);
		}

		matrixStackIn.pop();
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent event) {
		if (event.phase == Phase.START)
			return;
		if (firstPersonRenderer == null)
			return;
		firstPersonRenderer.prevEquippedProgressMainHand = equippedProgressMainHand;
		firstPersonRenderer.prevEquippedProgressOffHand = equippedProgressOffHand;
		ClientPlayerEntity clientplayerentity = mc.player;
		if (clientplayerentity == null)
			return;
		ItemStack itemstack = clientplayerentity.getHeldItemMainhand();
		if (mc.player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_HEART.get())) {
			itemstack = Items.AIR.getDefaultInstance();
		}
		ItemStack itemstack1 = clientplayerentity.getHeldItemOffhand();
		if (ItemStack.areItemStacksEqual(itemStackMainHand, itemstack)) {
			itemStackMainHand = itemstack;
		}

		if (ItemStack.areItemStacksEqual(itemStackOffHand, itemstack1)) {
			itemStackOffHand = itemstack1;
		}

		if (clientplayerentity.isRowingBoat()) {
			equippedProgressMainHand = MathHelper.clamp(equippedProgressMainHand - 0.4F, 0.0F, 1.0F);
			equippedProgressOffHand = MathHelper.clamp(equippedProgressOffHand - 0.4F, 0.0F, 1.0F);
		} else {
			float f = clientplayerentity.getCooledAttackStrength(1.0F);
			boolean requipM = net.minecraftforge.client.ForgeHooksClient.shouldCauseReequipAnimation(itemStackMainHand, itemstack, clientplayerentity.inventory.currentItem);
			boolean requipO = net.minecraftforge.client.ForgeHooksClient.shouldCauseReequipAnimation(itemStackOffHand, itemstack1, -1);

			if (!requipM && itemStackMainHand != itemstack)
				itemStackMainHand = itemstack;
			if (!requipO && itemStackOffHand != itemstack1)
				itemStackOffHand = itemstack1;

//			float test = mc.player.getCooledAttackStrength(1.0F) * mc.player.getCooldownPeriod();
			if (left) {
				equippedProgressMainHand += MathHelper.clamp((!requipM ? f * f * f : 0.0F) - equippedProgressMainHand, -0.4F, 0.4F);
				equippedProgressOffHand += MathHelper.clamp((!requipO ? 1.0F : 0.0F) - equippedProgressOffHand, -0.4F, 0.4F);
			} else {
				equippedProgressMainHand += MathHelper.clamp((!requipM ? 1.0F : 0.0F) - equippedProgressMainHand, -0.4F, 0.4F);
				equippedProgressOffHand += MathHelper.clamp((!requipO ? f * f * f : 0.0F) - equippedProgressOffHand, -0.4F, 0.4F);
			}

		}

		if (equippedProgressMainHand < 0.1F) {
			itemStackMainHand = itemstack;
		}

		if (equippedProgressOffHand < 0.1F) {
			itemStackOffHand = itemstack1;
		}

		firstPersonRenderer.equippedProgressMainHand = equippedProgressMainHand;
		firstPersonRenderer.equippedProgressOffHand = equippedProgressOffHand;

	}

	@SubscribeEvent(receiveCanceled = true)
	public static void RenderHands(RenderHandEvent event) {
		event.setCanceled(true);
		if (mc.player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_HEART.get())) {
			initEmptyHand();
		} else {
			init();
		}
		if (event.getHand() == Hand.MAIN_HAND)
			renderItemInFirstPerson(mc.player, event.getPartialTicks(), event.getInterpolatedPitch(), Hand.MAIN_HAND, event.getSwingProgress(), itemStackMainHand, event.getEquipProgress(),
					event.getMatrixStack(), event.getBuffers(), event.getLight());
		if (event.getHand() == Hand.OFF_HAND)
			renderItemInFirstPerson(mc.player, event.getPartialTicks(), event.getInterpolatedPitch(), Hand.OFF_HAND, event.getSwingProgress(), itemStackOffHand, event.getEquipProgress(),
					event.getMatrixStack(), event.getBuffers(), event.getLight());
	}

	private static void init() {
		itemStackOffHand = mc.player.getHeldItemOffhand();
		itemStackMainHand = mc.player.getHeldItemMainhand();
		renderManager = mc.getRenderManager();
		itemRenderer = mc.getItemRenderer();
		MAP_BACKGROUND = RenderType.getText(new ResourceLocation("textures/map/map_background.png"));
		MAP_BACKGROUND_CHECKERBOARD = RenderType.getText(new ResourceLocation("textures/map/map_background_checkerboard.png"));
		firstPersonRenderer = mc.getFirstPersonRenderer();
	}

	private static void initEmptyHand() {
		itemStackOffHand = mc.player.getHeldItemOffhand();
		itemStackMainHand = Items.AIR.getDefaultInstance();
		renderManager = mc.getRenderManager();
		itemRenderer = mc.getItemRenderer();
		MAP_BACKGROUND = RenderType.getText(new ResourceLocation("textures/map/map_background.png"));
		MAP_BACKGROUND_CHECKERBOARD = RenderType.getText(new ResourceLocation("textures/map/map_background_checkerboard.png"));
		firstPersonRenderer = mc.getFirstPersonRenderer();
	}

}
