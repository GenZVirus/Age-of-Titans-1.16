package com.GenZVirus.AgeOfTitans.Common.Events;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Common.Init.ItemInit;
import com.GenZVirus.VirusLIB.Titan.Titans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AgeOfTitans.MOD_ID, bus = Bus.FORGE)
public class TitanHeartEvents {

	@SubscribeEvent(receiveCanceled = true)
	public static void onItemToss(ItemTossEvent event) {
		if (event.getPlayer().world.isRemote())
			return;
		if (event.getEntityItem().getItem().getItem().equals(ItemInit.TITAN_HEART.get())) {
			event.setCanceled(true);
			if (event.getPlayer().inventory.add(4, ItemInit.TITAN_HEART.get().getDefaultInstance()))
				((ServerPlayerEntity) event.getPlayer()).connection.sendPacket(new SSetSlotPacket(-2, 4, ItemInit.TITAN_HEART.get().getDefaultInstance()));
		}
	}

	@SubscribeEvent(receiveCanceled = true)
	public static void onItemPickUp(EntityItemPickupEvent event) {
		if (event.getEntityLiving().world.isRemote)
			return;
		if (event.getItem().getItem().getItem().equals(ItemInit.TITAN_HEART.get())) {
			event.setCanceled(true);
			event.getItem().remove();
		}
	}

	@SubscribeEvent
	public static void checkInventory(PlayerEvent event) {
		PlayerEntity player = event.getPlayer();
		if (player.world.isRemote)
			return;
		if (Titans.getTitanFromPlayerUUID(player.getUniqueID()) == null)
			return;
		if (Titans.getTitanFromPlayerUUID(player.getUniqueID()).getStats() == null)
			return;
		if (Titans.getTitanFromPlayerUUID(player.getUniqueID()).getStats().getPlayerLevel() == 0)
			return;
		if (!player.inventory.getStackInSlot(4).getItem().equals(ItemInit.TITAN_HEART.get())) {
			ItemStack stack = player.inventory.getStackInSlot(4);
			player.inventory.setInventorySlotContents(4, ItemStack.EMPTY);
			if (player.inventory.add(4, ItemInit.TITAN_HEART.get().getDefaultInstance()))
				((ServerPlayerEntity) player).connection.sendPacket(new SSetSlotPacket(-2, 4, ItemInit.TITAN_HEART.get().getDefaultInstance()));
			int emptySlot = player.inventory.getFirstEmptyStack();
			if (player.inventory.add(emptySlot, stack))
				((ServerPlayerEntity) player).connection.sendPacket(new SSetSlotPacket(-2, emptySlot, stack));
			else
				player.dropItem(stack, true, false);
		}
	}
}
