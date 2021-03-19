package com.GenZVirus.AgeOfTitansAPI.AbilitySystem;

public class PassiveAbility extends Ability {

	public PassiveAbility(String name, double baseAmount, double ratio, int cost, int cooldown) {
		this.name = name;
		this.baseAmount = baseAmount;
		this.ratio = ratio;
		this.cost = cost;
		this.cooldown = cooldown;
		initRequirements();
	}
	
}
