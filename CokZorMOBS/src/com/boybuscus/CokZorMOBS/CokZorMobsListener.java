package com.boybuscus.CokZorMOBS;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Nameable;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Witch;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.boybuscus.CokZorMOBS.CustomEntity.HayatSomuren;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class CokZorMobsListener implements Listener {
	
	public static int mevsimDonem;
	public static String mevsimIsim;
	
	public static String ruzgar;
	

	
	
	
	private static final ConcurrentHashMap<Player, CokZorMobsListener> antiAgresif = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<Player, CokZorMobsListener> bogulma= new ConcurrentHashMap();
	private static final ConcurrentHashMap<Player, CokZorMobsListener> seriAtes= new ConcurrentHashMap();
	private static final ConcurrentHashMap<Entity, CokZorMobsListener> zombiDirilme= new ConcurrentHashMap();

	ItemStack weapon = new ItemStack(Material.DIAMOND_SWORD, 1);
	ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
	ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
	
	
	ItemStack superweapon = new ItemStack(Material.DIAMOND_SWORD, 1);
	ItemMeta superweapontMeta = superweapon.getItemMeta();
	
	private Plugin bu;
	private boolean ucus;
	
	
	
	
	@EventHandler
	public void katiyaDonme (EntityChangeBlockEvent e) {
		
		   Entity ent = e.getEntity();
		    if (ent.getType() != org.bukkit.entity.EntityType.FALLING_BLOCK)
		      return;
		    FallingBlock fb = (FallingBlock)ent;
		    if ((fb.getCustomName() == null) || (!fb.getCustomName().equals("cigdebug")) && (!fb.getCustomName().equals("BuzBlok5"))) {
		      return;
		    }
		  
		    e.setCancelled(true);
	}
	
	//MEVS�M--------
	@EventHandler
	public void konusma (AsyncPlayerChatEvent e) {
		
		Player player = e.getPlayer();
		if (player.getName().equalsIgnoreCase("Boybuscuss")) {
				e.setMessage(ChatColor.GOLD + e.getMessage());
		}
		if ( e.getMessage().startsWith("x+")) {
			
			Location loc = new Location(player.getWorld(), player.getLocation().getX() +1, player.getLocation().getY(), player.getLocation().getZ());
			Vector vec = loc.toVector().setY(0).setZ(0).normalize();
			player.setVelocity(vec);
		}
		//s KALDIR BUNU ACIL
		if ( e.getMessage().startsWith("donemset1")) {
			setmevsimDonem(1);
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +"Bu ay can�n�z�n yenilenme h�z� 4 kat d��t�!");
			player.sendMessage(ChatColor.DARK_AQUA +"Mevsim Debug:"+ ChatColor.GREEN + " Mevsim d�nemi 1!");
		}
		if ( e.getMessage().startsWith(ChatColor.GOLD +"sdw5q7mzof")) {
			if (player.getName().equalsIgnoreCase("Boybuscuss")) {
				CokZorMobsInfo.instance.getServer().getScheduler().scheduleSyncRepeatingTask(CokZorMobsInfo.instance, new MevsimSaniyeChecker(), 0, 24);
				CokZorMobsInfo.instance.getServer().getScheduler().scheduleSyncRepeatingTask(CokZorMobsInfo.instance, new MevsimTickChecker(), 0, 240);
				Bukkit.broadcastMessage(ChatColor.AQUA+"Mevsimler ba�lat�l�yor!\nL�tfen bekleyin...");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
				
						if (getmevsimIsim() == null) {
							Bukkit.broadcastMessage(ChatColor.DARK_RED+"Hata: Sunucuya at�lan reset nedeniyle aktif mevsim ve mevsim evresi bulunamad�.\nK�� mevsiminden ba�lat�l�yor.");
							player.getWorld().setTime(0);
							setmevsimIsim("kis");
							setmevsimDonem(0);
						
							Random rand = new Random();
							int nextInt = rand.nextInt(100);
							if (nextInt <= 25) {
								//kuzey
								//ruzgar yon degistirme duzelt
								setRuzgar("Kuzey");
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "kuzeyden g�neye" + ChatColor.RESET + ChatColor.BLUE + " esecek, y�kseklere ��karken dikkat edin!");
							}
							
							if (nextInt >= 26 && nextInt <= 50) {
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "do�udan bat�ya" + ChatColor.RESET + ChatColor.BLUE + " esecek, y�kseklere ��karken dikkat edin!");
								setRuzgar("Dogu");
							}
							
							if (nextInt >= 51 && nextInt <= 75) {
								//g�ney
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "g�neyden kuzeye" + ChatColor.RESET + ChatColor.BLUE + " esecek, y�kseklere ��karken dikkat edin!");
								setRuzgar("Guney");
							}
							
							if  (nextInt >= 76 && nextInt <= 100) {
								//bat�
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "bat�dan do�uya" + ChatColor.RESET + ChatColor.BLUE + " esecek, y�kseklere ��karken dikkat edin!");
								setRuzgar("Bati");
							}
						}
			
			
					
						
						
						
			//sonbahar
			if (getmevsimIsim().equalsIgnoreCase("sonbahar")) {
				

				//permaeffect	
					
					
					
					
					//donemler
					if (getmevsimDonem() == 2) {
			new BukkitRunnable() {
							
							@Override
							public void run() {
							
							
								setmevsimIsim("kis");
								setmevsimDonem(0);
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					if (getmevsimDonem() == 1) {
						
			new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(2);
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.GRAY + "Hava so�umaya ba�l�yor...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Kas�m Ay�").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +"Bu ay can�n�z�n yenilenme h�z� 4 kat d��t�!");
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.GRAY + "Her yer sanki sar�ya boyanm��...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Ekim Ay�").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					
					
					
					}
			}
						
						
						
						
						
			//yaz 
			if (getmevsimIsim().equalsIgnoreCase("yaz")) {
				

				//permaeffect	
					
					
					
					
					//donemler
					if (getmevsimDonem() == 2) {
			new BukkitRunnable() {
							
							@Override
							public void run() {
							
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle(ChatColor.YELLOW + "Sonbahar", ChatColor.GRAY + "Yapraklar�n sarard���n� g�r�yorsun...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Eyl�l Ay�").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
								}
								setmevsimIsim("sonbahar");
								setmevsimDonem(0);
							

								
								Random rand = new Random();
								if (rand.nextInt(100) <= 25) {
									//kuzey
									setRuzgar("Kuzey");
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "kuzeyden g�neye" + ChatColor.RESET + ChatColor.YELLOW + " esecek, y�kseklere ��karken dikkat edin!");
								}
								
								if (rand.nextInt(100) >= 26 && rand.nextInt(100) <= 50) {
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "do�udan bat�ya" + ChatColor.RESET + ChatColor.YELLOW + " esecek, y�kseklere ��karken dikkat edin!");
									setRuzgar("Dogu");
								}
								
								if (rand.nextInt(100) >= 51 && rand.nextInt(100) <= 75) {
									//g�ney
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "g�neyden kuzeye" + ChatColor.RESET + ChatColor.YELLOW + " esecek, y�kseklere ��karken dikkat edin!");
									setRuzgar("Guney");
								}
								
								if  (rand.nextInt(100) >= 76 && rand.nextInt(100) <= 100) {
									//bat�
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ay�nda r�zgarlar " + ChatColor.AQUA + ChatColor.BOLD + "bat�dan do�uya" + ChatColor.RESET + ChatColor.YELLOW + " esecek, y�kseklere ��karken dikkat edin!");
									setRuzgar("Bati");
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					if (getmevsimDonem() == 1) {
						
			new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(2);
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.AQUA + "Nem �ok nem.", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("A�ustos Ay�").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
								Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +"Bu ay can�n�z�n yenilenme h�z� 4 kat d��t�!");
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.AQUA + "�nan�lmaz bunalt�c� bir hava var...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Temmuz Ay�").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					
					
					
					}
			}
						
						
			//ilkbahar			
			if (getmevsimIsim().equalsIgnoreCase("ilkbahar")) {
				
				

				//permaeffect	
					
					
					
					
					//donemler
					if (getmevsimDonem() == 2) {
			new BukkitRunnable() {
							
							@Override
							public void run() {
							
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle(ChatColor.GOLD + "Yaz", ChatColor.AQUA + "Yaz geldi, hava �ok harika!", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Haziran Ay�").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
								}
								setmevsimIsim("yaz");
								setmevsimDonem(0);
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					if (getmevsimDonem() == 1) {
						
			new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(2);
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.BLUE + "Hava mis gibi, p�f�r p�f�r esiyor valla!", 20, 80, 20);
										player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("May�s Ay�").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
								Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +"Bu ay can�n�z�n yenilenme h�z� 4 kat d��t�!");
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.DARK_GREEN + "Sanki hayat yeniden ba�l�yor!", 20, 80, 20);
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Nisan Ay�").color(net.md_5.bungee.api.ChatColor.GREEN).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					
					
					
					}
			}
						
						
						
						
						
						
						
						
						
						
						
			//kis
			if (getmevsimIsim().equalsIgnoreCase("kis")) {
	
			//permaeffect	
				
				
				
				
				//donemler
				if (getmevsimDonem() == 2) {
		new BukkitRunnable() {
						
						@Override
						public void run() {
						
							for (Player player : Bukkit.getOnlinePlayers() ) {
								player.sendTitle(ChatColor.GREEN + "�lkbahar", ChatColor.DARK_GREEN + "Bahar geldi, ancak k��� aratm�yor!", 20, 80, 20);
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Mart Ay�").color(net.md_5.bungee.api.ChatColor.GREEN).bold(true).create());
							}
							setmevsimIsim("ilkbahar");
							setmevsimDonem(0);
						}
					}.runTaskLater(CokZorMobsInfo.instance, 24000);
				
				}
				
				if (getmevsimDonem() == 1) {
					
		new BukkitRunnable() {
						
						@Override
						public void run() {
							setmevsimDonem(2);
							for (Player player : Bukkit.getOnlinePlayers() ) {
								player.sendTitle("", ChatColor.BLUE + "Bahar yakla��yor, ancak hava hala so�uk!", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("�ubat Ay�").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
							}
						}
					}.runTaskLater(CokZorMobsInfo.instance, 24000);
				
				}
				
				
				
				if (getmevsimDonem() == 0) {
					for (Player player : Bukkit.getOnlinePlayers() ) {
						player.sendTitle(ChatColor.BLUE +"K�� geldi!", ChatColor.AQUA + "Buz gibi bir hava bizi bekliyor!", 20, 80, 20);
					
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Aral�k Ay�").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
					}
					new BukkitRunnable() {
						
						@Override
						public void run() {
							setmevsimDonem(1);
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +"Bu ay can�n�z�n yenilenme h�z� 4 kat d��t�!");
							
							for (Player player : Bukkit.getOnlinePlayers() ) {
								player.sendTitle("", ChatColor.BLUE + "Hava daha da so�uyor!", 20, 80, 20);
								
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Ocak Ay�").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
							}
						}
					}.runTaskLater(CokZorMobsInfo.instance, 24000);
				
				
				
				
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			
		
					
			
						
						
						
						
					}
				}.runTaskTimer(CokZorMobsInfo.getInstance(), 100, 24001);
				
				
				
				
				
			} else {
				e.setCancelled(true);
				player.sendMessage(ChatColor.DARK_RED +"Mevsimleri sadece javan�n tanr�s�, d�nyan�n en harika insan�, en etik �ocuk doland�r�c�s� ve Xayah'� damage vuran Hasan Emir Be�iro�lu ba�latabilir, e�er bi' s�k�nt� ya��yorsan�z ona bi' dan���n, bir ihtimal bu kodu girdi�iniz i�in size s�vebilir, ama n'apal�m...");
			}
		}
		
		


		
	}
	
	

	
	
	@SuppressWarnings("serial")
    @EventHandler
    public void onPlayerCraftItem(PrepareItemCraftEvent e){
        if(e.getInventory().getMatrix().length < 9){
            return;
        }
        
        
		 ItemStack pickaxeKonsantre = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta pickaxeMeta = pickaxeKonsantre.getItemMeta();
		pickaxeMeta.setDisplayName(ChatColor.DARK_BLUE + "Konsantre Elmas Kazma");
	    ArrayList<String> pickaxeLore = new ArrayList<String>();
	    pickaxeLore.add(ChatColor.AQUA + "Her �eyi kazabilecekmi� gibi duruyor.");
	    pickaxeMeta.setLore(pickaxeLore);
	    pickaxeMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
	    pickaxeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    pickaxeKonsantre.setItemMeta(pickaxeMeta);
	    
	    
	    
        checkCraft(pickaxeKonsantre,e.getInventory(), new HashMap<Integer, ItemStack>(){{
        	put(8, CokZorMobsInfo.konsantreElmas);
            put(7, CokZorMobsInfo.konsantreElmas);
        	put(6, CokZorMobsInfo.konsantreElmas);
        	
        	  put(1, new ItemStack(Material.STICK, 1));
          	put(4,  new ItemStack(Material.STICK, 1));
        }});
        
        if (e.getRecipe().getResult().equals(new ItemStack(Material.ENDER_EYE))) {
        	e.getInventory().setResult(new ItemStack(Material.DIRT));
        } else {
        	return;
        }
    }
	
	
	@EventHandler
	public void spawn (BlockBreakEvent e) {
		Block block = e.getBlock();
		
		
		if (block.getType() == Material.OBSIDIAN) {
		
			if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE +"Konsantre Elmas Kazma")) {
				block.getLocation().getBlock().setType(Material.LAVA);
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_STONE_BREAK, 1, 1);
				e.getPlayer().sendMessage(ChatColor.RED +"Bu alet obsidyeni kazmak i�in yeterince geli�mi� de�il...");
				e.setDropItems(false);
			}
		} else {
			
		}
		if (block.getType() == Material.NETHERRACK) {
				Random rand = new Random();
				int number = rand.nextInt(100) + 1;
				if(number >= 90){
				
						block.getLocation().getBlock().setType(Material.LAVA);
		
			}
		}
		
		
		
	}
	
	@EventHandler
	public void showServer (ServerListPingEvent e) {
		e.setMotd(ChatColor.DARK_RED + "Dolar 5 lirayken, bu sunucunun zorlu�u nedir ki?");
		
		
	}
	
	@EventHandler
	public void katilma (PlayerJoinEvent e) {
		
		
		Player player = e.getPlayer();


		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getName());
		player.setMaxHealth(14);
		if (!offlinePlayer.hasPlayedBefore())
		{
			player.sendMessage(ChatColor.DARK_RED + "\n-------\n-------" +ChatColor.RED +"\nZor Zamanlara ho� geldin! �lk olarak" + ChatColor.DARK_AQUA +" Acemi Totemi" +ChatColor.RED+"'ni ikinci eline takarak ba�la, bu totem ile canavarlar seni hedef alamaz, ancak bir canl�ya zarar verirsen, totem etkisini kaybeder, dikkatli ol ve g�vende kal, tabii kalabiliyorsan!\n---\n---"+ ChatColor.DARK_RED +"\nDredius Kabilesini hi� duydun mu? E�er o i�ren� yarat�klar� g�r�rsen l�tfen �unlar� yap:\n" +ChatColor.MAGIC +"ASDASDASDGASDASDASDASDADS"+ ChatColor.DARK_RED +"\n-------\n-------");
			 ItemStack ab = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
		     ItemMeta abMeta = ab.getItemMeta();
		     ArrayList<String> lore2 = new ArrayList<String>();
		     abMeta.setDisplayName(ChatColor.DARK_AQUA+ "Acemi Totemi");
		        lore2.add(ChatColor.AQUA +  "Acemi �ans�.");
		        lore2.add(ChatColor.AQUA + "Canavarlar senin gibi bir ezi�i");
		        lore2.add(ChatColor.AQUA +  "�ld�rmeye tenezz�l dahi etmiyor.");
		        abMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     abMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        abMeta.setLore(lore2);
		        ab.setItemMeta(abMeta);
		        player.getInventory().addItem(ab);
		}
		if (player.getName().equalsIgnoreCase("CruelGod")) {
			e.setJoinMessage(ChatColor.YELLOW + "Orospu �ocu�u Oktay yani CruelGod geldi.");
		}
		
	}
	
	@EventHandler
	public void customTradeTabSAGtik(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		Entity entity = e.getRightClicked();
			if (entity instanceof WitherSkeleton) {
				if (entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN +"Akl� Kar��m�� Kadim Ata")) {
					openTozEnder(player);
				}
				if (entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN +"Akl� Kar��m�� Kadim K�yl�")) {
					openIteems(player);
				}
			}
	}


	@EventHandler
	public void hedefAl(EntityTargetLivingEntityEvent e) {
	LivingEntity player =	e.getTarget();
	Entity entity = e.getEntity();
	if (entity instanceof Monster) {
		
	
		if (player != null || entity != null) {
		if (player instanceof Player) {
			if (entity instanceof Zombie ) {
				if (entity instanceof HayatSomuren) {
					e.setCancelled(true);
				}
			}
			if (entity instanceof WitherSkeleton) {
				if (entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN +"Akl� Kar��m�� Kadim Ata") || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN +"Akl� Kar��m�� Kadim K�yl�")) {
					e.setCancelled(true);
				}
			}
			if (player.getEquipment().getItemInOffHand() != null || player.getEquipment().getItemInOffHand().getType() != Material.AIR) {
				if (player.getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
			if (player.getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Acemi Totemi")) {
				e.setCancelled(true);
			} else {
				return;
			}
			}
		}
		}
	}
	}
	}
	
	@EventHandler
	public void vurma (EntityDamageByEntityEvent e) {
	Entity vuran =	e.getDamager();
	Entity alan = e.getEntity();
	
	if (vuran instanceof Monster && alan instanceof Player) {
		if (alan.getWorld().getName().equalsIgnoreCase("world") && day() && vuran.getLocation().getWorld().getHighestBlockAt(vuran.getLocation()).getY() >= vuran.getLocation().getY() +1 ) {
			e.setDamage(e.getDamage()/2);
		}
	}
	if (vuran instanceof Player) {
	if (alan instanceof WitherSkeleton) {
		if (alan.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Akl� Kar��m�� Kadim Ata") || alan.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Akl� Kar��m�� Kadim K�yl�")) {
			e.setCancelled(true);
		}
		if (alan.getCustomName().equalsIgnoreCase(ChatColor.RED + "Kadim Ata")) {
			if (((WitherSkeleton) alan).getHealth() <= 30) {
			e.setCancelled(true);
			alan.setCustomName(ChatColor.DARK_GREEN + "Akl� Kar��m�� Kadim Ata");
			((WitherSkeleton) alan).setMaxHealth(500);
			((WitherSkeleton) alan).setHealth(500);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					alan.setCustomName(ChatColor.RED + "Kadim Ata");
					((WitherSkeleton) alan).setMaxHealth(500);
					((WitherSkeleton) alan).setHealth(500);
				}
			}.runTaskLater(CokZorMobsInfo.instance, 24*50);
			
			
				}
			}
	
		if (alan.getCustomName().equalsIgnoreCase(ChatColor.RED + "Kadim K�yl�")) {
			if (((WitherSkeleton) alan).getHealth() <= 30) {
				e.setCancelled(true);
				alan.setCustomName(ChatColor.DARK_GREEN + "Akl� Kar��m�� Kadim K�yl�");
				((WitherSkeleton) alan).setMaxHealth(500);
				((WitherSkeleton) alan).setHealth(500);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						alan.setCustomName(ChatColor.RED + "Kadim K�yl�");
						((WitherSkeleton) alan).setMaxHealth(300);
						((WitherSkeleton) alan).setHealth(300);
					}
				}.runTaskLater(CokZorMobsInfo.instance, 24*50);
				
				
					}
		}
		}
	}
	if (alan instanceof LivingEntity && vuran instanceof Projectile) {
		if (((Projectile) vuran).getShooter() instanceof Player) {
			Player projecSource = (Player) ((Projectile) vuran).getShooter();
			if (((Player) projecSource).getItemInHand().getType().equals(Material.BOW)) {
				
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "R�nl� Yay"))) {
					((LivingEntity)alan).setNoDamageTicks(0);
					
				}
			
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_RED+ "Runaan'�n Yay�"))) {
					
					projecSource.setMaxHealth(projecSource.getMaxHealth() + 6);
					projecSource.setHealth(projecSource.getHealth()+6);
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							projecSource.setMaxHealth(projecSource.getMaxHealth() - 6);
							
						}
					}.runTaskLater(CokZorMobsInfo.instance, 20*7);
					
					
				}
				
				}
		}
	}
	if (alan instanceof LivingEntity && vuran instanceof LivingEntity) {

		if (vuran instanceof Drowned) {
			Random rand = new Random();
			if (rand.nextInt(100) <= 60) {
				if (alan.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER) {
					alan.sendMessage(ChatColor.RED +"Bo�ulmu� seni derinliklere itiyor!");
					CokZorMobsListener.bogulma.put((Player) alan, this);
					new BukkitRunnable() {
						
						@Override
						public void run() {
						CokZorMobsListener.bogulma.remove(alan);
						}
					}.runTaskLater(CokZorMobsInfo.getInstance(), 40);
				}
			
			}
		
		}
		if (vuran instanceof Zombie) {
			if (alan instanceof Player) {
	
		}
		if (vuran instanceof Player) {
			
	
			
			
			if (alan instanceof Zombie) {
				
				if (zombiDirilme.containsKey(alan)) {
					
				}
				if (!((Zombie) ((LivingEntity)alan)).isBaby()) {
					if (((LivingEntity)alan).getKiller() != null) {
						Random rand = new Random();
					if (rand.nextInt(100) <= 75) {
					
					 
					 	if (!zombiDirilme.containsKey(((LivingEntity)alan))) {
					 		((LivingEntity)alan).getLocation().getWorld().playSound(((LivingEntity)alan).getLocation(), Sound.ENTITY_WITHER_SPAWN, 10.0F, 1.0F);
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.FLAME, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 50, Math.random(), Math.random(), Math.random());
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.FLAME, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 50, Math.random(), Math.random(), Math.random());
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.SMOKE_NORMAL, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 20, Math.random(), Math.random(), Math.random());
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.SMOKE_NORMAL, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 20, Math.random(), Math.random(), Math.random());
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.SMOKE_NORMAL, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 20, Math.random(), Math.random(), Math.random());
							
						 	((LivingEntity)alan).getWorld().spawnParticle(Particle.SMOKE_NORMAL, ((LivingEntity)alan).getLocation().getX(), ((LivingEntity)alan).getLocation().getY(), ((LivingEntity)alan).getLocation().getZ(), 20, Math.random(), Math.random(), Math.random());
						 	e.setCancelled(true);
						 	((LivingEntity)alan).setMaxHealth(2000);
						 	((LivingEntity)alan).setHealth(2000);
						 	if (((LivingEntity)alan).getCustomName() ==null) {
						 		((LivingEntity)alan).setCustomName(ChatColor.DARK_PURPLE + "�l�ms�z Hiddet");
						 		((LivingEntity)alan).getWorld().playSound(((LivingEntity)alan).getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1F, 1F);
						 	}
						 
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 90));
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 3));
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));
						 	((LivingEntity)((LivingEntity)alan)).getKiller().sendMessage(ChatColor.RED + "Ka�mal�y�m, hem de hemen!");
					 		zombiDirilme.put(((LivingEntity)alan), this);
					 		new BukkitRunnable() {
								
								@Override
								public void run() {
									if (!((LivingEntity)alan).isDead()) {
										
										((LivingEntity)alan).damage(999999, ((LivingEntity)alan).getKiller());
									}
								
									
								}
							}.runTaskLater(CokZorMobsInfo.instance, 200);
					 	}
					 
					 	
					}
				}
				}
				if (zombiDirilme.containsKey(((LivingEntity)alan))) {
					
				}
			}
			if (((Player) vuran).getEquipment().getItemInMainHand().getType() == Material.STICK) {
				//CUSTOM ITEMS************************
				
				if ((((LivingEntity)vuran).getEquipment().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED+ "Cehennem Taz�s� Asas�"))) {
					Random rand = new Random();
					if (rand.nextInt(100) <= 20) {
						
						Entity en = vuran.getWorld().spawnEntity(alan.getLocation(), EntityType.WOLF);
						en.setCustomName(ChatColor.DARK_RED +" Cehennem Taz�s�");
						alan.getWorld().strikeLightningEffect(alan.getLocation());
						((Damageable) en).damage(0, alan);
						((Wolf) en).setAngry(true);
						((Wolf) en).setTarget((LivingEntity) alan);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if (!en.isDead())
								{
									((Wolf) en).setTarget((LivingEntity) vuran);
									vuran.sendMessage(ChatColor.RED +"Taz� seni cehenneme s�r�klemeye geliyor!");
									}
								}
						}.runTaskLater(CokZorMobsInfo.getInstance(), 150);
					}
				}
				
			}
		
			if (((Player) vuran).getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
				if ((((LivingEntity)vuran).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA+ "Acemi Totemi"))) {
					 ItemStack ab = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
					 
					((Player) vuran).getEquipment().setItemInOffHand(ab);
					 ((Player)vuran).sendMessage(ChatColor.RED+ "Elveda acemilik... Merhaba ac�mas�z hayat.");
				}
			
			}
			if (((Player) vuran).getFoodLevel() <= 8 && ((Player) vuran).getFoodLevel() >=  5) {
				e.setDamage(e.getDamage()/2);
				vuran.sendMessage(ChatColor.GRAY +"�ok yorgunum...\nDo�ru d�zg�n sald�ram�yorum...");
			}
			if (((Player) vuran).getFoodLevel() <=  4) {
				vuran.sendMessage(ChatColor.GRAY +"Elimi kald�r�cak halim yok...\n�ok a��m...");
				e.setCancelled(true);
			}
		}
		}	
		
		if (alan instanceof Enderman) {
			if (vuran instanceof Player) {
				Random rand = new Random();
				World world = vuran.getWorld();
				if (rand.nextInt(100) <= 40) {
					     int distanceSquared = (int)vuran.getLocation().distanceSquared(alan.getLocation());
				        
				        world.playSound(vuran.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
				        Block destinationBlock;
				        if (distanceSquared > 75)
				        {
				        destinationBlock = alan.getLocation().getBlock();
				         alan.teleport(vuran.getLocation());
				        }
				        else
				        {
				          destinationBlock = alan.getLocation().getBlock();
				        }
				        while ((destinationBlock.getType() != Material.AIR) || ((destinationBlock.getRelative(BlockFace.UP).getType() != Material.AIR) && 
				          (destinationBlock.getY() < destinationBlock.getWorld().getMaxHeight()))) {
				          destinationBlock = destinationBlock.getRelative(BlockFace.UP);
				        }
				        int vuranY = vuran.getLocation().getBlockY();int destY = destinationBlock.getLocation().getBlockY();
				        if (vuranY > destY ? vuranY - destY > 10 : destY - vuranY > 10) {
				          return;
				        }
				        if (!e.isCancelled()) {
				        	 vuran.teleport(new Location(vuran.getWorld(), destinationBlock.getX() +  rand.nextInt(13 + 1 -3) -3 , destinationBlock.getWorld().getHighestBlockYAt(destinationBlock.getLocation()) + Math.random() * 4,destinationBlock.getZ() + rand.nextInt(13 + 1 -3) -3));
							    world.playSound(vuran.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
				        }
			
				   
				   
				}
			
			}
	
		}
		if (alan instanceof Player) {
			if (((Player) alan).getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
		
				if (		((Player) alan).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "�l�m Totemi")) {
					e.setDamage(e.getDamage()*2);
				}
			}
		} else {
			return;
		}
		if (alan instanceof Monster) {
			if (vuran instanceof Player) {
				if (((Player) vuran).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "�l�m Totemi")) {
					e.setDamage(e.getDamage()*2);
				}
			
			} else {
				return;
			}
		} else  {
			return;
		}
	} else {
		return;
	}
	}
	
	
	
	@EventHandler
	public void canGitme(EntityDamageEvent e) {
	Entity player =	e.getEntity();
	if (player instanceof LivingEntity) {
		if (player instanceof Rabbit) {
			if (e.getCause() == DamageCause.FALL) {
				e.setCancelled(true);
			}
		}
		if (player instanceof Player) {
			e.setDamage(e.getDamage()*1.4);
		
				
			
			if (((Player) player).getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
				if ((((LivingEntity) player).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Zebani Totemi"))) {
					if (player.getWorld().getWorldType().equals(WorldType.NORMAL)) {
						e.setDamage(e.getDamage() * 2);
					}
					
				}
			}
	
			if (ucus == true) {
				if (e.getCause() == DamageCause.FALL) {
					if (((Player) player).getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
						//ucmag totemi ***********************************************************************************************************
						if (((Player) player).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "U�mag Totemi")) {
							e.setCancelled(true);
						}
						//ucmag totemi ***********************************************************************************************************
					}
					
				}
			}
			//ucus
			if (ucus == false) {
				if (e.getCause() == DamageCause.FALL) {
					e.setCancelled(true);
					ucus = true;
				}
			}
		} else {
			return;
		}
		
	} else {
		return;
	}
	}
	

	@EventHandler
	public void sag(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		  if ((e.getAction() == Action.RIGHT_CLICK_AIR)) {
			  
			  if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "Kanat Asas�"))) {
				Vector  dir = player.getEyeLocation().getDirection().normalize().multiply(1.5);
				player.damage(1);
				player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_HURT, 1F, 1F);
				player.setVelocity(dir);
			  }
			
		  }
	}
	@EventHandler
	public void antiTotem (InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack totem = p.getInventory().getItemInOffHand();
		  if (event.getSlotType() == SlotType.QUICKBAR && event.getSlot() == 40) {
			if (totem.getType() == Material.TOTEM_OF_UNDYING) {
				event.setCancelled(true);
				p.sendMessage(ChatColor.DARK_RED + "Kullan�lan totemler de�i�tirilemez!");
				
			}
		  }
	}
	@EventHandler
	public void antiDegsitirme(PlayerSwapHandItemsEvent e) {
		Player player = e.getPlayer();
		ItemStack totem = player.getInventory().getItemInOffHand();
		if (totem.getType() == Material.TOTEM_OF_UNDYING) {
			e.setCancelled(true);
			player.sendMessage(ChatColor.DARK_RED + "Kullan�lan totemler de�i�tirilemez!");
			
		}
	}
	@EventHandler
	public void gezmek (PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Block block = player.getLocation().getBlock();
		



		
	if (CokZorMobsListener.bogulma.containsKey(player)) {
		if (block.getRelative(BlockFace.DOWN).getType() == Material.WATER) {
			player.setVelocity(new Vector(0, -1, 0));
		}
	}

		if (player.getWorld().getWorldType().equals(WorldType.NORMAL)) {
			//eventTIMEEEEEEEEEEEEEEE
			
			
			if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()) == Biome.DESERT) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 150, 2));
			}
			if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()) == Biome.SWAMP) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 150, 2));
				if (block.getType() == Material.WATER) {
					player.setVelocity(new Vector(0, -1, 0));
		
				}
			}
		}
		if (!(player.getEquipment().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING)) {
			if (block.getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK) {
				player.setFireTicks(20);
			}
		} else {
			if (!player.getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Zebani Totemi")) {
				if (block.getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK) {
					player.setFireTicks(20);
				}
			}
		}
	
	
		//ucus
		//UCUSSSSSSssssssssssssssssssss
		if (block.getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
	
			ucus = false;

			player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10*20, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10*20, 1));
		
		}
		//bura sorunlu
	
	}
	
	

	@EventHandler
	public void onThrow (ProjectileLaunchEvent e) {
		Projectile projectile = e.getEntity();
		Location projecLocation = projectile.getLocation();
		ProjectileSource projecSource = projectile.getShooter();
		if (projecSource instanceof Player) {
			if (((Player) projecSource).getItemInHand().getType().equals(Material.BOW)) {
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				if (!seriAtes.containsKey(projecSource)) {
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "R�nl� Yay"))) {
					seriAtes.put((Player) projecSource, this);
				Arrow arrow1 = projecSource.launchProjectile(Arrow.class);
				arrow1.setCustomName("rapidFire");
				arrow1.setCustomNameVisible(false);
				
				arrow1.setPickupStatus(PickupStatus.DISALLOWED);
				arrow1.getWorld().playSound(arrow1.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1F, 1F);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						Arrow arrow =projecSource.launchProjectile(Arrow.class);
						arrow.setCustomName("rapidFire");
						arrow.setCustomNameVisible(false);
						arrow.setPickupStatus(PickupStatus.DISALLOWED);
						arrow.getWorld().playSound(arrow.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1F, 1F);
					}
				}.runTaskLater(CokZorMobsInfo.instance, 4);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						Arrow arrow =projecSource.launchProjectile(Arrow.class);
						arrow.setCustomName("rapidFire");
						arrow.setCustomNameVisible(false);
						arrow.setPickupStatus(PickupStatus.DISALLOWED);
						arrow.getWorld().playSound(arrow.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1F, 1F);
					}
				}.runTaskLater(CokZorMobsInfo.instance, 8);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						Arrow arrow = projecSource.launchProjectile(Arrow.class);
						arrow.setCustomName("rapidFire");
						arrow.setCustomNameVisible(false);
						seriAtes.remove(projecSource);
						arrow.setPickupStatus(PickupStatus.DISALLOWED);
						arrow.getWorld().playSound(arrow.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1F, 1F);
						
					}
				}.runTaskLater(CokZorMobsInfo.instance, 12);
				}
				
			} else {
				if (!projectile.getName().equals("rapidFire")) {
					
				}
			}
			}
		}
		
		if (getMevsim() !=null) {
			//kis
			if (getMevsim().equals("kis")) {
				if (getDonem() == 1) {
					ProjectileSource ent = e.getEntity().getShooter();
					if (ent instanceof LivingEntity) {
						
				if	(((LivingEntity) ent).getLocation().getY() >= ((LivingEntity) ent).getWorld().getHighestBlockYAt(((LivingEntity) ent).getLocation())) {
					Random rand = new Random();
					if (rand.nextInt(100) > 50) {
						Entity firlatilanSey = e.getEntity();
						if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Bati")) {
							
						
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
									Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX() , firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ());
									Vector vec = loc.toVector().normalize();
									Vector oldVec = e.getEntity().getVelocity().normalize();
									Vector vector = vec.subtract(oldVec).normalize();
									firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
									firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(2).setX(20).setZ(0).normalize());
								}
							}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(4)*8);
			
						
					
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Dogu")) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX() , firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ());
								Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(2).setX(-20).setZ(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
				
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Guney")) {
						
		
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX(), firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ() );
								Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(2).setZ(-20).setX(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
					}	
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Kuzey")) {
						
			
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX(), firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ() +20);Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(2).setZ(20).setX(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
				
					}
					}
					}
				} 
				}
			}
			//sonbahar
			if (getMevsim().equals("sonbahar")) {
				if (getDonem() == 1) {
					ProjectileSource ent = e.getEntity().getShooter();
					if (ent instanceof LivingEntity) {
						
				if	(((LivingEntity) ent).getLocation().getY() >= ((LivingEntity) ent).getWorld().getHighestBlockYAt(((LivingEntity) ent).getLocation())) {
					Random rand = new Random();
					if (rand.nextInt(100) > 50) {
						Entity firlatilanSey = e.getEntity();
						if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Bati")) {
							
						
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
									Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX() , firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ());
									Vector vec = loc.toVector().normalize();
									Vector oldVec = e.getEntity().getVelocity().normalize();
									Vector vector = vec.subtract(oldVec).normalize();
									firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
									firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(1).setX(5).setZ(0).normalize());
								}
							}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(4)*8);
			
						
					
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Dogu")) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX() , firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ());
								Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(1).setX(-5).setZ(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
				
					}
						
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Guney")) {
						
		
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX(), firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ() );
								Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(1).setZ(-5).setX(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
					}	
					if (CokZorMobsListener.ruzgar.equalsIgnoreCase("Kuzey")) {
						
			
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Location loc = new Location(firlatilanSey.getWorld(), firlatilanSey.getLocation().getX(), firlatilanSey.getLocation().getY(), firlatilanSey.getLocation().getZ() +20);Vector vec = loc.toVector().normalize();
								Vector oldVec = e.getEntity().getVelocity().normalize();
								Vector vector = vec.subtract(oldVec).normalize();
								firlatilanSey.getWorld().playSound(firlatilanSey.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
								firlatilanSey.setVelocity(firlatilanSey.getVelocity().multiply(0)); firlatilanSey.setVelocity(vector.multiply(1).setZ(5).setX(0).normalize());
							}
						}.runTaskLater(CokZorMobsInfo.instance, rand.nextInt(3)*8);
				
					}
					}
					}
				} 
				}
			}
		}
		
		//mevsim arasi
		if (e.getEntityType() == EntityType.SPLASH_POTION) {
			if (e.getEntity().getShooter() instanceof Witch) {
				if (((Nameable) e.getEntity().getShooter()).getCustomName() == null ) {
			Entity wi=	(Entity) e.getEntity().getShooter();
				e.setCancelled(true);
				((ProjectileSource) wi).launchProjectile(WitherSkull.class).setVelocity(e.getEntity().getVelocity().multiply(0.04));;
				} if (((Nameable) e.getEntity().getShooter()).getCustomName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "�ingene")) {
					Entity wi=	(Entity) e.getEntity().getShooter();
					e.setCancelled(true);
				((ProjectileSource) wi).launchProjectile(LlamaSpit.class).setVelocity(e.getEntity().getVelocity().multiply(1.5));;
					e.getEntity().getLocation().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_LLAMA_SPIT, 1, 1);
				}
				
			}
		}
	}
	@EventHandler
	public void onSpawn (CreatureSpawnEvent e) {
		
	
		LivingEntity entity = e.getEntity();
		Random rand = new Random();
		
		
		
		/***NETHER**
		 * kodlar�
		 bak buraya*/
		
		if (entity.getWorld().getName().equalsIgnoreCase("world_nether")) {
			if(entity instanceof WitherSkeleton) {
				if (rand.nextInt(100) >= 50) {
				
						entity.setCustomName(ChatColor.RED + "Kadim Ata");
						entity.setMaxHealth(500);
						entity.setHealth(500);
					 ItemStack testEnchant = new ItemStack (Material.IRON_AXE);
					 ItemStack testEnchant2 = new ItemStack (Material.SHIELD);
			
					
					entity.getEquipment().setItemInHand(testEnchant);
					entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 1));
					entity.getEquipment().setItemInOffHand(testEnchant2);
					entity.getEquipment().setItemInMainHandDropChance(0);
					entity.getEquipment().setItemInOffHandDropChance(0);
				} else {
					entity.setCustomName(ChatColor.RED + "Kadim K�yl�");
					entity.setMaxHealth(350);
					entity.setHealth(350);
				 ItemStack testEnchant = new ItemStack (Material.AIR);
			    entity.setMaxHealth(350);
				entity.setHealth(350);
				entity.getEquipment().setItemInMainHand(testEnchant);
				entity.getEquipment().setItemInOffHand(testEnchant);
				entity.getEquipment().setItemInOffHandDropChance(0);
				}
			}
		}
		
		
		//**************************************************************************************
		
		//**************************************************************************************************************************************************
		if (entity instanceof Monster) {
			entity.setRemoveWhenFarAway(true);
		}
		//****************************************************************************************************************************************************
	if (entity instanceof Rabbit){
		((Rabbit) entity).setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
		entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 5));
		entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 10));
	}
	if (entity instanceof Zombie) {
	entity.setMaxHealth(75);
	entity.setHealth(75);
		if(rand.nextInt(100) <= 7.5) {
			
			 ItemStack testEnchant = new ItemStack (Material.DIAMOND_SWORD ,1);
		        ItemMeta testEnchantMeta = testEnchant.getItemMeta();
		        testEnchantMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		        testEnchant.setItemMeta(testEnchantMeta);	
		    entity.setMaxHealth(500);
			entity.setHealth(500);
			entity.getEquipment().setChestplate(chestplate);
			entity.getEquipment().setItemInHand(testEnchant);
			entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 1));
			entity.getEquipment().setItemInOffHand(testEnchant);
			entity.getEquipment().setItemInHandDropChance(0);
			entity.setCustomName(ChatColor.RED +"Nadide Sava���");
		
		}
		if (rand.nextInt(100) <= 20) {
			if (entity.getWorld().getName().equalsIgnoreCase("world")) {
				  World world = Bukkit.getServer().getWorld("world");
					Location loc = new Location(world, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getBlockZ());
					com.boybuscus.CokZorMOBS.CustomEntity.HayatSomuren zomb = new HayatSomuren(((CraftWorld) world).getHandle());
					((CraftWorld) world).addEntity(zomb, CreatureSpawnEvent.SpawnReason.CUSTOM);
					zomb.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
					
					
			}
		}
		if(rand.nextInt(100) <= 30) {
			entity.getWorld().spawnEntity(entity.getLocation().add(2, 0, 2), EntityType.WITCH);
		}
	}
	if (entity instanceof PigZombie) {
		((PigZombie) entity).setAnger(Integer.MAX_VALUE);
		entity.setMaxHealth(80);
		entity.setHealth(80);
	}
	if (entity instanceof Witch) {
		if (rand.nextInt(100) <= 90) {
		entity.setMaxHealth(100);
		entity.setHealth(100);
		} else {
			entity.setCustomName(ChatColor.LIGHT_PURPLE +"�ingene");
			entity.setMaxHealth(100);
			entity.setHealth(100);
		}
	}
	
	if (entity instanceof Drowned) {
		entity.setMaxHealth(200);
		entity.setHealth(200);
	
	    
		 if (rand.nextInt(100) <= 15) {
			 ItemStack testEnchant = new ItemStack (Material.TRIDENT ,1);
			 entity.getEquipment().setItemInMainHandDropChance(0);
			 entity.getEquipment().setItemInHand(testEnchant);
		 }
		 if (rand.nextInt(100) <= 5) {
				entity.setMaxHealth(500);
				entity.setHealth(500);
			 ItemStack testEnchant = new ItemStack (Material.TRIDENT ,1);
			 entity.getEquipment().setItemInMainHandDropChance(0);
			 ItemMeta testEnchantMeta = testEnchant.getItemMeta();
		        testEnchantMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		        testEnchant.setItemMeta(testEnchantMeta);
		     entity.getEquipment().setHelmet(helmet);
		     entity.getEquipment().setHelmet(boots);
			 entity.getEquipment().setItemInHand(testEnchant);
			 entity.getEquipment().setItemInHand(testEnchant);
		 }
	       
	    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 3));
	    	entity.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 99999, 3));
	}
	//ENDERMAN**********************************************************************************************************
	if (entity instanceof Enderman) {
		entity.setMaxHealth(300);
		entity.setHealth(300);

		entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 0));
		if (rand.nextInt(100) <= 25) {
			entity.getWorld().spawnEntity(entity.getLocation().add(2, 0, 2), EntityType.VEX);
			entity.getEquipment().setItemInOffHandDropChance(100);
		}
		if (rand.nextInt(100) <= 2) {
			entity.getWorld().spawnEntity(entity.getLocation().add(2, 0, 2), EntityType.VINDICATOR);
		}
	}
	//VEX********************************************************************************************************************
	if (entity instanceof Vex){
		entity.setMaxHealth(100);
		entity.setHealth(100);
		entity.setCustomName(ChatColor.DARK_RED +"Ploxiano Hayaleti");
		//phraxeria
		if (rand.nextInt(100) <= 2) {
			entity.setCustomName(ChatColor.DARK_RED +"Phraxeria Hayaleti");
			ItemStack testEnchant = new ItemStack (Material.DIAMOND_SWORD ,1);
	        ItemMeta testEnchantMeta = testEnchant.getItemMeta();
	        testEnchantMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
	        testEnchant.setItemMeta(testEnchantMeta);
		}
	}
		
	if (entity instanceof Vindicator) {
		entity.setMaxHealth(300);
		entity.setHealth(300);
		entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 1));
	}
	if (entity instanceof Phantom){
		entity.setMaxHealth(160);
		entity.setHealth(160);
		((Phantom) entity).setSize(50);
	
	}
	if (entity instanceof Creeper) {
		((Creeper) entity).setPowered(true);
		
	}
	//�M�RCEK***********************************************************************************************
	if (entity.getType() == EntityType.SPIDER) {
		LivingEntity orumc = (LivingEntity) entity.getWorld().spawnEntity(entity.getLocation().add(2, 0, 2), EntityType.CAVE_SPIDER);
		orumc.setMaxHealth(75);
		orumc.setHealth(75);
		entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 0));
	
	if (rand.nextInt(100) <= 7.4) {
		entity.setMaxHealth(1000);
		entity.setHealth(1000);
		entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 4));
		entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999, 4));
		entity.setCustomName(ChatColor.LIGHT_PURPLE + "Alkar�s�");
	

	}
		
	}
	if (entity instanceof Skeleton) {
		entity.setMaxHealth(70);
		entity.setHealth(70);
		ItemStack tes= new ItemStack (Material.LEATHER_HELMET ,1);
		entity.getEquipment().setHelmet(tes);
		if(rand.nextInt(100) <= 10) {
			entity.setMaxHealth(300);
			entity.setHealth(300);
			entity.getEquipment().setHelmet(helmet);
			entity.getEquipment().setLeggings(pants);

			 ItemStack testEnchant = new ItemStack (Material.BOW ,1);
		        ItemMeta testEnchantMeta = testEnchant.getItemMeta();
		        testEnchantMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		        testEnchantMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 10, true);
		        testEnchant.setItemMeta(testEnchantMeta);	
		    	entity.getEquipment().setItemInHand(testEnchant);
		}
	
	}
	}
	
	

	@EventHandler
	public void oyuncuOlumu (PlayerDeathEvent e) {
		Player player = e.getEntity();
		if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND && player.getLocation().getBlock().getType() != Material.WATER) {
			if(e.getDeathMessage().contains("died")){
				e.setDeathMessage(ChatColor.GRAY + player.getName() + ChatColor.WHITE +" abimiz ayaklar�n� kumda yakt�ktan sonra ac�dan kendini �ld�rd�, hakk�n�z helal olsun mu?");
			}
			
		
		}
	}
	@EventHandler
	public void olum (EntityDeathEvent e){
		LivingEntity entity = e.getEntity();
	
		Random rand = new Random();
		
		
	
		if (entity instanceof Monster) {
			if (entity instanceof Spider && entity.getCustomName() != null) {
				if (entity.getCustomName().equalsIgnoreCase("Alkar�s�")) {
					ItemStack stack = new ItemStack(Material.REDSTONE);
					ItemStack stack1 = new ItemStack(Material.IRON_NUGGET);
					ItemStack stack2 = new ItemStack(Material.DIAMOND);
					  ItemStack runaanYay = new ItemStack (Material.BOW, 1);
					     ItemMeta runaanYayMeta = runaanYay.getItemMeta();
					     runaanYayMeta.setUnbreakable(true); // On versions 1.11 and above
					     runaanYayMeta.spigot().setUnbreakable(true); 
					     runaanYay.setDurability((short)1);
					     runaanYayMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
					     ArrayList<String> runaanYaylore4 = new ArrayList<String>();
					     runaanYayMeta.setDisplayName(ChatColor.DARK_RED+ "Runaan'�n Yay�");
					     runaanYayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					     runaanYayMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
					        runaanYaylore4.add(ChatColor.RED + "Alaca�� canlarla dolup ta��yor.");
					 
					        runaanYayMeta.setLore(runaanYaylore4);
					        runaanYay.setItemMeta(runaanYayMeta);
					        e.getDrops().add(10, stack);
					        e.getDrops().add(stack1);
					        e.getDrops().add(stack2);
					        e.getDrops().add(stack2);
					        e.getDrops().add(stack);
					        e.getDrops().add(1,runaanYay);
				}
			}
			ItemStack stack = new ItemStack(Material.TOTEM_OF_UNDYING);
			ItemStack stack2 = new ItemStack(Material.ENDER_PEARL);
			if(rand.nextInt(100) <= 2) {
				e.getDrops().add(stack);
			}
	
			if (rand.nextInt(200) >= 199) {
				e.getDrops().add(stack2);
			}
		}

		if (entity instanceof Creeper) {
			entity.getWorld().strikeLightningEffect(entity.getLocation());
			entity.getWorld().createExplosion(entity.getLocation(), 2);
		}
	}
	@EventHandler
	public void yatmak (PlayerBedEnterEvent e){
		Player player = e.getPlayer();
		if (player.getWorld().hasStorm() == true) {
			e.setCancelled(true);
			player.sendMessage(ChatColor.RED + "Havan�n bu kadar kasvetli olmas� seni korkutuyor.\nUyuyam�yorsun...");
		}
	}
	
	  @EventHandler
	    public void oyuncuCanYenileme(EntityRegainHealthEvent event) {
		  if (event.getEntity() instanceof Player) {
			  if (getMevsim() != null) {
				  if (getmevsimDonem() == 1 ) {
				     if(event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN)
				            event.setAmount(event.getAmount()/4);		 
				  }
			  
			  
		  }
		  }
	
	   
	    }
	@EventHandler
	public void koymak (BlockPlaceEvent e) {
		Player player = e.getPlayer();
		Block block = e.getBlockPlaced();
		
	
		
		
		if (e.getItemInHand().getType() == Material.TORCH) {
		
			if (player.getWorld().getWorldType().equals(WorldType.NORMAL) && player.getLocation().getY() < 30){
				player.sendMessage(ChatColor.RED +"Burda oksijen seviyesi �ok az. Ate�in yanmas� imkans�z gibi...");
				e.setCancelled(true);
			}
		}

	}
	
	
	@EventHandler
	public void kovaBosalt (PlayerBucketEmptyEvent e) {
		Material kova = e.getBucket();
		if (kova == Material.WATER_BUCKET) {
			if (getMevsim().equalsIgnoreCase("kis")) {
				if (e.getPlayer().getWorld().getWorldType() == WorldType.NORMAL) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(ChatColor.BLUE + "Hava o kadar so�uk ki, su bile hemen buza d�n��t�!");
					itemiKullan(e.getPlayer(), 1, new ItemStack(Material.WATER_BUCKET));
					e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
					e.getBlockClicked().getRelative(e.getBlockFace()).setType(Material.ICE);
				}
			
			}
		}
	}
	//METHODS**************************************************************
	
