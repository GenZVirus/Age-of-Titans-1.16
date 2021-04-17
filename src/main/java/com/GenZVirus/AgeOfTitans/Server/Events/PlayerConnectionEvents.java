package com.GenZVirus.AgeOfTitans.Server.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.VirusLIB.IPlayerStats;
import com.GenZVirus.VirusLIB.Capability.CapabilityStats;
import com.GenZVirus.VirusLIB.Network.PacketHandler;
import com.GenZVirus.VirusLIB.Network.SyncStatsPacket;
import com.GenZVirus.VirusLIB.Titan.TitanPlayer;
import com.GenZVirus.VirusLIB.Titan.Titans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.NetworkDirection;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class PlayerConnectionEvents {

	// When a player leaves the server all lists clear his data from them

	@SubscribeEvent
	public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
		Titans.removeTitan(Titans.getTitanFromPlayerUUID(event.getPlayer().getUniqueID()));
	}

	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		Titans.addTitan(new TitanPlayer((ServerPlayerEntity) event.getPlayer()));
		IPlayerStats stats = Titans.getTitanFromPlayerUUID(event.getPlayer().getUniqueID()).getStats();
		PacketHandler.INSTANCE.sendTo(
				new SyncStatsPacket(stats.getApplesEaten(), stats.getBalance(), stats.getMaxRagePoints(), stats.getPlayerEXP(), stats.getPlayerLevel(), stats.getPoints(), stats.getRagePoints()),
				((ServerPlayerEntity) event.getPlayer()).connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
	}

	@SubscribeEvent
	public static void onPlayerDeath(LivingDeathEvent event) {
		if (!(event.getEntityLiving() instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) event.getEntityLiving();
		Titans.removeTitan(Titans.getTitanFromPlayerUUID(player.getUniqueID()));
	}

	@SubscribeEvent
	public static void onPlayerClone(Clone event) {
		IPlayerStats capOriginal = event.getOriginal().getCapability(CapabilityStats.CAPABILITY_STATS, null).orElse(null);
		IPlayerStats capNew = event.getPlayer().getCapability(CapabilityStats.CAPABILITY_STATS, null).orElse(null);
		capNew.setApplesEaten(capOriginal.getApplesEaten());
		capNew.setBalance(capOriginal.getBalance());
		capNew.setMaxRagePoints(capOriginal.getMaxRagePoints());
		capNew.setPlayerEXP(capOriginal.getPlayerEXP());
		capNew.setPlayerLevel(capOriginal.getPlayerLevel());
		capNew.setPoints(capOriginal.getPoints());
		capNew.setRagePoints(capOriginal.getRagePoints());
		Titans.addTitan(new TitanPlayer((ServerPlayerEntity) event.getPlayer()));
	}

	@SubscribeEvent
	public static void onPlayerRespawn(PlayerRespawnEvent event) {
		IPlayerStats stats = Titans.getTitanFromPlayerUUID(event.getPlayer().getUniqueID()).getStats();
		PacketHandler.INSTANCE.sendTo(
				new SyncStatsPacket(stats.getApplesEaten(), stats.getBalance(), stats.getMaxRagePoints(), stats.getPlayerEXP(), stats.getPlayerLevel(), stats.getPoints(), stats.getRagePoints()),
				((ServerPlayerEntity) event.getPlayer()).connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);

	}

}
