package com.GenZVirus.AgeOfTitans.Common.Network;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;
import com.GenZVirus.AgeOfTitans.Client.Network.ReaperLoadPacket;
import com.GenZVirus.AgeOfTitans.Common.Network.SDW.SendPlayerHandPacket;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandlerCommon {

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(AgeOfTitans.MOD_ID, "aot"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void init() {
		int id = 0;
		
		INSTANCE.messageBuilder(sendTileEntityDataPacket.class, id++)
				.encoder(sendTileEntityDataPacket::encode)
				.decoder(sendTileEntityDataPacket::decode)
				.consumer(sendTileEntityDataPacket::handle)
				.add();
		
		INSTANCE.messageBuilder(SendPlayerHandPacket.class, id++)
		.encoder(SendPlayerHandPacket::encode)
		.decoder(SendPlayerHandPacket::decode)
		.consumer(SendPlayerHandPacket::handle)
		.add();	

		INSTANCE.messageBuilder(ReaperInteractionPacket.class, id++)
		.encoder(ReaperInteractionPacket::encode)
		.decoder(ReaperInteractionPacket::decode)
		.consumer(ReaperInteractionPacket::handle)
		.add();	
		
		INSTANCE.messageBuilder(ReaperLoadPacket.class, id++)
		.encoder(ReaperLoadPacket::encode)
		.decoder(ReaperLoadPacket::decode)
		.consumer(ReaperLoadPacket::handle)
		.add();	
		
		INSTANCE.messageBuilder(PlayerPaymentPacket.class, id++)
		.encoder(PlayerPaymentPacket::encode)
		.decoder(PlayerPaymentPacket::decode)
		.consumer(PlayerPaymentPacket::handle)
		.add();	
		
		INSTANCE.messageBuilder(GivePlayerItemsPacket.class, id++)
		.encoder(GivePlayerItemsPacket::encode)
		.decoder(GivePlayerItemsPacket::decode)
		.consumer(GivePlayerItemsPacket::handle)
		.add();
	}
}
