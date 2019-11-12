package com.boybuscus.CokZorMOBS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import io.netty.util.internal.ThreadLocalRandom;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class MevsimTickChecker implements Runnable {
//bu class her 10 saniyede 1 bu komutlarý yürütür:
	private int sekizbl;
	@Override
	public void run() {
		
		if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("kis")) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getLocation().getY() > 89) {
					if (player.getLocation().getY() >= player.getWorld().getHighestBlockYAt(player.getLocation())) {
						
					//check if highest y equals to snow or dirt or stone
					Block targetBlock =	player.getTargetBlock((Set<Material>) null, 8);
						if (targetBlock.getY() > 89 && targetBlock.getY() > player.getLocation().getY() ) {
							Random rand = new Random();
							int nextInt = rand.nextInt(100);
							if (nextInt <= 45) {
							Location fromLoc = new Location(targetBlock.getWorld(), targetBlock.getX(), 		targetBlock.getWorld().getHighestBlockYAt(targetBlock.getLocation()) +2 , targetBlock.getZ());
							Vector targetLoc = player.getLocation().add(player.getLocation().getDirection().multiply(-3)).toVector().setY(player.getLocation().getY() - 5);
							Vector pos = fromLoc.toVector();
							Vector velocity = targetLoc.subtract(pos);
							
							
							
							FallingBlock fb = player.getWorld().spawnFallingBlock(fromLoc, Material.SNOW_BLOCK, (byte) 0);
							fb.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb.setDropItem(false);
							fb.setHurtEntities(true);
							fb.setInvulnerable(true);
							fb.setCustomName("cigdebug");
						
							
							
							
							
							FallingBlock fb1 = player.getWorld().spawnFallingBlock(new Location(fromLoc.getWorld(), fromLoc.getX() +1 , fromLoc.getY() , fromLoc.getZ() -1), Material.SNOW_BLOCK, (byte) 0);
							fb1.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb1.setDropItem(false);
							fb1.setHurtEntities(true);
							fb1.setInvulnerable(true);
							fb1.setCustomName("cigdebug");
							fb1.getWorld().playSound(fb1.getLocation(), Sound.BLOCK_SNOW_PLACE, 10, 10);
							
							
							FallingBlock fb2 = player.getWorld().spawnFallingBlock(new Location(fromLoc.getWorld(), fromLoc.getX() +1 , fromLoc.getY() , fromLoc.getZ() +1) , Material.SNOW_BLOCK, (byte) 0);
							fb2.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb2.setDropItem(false);
							fb2.setHurtEntities(true);
							fb2.setInvulnerable(true);
							fb2.setCustomName("cigdebug");
							fb2.getWorld().playSound(fb2.getLocation(), Sound.BLOCK_SNOW_PLACE, 10, 10);
							
							
							FallingBlock fb3 = player.getWorld().spawnFallingBlock(new Location(fromLoc.getWorld(), fromLoc.getX() -1 , fromLoc.getY() , fromLoc.getZ() +1 ), Material.SNOW_BLOCK, (byte) 0);
							fb3.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb3.setDropItem(false);
							fb3.setHurtEntities(true);
							fb3.setInvulnerable(true);
							fb3.setCustomName("cigdebug");
							fb3.getWorld().playSound(fb3.getLocation(), Sound.BLOCK_SNOW_PLACE, 10, 10);
							
							
							FallingBlock fb4 = player.getWorld().spawnFallingBlock(new Location(fromLoc.getWorld(), fromLoc.getX() + 2 , fromLoc.getY() , fromLoc.getZ() - 2 - Math.random()), Material.SNOW_BLOCK, (byte) 0);
							fb4.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb4.setDropItem(false);
							fb4.setHurtEntities(true);
							fb4.setInvulnerable(true);
							fb4.setCustomName("cigdebug");
							fb4.getWorld().playSound(fb4.getLocation(), Sound.BLOCK_SNOW_PLACE, 10, 10);
							
							
							FallingBlock fb5 = player.getWorld().spawnFallingBlock(new Location(fromLoc.getWorld(), fromLoc.getX() -Math.random() - 1 , fromLoc.getY() , fromLoc.getZ() + Math.random() +1), Material.SNOW_BLOCK, (byte) 0);
							fb5.setVelocity(velocity.normalize().multiply(0.47).setY(0));
							fb5.setDropItem(false);
							fb5.setHurtEntities(true);
							fb5.setInvulnerable(true);
							fb5.setCustomName("cigdebug");
							fb5.getWorld().playSound(fb5.getLocation(), Sound.BLOCK_SNOW_PLACE, 10, 10);
							
							for (Entity en : fb.getNearbyEntities(4, 2, 4)) {
							  if (en instanceof Monster) {
	                			  if (fb.getPassenger() == null) {
	                				  fb.setPassenger(en);
	                			  } else {
	                				  if (fb1.getPassenger() == null) {
	                					  fb1.setPassenger(en);
	                				  } else {
	                					  if (fb2.getPassenger() == null) {
	                						  fb2.setPassenger(en);
	                					  } else {
	                						  if (fb3.getPassenger() == null) {
	                							  fb3.setPassenger(en);
	                						  } else {
	                							  if (fb4.getPassenger()==null) {
	                								  fb4.setPassenger(en);
	                							  } else {
	                								  if (fb5.getPassenger() == null) {
	                									  fb5.setPassenger(en);
	                								  } else {
	                									  ((Monster) en).damage(50);
	                										en.setVelocity(velocity.multiply(1.5));
	                								  }
	                							  }
	                						  }
	                					  }
	                				  }
	                			  }
	                		  }
							}
							new BukkitRunnable() {
								
								@Override
								public void run() {
									fb.remove();
									fb1.remove();
									fb2.remove();
									fb3.remove();
									fb4.remove();
									fb5.remove();
									
								}
							}.runTaskLater(CokZorMobsInfo.instance, 300);
							
						    sekizbl =  Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CokZorMobsInfo.instance, new Runnable() {
				                  public void run() {
				                	  
				                	  if (!fb.isDead()) {
				                		  for (Entity en : fb.getNearbyEntities(4, 4, 4)) {
								                
						                		if (en instanceof Player) {
						                			en.setVelocity(velocity.multiply(1.5));
						                			((Damageable) en).damage(1);
						                		}
						                		  
						                		  
						                		  
						                	  } 
				                	  }
				                
				                  }
						    }, 0, 10);
						}
						}
			}
				}}
			
			if (CokZorMobsListener.mevsimDonem == 0) {
				if (CokZorMobsInfo.getInstance().getServer().getWorld("world").hasStorm()) {
					for (Player player : Bukkit.getServer().getOnlinePlayers()) {
						if (player.getWorld().getWorldType() == WorldType.NORMAL) {
							if (player.getLocation().getY() >= player.getWorld().getHighestBlockYAt(player.getLocation())) {
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.AQUA + "Soðuk hava beni yavaþlatýyor, bir çatýnýn altýna girmem gerek!"));

								player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 240, 0));
							}
			
						}
					}
				}
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				
				//add wind here
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					
				
						if (player.getLocation().getY() > player.getWorld().getHighestBlockYAt(player.getLocation())) {
						
							Random rand = new Random();
							int number = rand.nextInt(100) + 1;
							if(number >= 60){
								
							if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Bati")) {
						
									Location loc = new Location(player.getWorld(), player.getLocation().getX() +5 + Math.random(), player.getLocation().getY(), player.getLocation().getZ());
									Vector vec = loc.toVector().setY(0).setZ(0).normalize();
									player.setVelocity(vec);
									player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
									player.sendMessage(ChatColor.BLUE +"Buz gibi bir rüzgar esti...");
								
							
							}
								
							if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Dogu")) {
								Location loc = new Location(player.getWorld(), player.getLocation().getX() -5 - Math.random(), player.getLocation().getY(), player.getLocation().getZ());
								Vector vec = loc.toVector().setY(0).setZ(0).normalize();
								player.setVelocity(vec);
								player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
								player.sendMessage(ChatColor.BLUE +"Buz gibi bir rüzgar esti...");
							}
								
							if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Guney")) {
								Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ() -5 - Math.random());
								Vector vec = loc.toVector().setY(0).setX(0).normalize();
								player.setVelocity(vec);
								player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
								player.sendMessage(ChatColor.BLUE +"Buz gibi bir rüzgar esti...");
							}	
							if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Kuzey")) {
								Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ() +5. + Math.random());
								Vector vec = loc.toVector().setY(0).setX(0).normalize();
								player.setVelocity(vec);
								player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
								player.sendMessage(ChatColor.BLUE +"Buz gibi bir rüzgar esti...");
							}
							}
						
					}
					
					if (player.getInventory().getArmorContents() == null) {
						if (player.getWorld().getWorldType() == WorldType.NORMAL) {
							player.sendMessage(ChatColor.BLUE + ChatColor.BOLD.toString() + "D O N U Y O R U M !");
							player.sendMessage(ChatColor.BLUE + "Çok soðuk, bir þeyler giymeliyim!");
						}
					}
				}
			}
			if (CokZorMobsListener.mevsimDonem == 2) {
				
			}
		}
		
