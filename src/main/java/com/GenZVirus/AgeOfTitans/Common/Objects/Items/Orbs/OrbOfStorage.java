package com.GenZVirus.AgeOfTitans.Common.Objects.Items.Orbs;

import java.util.List;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Network.PacketHandlerCommon;
import com.GenZVirus.AgeOfTitans.Common.Network.sendTileEntityDataPacket;
import com.GenZVirus.AgeOfTitans.Common.Objects.Items.PricedItem;

import net.minecraft.block.ContainerBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkHooks;

public class OrbOfStorage extends Item implements PricedItem {

	private int price = 0;
	
	public OrbOfStorage(Properties properties) {
		super(properties);
		this.price = 500;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent(""));
		tooltip.add(new StringTextComponent("\u00A75Once bound to a Titan's Locker it will show the user the contents."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@SuppressWarnings("resource")
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().isRemote)
			return ActionResultType.FAIL;
		BlockPos blockPos = context.getPos();
		if (context.getWorld().getBlockState(blockPos).getBlock() instanceof ContainerBlock) {
			ItemStack stack = context.getItem();
			CompoundNBT nbt = stack.getOrCreateTag();
			context.getWorld().getServer().getWorld(context.getWorld().getDimensionKey()).forceChunk(blockPos.getX(), blockPos.getZ(), false);
			nbt.putInt("posX", blockPos.getX());
			nbt.putInt("posY", blockPos.getY());
			nbt.putInt("posZ", blockPos.getZ());
			nbt.putString("modid", context.getWorld().getDimensionKey().getLocation().getNamespace());
			nbt.putString("dimensionID", context.getWorld().getDimensionKey().getLocation().getPath());
			context.getWorld().getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(nbt.getString("modid"),nbt.getString("dimensionID"))));
			stack.write(nbt);
		} else {
			ItemStack stack = context.getItem();
			CompoundNBT nbt = stack.getOrCreateTag();
			BlockPos pos = new BlockPos(nbt.getInt("posX"), nbt.getInt("posY"), nbt.getInt("posZ"));
			context.getWorld().getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(nbt.getString("modid"),nbt.getString("dimensionID"))))
					.forceChunk(pos.getX(), pos.getZ(), true);
			INamedContainerProvider namedContainerProvider = (INamedContainerProvider) context.getWorld().getServer()
					.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(nbt.getString("modid"),nbt.getString("dimensionID")))).getTileEntity(pos);
			if (namedContainerProvider != null) {
				if (!(context.getPlayer() instanceof ServerPlayerEntity))
					return super.onItemUse(context); // should always be true, but just in case...
				ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) context.getPlayer();
				NetworkHooks.openGui(serverPlayerEntity, namedContainerProvider, (packetBuffer) -> {
				});
				AgeOfTitans.LOGGER.info("Titan's Locker opened!");
				// (packetBuffer)->{} is just a do-nothing because we have no extra data to send
				PacketHandlerCommon.INSTANCE.sendTo(
						new sendTileEntityDataPacket(pos.getX(), pos.getY(), pos.getZ(), nbt.getInt("dimensionID")),
						((ServerPlayerEntity) context.getPlayer()).connection.netManager,
						NetworkDirection.PLAY_TO_CLIENT);
			}
		}
		return super.onItemUse(context);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (worldIn.isRemote)
			return ActionResult.resultFail(stack);
		if (stack.getTag() != null) {
			CompoundNBT nbt = stack.getTag();
			BlockPos pos = new BlockPos(nbt.getInt("posX"), nbt.getInt("posY"), nbt.getInt("posZ"));
			worldIn.getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(nbt.getString("modid"),nbt.getString("dimensionID"))))
					.forceChunk(pos.getX(), pos.getZ(), true);
			INamedContainerProvider namedContainerProvider = (INamedContainerProvider) worldIn.getServer()
					.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(nbt.getString("modid"),nbt.getString("dimensionID")))).getTileEntity(pos);
			if (namedContainerProvider != null) {
				if (!(playerIn instanceof ServerPlayerEntity))
					return ActionResult.resultFail(stack); // should always be true, but just in case...
				ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerIn;
				NetworkHooks.openGui(serverPlayerEntity, namedContainerProvider, (packetBuffer) -> {
				});
				AgeOfTitans.LOGGER.info("Titan's Locker opened!");
				// (packetBuffer)->{} is just a do-nothing because we have no extra data to send
				PacketHandlerCommon.INSTANCE.sendTo(
						new sendTileEntityDataPacket(pos.getX(), pos.getY(), pos.getZ(), nbt.getInt("dimensionID")),
						((ServerPlayerEntity) playerIn).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
			} else {
				nbt.putInt("posX", 0);
				nbt.putInt("posY", 0);
				nbt.putInt("posZ", 0);
				stack.write(nbt);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
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
