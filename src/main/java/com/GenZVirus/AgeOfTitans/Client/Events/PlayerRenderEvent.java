package com.GenZVirus.AgeOfTitans.Client.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Client.Entities.Renderer.ModifiedPlayerRenderer;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class PlayerRenderEvent {

	@SubscribeEvent(receiveCanceled = true)
	public static void renderPlayer(RenderPlayerEvent.Pre event) {
		if(event.getPlayer().getHeldItemMainhand().getItem().equals(ItemInit.TITAN_HEART.get())) {
			event.setCanceled(true);
			PlayerEntity player = event.getPlayer();
			new ModifiedPlayerRenderer(event.getRenderer().getRenderManager()).render((AbstractClientPlayerEntity) player, player.getYaw(event.getPartialRenderTick()), event.getPartialRenderTick(), event.getMatrixStack(), event.getBuffers(), event.getLight());
		}
	}
	
}
