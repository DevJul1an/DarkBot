package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;
import org.darkstorm.darkbot.minecraftbot.world.Difficulty;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC15_ClientSettings extends AbstractPacketX implements WriteablePacket {
	private String locale;
	private ViewDistance viewDistance;
	private ChatMode chatMode;
	private Difficulty difficulty;
	private boolean showChatColors, showCape;

	public PacketC15_ClientSettings(String locale, ViewDistance viewDistance, ChatMode chatMode, Difficulty difficulty, boolean showChatColors, boolean showCape) {
		super(0x15, State.PLAY, Direction.UPSTREAM);

		this.locale = locale;
		this.viewDistance = viewDistance;
		this.chatMode = chatMode;
		this.difficulty = difficulty;
		this.showChatColors = showChatColors;
		this.showCape = showCape;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		writeString(locale, out);
		out.write(viewDistance.ordinal());
		out.write(chatMode.ordinal());
		out.writeBoolean(showChatColors);
		out.write(difficulty.getId());
		out.writeBoolean(showCape);
	}

	public String getLocale() {
		return locale;
	}

	public ViewDistance getViewDistance() {
		return viewDistance;
	}

	public ChatMode getChatMode() {
		return chatMode;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public boolean shouldShowChatColors() {
		return showChatColors;
	}

	public boolean shouldShowCape() {
		return showCape;
	}

	public enum ViewDistance {
		FAR,
		NORMAL,
		SHORT,
		TINY
	}

	public enum ChatMode {
		ENABLED,
		COMMANDS_ONLY,
		DISABLED,
	}
}
