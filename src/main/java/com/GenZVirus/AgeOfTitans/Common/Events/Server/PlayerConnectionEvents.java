package com.GenZVirus.AgeOfTitans.Common.Events.Server;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.FileSystem.XMLFileJava;
import com.GenZVirus.AgeOfTitans.Util.TitanPlayer;
import com.GenZVirus.AgeOfTitans.Util.Titans;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class PlayerConnectionEvents {

	// When a player leaves the server all lists clear his data from them

	@SubscribeEvent
	public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent e) {
		for (TitanPlayer player : Titans.getTitans())
			if (player.getPlayer().getName().equals(e.getPlayer().getName())) {
				XMLFileJava.save(player);
				Titans.removeTitan(player);
				break;
			}
	}

	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
		Titans.addTitan(XMLFileJava.load((ServerPlayerEntity) e.getPlayer()));
	}

}
