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

public class MevsimSaniyeChecker implements Runnable {
//her 1 saniyede 1 bu komutlar� y�r�t�r
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
						if (rand.nextInt(100) <= 10) {
							player.sendMessage(ChatColor.GREEN + "B�ylesine ferah bir g�nde g�ne�in do�u�unu g�rmek, i�ini umutla dolduruyor!");
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
					if (player.getInventory().getBoots() == null) {
						player.damage(0.6);
						player.sendMessage(ChatColor.RED + "AYAKLARIM YANIYOR!");
					}
					
				}
			}
		
			if (CokZorMobsListener.mevsimDonem == 0) {
				
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (player.getInventory().getArmorContents() == null) {
						Random rand = new Random();
						if (rand.nextInt(100) <= 1) {
							if (!player.hasPotionEffect(PotionEffectType.SPEED)) {
								player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 0));
								player.sendMessage(ChatColor.YELLOW + "P�f�r p�f�r r�zgar� teninde hissediyorsun, yaz ortas�nda z�rhs�z dola�mak ne g�zel �ey!\n�st�ndeki hafiflik sayesinde h�zland���n� hissediyorsun!!");
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
				
				if (Bukkit.getServer().getWorld(player.getWorld().getName()).getTime() == 450) {
					Random rand = new Random();
					if (rand.nextInt(100) <= 10) {
						player.sendMessage(ChatColor.GOLD + "B�ylesine serin bir g�nde g�ne�in do�u�unu g�rmek, i�ini umutla dolduruyor!");
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
