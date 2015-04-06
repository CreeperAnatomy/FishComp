package me.creepermajor.fishcomp;

import java.util.Random;

import me.creepermajor.fishcomp.listeners.SignHandler;

import org.bukkit.plugin.java.JavaPlugin;

public class FishComp extends JavaPlugin {
	
	FishComp plugin;
	Random random = new Random();
	
	int fishpoints;
	int inkpoints;
	int salmonpoints;
	int pufferpoints;
	int clownpoints;
	String metric = "cm";
	
	int fishsize = random.nextInt(getConfig().getInt("Fish-Size-Max")) + getConfig().getInt("Fish-Size-Min");
	
	public void onEnable() {
		plugin = this;
		fishpoints = getConfig().getInt("Fish-Points");
		inkpoints = getConfig().getInt("Ink-Points");
		salmonpoints = getConfig().getInt("Salmon-Points");
		pufferpoints = getConfig().getInt("Puffer-Points");
		clownpoints = getConfig().getInt("Clown-Points");
		metric = getConfig().getString("Metric-Value");
		getConfig().addDefault("Fish-Points", 10);
		getConfig().addDefault("Ink-Points", 20);
		getConfig().addDefault("Salmon-Points", 30);
		getConfig().addDefault("Puffer-Points", 40);
		getConfig().addDefault("Clown-Points", 50);
		getConfig().addDefault("Fish-Size-Max", 100);
		getConfig().addDefault("Fish-Size-Min", 5);
		getConfig().addDefault("Metric-Value", "cm");
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new SignHandler(), this);
		
	}
	
	public void onDisable() {
		saveConfig();
	}

}
