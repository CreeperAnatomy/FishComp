package me.creepermajor.fishcomp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
public class SignHandler implements Listener {


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
	    if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	        if(e.getClickedBlock().getTypeId() == 63 || e.getClickedBlock().getTypeId() == 68) {
	            Sign sign = (Sign) e.getClickedBlock().getState();
	            Player p = e.getPlayer();
	            if (sign.getLine(0).equalsIgnoreCase(ChatColor.BLUE + "[Enter]") && sign.getLine(1).equalsIgnoreCase("Fish Comp")) {
	            	p.sendMessage("You clicked teh sign");
	            }
	        }
	    }
	}
	
	@EventHandler
	public void onChange(final SignChangeEvent e) {
		
		if(e.isCancelled()) { return; }
		
		if(!(ChatColor.stripColor(e.getLine(0)).equalsIgnoreCase("[Enter]"))) {
			return;
		}
		
		e.setLine(0, ChatColor.BLUE + "[Enter]");
		e.setLine(1, "Fish Comp");
		
	}

}
