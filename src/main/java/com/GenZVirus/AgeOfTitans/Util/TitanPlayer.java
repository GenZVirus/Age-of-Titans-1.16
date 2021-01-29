package com.GenZVirus.AgeOfTitans.Util;

import net.minecraft.entity.player.ServerPlayerEntity;

public class TitanPlayer {

	private int points;
	private int balance;
	private int apples_eaten;
	private int player_level;
	private int player_exp;
	private int rage_points;
	private int max_rage_points;
	private int SwordSlashLevel, ShieldBashLevel, BerserkerLevel, ChainLevel, GravityBombLevel, RevitaliseLevel, ForcefieldLevel, POAGLevel, ROSLevel;
	private int Slot1_ID, Slot2_ID, Slot3_ID, Slot4_ID;
	private ServerPlayerEntity player;

	public TitanPlayer(ServerPlayerEntity player) {
		this.init();
		this.player = player;
	}

	public void init() {
		points = 0;
		balance = 0;
		apples_eaten = 0;
		player_level = 0;
		rage_points = 0;
		max_rage_points = 1000;
	}

	public int getApples_eaten() {
		return apples_eaten;
	}

	public int getMax_rage_points() {
		return max_rage_points;
	}

	public ServerPlayerEntity getPlayer() {
		return player;
	}

	public int getPlayer_level() {
		return player_level;
	}
	
	public int getPlayer_exp() {
		return player_exp;
	}
	
	public int getBalance() {
		return balance;
	}

	public int getPoints() {
		return points;
	}

	public int getRage_points() {
		return rage_points;
	}

	public int getBerserkerLevel() {
		return BerserkerLevel;
	}

	public int getChainLevel() {
		return ChainLevel;
	}

	public int getForcefieldLevel() {
		return ForcefieldLevel;
	}

	public int getGravityBombLevel() {
		return GravityBombLevel;
	}

	public int getPOAGLevel() {
		return POAGLevel;
	}

	public int getRevitaliseLevel() {
		return RevitaliseLevel;
	}

	public int getROSLevel() {
		return ROSLevel;
	}

	public int getShieldBashLevel() {
		return ShieldBashLevel;
	}

	public int getSwordSlashLevel() {
		return SwordSlashLevel;
	}

	public int getSlot1_ID() {
		return Slot1_ID;
	}
	
	public int getSlot2_ID() {
		return Slot2_ID;
	}
	
	public int getSlot3_ID() {
		return Slot3_ID;
	}
	
	public int getSlot4_ID() {
		return Slot4_ID;
	}
	
	public void setSlot1_ID(int slot1_ID) {
		Slot1_ID = slot1_ID;
	}
	
	public void setSlot2_ID(int slot2_ID) {
		Slot2_ID = slot2_ID;
	}
	
	public void setSlot3_ID(int slot3_ID) {
		Slot3_ID = slot3_ID;
	}
	
	public void setSlot4_ID(int slot4_ID) {
		Slot4_ID = slot4_ID;
	}
	
	public void setBerserkerLevel(int berserkerLevel) {
		BerserkerLevel = berserkerLevel;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setPlayer_exp(int player_exp) {
		this.player_exp = player_exp;
	}
	
	public void setChainLevel(int chainLevel) {
		ChainLevel = chainLevel;
	}

	public void setForcefieldLevel(int forcefieldLevel) {
		ForcefieldLevel = forcefieldLevel;
	}

	public void setGravityBombLevel(int gravityBombLevel) {
		GravityBombLevel = gravityBombLevel;
	}

	public void setPOAGLevel(int pOAGLevel) {
		POAGLevel = pOAGLevel;
	}

	public void setRevitaliseLevel(int revitaliseLevel) {
		RevitaliseLevel = revitaliseLevel;
	}

	public void setROSLevel(int rOSLevel) {
		ROSLevel = rOSLevel;
	}

	public void setShieldBashLevel(int shieldBashLevel) {
		ShieldBashLevel = shieldBashLevel;
	}

	public void setSwordSlashLevel(int swordSlashLevel) {
		SwordSlashLevel = swordSlashLevel;
	}

	public void setApples_eaten(int apples_eaten) {
		this.apples_eaten = apples_eaten;
	}

	public void setMax_rage_points(int max_rage_points) {
		this.max_rage_points = max_rage_points;
	}

	public void setPlayer(ServerPlayerEntity player) {
		this.player = player;
	}

	public void setPlayer_level(int player_level) {
		this.player_level = player_level;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setRage_points(int rage_points) {
		this.rage_points = rage_points;
	}
	
	public void addSouls(int amount) {
		this.balance += amount;
	}
	
	public void hasAteFOTG() {
		this.apples_eaten++;
		this.player_level++;
		this.points++;
	}
	
}
