package com.GenZVirus.AgeOfTitans.Util;

import java.util.List;

import com.google.common.collect.Lists;

public class Titans {
	
	private static List<TitanPlayer> list = Lists.newArrayList();
	
	public static List<TitanPlayer> getTitans() {
		return list;
	}
	
	public static void addTitan(TitanPlayer player) {
		list.add(player);
	}

	public static void removeTitan(TitanPlayer player) {
		list.remove(player);
	}
	
}
