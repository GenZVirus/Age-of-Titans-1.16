package com.GenZVirus.AgeOfTitans.Client.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Client.Container.ContainerScreenBasic;
import com.GenZVirus.AgeOfTitans.Client.Entities.Renderer.ReaperEntityRender;
import com.GenZVirus.AgeOfTitans.Common.Init.ModContainerTypes;
import com.GenZVirus.AgeOfTitans.Common.Init.ModEntityTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventsHandler {

	// Client Side Events
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.TITANS_LOCKER.get(), ContainerScreenBasic::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REAPER.get(), ReaperEntityRender::new);
	}

}
