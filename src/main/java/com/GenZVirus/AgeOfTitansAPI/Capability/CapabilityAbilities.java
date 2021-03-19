package com.GenZVirus.AgeOfTitansAPI.Capability;

import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.AbilityCollectionCaps;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityAbilities {
    @CapabilityInject(AbilityCollectionCaps.class)
    public static Capability<AbilityCollectionCaps> CAPABILITY_ABILITIES = null;

    public static void register() {
      CapabilityManager.INSTANCE.register(
    		  AbilityCollectionCaps.class,
              new AbilityCollectionCaps.AbilityCollectionNBTStorage(),
              AbilityCollectionCaps::createADefaultInstance);
    }
}
