package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC10_CreativeInventoryAction extends AbstractPacketX implements WriteablePacket {

	public PacketC10_CreativeInventoryAction() {
		super(0x00, State.PLAY, Direction.UPSTREAM);
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
	}
}
