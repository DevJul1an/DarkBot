package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC01_Chat extends AbstractPacketX implements WriteablePacket {
	private String message;

	public PacketC01_Chat(String message) {
		super(0x01, State.PLAY, Direction.UPSTREAM);

		this.message = message;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		writeString(message, out);
	}

	public String getMessage() {
		return message;
	}
}
