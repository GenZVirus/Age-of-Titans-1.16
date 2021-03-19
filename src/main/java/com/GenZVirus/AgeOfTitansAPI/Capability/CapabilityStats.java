package com.GenZVirus.AgeOfTitansAPI.Capability;

import com.GenZVirus.AgeOfTitansAPI.PlayerStats;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityStats {
    @CapabilityInject(PlayerStats.class)
    public static Capability<PlayerStats> CAPABILITY_STATS = null;

    public static void register() {
      CapabilityManager.INSTANCE.register(
              PlayerStats.class,
              new PlayerStats.PlayerStatsNBTStorage(),
              PlayerStats::createADefaultInstance);
    }
}
