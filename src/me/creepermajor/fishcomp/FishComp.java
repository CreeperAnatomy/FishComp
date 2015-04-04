package me.creepermajor.fishcomp;

import org.bukkit.plugin.java.JavaPlugin;

public class FishComp extends JavaPlugin {
	
	FishComp plugin;
	
	int fishpoints;
	int inkpoints;
	int salmonpoints;
	int pufferpoints;
	int clownpoints;
	
	public void onEnable() {
		plugin = this;
		fishpoints = getConfig().getInt("Fish-Points");
		inkpoints = getConfig().getInt("Ink-Points");
		salmonpoints = getConfig().getInt("Salmon-Points");
		pufferpoints = getConfig().getInt("Puffer-Points");
		clownpoints = getConfig().getInt("Clown-Points");
		getConfig().addDefault("Fish-Points", 10);
		getConfig().addDefault("Ink-Points", 20);
		getConfig().addDefault("Salmon-Points", 30);
		getConfig().addDefault("Puffer-Points", 40);
		getConfig().addDefault("Clown-Points", 50);
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	
	public void onDisable() {
		saveConfig();
	}

}