//itemisil	
	public boolean itemiKullan(Player player, int count, ItemStack itemStack) {
	    Map<Integer, ? extends ItemStack> ammo = player.getInventory().all(itemStack);

	    int found = 0;
	    for (ItemStack stack : ammo.values())
	        found += stack.getAmount();
	    if (count > found)
	        return false;

	    for (Integer index : ammo.keySet()) {
	        ItemStack stack = ammo.get(index);

	        int removed = Math.min(count, stack.getAmount());
	        count -= removed;

	        if (stack.getAmount() == removed)
	            player.getInventory().setItem(index, null);
	        else
	            stack.setAmount(stack.getAmount() - removed);

	        if (count <= 0)
	            break;
	    }

	    player.updateInventory();
	    return true;
	}
//craft
	 public void checkCraft(ItemStack result, CraftingInventory inv, HashMap<Integer, ItemStack> ingredients){
	        ItemStack[] matrix = inv.getMatrix();
	        for(int i = 0; i < 9; i++){
	            if(ingredients.containsKey(i)){
	                if(matrix[i] == null || !matrix[i].equals(ingredients.get(i))){
	                    return;
	                }
	            } else {
	                if(matrix[i] != null){
	                    return;
	                }
	            }
	        }
	        inv.setResult(result);
	    }
