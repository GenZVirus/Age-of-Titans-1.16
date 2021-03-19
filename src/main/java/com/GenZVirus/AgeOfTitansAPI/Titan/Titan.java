package com.GenZVirus.AgeOfTitansAPI.Titan;

import java.util.HashMap;

import com.GenZVirus.AgeOfTitansAPI.IPlayerStats;
import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.ActiveAbility;
import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.PassiveAbility;
import com.GenZVirus.AgeOfTitansAPI.Capability.CapabilityStats;
import com.GenZVirus.AgeOfTitansAPI.Registry.Registries;

import net.minecraft.entity.player.ServerPlayerEntity;

public abstract class Titan {

	protected IPlayerStats playerStats;
	protected HashMap<String, ActiveAbility> ACTIVE_ABILITIES = new HashMap<String, ActiveAbility>();
	protected HashMap<String, PassiveAbility> PASSIVE_ABILITIES = new HashMap<String, PassiveAbility>();
	protected ServerPlayerEntity player;

	public IPlayerStats getStats() {
		return player.getCapability(CapabilityStats.CAPABILITY_STATS, null).orElse(null);
	}

	public void init() {
		ACTIVE_ABILITIES.putAll(Registries.getActiveAbilities());
		PASSIVE_ABILITIES.putAll(Registries.getPassiveAbilities());
	}
	
	public HashMap<String, ActiveAbility> getActiveAbilities() {
		return this.ACTIVE_ABILITIES;
	}
	
	public HashMap<String, PassiveAbility> getPassiveAbilities() {
		return this.PASSIVE_ABILITIES;
	}
	
	public ServerPlayerEntity getPlayer() {
		return this.player;
	}

	
}
