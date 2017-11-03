package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS06_UpdateHealth extends AbstractPacketX implements ReadablePacket {
	private double health;
	private int food;
	private double foodSaturation;

	public PacketS06_UpdateHealth() {
		super(0x06, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		health = in.readFloat();
		food = in.readShort();
		foodSaturation = in.readFloat();
	}

	public double getHealth() {
		return health;
	}

	public int getFood() {
		return food;
	}

	public double getFoodSaturation() {
		return foodSaturation;
	}
}
