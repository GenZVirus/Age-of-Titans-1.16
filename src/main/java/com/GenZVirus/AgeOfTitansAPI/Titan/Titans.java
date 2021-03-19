package com.GenZVirus.AgeOfTitansAPI.Titan;

import java.util.HashMap;
import java.util.UUID;

public class Titans {

	private static HashMap<UUID, TitanPlayer> MAP = new HashMap<UUID, TitanPlayer>();

	public static TitanPlayer getTitanFromPlayerUUID(UUID uuid) {
		return MAP.get(uuid);
	}

	public static void addTitan(TitanPlayer player) {
		MAP.put(player.getPlayer().getUniqueID(), player);
	}

	public static void removeTitan(TitanPlayer player) {
		MAP.remove(player.getPlayer().getUniqueID());
	}

}
