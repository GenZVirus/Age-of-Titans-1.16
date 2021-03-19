package com.GenZVirus.AgeOfTitans.Common.Events.Client.SDW;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Network.PacketHandlerCommon;
import com.GenZVirus.AgeOfTitans.Common.Network.SDW.SendPlayerHandPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
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

	public static Boolean left = false;
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
		if (!(player.getHeldItemOffhand().getItem() instanceof TieredItem)) { return; }
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

	@SubscribeEvent
	public static void tick(ClientTickEvent event) {
		if (event.phase == Phase.START)
			return;
		if (firstPersonRenderer == null)
			return;
		firstPersonRenderer.prevEquippedProgressMainHand = equippedProgressMainHand;
		firstPersonRenderer.prevEquippedProgressOffHand = equippedProgressOffHand;
		ClientPlayerEntity clientplayerentity = mc.player;
		if(clientplayerentity == null) return;
		ItemStack itemstack = clientplayerentity.getHeldItemMainhand();
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

			if (left) {
				equippedProgressMainHand += MathHelper.clamp((!requipM ? f * f * f : 0.0F) - equippedProgressMainHand, -0.4F, 0.4F);
				equippedProgressOffHand += MathHelper.clamp((!requipO ? 1 : 0.0F) - equippedProgressOffHand, -0.4F, 0.4F);
			} else {
				equippedProgressMainHand += MathHelper.clamp((!requipM ? 1 : 0.0F) - equippedProgressMainHand, -0.4F, 0.4F);
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
		init();
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

}
