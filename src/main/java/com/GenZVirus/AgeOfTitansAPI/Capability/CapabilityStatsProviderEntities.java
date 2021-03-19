package com.GenZVirus.AgeOfTitansAPI.Capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.GenZVirus.AgeOfTitansAPI.PlayerStats;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CapabilityStatsProviderEntities implements ICapabilitySerializable<INBT> {

	/**
	 * Asks the Provider if it has the given capability
	 * 
	 * @param capability<T> capability to be checked for
	 * @param facing        the side of the provider being checked (null = no
	 *                      particular side)
	 * @param <T>           The interface instance that is used
	 * @return a lazy-initialisation supplier of the interface instance that is used
	 *         to access this capability In this case, we don't actually use lazy
	 *         initialisation because the instance is very quick to create. See
	 *         CapabilityProviderFlowerBag for an example of lazy initialisation
	 */
	@SuppressWarnings("unchecked")
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
		if (CapabilityStats.CAPABILITY_STATS == capability) {
			return (LazyOptional<T>) LazyOptional.of(() -> stats);
			// why are we using a lambda? Because LazyOptional.of() expects a
			// NonNullSupplier interface. The lambda automatically
			// conforms itself to that interface. This save me having to define an inner
			// class implementing NonNullSupplier.
			// The explicit cast to LazyOptional<T> is required because our
			// CAPABILITY_ELEMENTAL_FIRE can't be typed. Our code has
			// checked that the requested capability matches, so the explict cast is safe
			// (unless you have mixed them up)
		}

		return LazyOptional.empty();
		// Note that if you are implementing getCapability in a derived class which
		// implements ICapabilityProvider
		// eg you have added a new MyEntity which has the method MyEntity::getCapability
		// instead of using AttachCapabilitiesEvent to attach a
		// separate class, then you should call
		// return super.getCapability(capability, facing);
		// instead of
		// return LazyOptional.empty();
	}

	private final static String PLAYER_LEVEL = "player_level";
	private final static String POINTS = "points";
	private final static String APPLES_EATEN = "apples_eaten";
	private final static String PLAYER_EXP = "player_exp";
	private final static String BALANCE = "balance";
	private final static String RAGE_POINTS = "rage_points";
	private final static String MAX_RAGE_POINTS = "max_rage_points";

	/**
	 * Write all the capability state information to NBT - fire, and air
	 */
	@Override
	public INBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.put(PLAYER_LEVEL, IntNBT.valueOf(stats.getPlayerLevel()));
		nbt.put(POINTS, IntNBT.valueOf(stats.getPoints()));
		nbt.put(APPLES_EATEN, IntNBT.valueOf(stats.getApplesEaten()));
		nbt.put(PLAYER_EXP, IntNBT.valueOf(stats.getPlayerEXP()));
		nbt.put(BALANCE, IntNBT.valueOf(stats.getBalance()));
		nbt.put(RAGE_POINTS, IntNBT.valueOf(stats.getRagePoints()));
		nbt.put(MAX_RAGE_POINTS, IntNBT.valueOf(stats.getMaxRagePoints()));
		return nbt;
	}

	/**
	 * Read the capability state information out of NBT - fire, and air Overwrite
	 * the interface instances with the nbt information
	 */
	@Override
	public void deserializeNBT(INBT nbt) {
		if (nbt.getId() != NBTtypes.COMPOUND_NBT_ID) {
			return; // leave as default in case of error
		}
		CompoundNBT compoundNBT = (CompoundNBT) nbt;
		stats.setPlayerLevel(INBTtoINT((IntNBT) compoundNBT.get(PLAYER_LEVEL)));
		stats.setPoints(INBTtoINT((IntNBT) compoundNBT.get(POINTS)));
		stats.setApplesEaten(INBTtoINT((IntNBT) compoundNBT.get(APPLES_EATEN)));
		stats.setPlayerEXP(INBTtoINT((IntNBT) compoundNBT.get(PLAYER_EXP)));
		stats.setBalance(INBTtoINT((IntNBT) compoundNBT.get(BALANCE)));
		stats.setRagePoints(INBTtoINT((IntNBT) compoundNBT.get(RAGE_POINTS)));
		stats.setMaxRagePoints(INBTtoINT((IntNBT) compoundNBT.get(MAX_RAGE_POINTS)));
	}

	public int INBTtoINT(IntNBT nbt) {
		int value = 0;
		if(nbt == null) return value;
		if (nbt.getType() == IntNBT.TYPE) {
			value = ((IntNBT) nbt).getInt();
		}
		return value;
	}

	private PlayerStats stats = new PlayerStats();
}