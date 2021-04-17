package com.GenZVirus.AgeOfTitans.Common.Init;

import java.util.function.Supplier;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.AgeOfTitans.AgeOfTitansItemGroup;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.FruitOfTheGods;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Keystone;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.SpecialItem;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelHelmet;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitanSteelArmor.HeavyTitanSteelLeggings;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelHood;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitanSteelArmor.LightTitanSteelLeggings;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Daggers.DaggerItem;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Daggers.DemonicDagger;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Orbs.OrbOfEnd;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Orbs.OrbOfNether;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Orbs.OrbOfStorage;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * ItemInit class
*/

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AgeOfTitans.MOD_ID);

	/*
     * Here are the instances of custom items added to the game
    */
	public static final RegistryObject<Item> FRUIT_OF_THE_GODS = ITEMS.register("fruit_of_the_gods", () -> new FruitOfTheGods(new Item.Properties().group(AgeOfTitansItemGroup.instance).food(new Food.Builder().hunger(20).saturation(20.0f).setAlwaysEdible().build())));
//	public static final RegistryObject<Item> ORB_OF_EDEN = ITEMS.register("orb_of_eden", () -> new OrbOfEden(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> ORB_OF_NETHER = ITEMS.register("orb_of_nether", () -> new OrbOfNether(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> ORB_OF_END = ITEMS.register("orb_of_end", () -> new OrbOfEnd(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
//	public static final RegistryObject<Item> ORB_OF_SUMMONING = ITEMS.register("orb_of_summoning", () -> new OrbOfSummoning(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
//	public static final RegistryObject<Item> ORB_OF_DISLOCATION = ITEMS.register("orb_of_dislocation", () -> new OrbOfDislocation(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> ORB_OF_STORAGE = ITEMS.register("orb_of_storage", () -> new OrbOfStorage(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> KEYSTONE = ITEMS.register("keystone", () -> new Keystone(new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	public static final RegistryObject<Item> SOUL_SHARD = ITEMS.register("soul_shard", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> WITHER_DUST = ITEMS.register("wither_dust", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	//Materials
	public static final RegistryObject<Item> TITAN_STEEL_INGOT = ITEMS.register("titan_steel_ingot", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	
	//TestItem
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new SpecialItem(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	
	//Weapons
	public static final RegistryObject<Item> TITAN_STEEL_SWORD = ITEMS.register("titan_steel_sword", () -> new SwordItem(ModItemTier.MATERIAL_TITAN_STEEL, 12, -2.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITAN_STEEL_DAGGER = ITEMS.register("titan_steel_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITAN_STEEL, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> POISONOUS_TITAN_STEEL_DAGGER = ITEMS.register("poisonous_titan_steel_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITAN_STEEL, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> WITHERING_TITAN_STEEL_DAGGER = ITEMS.register("withering_titan_steel_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITAN_STEEL, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> DEMONIC_DAGGER = ITEMS.register("demonic_dagger", () -> new DemonicDagger(ModItemTier.MATERIAL_TITAN_STEEL, 17, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	
	//Tools
	public static final RegistryObject<Item> TITAN_STEEL_PICKAXE = ITEMS.register("titan_steel_pickaxe", () -> new PickaxeItem(ModItemTier.MATERIAL_TITAN_STEEL, 4, -2.8F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITAN_STEEL_SHOVEL = ITEMS.register("titan_steel_shovel", () -> new ShovelItem(ModItemTier.MATERIAL_TITAN_STEEL, 2, -3.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITAN_STEEL_AXE = ITEMS.register("titan_steel_axe", () -> new AxeItem(ModItemTier.MATERIAL_TITAN_STEEL, 8, -3.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITAN_STEEL_HOE = ITEMS.register("titan_steel_hoe", () -> new HoeItem(ModItemTier.MATERIAL_TITAN_STEEL, 5, 0.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
		
	//Armor
	public static final RegistryObject<Item> HEAVY_TITAN_STEEL_HELMET = ITEMS.register("heavy_titan_steel_helmet", () -> new HeavyTitanSteelHelmet(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITAN_STEEL_CHESTPLATE = ITEMS.register("heavy_titan_steel_chestplate", () -> new HeavyTitanSteelChestplate(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITAN_STEEL_LEGGINGS = ITEMS.register("heavy_titan_steel_leggings", () -> new HeavyTitanSteelLeggings(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITAN_STEEL_BOOTS = ITEMS.register("heavy_titan_steel_boots", () -> new HeavyTitanSteelBoots(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.FEET, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	
	public static final RegistryObject<Item> LIGHT_TITAN_STEEL_HOOD = ITEMS.register("light_titan_steel_hood", () -> new LightTitanSteelHood(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITAN_STEEL_CHESTPLATE = ITEMS.register("light_titan_steel_chestplate", () -> new LightTitanSteelChestplate(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITAN_STEEL_LEGGINGS = ITEMS.register("light_titan_steel_leggings", () -> new LightTitanSteelLeggings(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITAN_STEEL_BOOTS = ITEMS.register("light_titan_steel_boots", () -> new LightTitanSteelBoots(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITAN_STEEL, EquipmentSlotType.FEET, new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	//Heart
	public static final RegistryObject<Item> TITAN_HEART = ITEMS.register("titan_heart", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));	
	
	public enum ModItemTier implements IItemTier{
		MATERIAL_TITAN_STEEL(8, 4000, 16.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.TITAN_STEEL_INGOT.get());
		}); 
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
	}
	
	public enum ModArmorMaterial implements IArmorMaterial{
		HEAVY_ARMOR_MATERIAL_TITAN_STEEL(AgeOfTitans.MOD_ID + ":heavy_titan_steel", 50, new int[] {7, 9, 11, 8}, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.TITAN_STEEL_INGOT.get());
		}),
		LIGHT_ARMOR_MATERIAL_TITAN_STEEL(AgeOfTitans.MOD_ID + ":light_titan_steel", 50, new int[] {6, 7, 9, 6}, 300, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.7F, () -> {
			return Ingredient.fromItems(ItemInit.TITAN_STEEL_INGOT.get());
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactor;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
		
	}
	
}
