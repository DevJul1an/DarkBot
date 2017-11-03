package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS22_MultiBlockUpdate extends AbstractPacketX implements ReadablePacket {
	private int x, z;
	private int[] blockData;

	public PacketS22_MultiBlockUpdate() {
		super(0x22, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		x = in.readInt();
		z = in.readInt();

		blockData = new int[in.readShort()];
		in.readInt();
		for(int i = 0; i < blockData.length; i++)
			blockData[i] = in.readInt();
	}

	public int getX() {
		return x;
	}

	public int getZ() {
		return z;
	}

	public int[] getBlockData() {
		return blockData;
	}
}
