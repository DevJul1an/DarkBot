package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS34_MapUpdate extends AbstractPacketX implements ReadablePacket {
	private int mapId;
	private byte[] data;

	public PacketS34_MapUpdate() {
		super(0x34, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		mapId = readVarInt(in);
		data = readByteArray(in);
	}

	public int getMapId() {
		return mapId;
	}

	public byte[] getData() {
		return data;
	}
}
