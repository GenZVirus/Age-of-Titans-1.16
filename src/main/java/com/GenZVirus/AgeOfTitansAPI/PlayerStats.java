package com.GenZVirus.AgeOfTitansAPI;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerStats implements IPlayerStats {

	private int points = 0;
	private int applesEaten = 0;
	private int playerLevel = 0;
	private int playerExp = 0;
	private int balance = 0;
	private int ragePoints = 0;
	private int maxRagePoints = 1000;

	public PlayerStats() {
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int getApplesEaten() {
		return this.applesEaten;
	}
	
	@Override
	public void setApplesEaten(int amount) {
		this.applesEaten = amount;
	}

	@Override
	public void appleEaten() {
		this.applesEaten++;
		this.levelUp();
	}

	@Override
	public int getPlayerLevel() {
		return this.playerLevel;
	}

	@Override
	public void setPlayerLevel(int level) {
		this.playerLevel = level;
	}
	
	@Override
	public void levelUp() {
		this.playerLevel++;
	}

	@Override
	public int getPlayerEXP() {
		return this.playerExp;
	}

	@Override
	public void setPlayerEXP(int amount) {
		this.playerExp = amount;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public void setBalance(int amount) {
		this.balance = amount;
	}

	@Override
	public int getRagePoints() {
		return this.ragePoints;
	}

	@Override
	public void setRagePoints(int points) {
		this.ragePoints = points;
	}

	@Override
	public int getMaxRagePoints() {
		return this.maxRagePoints;
	}

	@Override
	public void setMaxRagePoints(int points) {
		this.maxRagePoints = points;
	}
	
	public static PlayerStats createADefaultInstance() {
		return new PlayerStats();
	}
	
	// Convert to/from NBT
		public static class PlayerStatsNBTStorage implements Capability.IStorage<PlayerStats> {
			@Override
			public INBT writeNBT(Capability<PlayerStats> capability, PlayerStats instance, Direction side) {
				IntNBT intNBT = IntNBT.valueOf(instance.getPlayerLevel());
				return intNBT;
			}

			@Override
			public void readNBT(Capability<PlayerStats> capability, PlayerStats instance, Direction side, INBT nbt) {
				int titanLevel = 0;
				if (nbt.getType() == IntNBT.TYPE) {
					titanLevel = ((IntNBT) nbt).getInt();
				}
				instance.setPlayerLevel(titanLevel);
			}
		}

}
