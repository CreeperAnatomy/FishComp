package me.creepermajor.fishcomp.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {

	private YamlConfiguration playerdata;
	private File playerdatafile;
	String playername;
	
	public PlayerData(File pdf, String playername)
	{
		this.playerdata = new YamlConfiguration();
		this.playerdatafile = pdf;
		this.playername = playername;
	}
	
	public boolean load() {
		if(!playerdatafile.exists()) {
			try {
				playerdatafile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			loadDefaults();
		}
			try {
				playerdata.load(playerdatafile);
			} catch (IOException | InvalidConfigurationException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
	
	public boolean save() {
		try {
			playerdata.save(playerdatafile);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void loadDefaults() {
		playerdata.addDefault("Player.name", playername);
	}
	
}
