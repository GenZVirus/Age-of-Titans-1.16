package com.GenZVirus.AgeOfTitans.Common.Events.Server;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.FileSystem.XMLFileJava;
import com.GenZVirus.AgeOfTitans.Util.TitanPlayer;
import com.GenZVirus.AgeOfTitans.Util.Titans;

import net.minecraftforge.event.world.WorldEvent.Save;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class SaveEvents {

	@SubscribeEvent
	public static void save(Save event) {
		for (TitanPlayer player : Titans.getTitans()) {
			XMLFileJava.save(player);
		}
	}

}
