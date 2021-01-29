package com.GenZVirus.AgeOfTitans.Common.Network;

import com.GenZVirus.AgeOfTitans.AgeOfTitans;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandlerCommon {

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(AgeOfTitans.MOD_ID, "spell"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void init() {
		int id = 0;
		
		INSTANCE.messageBuilder(sendTileEntityDataPacket.class, id++)
				.encoder(sendTileEntityDataPacket::encode)
				.decoder(sendTileEntityDataPacket::decode)
				.consumer(sendTileEntityDataPacket::handle)
				.add();

	}
}
