package com.boybuscus.CokZorMOBS;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.WorldType;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class MevsimSaniyeChecker implements Runnable {
//her 1 saniyede 1 bu komutlarý yürütür
	@Override
	public void run() {
if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("kis")) {
			
			if (CokZorMobsListener.mevsimDonem == 0) {
				
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				
				
		
			}
			if (CokZorMobsListener.mevsimDonem == 2) {
				
			}
		}
		
//---------------------------------------------------------------------------------------------------------------------------------------------		
		if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("ilkbahar")) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getWorld().getWorldType() == WorldType.NORMAL) {
					
					if (Bukkit.getServer().getWorld(player.getWorld().getName()).getTime() == 450) {
						Random rand = new Random();
						if (rand.nextInt(100) <= 20) {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.GREEN + "Böylesine serin bir günde güneþin doðuþunu görmek, içini umutla dolduruyor!"));
								player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 11000, 0));
						} else {
							player.getWorld().setStorm(true);
						}
					}
				}
			}
			if (CokZorMobsListener.mevsimDonem == 0) {
				
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				
			}
			if (CokZorMobsListener.mevsimDonem == 2) {
				
			}
			
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------		
		if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("yaz")) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND && player.getLocation().getBlock().getType() != Material.WATER) {
					if (player.getLocation().getBlock().getWorld().getHighestBlockYAt(player.getLocation()) >= player.getLocation().getBlock().getLocation().getBlockY()) {
					if (player.getInventory().getBoots() == null) {
						player.damage(0.6);
						player.sendMessage(ChatColor.RED + "AYAKLARIM YANIYOR!");
					}
				}
				}
			}
		
			if (CokZorMobsListener.mevsimDonem == 0) {
				
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (player.getInventory().getArmorContents() == null) {
						Random rand = new Random();
						if (rand.nextInt(100) <= 40) {
							if (!player.hasPotionEffect(PotionEffectType.SPEED)) {
								player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 0));
								
								player.sendMessage(ChatColor.YELLOW + "Püfür püfür rüzgarý teninde hissediyorsun, yaz ortasýnda zýrhsýz dolaþmak ne güzel þey!\nÜstündeki hafiflik sayesinde hýzlandýðýný hissediyorsun!!");
							}
						}
					}
				}
			
			}
			if (CokZorMobsListener.mevsimDonem == 2) {
				
			}
			
		}

//---------------------------------------------------------------------------------------------------------------------------------------------	
		
	if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("sonbahar")) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.getWorld().getWorldType() == WorldType.NORMAL) {
				
				if (Bukkit.getServer().getWorld(player.getWorld().getName()).getTime() <= 450 && Bukkit.getServer().getWorld(player.getWorld().getName()).getTime() >= 550) {
					Random rand = new Random();
					if (rand.nextInt(100) <= 30) {
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.GREEN + "Böylesine serin bir günde güneþin doðuþunu görmek, içini umutla dolduruyor!"));
						
		
						player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 11000, 0));
					} else {
						player.getWorld().setStorm(true);
					}
				}
			}
		}
		
		if (CokZorMobsListener.mevsimDonem == 0) {
			
		}
		
		if (CokZorMobsListener.mevsimDonem == 1) {
			
		}
		if (CokZorMobsListener.mevsimDonem == 2) {
			
		}
		
		}
	

	}

}
