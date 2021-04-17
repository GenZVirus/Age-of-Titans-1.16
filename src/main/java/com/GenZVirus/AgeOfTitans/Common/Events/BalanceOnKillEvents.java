package com.GenZVirus.AgeOfTitans.Common.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.VirusLIB.IPlayerStats;
import com.GenZVirus.VirusLIB.Network.PacketHandler;
import com.GenZVirus.VirusLIB.Network.SyncStatsPacket;
import com.GenZVirus.VirusLIB.Titan.Titans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.NetworkDirection;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class BalanceOnKillEvents {

	@SubscribeEvent
	public static void onEntityDead(LivingDeathEvent event) {
		if (!(event.getSource().getTrueSource() instanceof PlayerEntity)) {
			return;
		}
		PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
		if (player.world.isRemote) {
			return;
		}
		IPlayerStats stats = Titans.getTitanFromPlayerUUID(player.getUniqueID()).getStats();
		stats.setBalance(stats.getBalance() + 1);
		PacketHandler.INSTANCE.sendTo(
				new SyncStatsPacket(stats.getApplesEaten(), stats.getBalance(), stats.getMaxRagePoints(), stats.getPlayerEXP(), stats.getPlayerLevel(), stats.getPoints(), stats.getRagePoints()),
				Titans.getTitanFromPlayerUUID(player.getUniqueID()).getPlayer().connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);

	}

}