//---------------------------------------------------------------------------------------------------------------------------------------------		
		if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("ilkbahar")) {
			if (CokZorMobsListener.mevsimDonem == 0) {
				
			}
			
			if (CokZorMobsListener.mevsimDonem == 1) {
				int random = new Random().nextInt(CokZorMobsInfo.getInstance().getServer().getOnlinePlayers().size());

				Player p1 = (Player) CokZorMobsInfo.getInstance().getServer().getOnlinePlayers().toArray()[random];
				
				if (p1 != null) {
					p1.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.GREEN + "Havanýn güzelliði, keyfini yerine getiriyor!"));
					p1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 24*60, 0));
					
				}
			}
			if (CokZorMobsListener.mevsimDonem == 2) {
				
			}
			
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------		
		if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("yaz")) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				
				if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()) == Biome.DESERT) {
					if (player.getEyeLocation().getY() > player.getWorld().getHighestBlockYAt(player.getLocation())) {
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.YELLOW + "Çöl... Çok... Sýcak..."));
						
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 240, 0));
					}
				}
				if (player.getEquipment().getHelmet() != null && player.getEquipment().getChestplate() != null && player.getEquipment().getLeggings() != null && player.getEquipment().getBoots() !=null) {
				
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.YELLOW + "Hava çok sýcak, bunaldým ya! Üstümdekileri çýkarabilsem keþke..."));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 240, 0));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 240, 0));
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
		
	if (CokZorMobsListener.mevsimIsim.equalsIgnoreCase("sonbahar")) {
		if (CokZorMobsListener.mevsimDonem == 0) {
			
		}
		
		if (CokZorMobsListener.mevsimDonem == 1) {
			
			//add wind here
			for (Player player: Bukkit.getOnlinePlayers()) {
				if (player.getLocation().getY() > player.getWorld().getHighestBlockYAt(player.getLocation())) {
				if (player.getLocation().getY() > 100) {
					Random rand = new Random();
					int number = rand.nextInt(100) + 1;
					if(number >= 90){
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Bati")) {
				
							Location loc = new Location(player.getWorld(), player.getLocation().getX() +1, player.getLocation().getY(), player.getLocation().getZ());
							Vector vec = loc.toVector().setY(0).setZ(0).normalize();
							player.setVelocity(vec);
							player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
							player.sendMessage(ChatColor.GRAY +"Rüzgar esti...");
						
					
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Dogu")) {
						Location loc = new Location(player.getWorld(), player.getLocation().getX() -1, player.getLocation().getY(), player.getLocation().getZ());
						Vector vec = loc.toVector().setY(0).setZ(0).normalize();
						player.setVelocity(vec);
						player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
						player.sendMessage(ChatColor.GRAY +"Rüzgar esti...");
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Guney")) {
						Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ() -1);
						Vector vec = loc.toVector().setY(0).setX(0).normalize();
						player.setVelocity(vec);
						player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
						player.sendMessage(ChatColor.GRAY +"Rüzgar esti...");
					}	
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Kuzey")) {
						Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ() +1);
						Vector vec = loc.toVector().setY(0).setX(0).normalize();
						player.setVelocity(vec);
						player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 10, 10);
						player.sendMessage(ChatColor.GRAY +"Rüzgar esti...");
					}
					}
				}
			}
			}
		}
		if (CokZorMobsListener.mevsimDonem == 2) {
			
		}
		
		}
	
	
	}
	//METHODS
	 public String oyuncuYon(Player playerSelf){
         String dir = "";
         float y = playerSelf.getLocation().getYaw();
         if( y < 0 ){y += 360;}
         y %= 360;
         int i = (int)((y+8) / 22.5);
         if(i == 0){dir = "west";}
         else if(i == 1 || i == 2 || i == 15){dir = "west";}
         else if(i == 3 || i == 4 || i == 5){dir = "north";}
         else if(i == 6 || i == 7 ||i ==8){dir = "east";}
         else if(i == 9 || i == 10 || i == 11 || i == 12){dir = "south";}
         else if(i == 13){dir = "atlattin";}
         else if(i == 14){dir = "ucuz";}
         else {dir = "west";}
         return dir;
    }
	 //sssssssssssssssssssssssssssssssssssssss

		
	 //sssssssssssssssssssssssssssssssssssssssssss
		public static List<Block> getBlocksAroundPoint(final Location location, final double radius) {
			final List<Block> blocks = new ArrayList<Block>();

			final int xorg = location.getBlockX();
			final int yorg = location.getBlockY();
			final int zorg = location.getBlockZ();

			final int r = (int) radius * 4;

			for (int x = xorg - r; x <= xorg + r; x++) {
				for (int y = yorg - r; y <= yorg + r; y++) {
					for (int z = zorg - r; z <= zorg + r; z++) {
						final Block block = location.getWorld().getBlockAt(x, y, z);
						if (block.getLocation().distanceSquared(location) <= radius * radius) {
							blocks.add(block);
						}
					}
				}
			}
			return blocks;
		}
}
