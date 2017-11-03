package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC09_HeldItemChange extends AbstractPacketX implements WriteablePacket {
	private int slot;

	public PacketC09_HeldItemChange(int slot) {
		super(0x09, State.PLAY, Direction.UPSTREAM);

		this.slot = slot;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeShort(slot);
	}

	public int getSlot() {
		return slot;
	}
}
