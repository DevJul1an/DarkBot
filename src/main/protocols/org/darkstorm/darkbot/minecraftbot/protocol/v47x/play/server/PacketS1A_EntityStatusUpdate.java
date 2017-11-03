package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS1A_EntityStatusUpdate extends PacketS14_EntityUpdate {
	private int status;

	public PacketS1A_EntityStatusUpdate() {
		super(0x1A);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		super.readData(in);

		status = in.read();
	}

	public int getStatus() {
		return status;
	}
}
