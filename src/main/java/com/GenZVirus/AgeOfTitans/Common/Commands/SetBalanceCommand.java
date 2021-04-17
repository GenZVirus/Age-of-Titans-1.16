package com.GenZVirus.AgeOfTitans.Common.Commands;

import com.GenZVirus.VirusLIB.PlayerStats;
import com.GenZVirus.VirusLIB.Capability.CapabilityStats;
import com.GenZVirus.VirusLIB.Network.PacketHandler;
import com.GenZVirus.VirusLIB.Network.SyncStatsPacket;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkDirection;

public class SetBalanceCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("setbalance").requires(context -> {
			return context.hasPermissionLevel(3);
		}).then(Commands.argument("souls", IntegerArgumentType.integer(0, Integer.MAX_VALUE - 1)).executes(source -> {
			return setLevel(source.getSource(), source.getSource().asPlayer(), IntegerArgumentType.getInteger(source, "souls"));
		}).then(Commands.argument("target", EntityArgument.player()).executes(source ->{
			return setLevel(source.getSource(), EntityArgument.getPlayer(source, "target"), IntegerArgumentType.getInteger(source, "souls"));
		}))));
	}
	
	private static int setLevel(CommandSource source, PlayerEntity player, int balance) {
		if(player.world.isRemote) return 1;
		player.getCapability(CapabilityStats.CAPABILITY_STATS).orElse(null).setBalance(balance);
		PlayerStats stats = player.getCapability(CapabilityStats.CAPABILITY_STATS).orElse(null);
		PacketHandler.INSTANCE.sendTo(new SyncStatsPacket(stats.getApplesEaten(), stats.getBalance(), stats.getMaxRagePoints(), stats.getPlayerEXP(), stats.getPlayerLevel(), stats.getPoints(), stats.getRagePoints()), ((ServerPlayerEntity)player).connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
		source.sendFeedback(new TranslationTextComponent("commands.setbalance", player.getDisplayName().getUnformattedComponentText(), balance), true);
		return 1;
	}
	
}