package com.github.anon232.MobShooter;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import java.util.logging.Logger;
public class MSCommandExecutor implements CommandExecutor,Listener{

	private Plugin plugin;
	private EntityType mob;
	public String mobName;
	public EntityType p;
	
	public MSCommandExecutor(MobShooter plugin){
		this.plugin = plugin;
	}
	


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = null;
		if(sender instanceof Player){
			p = (Player)sender;
		}
		else return false;
		mob = EntityType.fromName(args[0].toUpperCase());
		sender.sendMessage(mob.toString());
		mobName = args[0];
		sender.sendMessage("Current Entity is "+ p);
		sender.sendMessage("Entity Set To " + mobName );
		return true;
	
	}


	@EventHandler(priority=EventPriority.HIGHEST)
	public void ArrowEntity(EntityShootBowEvent e) {
		//heres your event 1 sec
		Creeper creeper = e.getEntity().getWorld().spawn(e.getEntity().getLocation(), Creeper.class);
		creeper.setVelocity(e.getEntity().getEyeLocation().getDirection().multiply(2));
		e.setProjectile(creeper);
		
		//e.setProjectile(e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), mob));

	}
}
