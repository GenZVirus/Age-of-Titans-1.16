package com.GenZVirus.AgeOfTitans.Common.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardKeyPressedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.MouseClickedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.MouseReleasedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class PlayerInputEvents {
	
	public static Minecraft mc = Minecraft.getInstance();

	@SubscribeEvent(receiveCanceled = true)
	public static void mouseclick(MouseClickedEvent.Pre event) {
		if (mc.player == null)
			return;
		if (mc.player.isCreative())
			return;
		if (event.getGui() instanceof ContainerScreen) {
			if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse() != null) {
				if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse().getStack().getItem().equals(ItemInit.TITAN_HEART.get())) {
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent(receiveCanceled = true)
	public static void mouseclick(MouseReleasedEvent.Pre event) {
		if (mc.player == null)
			return;
		if (mc.player.isCreative())
			return;
		if (event.getGui() instanceof ContainerScreen) {
			if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse() != null) {
				if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse().getStack().getItem().equals(ItemInit.TITAN_HEART.get())) {
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent(receiveCanceled = true)
	public static void keyPressed(KeyboardKeyPressedEvent.Pre event) {
		if (mc.player == null)
			return;
		if (mc.player.isCreative())
			return;
		if (event.getGui() instanceof ContainerScreen) {
			if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse() != null) {
				if (((ContainerScreen<?>) event.getGui()).getSlotUnderMouse().getStack().getItem().equals(ItemInit.TITAN_HEART.get())) {
					event.setCanceled(true);
				}
				if (event.getKeyCode() == 49) {
					event.setCanceled(true);
				}
			}
		}
	}
	
}
