package com.GenZVirus.AgeOfTitans.Common.Events.Client;

import java.util.List;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelHelmet;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelLeggings;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelHood;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelLeggings;
import com.google.common.collect.Lists;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ItemToolTipEventsHandler {

	@SubscribeEvent
	public static void heavyTitanSteelArmorSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!(event.getItemStack().getItem() instanceof HeavyTitanSteelHelmet)
				&& !(event.getItemStack().getItem() instanceof HeavyTitanSteelChestplate)
				&& !(event.getItemStack().getItem() instanceof HeavyTitanSteelLeggings)
				&& !(event.getItemStack().getItem() instanceof HeavyTitanSteelBoots)) return;
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		List<ItemStack> armory = (List<ItemStack>) player.getArmorInventoryList();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(armory.get(3)) || event.getItemStack().equals(armory.get(2)) || event.getItemStack().equals(armory.get(1)) || event.getItemStack().equals(armory.get(0))) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(armory.get(3).getItem() instanceof HeavyTitanSteelHelmet && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Heavy Titan Steel Helmet"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Heavy Titan Steel Helmet"));
		}
		
		if(armory.get(2).getItem() instanceof HeavyTitanSteelChestplate && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Heavy Titan Steel Chestplate"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Heavy Titan Steel Chestplate"));
		}
		
		if(armory.get(1).getItem() instanceof HeavyTitanSteelLeggings && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Heavy Titan Steel Leggings"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Heavy Titan Steel Leggings"));
		}
		
		if(armory.get(0).getItem() instanceof HeavyTitanSteelBoots && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Heavy Titan Steel Boots"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Heavy Titan Steel Boots"));
		}
		
		text.add(new TranslationTextComponent(""));
		
		if(armory.get(3).getItem() instanceof HeavyTitanSteelHelmet
				&& armory.get(2).getItem() instanceof HeavyTitanSteelChestplate
				&& armory.get(1).getItem() instanceof HeavyTitanSteelLeggings
				&& armory.get(0).getItem() instanceof HeavyTitanSteelBoots
				&& (event.getItemStack().equals(armory.get(3)) || event.getItemStack().equals(armory.get(2)) || event.getItemStack().equals(armory.get(1)) || event.getItemStack().equals(armory.get(0)))) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a(1) Getting hit by an item that has less than 7 damage or that does not have any level of unbreaking will destroy the item."));
			text.add(new TranslationTextComponent("\u00A7a(2) Getting hit by an item that has less than 10 damage has a 10% chance to disarm the attacker."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77(1) Getting hit by an item that has less than 7 damage or that does not have any level of unbreaking will destroy the item."));
			text.add(new TranslationTextComponent("\u00A77(2) Getting hit by an item that has less than 10 damage has a 10% chance to disarm the attacker."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
	@SubscribeEvent
	public static void LightTitanSteelArmorSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!(event.getItemStack().getItem() instanceof LightTitanSteelHood)
				&& !(event.getItemStack().getItem() instanceof LightTitanSteelChestplate)
				&& !(event.getItemStack().getItem() instanceof LightTitanSteelLeggings)
				&& !(event.getItemStack().getItem() instanceof LightTitanSteelBoots)) return;
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		List<ItemStack> armory = (List<ItemStack>) player.getArmorInventoryList();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(armory.get(3)) || event.getItemStack().equals(armory.get(2)) || event.getItemStack().equals(armory.get(1)) || event.getItemStack().equals(armory.get(0))) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(armory.get(3).getItem() instanceof LightTitanSteelHood && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Light Titan Steel Helmet"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Light Titan Steel Helmet"));
		}
		
		if(armory.get(2).getItem() instanceof LightTitanSteelChestplate && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Light Titan Steel Chestplate"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Light Titan Steel Chestplate"));
		}
		
		if(armory.get(1).getItem() instanceof LightTitanSteelLeggings && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Light Titan Steel Leggings"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Light Titan Steel Leggings"));
		}
		
		if(armory.get(0).getItem() instanceof LightTitanSteelBoots && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Light Titan Steel Boots"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Light Titan Steel Boots"));
		}
		
		text.add(new TranslationTextComponent(""));
		
		if(armory.get(3).getItem() instanceof LightTitanSteelHood
				&& armory.get(2).getItem() instanceof LightTitanSteelChestplate
				&& armory.get(1).getItem() instanceof LightTitanSteelLeggings
				&& armory.get(0).getItem() instanceof LightTitanSteelBoots
				&& (event.getItemStack().equals(armory.get(3)) || event.getItemStack().equals(armory.get(2)) || event.getItemStack().equals(armory.get(1)) || event.getItemStack().equals(armory.get(0)))) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a(1) Increase movement speed by 50%."));
			text.add(new TranslationTextComponent("\u00A7a(2) Grants 33.33% chance to dodge the incoming attack."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77(1) Increase movement speed by 50%."));
			text.add(new TranslationTextComponent("\u00A77(2) Grants 33.33% chance to dodge the incoming attack."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
	@SubscribeEvent
	public static void titaniumSwordSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!event.getItemStack().getItem().equals(ItemInit.TITAN_STEEL_SWORD.get())) {
			return;
		}
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(player.getHeldItemMainhand()) || event.getItemStack().equals(player.getHeldItemOffhand())) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_STEEL_SWORD.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Titan Steel Sword (Mainhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Titan Steel Sword (Mainhand)"));
		}
		
		if(player.getHeldItemOffhand().getItem().equals(ItemInit.TITAN_STEEL_SWORD.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Titan Steel Sword (Offhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Titan Steel Sword (Offhand)"));
		}
		
		if(player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_STEEL_SWORD.get()) && player.getHeldItemOffhand().getItem().equals(ItemInit.TITAN_STEEL_SWORD.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a While dual wielding a set of TitanSteel Sword damage dealt with them is increased by 50%."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77 While dual wielding a set of TitanSteel Sword damage dealt with them is increased by 50%."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
	@SubscribeEvent
	public static void titaniumDaggerSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!event.getItemStack().getItem().equals(ItemInit.TITAN_STEEL_DAGGER.get())) {
			return;
		}
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(player.getHeldItemMainhand()) || event.getItemStack().equals(player.getHeldItemOffhand())) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Titan Steel Dagger (Mainhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Titan Steel Dagger (Mainhand)"));
		}
		
		if(player.getHeldItemOffhand().getItem().equals(ItemInit.TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Titan Steel Dagger (Offhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Titan Steel Dagger (Offhand)"));
		}
		
		if((player.getHeldItemMainhand().getItem().equals(ItemInit.TITAN_STEEL_DAGGER.get()) || event.getItemStack().equals(player.getHeldItemOffhand())) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77 Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
	@SubscribeEvent
	public static void poisonousDaggerSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!event.getItemStack().getItem().equals(ItemInit.POISONOUS_TITAN_STEEL_DAGGER.get())) {
			return;
		}
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(player.getHeldItemMainhand()) || event.getItemStack().equals(player.getHeldItemOffhand())) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(player.getHeldItemMainhand().getItem().equals(ItemInit.POISONOUS_TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Poisonous Titan Steel Dagger (Mainhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Poisonous Titan Steel Dagger (Mainhand)"));
		}
		
		if(player.getHeldItemOffhand().getItem().equals(ItemInit.POISONOUS_TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Poisonous Titan Steel Dagger (Offhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Poisonous Titan Steel Dagger (Offhand)"));
		}
		
		if((player.getHeldItemMainhand().getItem().equals(ItemInit.POISONOUS_TITAN_STEEL_DAGGER.get()) || event.getItemStack().equals(player.getHeldItemOffhand()))&& itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a (1)Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
			text.add(new TranslationTextComponent("\u00A7a (2)Damaging a target inflicts poison on it. The effect is amplified for each hit up to 5. Increase amplifier limit to 10 if dual wielding 2 daggers."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77 (1)Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
			text.add(new TranslationTextComponent("\u00A77 (2)Damaging a target inflicts poison on it. The effect is amplified for each hit up to 5. Increase amplifier limit to 10 if dual wielding 2 daggers."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
	@SubscribeEvent
	public static void witheringDaggerSet(ItemTooltipEvent event) {
		if(event.getPlayer() == null) return;
		if(!event.getItemStack().getItem().equals(ItemInit.WITHERING_TITAN_STEEL_DAGGER.get())) {
			return;
		}
		
		List<ITextComponent> text = Lists.newArrayList();
		text.add(event.getToolTip().get(0));
		text.add(new TranslationTextComponent(""));
		PlayerEntity player = event.getPlayer();
		boolean itemInSlot = false;
		if(event.getItemStack().equals(player.getHeldItemMainhand()) || event.getItemStack().equals(player.getHeldItemOffhand())) {
			text.add(new TranslationTextComponent("\u00A7b\u00A7nSet:"));
			itemInSlot = true;
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet:"));
		}
		
		if(player.getHeldItemMainhand().getItem().equals(ItemInit.WITHERING_TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Withering Titan Steel Dagger (Mainhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Withering Titan Steel Dagger (Mainhand)"));
		}
		
		if(player.getHeldItemOffhand().getItem().equals(ItemInit.WITHERING_TITAN_STEEL_DAGGER.get()) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7b- Withering Titan Steel Dagger (Offhand)"));
		} else {
			text.add(new TranslationTextComponent("\u00A77- Withering Titan Steel Dagger (Offhand)"));
		}
		
		if((player.getHeldItemMainhand().getItem().equals(ItemInit.WITHERING_TITAN_STEEL_DAGGER.get()) || event.getItemStack().equals(player.getHeldItemOffhand())) && itemInSlot) {
			text.add(new TranslationTextComponent("\u00A7a\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A7a (1)Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
			text.add(new TranslationTextComponent("\u00A7a (2)Damaging a target inflicts wither effect on it. The effect is amplified for each hit up to 5. Increase amplifier limit to 10 if dual wielding 2 daggers."));
		} else {
			text.add(new TranslationTextComponent("\u00A77\u00A7nSet bonus:"));
			text.add(new TranslationTextComponent("\u00A77 (1)Damaging a target has a 10% chance reduce their health by 10% of target max health. The chance is increased to 25% if dual wielding 2 daggers."));
			text.add(new TranslationTextComponent("\u00A77 (2)Damaging a target inflicts wither effect on it. The effect is amplified for each hit up to 5. Increase amplifier limit to 10 if dual wielding 2 daggers."));
		}
		for(int index = 1; index < event.getToolTip().size(); index++) {
			text.add(event.getToolTip().get(index));
		}
		event.getToolTip().clear();
		event.getToolTip().addAll(text);
	}
	
}
