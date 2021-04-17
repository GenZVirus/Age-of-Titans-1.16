package com.GenZVirus.AgeOfTitans.Common.Objects.Items.Orbs;

import java.util.List;
import java.util.function.Function;

import com.GenZVirus.AgeOfTitans.Common.Objects.Items.PricedItem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

public class OrbOfNether extends Item implements PricedItem {

	private int price = 0;

	public OrbOfNether(Properties properties) {
		super(properties);
		this.price = 1000;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent(""));
		tooltip.add(new StringTextComponent("\u00A75Teleports the user between Nether and Overworld"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote)
			return super.onItemRightClick(worldIn, playerIn, handIn);
		RegistryKey<World> registrykey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_nether"));
		if (worldIn.getDimensionKey().equals(registrykey)) {
			registrykey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("overworld"));
		}
		ServerWorld serverworld = worldIn.getServer().getWorld(registrykey);
		playerIn.changeDimension(serverworld, new ITeleporter() {
			@SuppressWarnings("deprecation")
			@Override
			public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
				Entity repositionedEntity = repositionEntity.apply(false);
				BlockPos pos = new BlockPos(playerIn.getPosition().getX(), 64, playerIn.getPosition().getZ());
				while (!destWorld.getBlockState(pos).isAir() || !destWorld.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isAir()) {
					pos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
				}
				while (destWorld.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isAir()) {
					pos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
				}
				repositionedEntity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
				return repositionedEntity;
			}
		});
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return super.getBurnTime(itemStack);
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}
