package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS0D_CollectItem extends AbstractPacketX implements ReadablePacket {
	private int itemEntityId, collectorEntityId;

	public PacketS0D_CollectItem() {
		super(0x0D, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		itemEntityId = in.readInt();
		collectorEntityId = in.readInt();
	}

	public int getItemEntityId() {
		return itemEntityId;
	}

	public int getCollectorEntityId() {
		return collectorEntityId;
	}
}
