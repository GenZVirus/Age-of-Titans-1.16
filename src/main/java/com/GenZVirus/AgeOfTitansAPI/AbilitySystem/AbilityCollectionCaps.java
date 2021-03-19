package com.GenZVirus.AgeOfTitansAPI.AbilitySystem;

import java.util.HashMap;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class AbilityCollectionCaps {

	private HashMap<String, ActiveAbility> ACTIVE_ABILITIES = new HashMap<String, ActiveAbility>();
	private HashMap<String, PassiveAbility> PASSIVE_ABILITIES = new HashMap<String, PassiveAbility>();
	
	public AbilityCollectionCaps() {	
	}
	
	public HashMap<String, ActiveAbility> getACTIVE_ABILITIES() {
		return ACTIVE_ABILITIES;
	}
	
	public HashMap<String, PassiveAbility> getPASSIVE_ABILITIES() {
		return PASSIVE_ABILITIES;
	}
	
	public void setACTIVE_ABILITIES(HashMap<String, ActiveAbility> aCTIVE_ABILITIES) {
		ACTIVE_ABILITIES.putAll(aCTIVE_ABILITIES);
	}
	
	public void setPASSIVE_ABILITIES(HashMap<String, PassiveAbility> pASSIVE_ABILITIES) {
		PASSIVE_ABILITIES.putAll(pASSIVE_ABILITIES);
	}
	
	public static AbilityCollectionCaps createADefaultInstance() {
		return new AbilityCollectionCaps();
	}
	
	// Convert to/from NBT
		public static class AbilityCollectionNBTStorage implements Capability.IStorage<AbilityCollectionCaps> {

			@Override
			public INBT writeNBT(Capability<AbilityCollectionCaps> capability, AbilityCollectionCaps instance, Direction side) {
				return IntNBT.valueOf(0);
			}

			@Override
			public void readNBT(Capability<AbilityCollectionCaps> capability, AbilityCollectionCaps instance, Direction side, INBT nbt) {
			}
		}
	
}
