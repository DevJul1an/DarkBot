package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS24_BlockAction extends AbstractPacketX implements ReadablePacket {
	private int x, y, z;
	private int blockId, data1, data2;

	public PacketS24_BlockAction() {
		super(0x24, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		x = in.readInt();
		y = in.readShort();
		z = in.readInt();

		data1 = in.read();
		data2 = in.read();
		blockId = readVarInt(in);
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

	public int getBlockId() {
		return blockId;
	}

	public int getData1() {
		return data1;
	}

	public int getData2() {
		return data2;
	}
}
