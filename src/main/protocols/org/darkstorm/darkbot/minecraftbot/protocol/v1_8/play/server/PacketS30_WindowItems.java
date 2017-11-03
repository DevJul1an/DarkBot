package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;
import org.darkstorm.darkbot.minecraftbot.world.item.ItemStack;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS30_WindowItems extends AbstractPacketX implements ReadablePacket {
	private int windowId;
	private ItemStack[] items;

	public PacketS30_WindowItems() {
		super(0x30, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		windowId = in.readByte();
		short count = in.readShort();
		items = new ItemStack[count];

		for(int i = 0; i < count; i++)
			items[i] = readItemStack(in);
	}

	public int getWindowId() {
		return windowId;
	}

	public ItemStack[] getItems() {
		return items;
	}
}
