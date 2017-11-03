package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS13_DespawnEntities extends AbstractPacketX implements ReadablePacket {
	private int[] entityIds;

	public PacketS13_DespawnEntities() {
		super(0x13, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		int length = in.read();
		int[] entityIds = new int[length];
		for(int i = 0; i < length; i++)
			entityIds[i] = in.readInt();
		this.entityIds = entityIds;
	}

	public int[] getEntityIds() {
		return entityIds.clone();
	}
}
