package com.GenZVirus.AgeOfTitansAPI.Titan;

import net.minecraft.entity.player.ServerPlayerEntity;

public class TitanPlayer extends Titan {

	public TitanPlayer(ServerPlayerEntity player) {
		this.player = player;
		this.init();
	}

}
