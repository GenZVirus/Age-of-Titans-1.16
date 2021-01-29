package com.GenZVirus.AgeOfTitans.Common.Events.Server;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;
import com.GenZVirus.AgeOfTitans.Util.TitanPlayer;
import com.GenZVirus.AgeOfTitans.Util.Titans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class FOTGEvents {

	@SubscribeEvent
	public static void AOTOnApplesEaten(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntityLiving().world.isRemote)
			return;
		if (!(event.getEntityLiving() instanceof PlayerEntity))
			return;
		if (event.getItem().getItem().equals(ItemInit.FRUIT_OF_THE_GODS.get())) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			player.setAbsorptionAmount(player.getAbsorptionAmount() + 20);
			player.setHealth(player.getMaxHealth());
			TitanPlayer titan = null;
			for (TitanPlayer playerMSG : Titans.getTitans()) {
				playerMSG.getPlayer().sendMessage(new TranslationTextComponent(player.getName().getUnformattedComponentText() + " has eaten the Fruit of the Gods"), player.getUniqueID());
				if (playerMSG.getPlayer().getName().equals(player.getName())) {
					titan = playerMSG;
				}
			}
			if (titan != null)
				titan.hasAteFOTG();
		}
	}

}
