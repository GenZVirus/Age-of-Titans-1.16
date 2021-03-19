package com.GenZVirus.AgeOfTitansAPI.AbilitySystem;

import java.util.List;

import com.GenZVirus.AgeOfTitansAPI.IRequirement;
import com.google.common.collect.Lists;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class Ability {

	public int level = 0, cooldown = 0, cost = 0;
	public double baseAmount = 0, ratio = 0;
	public String name;

	public void initRequirements() {
	}

	public boolean meetsRequirements() {
		return false;
	}

	public int getLevel() {
		return this.level;
	}

	public int getCooldown() {
		return this.cooldown;
	}

	public int getCost() {
		return this.cost;
	}

	public double getBaseAmount() {
		return this.baseAmount;
	}

	public double getRatio() {
		return this.ratio;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setCooldown(int cd) {
		this.cooldown = cd;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setBaseAmount(double amount) {
		this.baseAmount = amount;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	public String getName() {
		return this.name;
	}

	public void effect(World worldIn, PlayerEntity playerIn) {
	}

	public ResourceLocation getIcon() {
		return null;
	}

	public ResourceLocation getIconOff() {
		return null;
	}

	public List<String> getDescription() {
		return Lists.newArrayList();
	}

	public List<String> getDetails() {
		return Lists.newArrayList();
	}

	public List<IRequirement> getRequirements() {
		return Lists.newArrayList();
	}

}
