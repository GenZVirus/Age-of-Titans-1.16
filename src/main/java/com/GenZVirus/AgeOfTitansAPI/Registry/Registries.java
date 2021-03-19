package com.GenZVirus.AgeOfTitansAPI.Registry;

import java.util.HashMap;

import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.ActiveAbility;
import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.PassiveAbility;

public class Registries {

	private static HashMap<String, ActiveAbility> ACTIVE_ABILITIES = new HashMap<String, ActiveAbility>();
	private static HashMap<String, PassiveAbility> PASSIVE_ABILITIES = new HashMap<String, PassiveAbility>();

	public static void register(ActiveAbility ability) {
		ACTIVE_ABILITIES.put(ability.getName(), ability);
	}
	
	public static void register(PassiveAbility ability) {
		PASSIVE_ABILITIES.put(ability.getName(), ability);
	}

	public static HashMap<String, ActiveAbility> getActiveAbilities() {
		return ACTIVE_ABILITIES;
	}
	
	public static HashMap<String, PassiveAbility> getPassiveAbilities() {
		return PASSIVE_ABILITIES;
	}
}
