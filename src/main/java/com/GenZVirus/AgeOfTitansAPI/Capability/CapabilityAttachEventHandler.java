package com.GenZVirus.AgeOfTitansAPI.Capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityAttachEventHandler {
	@SubscribeEvent
	public static void attachCapabilityToEntityHandler(AttachCapabilitiesEvent<Entity> event) {
		Entity entity = event.getObject();
		if (entity instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation("ageoftitans:stats"), new CapabilityStatsProviderEntities());
			event.addCapability(new ResourceLocation("ageoftitans:abilities"), new CapabilityAbilitiesProviderEntities());
		}
	}
}
