package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;
import org.darkstorm.darkbot.minecraftbot.world.Difficulty;
import org.darkstorm.darkbot.minecraftbot.world.Dimension;
import org.darkstorm.darkbot.minecraftbot.world.GameMode;
import org.darkstorm.darkbot.minecraftbot.world.WorldType;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS01_JoinGame extends AbstractPacketX implements ReadablePacket {
	private int playerId;
	private GameMode gameMode;
	private boolean hardcore;
	private Dimension dimension;
	private Difficulty difficulty;
	private int maxPlayers;
	private WorldType worldType;

	public PacketS01_JoinGame() {
		super(0x01, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		playerId = in.readInt();

		int gameModeValue = in.read();
		gameMode = GameMode.getGameModeById(gameModeValue & 0x7);
		hardcore = (gameModeValue & 0x8) == 0x8;

		dimension = Dimension.getDimensionById(in.read());
		difficulty = Difficulty.getDifficultyById(in.readByte());
		maxPlayers = in.read();

		worldType = WorldType.parseWorldType(readString(in));
	}

	public int getPlayerId() {
		return playerId;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public boolean isHardcore() {
		return hardcore;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public WorldType getWorldType() {
		return worldType;
	}
}
