package com.GenZVirus.AgeOfTitansAPI.Capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.GenZVirus.AgeOfTitansAPI.AbilitySystem.AbilityCollectionCaps;
import com.GenZVirus.AgeOfTitansAPI.Registry.Registries;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CapabilityAbilitiesProviderEntities implements ICapabilitySerializable<INBT> {

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
		if (CapabilityAbilities.CAPABILITY_ABILITIES == capability) {
			return (LazyOptional<T>) LazyOptional.of(() -> abilities);
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

	/**
	 * Write all the capability state information to NBT - fire, and air
	 */
	@Override
	public INBT serializeNBT() {
		if (abilities.getACTIVE_ABILITIES().isEmpty()) {
			abilities.setACTIVE_ABILITIES(Registries.getActiveAbilities());
		}
		if (abilities.getPASSIVE_ABILITIES().isEmpty()) {
			abilities.setPASSIVE_ABILITIES(Registries.getPassiveAbilities());
		}
		CompoundNBT nbt = new CompoundNBT();
		CompoundNBT activeAbilities = new CompoundNBT();
		CompoundNBT passiveAbilities = new CompoundNBT();

		// Active abilities
		abilities.getACTIVE_ABILITIES().forEach((name, ability) -> {
			CompoundNBT abilityNBT = new CompoundNBT();
			String usableName = name.toLowerCase().replace(' ', '_');
			// Add ability's level
			abilityNBT.putInt("level", ability.getLevel());

			// Add ability to the Active Ability list
			activeAbilities.put(usableName, abilityNBT);
		});
		nbt.put("active_abilities", activeAbilities);

		// Passive Abilities
		abilities.getPASSIVE_ABILITIES().forEach((name, ability) -> {
			CompoundNBT abilityNBT = new CompoundNBT();
			String usableName = name.toLowerCase().replace(' ', '_');
			// Add ability's level
			abilityNBT.putInt("level", ability.getLevel());

			// Add ability to the Passive Ability list
			passiveAbilities.put(usableName, abilityNBT);
		});
		nbt.put("passive_abilities", passiveAbilities);
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
		if (abilities.getACTIVE_ABILITIES().isEmpty()) {
			abilities.setACTIVE_ABILITIES(Registries.getActiveAbilities());
		}
		if (abilities.getPASSIVE_ABILITIES().isEmpty()) {
			abilities.setPASSIVE_ABILITIES(Registries.getPassiveAbilities());
		}
		CompoundNBT compoundNBT = (CompoundNBT) nbt;
		// Active abilities
		abilities.getACTIVE_ABILITIES().forEach((name, ability) -> {
			String usableName = name.toLowerCase().replace(' ', '_');
			abilities.getACTIVE_ABILITIES().get(name).setLevel(compoundNBT.getCompound("active_abilities").getCompound(usableName).getInt("level"));
		});

		// Passive Abilities
		abilities.getPASSIVE_ABILITIES().forEach((name, ability) -> {
			String usableName = name.toLowerCase().replace(' ', '_');
			abilities.getPASSIVE_ABILITIES().get(name).setLevel(compoundNBT.getCompound("passive_abilities").getCompound(usableName).getInt("level"));
		});
	}

	public int INBTtoINT(IntNBT nbt) {
		int value = 0;
		if (nbt == null)
			return value;
		if (nbt.getType() == IntNBT.TYPE) {
			value = ((IntNBT) nbt).getInt();
		}
		return value;
	}

	private AbilityCollectionCaps abilities = new AbilityCollectionCaps();
}