//title**
		 
	
//mevsim------------------------------------------------------------------------------------------------------------------	

	    public void buscusMevsim(String mevsimIsim, int mevsimDonem) {
	        this.mevsimIsim = mevsimIsim;
	        this.mevsimDonem = mevsimDonem;
	    }

	    public String getmevsimIsim() {
	        return mevsimIsim;
	    }

	    public void setmevsimIsim(String mevsimIsim) {
	        this.mevsimIsim = mevsimIsim;
	    }

	    public int getmevsimDonem() {
	        return mevsimDonem;
	    }

	    public  void setmevsimDonem(int mevsimDonem) {
	        this.mevsimDonem = mevsimDonem;
	    }
		
	    
	    
	   //customcodes
	    public int getDonem() {
			return mevsimDonem;
	    	
	    }
	    public String getMevsim() {
	    	return mevsimIsim;
	    }
	    
	    public void setRuzgar(String ruzgar) {
	    	this.ruzgar = ruzgar;
		
	    }
	
//spawnTNT------------------------------------------------------------------------------------------------------------------------------

	    public TNTPrimed createPrimedTNT(String type, Location location, Float multiplier, int ticks, Sound sound, float pitch, JavaPlugin plugin) {
	        TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
	        location.getWorld().playSound(location, sound, 1, pitch);
	        tnt.setYield(tnt.getYield() * multiplier);
	        tnt.setMetadata("tntType", new FixedMetadataValue(plugin, type));
	        tnt.setFuseTicks(ticks);
	        return tnt;
	      }
	    
	    public boolean day() {
	        Server server = CokZorMobsInfo.getInstance().getServer();
	        long time = server.getWorld("world").getTime();

	        return time < 12300 || time > 23850;
	    }
	    
	    
	    //merchantrecipe
	    
	    private MerchantRecipe getTozEnder() {
	    	ItemStack sonuc = new ItemStack(Material.COCOA_BEANS);
	    	ItemMeta meta = sonuc.getItemMeta();
	    	meta.setDisplayName(ChatColor.DARK_PURPLE +"Kadim B�y�l� Par�a");
	        ArrayList<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.GOLD + "Bu kadim e�yaya bakt�k�a akl�n seninle");
	        lore.add(ChatColor.GOLD + "oyun oynuyor...");
	        lore.add(ChatColor.GOLD + "Yoksa bu ��r�m�� iskeletler...");
	        lore.add(ChatColor.DARK_RED + "Bizim atam�z m�yd�?");
	        meta.setLore(lore);
	    	sonuc.setItemMeta(meta);
	    	MerchantRecipe recipe = new MerchantRecipe(sonuc, 1000);
	    	recipe.addIngredient(new ItemStack(CokZorMobsInfo.konsantreElmas));
	    	recipe.addIngredient(new ItemStack(Material.STONE_BRICKS, 64));
	    	return recipe;
	    }
	    private void openTozEnder(Player player) {
	        // create the actual merchant
	        Merchant merchant = Bukkit.createMerchant(ChatColor.GREEN+ "Antik Ata'n�n G�sterdi�i E�yalar");
	        
	        // Create a list of recipes for this merchant
	        List<MerchantRecipe> recipes = new ArrayList<>();
	        // Add our diamond recipe to this list
	        recipes.add(getTozEnder());
	        // Add this list of recipes to our merchant
	        merchant.setRecipes(recipes);
	        // Open this merchant inventory to the player
	        player.openMerchant(merchant, true);
	    }
	    
	    private MerchantRecipe getIteems() {
	    	ItemStack sonuc = new ItemStack(Material.BLAZE_ROD);
	    	ItemMeta meta = sonuc.getItemMeta();
	    	meta.setDisplayName(ChatColor.DARK_PURPLE +"Cehennem Sopas�");
	        ArrayList<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.GOLD + "S�cac�k...");
	        lore.add(ChatColor.GOLD + "O kadar s�cak ki...");

	        lore.add(ChatColor.DARK_RED + "D��manlar�m�n ruhunu eritecek kadar s�cak.");
	        meta.setLore(lore);
	    	sonuc.setItemMeta(meta);
	    	MerchantRecipe recipe = new MerchantRecipe(sonuc, 1000);
	    	recipe.addIngredient(new ItemStack(CokZorMobsInfo.konsantreElmas));
	    	recipe.addIngredient(new ItemStack(Material.JUNGLE_LEAVES, 64));
	    	return recipe;
	    }
	    private void openIteems(Player player) {
	        // create the actual merchant
	        Merchant merchant = Bukkit.createMerchant(ChatColor.GREEN+ "Antik K�yl�'n�n G�sterdi�i E�yalar");
	        
	        // Create a list of recipes for this merchant
	        List<MerchantRecipe> recipes = new ArrayList<>();
	        // Add our diamond recipe to this list
	        recipes.add(getIteems());
	        // Add this list of recipes to our merchant
	        merchant.setRecipes(recipes);
	        // Open this merchant inventory to the player
	        player.openMerchant(merchant, true);
	    }
}
