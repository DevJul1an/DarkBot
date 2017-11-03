package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS14_EntityUpdate extends AbstractPacketX implements ReadablePacket {
	private int entityId;

	public PacketS14_EntityUpdate() {
		super(0x14, State.PLAY, Direction.DOWNSTREAM);
	}

	protected PacketS14_EntityUpdate(int id) {
		super(id, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		entityId = in.readInt();
	}

	public int getEntityId() {
		return entityId;
	}
}
