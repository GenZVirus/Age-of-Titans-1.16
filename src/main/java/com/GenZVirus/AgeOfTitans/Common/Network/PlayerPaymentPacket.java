package com.GenZVirus.AgeOfTitans.Common.Network;

import java.util.UUID;
import java.util.function.Supplier;

import com.GenZVirus.VirusLIB.IPlayerStats;
import com.GenZVirus.VirusLIB.Network.PacketHandler;
import com.GenZVirus.VirusLIB.Network.SyncStatsPacket;
import com.GenZVirus.VirusLIB.Titan.Titans;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class PlayerPaymentPacket {

	public UUID uuid;
	public String element;
	public int value;

	public PlayerPaymentPacket(UUID uuid, String element, int value) {
		this.uuid = uuid;
		this.element = element;
		this.value = value;
	}

	public static void encode(PlayerPaymentPacket pkt, PacketBuffer buf) {
		buf.writeUniqueId(pkt.uuid);
		buf.writeString(pkt.element);
		buf.writeInt(pkt.value);
	}

	public static PlayerPaymentPacket decode(PacketBuffer buf) {
		return new PlayerPaymentPacket(buf.readUniqueId(), buf.readString(32767), buf.readInt());
	}

	public static void handle(PlayerPaymentPacket pkt, Supplier<NetworkEvent.Context> ctx) {

		ctx.get().enqueueWork(() -> {
			if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
				IPlayerStats stats = Titans.getTitanFromPlayerUUID(pkt.uuid).getStats();
				stats.setBalance(stats.getBalance() + pkt.value);
				PacketHandler.INSTANCE.sendTo(new SyncStatsPacket(stats.getApplesEaten(), stats.getBalance(), stats.getMaxRagePoints(), stats.getPlayerEXP(), stats.getPlayerLevel(), stats.getPoints(),
						stats.getRagePoints()), Titans.getTitanFromPlayerUUID(pkt.uuid).getPlayer().connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);

			}
		});

		ctx.get().setPacketHandled(true);
	}

}
