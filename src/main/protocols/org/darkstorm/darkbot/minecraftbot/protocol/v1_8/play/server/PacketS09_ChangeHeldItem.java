package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS09_ChangeHeldItem extends AbstractPacketX implements ReadablePacket {
	private int slot;

	public PacketS09_ChangeHeldItem() {
		super(0x09, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		slot = in.read();
	}

	public int getSlot() {
		return slot;
	}
}
