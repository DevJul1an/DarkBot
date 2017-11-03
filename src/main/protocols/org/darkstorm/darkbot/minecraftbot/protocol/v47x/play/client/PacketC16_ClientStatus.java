package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC16_ClientStatus extends AbstractPacketX implements WriteablePacket {
	private int action;

	public PacketC16_ClientStatus(int action) {
		super(0x16, State.PLAY, Direction.UPSTREAM);

		this.action = action;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.write(action);
	}
}
