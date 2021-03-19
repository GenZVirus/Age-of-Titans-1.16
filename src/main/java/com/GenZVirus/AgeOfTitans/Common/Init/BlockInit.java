package com.GenZVirus.AgeOfTitans.Common.Init;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Objects.Blocks.SoulStone;
import com.GenZVirus.AgeOfTitans.Common.Objects.Blocks.TitanLocker;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * BlockInit class
*/


public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AgeOfTitans.MOD_ID);
	
	/*
	 * Here are the instances of custom blocks added to the game
	 */
	
	public static final RegistryObject<Block> TITAN_STEEL_BLOCK = BLOCKS.register("titan_steel_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(10.0F, 1000.0F).sound(SoundType.METAL).harvestLevel(3)));
	public static final RegistryObject<Block> TITAN_STEEL_ORE = BLOCKS.register("titan_steel_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(10.0F, 1000.0F).sound(SoundType.STONE).harvestLevel(3)));
	public static final RegistryObject<Block> TITAN_LOCKER = BLOCKS.register("titan_locker", () -> new TitanLocker(Block.Properties.create(Material.IRON).hardnessAndResistance(10.0F, 3000.0F).sound(SoundType.METAL).harvestLevel(3)));
	public static final RegistryObject<Block> SOUL_STONE = BLOCKS.register("soul_stone", () -> new SoulStone(Block.Properties.create(Material.ROCK).hardnessAndResistance(10.0F, 1000.0F).sound(SoundType.STONE).harvestLevel(3)));
}
