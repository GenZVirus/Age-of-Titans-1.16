package com.GenZVirus.AgeOfTitans.Server.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Commands.SetBalanceCommand;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID)
public class CommandEventsHandler {

	@SubscribeEvent
	public static void onServerStarting(RegisterCommandsEvent event) {
		CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
		
		SetBalanceCommand.register(dispatcher);
	}
	
}
