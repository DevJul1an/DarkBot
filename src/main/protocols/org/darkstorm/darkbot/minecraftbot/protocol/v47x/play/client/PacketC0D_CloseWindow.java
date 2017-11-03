package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC0D_CloseWindow extends AbstractPacketX implements WriteablePacket {
	private int windowId;

	public PacketC0D_CloseWindow(int windowId) {
		super(0x0D, State.PLAY, Direction.UPSTREAM);

		this.windowId = windowId;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeByte(windowId);
	}

	public int getWindowId() {
		return windowId;
	}
}
