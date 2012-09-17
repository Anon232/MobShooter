package com.github.anon232.MobShooter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class MobShooter extends JavaPlugin{

	@Override
	public void onEnable(){
		getLogger().info("Starting Mob Shooter...");

		getCommand("ms").setExecutor(new MSCommandExecutor(this));
		Bukkit.getPluginManager().registerEvents(new MSCommandExecutor(this),this );

	}

	@Override
	public void onDisable(){
		getLogger().info("MobShooter has been disabled...");

	}
}
