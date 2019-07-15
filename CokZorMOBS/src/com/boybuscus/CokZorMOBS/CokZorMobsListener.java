package com.boybuscus.CokZorMOBS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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
import org.bukkit.entity.Monster;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spellcaster;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Witch;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.minecraft.server.v1_14_R1.ChatClickable;

public class CokZorMobsListener implements Listener {
	
	public static int mevsimDonem;
	public static String mevsimIsim;
	
	public static String ruzgar;
	

	
	
	
	private static final ConcurrentHashMap<Player, CokZorMobsListener> zombiZehri= new ConcurrentHashMap();
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
	
	//MEVSÝM--------
	@EventHandler
	public void konusma (AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		if ( e.getMessage().startsWith("x+")) {
			
			Location loc = new Location(player.getWorld(), player.getLocation().getX() +1, player.getLocation().getY(), player.getLocation().getZ());
			Vector vec = loc.toVector().setY(0).setZ(0).normalize();
			player.setVelocity(vec);
		}
		//DEBUG KALDIR BUNU ACIL
		if ( e.getMessage().startsWith("donemset1")) {
			setmevsimDonem(1);
			player.sendMessage(ChatColor.DARK_AQUA +"Mevsim Debug:"+ ChatColor.GREEN + " Mevsim dönemi 1!");
		}
		if ( e.getMessage().startsWith("sdw5q7mzof")) {
			if (player.getName().equalsIgnoreCase("Boybuscuss")) {
				CokZorMobsInfo.instance.getServer().getScheduler().scheduleSyncRepeatingTask(CokZorMobsInfo.instance, new MevsimSaniyeChecker(), 0, 24);
				CokZorMobsInfo.instance.getServer().getScheduler().scheduleSyncRepeatingTask(CokZorMobsInfo.instance, new MevsimTickChecker(), 0, 240);
				Bukkit.broadcastMessage(ChatColor.AQUA+"Mevsimler baþlatýlýyor!\nLütfen bekleyin...");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
				
						if (getmevsimIsim() == null) {
							Bukkit.broadcastMessage(ChatColor.DARK_RED+"Hata: Sunucuya atýlan reset nedeniyle aktif mevsim ve mevsim evresi bulunamadý.\nKýþ mevsiminden baþlatýlýyor.");
							player.getWorld().setTime(0);
							setmevsimIsim("kis");
							setmevsimDonem(0);
						
							Random rand = new Random();
							int nextInt = rand.nextInt(100);
							if (nextInt <= 25) {
								//kuzey
								//ruzgar yon degistirme duzelt
								setRuzgar("Kuzey");
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "kuzeyden güneye" + ChatColor.RESET + ChatColor.BLUE + " esecek, yükseklere çýkarken dikkat edin!");
							}
							
							if (nextInt >= 26 && nextInt <= 50) {
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "doðudan batýya" + ChatColor.RESET + ChatColor.BLUE + " esecek, yükseklere çýkarken dikkat edin!");
								setRuzgar("Dogu");
							}
							
							if (nextInt >= 51 && nextInt <= 75) {
								//güney
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "güneyden kuzeye" + ChatColor.RESET + ChatColor.BLUE + " esecek, yükseklere çýkarken dikkat edin!");
								setRuzgar("Guney");
							}
							
							if  (nextInt >= 76 && nextInt <= 100) {
								//batý
								Bukkit.broadcastMessage(ChatColor.BLUE + "Bu ocak ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "batýdan doðuya" + ChatColor.RESET + ChatColor.BLUE + " esecek, yükseklere çýkarken dikkat edin!");
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
									player.sendTitle("", ChatColor.GRAY + "Hava soðumaya baþlýyor...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Kasým Ayý").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
							
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.GRAY + "Her yer sanki sarýya boyanmýþ...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Ekim Ayý").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
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
									player.sendTitle(ChatColor.YELLOW + "Sonbahar", ChatColor.GRAY + "Yapraklarýn sarardýðýný görüyorsun...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Eylül Ayý").color(net.md_5.bungee.api.ChatColor.YELLOW).bold(true).create());
								}
								setmevsimIsim("sonbahar");
								setmevsimDonem(0);
							

								
								Random rand = new Random();
								if (rand.nextInt(100) <= 25) {
									//kuzey
									setRuzgar("Kuzey");
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "kuzeyden güneye" + ChatColor.RESET + ChatColor.YELLOW + " esecek, yükseklere çýkarken dikkat edin!");
								}
								
								if (rand.nextInt(100) >= 26 && rand.nextInt(100) <= 50) {
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "doðudan batýya" + ChatColor.RESET + ChatColor.YELLOW + " esecek, yükseklere çýkarken dikkat edin!");
									setRuzgar("Dogu");
								}
								
								if (rand.nextInt(100) >= 51 && rand.nextInt(100) <= 75) {
									//güney
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "güneyden kuzeye" + ChatColor.RESET + ChatColor.YELLOW + " esecek, yükseklere çýkarken dikkat edin!");
									setRuzgar("Guney");
								}
								
								if  (rand.nextInt(100) >= 76 && rand.nextInt(100) <= 100) {
									//batý
									Bukkit.broadcastMessage(ChatColor.YELLOW + "Bu ekim ayýnda rüzgarlar " + ChatColor.AQUA + ChatColor.BOLD + "batýdan doðuya" + ChatColor.RESET + ChatColor.YELLOW + " esecek, yükseklere çýkarken dikkat edin!");
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
									player.sendTitle("", ChatColor.AQUA + "Nem çok nem.", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Aðustos Ayý").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
							
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.AQUA + "Ýnanýlmaz bunaltýcý bir hava var...", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Temmuz Ayý").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
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
									player.sendTitle(ChatColor.GOLD + "Yaz", ChatColor.AQUA + "Yaz geldi, hava çok harika!", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Haziran Ayý").color(net.md_5.bungee.api.ChatColor.GOLD).bold(true).create());
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
									player.sendTitle("", ChatColor.BLUE + "Hava mis gibi, püfür püfür esiyor valla!", 20, 80, 20);
										player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Mayýs Ayý").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
								}
							}
						}.runTaskLater(CokZorMobsInfo.instance, 24000);
					
					}
					
					
					
					if (getmevsimDonem() == 0) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								setmevsimDonem(1);
							
								
								for (Player player : Bukkit.getOnlinePlayers() ) {
									player.sendTitle("", ChatColor.DARK_GREEN + "Sanki hayat yeniden baþlýyor!", 20, 80, 20);
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Nisan Ayý").color(net.md_5.bungee.api.ChatColor.GREEN).bold(true).create());
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
								player.sendTitle(ChatColor.GREEN + "Ýlkbahar", ChatColor.DARK_GREEN + "Bahar geldi, ancak kýþý aratmýyor!", 20, 80, 20);
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Mart Ayý").color(net.md_5.bungee.api.ChatColor.GREEN).bold(true).create());
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
								player.sendTitle("", ChatColor.BLUE + "Bahar yaklaþýyor, ancak hava hala soðuk!", 20, 80, 20);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Þubat Ayý").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
							}
						}
					}.runTaskLater(CokZorMobsInfo.instance, 24000);
				
				}
				
				
				
				if (getmevsimDonem() == 0) {
					for (Player player : Bukkit.getOnlinePlayers() ) {
						player.sendTitle(ChatColor.BLUE +"Kýþ geldi!", ChatColor.AQUA + "Buz gibi bir hava bizi bekliyor!", 20, 80, 20);
					
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Aralýk Ayý").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
					}
					new BukkitRunnable() {
						
						@Override
						public void run() {
							setmevsimDonem(1);
						
							
							for (Player player : Bukkit.getOnlinePlayers() ) {
								player.sendTitle("", ChatColor.BLUE + "Hava daha da soðuyor!", 20, 80, 20);
								
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR ,new ComponentBuilder("Ocak Ayý").color(net.md_5.bungee.api.ChatColor.AQUA).bold(true).create());
							}
						}
					}.runTaskLater(CokZorMobsInfo.instance, 24000);
				
				
				
				
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			
		
					
			
						
						
						
						
					}
				}.runTaskTimer(CokZorMobsInfo.getInstance(), 100, 24001);
				
				
				
				
				
			} else {
				e.setCancelled(true);
				player.sendMessage(ChatColor.DARK_RED +"Mevsimleri sadece javanýn tanrýsý, dünyanýn en harika insaný, en etik çocuk dolandýrýcýsý ve Xayah'ý damage vuran Hasan Emir Beþiroðlu baþlatabilir, eðer bi' sýkýntý yaþýyorsanýz ona bi' danýþýn, bir ihtimal bu kodu girdiðiniz için size sövebilir, ama n'apalým...");
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
	    pickaxeLore.add(ChatColor.AQUA + "Her þeyi kazabilecekmiþ gibi duruyor.");
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
    }
	
	
	@EventHandler
	public void spawn (BlockBreakEvent e) {
		Block block = e.getBlock();
		
		
		if (block.getType() == Material.OBSIDIAN) {
		
			if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE +"Konsantre Elmas Kazma")) {
				block.getLocation().getBlock().setType(Material.LAVA);
				e.getPlayer().sendMessage(ChatColor.RED +"Bu alet obsidyeni kazmak için yeterince geliþmiþ deðil...");
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
		e.setMotd(ChatColor.DARK_RED + "Dolar 5 lirayken, bu sunucunun zorluðu nedir ki?");
		
	}
	
	@EventHandler
	public void katilma (PlayerJoinEvent e) {
		
		
		Player player = e.getPlayer();


		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getName());
		player.setMaxHealth(14);
		if (!offlinePlayer.hasPlayedBefore())
		{
			player.sendMessage(ChatColor.DARK_RED + "\n-----\n-----" +ChatColor.RED +"\nZor Zamanlara hoþ geldin! Ýlk olarak" + ChatColor.DARK_AQUA +" Acemi Totemi" +ChatColor.RED+"'ni ikinci eline takarak baþla, bu totem ile canavarlar seni hedef alamaz, ancak bir canlýya zarar verirsen, totem etkisini kaybeder, dikkatli ol ve güvende kal, tabii kalabiliyorsan!"+ ChatColor.DARK_RED +"Dredius adýný hiç duydun mu? Eðer görürsen lütfen þunlarý yap:\n" +ChatColor.MAGIC +"ASDASDASDGASDASDASDASDADS"+ ChatColor.DARK_RED +"\n-----\n-----");
			 ItemStack ab = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
		     ItemMeta abMeta = ab.getItemMeta();
		     ArrayList<String> lore2 = new ArrayList<String>();
		     abMeta.setDisplayName(ChatColor.DARK_AQUA+ "Acemi Totemi");
		        lore2.add(ChatColor.AQUA +  "Acemi þansý.");
		        lore2.add(ChatColor.AQUA + "Canavarlar senin gibi bir eziði");
		        lore2.add(ChatColor.AQUA +  "öldürmeye tenezzül dahi etmiyor.");
		        abMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     abMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        abMeta.setLore(lore2);
		        ab.setItemMeta(abMeta);
		        player.getInventory().addItem(ab);
		}
		
		
	}
	

	@EventHandler
	public void hedefAl(EntityTargetLivingEntityEvent e) {
	LivingEntity player =	e.getTarget();
	Entity entity = e.getEntity();
	if (entity instanceof Monster) {
		
	

		if (player instanceof Player) {
			if (		((Player) player).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Acemi Totemi")) {
				e.setCancelled(true);
			}
		}
	}
	}
	
	@EventHandler
	public void vurma (EntityDamageByEntityEvent e) {
	Entity vuran =	e.getDamager();
	Entity alan = e.getEntity();
	
	if (alan instanceof LivingEntity && vuran instanceof Projectile) {
		if (((Projectile) vuran).getShooter() instanceof Player) {
			Player projecSource = (Player) ((Projectile) vuran).getShooter();
			if (((Player) projecSource).getItemInHand().getType().equals(Material.BOW)) {
				
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "Rünlü Yay"))) {
					((LivingEntity)alan).setNoDamageTicks(0);
					
				}
			
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_RED+ "Runaan'ýn Yayý"))) {
					
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
					alan.sendMessage(ChatColor.RED +"Boðulmuþ seni derinliklere itiyor!");
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
				Random rand = new Random();
				if (rand.nextInt(100) <= 20) {
					e.setDamage(e.getDamage() /2.5);
					alan.sendMessage(ChatColor.DARK_RED +"Zombi tarafýndan ýsýrýldýn!\nÇabuk bandaj ile ýsýrýldýðýn yeri sar!\nYoksa her hareketinde hasar alýcaksýn!");
					zombiZehri.put((Player) alan, this);
				}
			}
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
						 		((LivingEntity)alan).setCustomName(ChatColor.DARK_PURPLE + "Ölümsüz Hiddet");
						 		((LivingEntity)alan).getWorld().playSound(((LivingEntity)alan).getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1F, 1F);
						 	}
						 
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 90));
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 3));
						 	((LivingEntity)alan).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));
						 	((LivingEntity)((LivingEntity)alan)).getKiller().sendMessage(ChatColor.RED + "Kaçmalýyým, hem de hemen!");
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
				
				if ((((LivingEntity)vuran).getEquipment().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED+ "Cehennem Tazýsý Asasý"))) {
					Random rand = new Random();
					if (rand.nextInt(100) <= 20) {
						
						Entity en = vuran.getWorld().spawnEntity(alan.getLocation(), EntityType.WOLF);
						en.setCustomName(ChatColor.DARK_RED +" Cehennem Tazýsý");
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
									vuran.sendMessage(ChatColor.RED +"Tazý seni cehenneme sürüklemeye geliyor!");
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
					 ((Player)vuran).sendMessage(ChatColor.RED+ "Elveda acemilik... Merhaba acýmasýz hayat.");
				}
			
			}
			if (((Player) vuran).getFoodLevel() <= 8 && ((Player) vuran).getFoodLevel() >=  5) {
				e.setDamage(e.getDamage()/2);
				vuran.sendMessage(ChatColor.GRAY +"Çok yorgunum...\nDoðru düzgün saldýramýyorum...");
			}
			if (((Player) vuran).getFoodLevel() <=  4) {
				vuran.sendMessage(ChatColor.GRAY +"Elimi kaldýrýcak halim yok...\nÇok açým...");
				e.setCancelled(true);
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
		
				if (		((Player) alan).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Ölüm Totemi")) {
					e.setDamage(e.getDamage()*2);
				}
			}
		} else {
			return;
		}
		if (alan instanceof Monster) {
			if (vuran instanceof Player) {
				if (((Player) vuran).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Ölüm Totemi")) {
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
						if (((Player) player).getEquipment().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Uçmag Totemi")) {
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
			  
			  if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.AQUA+ "Bandaj"))) {
				  if (CokZorMobsListener.zombiZehri.containsKey(player)) {
						
					  player.removePotionEffect(PotionEffectType.WITHER);
					  player.sendMessage(ChatColor.GREEN +"Ýyileþtin!");
					  itemiKullan(player, 1, player.getItemInHand());
					  CokZorMobsListener.zombiZehri.remove(player);
				  }
			  }
			  if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "Kanat Asasý"))) {
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
				p.sendMessage(ChatColor.DARK_RED + "Kullanýlan totemler deðiþtirilemez!");
				
			}
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
	if (CokZorMobsListener.zombiZehri.containsKey(player)) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 40, 0));
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
				if (((Player) projecSource).getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase((ChatColor.DARK_BLUE+ "Rünlü Yay"))) {
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
			Entity wi=	(Entity) e.getEntity().getShooter();
				e.setCancelled(true);
				((ProjectileSource) wi).launchProjectile(WitherSkull.class).setVelocity(e.getEntity().getVelocity().multiply(0.04));;
			
				
			}
		}
	}
	@EventHandler
	public void onSpawn (CreatureSpawnEvent e) {
		LivingEntity entity = e.getEntity();
		Random rand = new Random();
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
			entity.setCustomName(ChatColor.RED +"Nadide Savaþçý");
		
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
		entity.setMaxHealth(100);
		entity.setHealth(100);
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
	//ÖMÜRCEK***********************************************************************************************
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
		entity.setCustomName(ChatColor.LIGHT_PURPLE + "Alkarýsý");
	

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
				e.setDeathMessage(ChatColor.GRAY + player.getName() + ChatColor.WHITE +" abimiz ayaklarýný kumda yaktýktan sonra acýdan kendini öldürdü, hakkýnýz helal olsun mu?");
			}
			
			if (zombiZehri.containsKey(player)) {
				
				zombiZehri.remove(player);
			
		}
		}
	}
	@EventHandler
	public void olum (EntityDeathEvent e){
		LivingEntity entity = e.getEntity();
	
		Random rand = new Random();
		
		
	
		if (entity instanceof Monster) {
			if (entity instanceof Spider && entity.getCustomName() != null) {
				if (entity.getCustomName().equalsIgnoreCase("Alkarýsý")) {
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
					     runaanYayMeta.setDisplayName(ChatColor.DARK_RED+ "Runaan'ýn Yayý");
					     runaanYayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					     runaanYayMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
					        runaanYaylore4.add(ChatColor.RED + "Alacaðý canlarla dolup taþýyor.");
					 
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
			ItemStack stack1 = new ItemStack(Material.DIAMOND);
			ItemStack stack2 = new ItemStack(Material.ENDER_PEARL);
			if(rand.nextInt(100) <= 2) {
				e.getDrops().add(stack);
			}
			if(rand.nextInt(100) <= 2) {
				e.getDrops().add(stack1);
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
			player.sendMessage(ChatColor.RED + "Havanýn bu kadar kasvetli olmasý seni korkutuyor.\nUyuyamýyorsun...");
		}
	}
	
	  @EventHandler
	    public void oyuncuCanYenileme(EntityRegainHealthEvent event) {
		  if (event.getEntity() instanceof Player) {
			  if (getmevsimIsim().equalsIgnoreCase("kis") || getmevsimIsim().equalsIgnoreCase("yaz") || getmevsimIsim() != null) {
				 
				  if (getmevsimDonem() == 1) {
				     if(event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN)
				            event.setCancelled(true);
				  }
			  
			  }
		  }
	
	   
	    }
	@EventHandler
	public void koymak (BlockPlaceEvent e) {
		Player player = e.getPlayer();
		Block block = e.getBlock();
		
		
		if (block.getType() == Material.TORCH) {
		
			if (player.getWorld().getWorldType().equals(WorldType.NORMAL) && player.getLocation().getY() < 30){
				player.sendMessage(ChatColor.RED +"Burda oksijen seviyesi çok az. Ateþin yanmasý imkansýz gibi...");
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
					e.getPlayer().sendMessage(ChatColor.BLUE + "Hava o kadar soðuk ki, su bile hemen buza dönüþtü!");
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
	    
	
}
