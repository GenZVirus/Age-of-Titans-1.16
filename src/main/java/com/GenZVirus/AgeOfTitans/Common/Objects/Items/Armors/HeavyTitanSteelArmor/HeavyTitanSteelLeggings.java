package com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor;

import com.GenZVirus.AgeOfTitans.Client.ArmorModel.HeavyTitaniumArmor.HeavyTitanSteelLeggingsModel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HeavyTitanSteelLeggings extends ArmorItem{

	
	public HeavyTitanSteelLeggings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
		return (A) new HeavyTitanSteelLeggingsModel();
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return "ageoftitans:textures/models/armor/heavy_titan_steel_leggings.png";
	}
	
	
	
}
