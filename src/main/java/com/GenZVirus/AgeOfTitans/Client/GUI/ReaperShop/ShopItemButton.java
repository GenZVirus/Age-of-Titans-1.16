package com.GenZVirus.AgeOfTitans.Client.GUI.ReaperShop;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.PricedItem;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class ShopItemButton extends Widget {

	public ResourceLocation BUTTON = new ResourceLocation(AgeOfTitans.MOD_ID, "textures/gui/shop_item_button.png");
	public ResourceLocation BUTTON_HOVER = new ResourceLocation(AgeOfTitans.MOD_ID, "textures/gui/shop_item_button_hover.png");
	public ResourceLocation BUTTON_ACTIVE = new ResourceLocation(AgeOfTitans.MOD_ID, "textures/gui/shop_item_button_active.png");
	public ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
	public FontRenderer font = Minecraft.getInstance().fontRenderer;
	public Minecraft minecraft = Minecraft.getInstance();
	public boolean clickedOnce = false;
	public PricedItem item;
	public ItemStack stack;
	
	public ShopItemButton(int widthIn, int heightIn, PricedItem item) {
		super(widthIn, heightIn, 110, 170, new TranslationTextComponent(""));
		this.active = false;
		this.item = item;
		this.stack = new ItemStack((IItemProvider) item);
	}

	@Override
	public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		ItemRenderer itemRenderer = minecraft.getItemRenderer();
		
		RenderSystem.enableBlend();
		if(this.active) {
			minecraft.getTextureManager().bindTexture(BUTTON_ACTIVE);
		} else if(this.isHovered()) {
			minecraft.getTextureManager().bindTexture(BUTTON_HOVER);
		} else {
			minecraft.getTextureManager().bindTexture(BUTTON);			
		}

		AbstractGui.blit(matrixStack, this.x, this.y, 0, 0, 0, this.width, this.height, this.height, this.width);
		int itemPosX = this.x + this.width / 2 - 8;
		int itemPosY = this.y + this.height / 2 - 6;
		itemRenderer.renderItemAndEffectIntoGUI(stack, itemPosX, itemPosY);
		if(mouseX < itemPosX  + 20 && mouseX > itemPosX && mouseY < itemPosY + 20 && mouseY > itemPosY) {
			ReaperShopScreen.SCREEN.setBlitOffset(300);
			this.renderTooltip(stack, this.x - 5, itemPosY + 32);
			ReaperShopScreen.SCREEN.setBlitOffset(0);
		}
		RenderSystem.disableBlend();
		this.renderBg(matrixStack, minecraft, mouseX, mouseY);
	}

	protected void renderTooltip(ItemStack stack, int posX, int posY) {
	      FontRenderer font = stack.getItem().getFontRenderer(stack);
	      net.minecraftforge.fml.client.gui.GuiUtils.preItemToolTip(stack);
	      GuiUtils.drawHoveringText(stack, new MatrixStack(), this.getTooltipFromItem(stack), posX, posY, minecraft.getMainWindow().getWidth(), minecraft.getMainWindow().getHeight(), 100,(font == null ? this.font : font));
	      net.minecraftforge.fml.client.gui.GuiUtils.postItemToolTip();
	   }
	
	public List<ITextComponent> getTooltipFromItem(ItemStack p_getTooltipFromItem_1_) {
	      List<ITextComponent> list = p_getTooltipFromItem_1_.getTooltip(this.minecraft.player, this.minecraft.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);

	      list.add(new TranslationTextComponent(""));
	      list.add(new TranslationTextComponent("\u00A7bPrice: " + Integer.toString(((PricedItem)stack.getItem()).getPrice()) + " Souls"));
	      
	      return list;
	   }
	
	

	@SuppressWarnings("deprecation")
	public static void drawGradientRect(int zLevel, int left, int top, int right, int bottom, int startColor, int endColor) {
		float startAlpha = (float) (startColor >> 24 & 255) / 255.0F;
		float startRed = (float) (startColor >> 16 & 255) / 255.0F;
		float startGreen = (float) (startColor >> 8 & 255) / 255.0F;
		float startBlue = (float) (startColor & 255) / 255.0F;
		float endAlpha = (float) (endColor >> 24 & 255) / 255.0F;
		float endRed = (float) (endColor >> 16 & 255) / 255.0F;
		float endGreen = (float) (endColor >> 8 & 255) / 255.0F;
		float endBlue = (float) (endColor & 255) / 255.0F;

		RenderSystem.disableTexture();
		RenderSystem.enableBlend();
		RenderSystem.disableAlphaTest();
		RenderSystem.defaultBlendFunc();
		RenderSystem.shadeModel(GL11.GL_SMOOTH);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos(right, top, zLevel).color(startRed, startGreen, startBlue, startAlpha).endVertex();
		buffer.pos(left, top, zLevel).color(startRed, startGreen, startBlue, startAlpha).endVertex();
		buffer.pos(left, bottom, zLevel).color(endRed, endGreen, endBlue, endAlpha).endVertex();
		buffer.pos(right, bottom, zLevel).color(endRed, endGreen, endBlue, endAlpha).endVertex();
		tessellator.draw();

		RenderSystem.shadeModel(GL11.GL_FLAT);
		RenderSystem.disableBlend();
		RenderSystem.enableAlphaTest();
		RenderSystem.enableTexture();
	}
	
	public void onPress() {
		if(!this.clickedOnce) {
			this.active = true;
			this.clickedOnce = true;
		} else {
			this.active = false;
			this.clickedOnce = false;
		}
		this.playDownSound(Minecraft.getInstance().getSoundHandler());
	}
	
	

}
