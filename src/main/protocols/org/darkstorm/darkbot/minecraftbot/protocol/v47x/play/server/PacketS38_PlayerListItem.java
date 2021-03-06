package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS38_PlayerListItem extends AbstractPacketX implements ReadablePacket {
	private String playerName;
	private boolean online;
	private int ping;

	public PacketS38_PlayerListItem() {
		super(0x38, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		playerName = readString(in);
		online = in.readBoolean();
		ping = in.readShort();
	}

	public String getPlayerName() {
		return playerName;
	}

	public boolean isOnline() {
		return online;
	}

	public int getPing() {
		return ping;
	}
}
