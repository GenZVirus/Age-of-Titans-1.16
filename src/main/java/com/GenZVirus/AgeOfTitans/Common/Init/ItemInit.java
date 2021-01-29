package com.GenZVirus.AgeOfTitans.Common.Init;

import java.util.function.Supplier;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.AgeOfTitans.AgeOfTitansItemGroup;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.FruitOfTheGods;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Keystone;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.SpecialItem;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitaniumArmor.HeavyTitaniumBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitaniumArmor.HeavyTitaniumChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitaniumArmor.HeavyTitaniumHelmet;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.HeavyTitaniumArmor.HeavyTitaniumLeggings;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitaniumArmor.LightTitaniumBoots;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitaniumArmor.LightTitaniumChestplate;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitaniumArmor.LightTitaniumHood;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Armors.LightTitaniumArmor.LightTitaniumLeggings;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Daggers.DaggerItem;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.Daggers.DemonicDagger;
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
//	public static final RegistryObject<Item> ORB_OF_NETHER = ITEMS.register("orb_of_nether", () -> new OrbOfNether(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
//	public static final RegistryObject<Item> ORB_OF_END = ITEMS.register("orb_of_end", () -> new OrbOfEnd(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
//	public static final RegistryObject<Item> ORB_OF_SUMMONING = ITEMS.register("orb_of_summoning", () -> new OrbOfSummoning(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
//	public static final RegistryObject<Item> ORB_OF_DISLOCATION = ITEMS.register("orb_of_dislocation", () -> new OrbOfDislocation(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> ORB_OF_STORAGE = ITEMS.register("orb_of_storage", () -> new OrbOfStorage(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> KEYSTONE = ITEMS.register("keystone", () -> new Keystone(new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	public static final RegistryObject<Item> SOUL_SHARD = ITEMS.register("soul_shard", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> WITHER_DUST = ITEMS.register("wither_dust", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	//Ingots
	public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	
	//TestItem
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new SpecialItem(new Item.Properties().group(AgeOfTitansItemGroup.instance).maxStackSize(1)));
	
	//Weapons
	public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(ModItemTier.MATERIAL_TITANIUM, 12, -2.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITANIUM_DAGGER = ITEMS.register("titanium_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITANIUM, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> POISONOUS_TITANIUM_DAGGER = ITEMS.register("poisonous_titanium_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITANIUM, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> WITHERING_TITANIUM_DAGGER = ITEMS.register("withering_titanium_dagger", () -> new DaggerItem(ModItemTier.MATERIAL_TITANIUM, 7, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	public static final RegistryObject<Item> DEMONIC_DAGGER = ITEMS.register("demonic_dagger", () -> new DemonicDagger(ModItemTier.MATERIAL_TITANIUM, 17, -1.4F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));	
	
	//Tools
	public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(ModItemTier.MATERIAL_TITANIUM, 4, -2.8F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(ModItemTier.MATERIAL_TITANIUM, 2, -3.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(ModItemTier.MATERIAL_TITANIUM, 8, -3.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(ModItemTier.MATERIAL_TITANIUM, 5, 0.0F, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
		
	//Armor
	public static final RegistryObject<Item> HEAVY_TITANIUM_HELMET = ITEMS.register("heavy_titanium_helmet", () -> new HeavyTitaniumHelmet(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.HEAD, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITANIUM_CHESTPLATE = ITEMS.register("heavy_titanium_chestplate", () -> new HeavyTitaniumChestplate(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.CHEST, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITANIUM_LEGGINGS = ITEMS.register("heavy_titanium_leggings", () -> new HeavyTitaniumLeggings(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.LEGS, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> HEAVY_TITANIUM_BOOTS = ITEMS.register("heavy_titanium_boots", () -> new HeavyTitaniumBoots(ModArmorMaterial.HEAVY_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.FEET, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	
	public static final RegistryObject<Item> LIGHT_TITANIUM_HOOD = ITEMS.register("light_titanium_hood", () -> new LightTitaniumHood(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.HEAD, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITANIUM_CHESTPLATE = ITEMS.register("light_titanium_chestplate", () -> new LightTitaniumChestplate(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.CHEST, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITANIUM_LEGGINGS = ITEMS.register("light_titanium_leggings", () -> new LightTitaniumLeggings(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.LEGS, new Item.Properties().group(AgeOfTitansItemGroup.instance)));
	public static final RegistryObject<Item> LIGHT_TITANIUM_BOOTS = ITEMS.register("light_titanium_boots", () -> new LightTitaniumBoots(ModArmorMaterial.LIGHT_ARMOR_MATERIAL_TITANIUM, EquipmentSlotType.FEET, new Item.Properties().group(AgeOfTitansItemGroup.instance)));

	
	public enum ModItemTier implements IItemTier{
		MATERIAL_TITANIUM(8, 4000, 16.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.TITANIUM_INGOT.get());
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
		HEAVY_ARMOR_MATERIAL_TITANIUM(AgeOfTitans.MOD_ID + ":heavy_titanium", 50, new int[] {7, 9, 11, 8}, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.TITANIUM_INGOT.get());
		}),
		LIGHT_ARMOR_MATERIAL_TITANIUM(AgeOfTitans.MOD_ID + ":light_titanium", 50, new int[] {6, 7, 9, 6}, 300, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.7F, () -> {
			return Ingredient.fromItems(ItemInit.TITANIUM_INGOT.get());
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
