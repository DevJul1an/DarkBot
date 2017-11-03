package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS32_ConfirmTransaction extends AbstractPacketX implements ReadablePacket {
	private int windowId, actionId;
	private boolean accepted;

	public PacketS32_ConfirmTransaction() {
		super(0x32, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		windowId = in.readByte();
		actionId = in.readShort();
		accepted = in.readBoolean();
	}

	public int getWindowId() {
		return windowId;
	}

	public int getActionId() {
		return actionId;
	}

	public boolean isAccepted() {
		return accepted;
	}
}
