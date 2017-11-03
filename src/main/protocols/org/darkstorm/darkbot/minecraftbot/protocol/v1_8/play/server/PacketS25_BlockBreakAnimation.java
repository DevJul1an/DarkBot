package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS25_BlockBreakAnimation extends AbstractPacketX implements ReadablePacket {
	private int entityId, x, y, z, destroyStage;

	public PacketS25_BlockBreakAnimation() {
		super(0x25, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		entityId = readVarInt(in);
		x = in.readInt();
		y = in.readInt();
		z = in.readInt();
		destroyStage = in.read();
	}

	public int getEntityId() {
		return entityId;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getDestroyStage() {
		return destroyStage;
	}
}
