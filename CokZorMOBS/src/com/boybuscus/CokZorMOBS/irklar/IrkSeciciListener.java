package com.boybuscus.CokZorMOBS.irklar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.boybuscus.CokZorMOBS.CokZorMobsInfo;

import com.sun.istack.internal.NotNull;

public class IrkSeciciListener implements InventoryHolder, Listener {
	 static Map<Player, Irk> irklar = new HashMap<>();
	
	@EventHandler
	public void katilmaEventi(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		loadIrk(player);
		Irk irk = getIrk(player);

		if (irk == null || irk == Irk.NONE) {
			 CokZorMobsInfo.getInstance().saveConfig();
			initializeItems();
			openInventory(player);
		}
		new IrkPlayer(player.getUniqueId(), player.getName(), irk, false);
	}
	
	
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() != this) {
            return;
        }
        if (e.getClick().equals(ClickType.NUMBER_KEY)){
            e.setCancelled(true);
        }
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // Using slots click is a best option for your inventory click's
        if (e.getRawSlot() == 0) {
        	p.closeInventory(); 
        	e.setCancelled(true); 
        	e.setCursor(null); 
        	p.sendMessage("Art�k " +ChatColor.RED + "Dredius " + ChatColor.WHITE + "milletinin bir �yesisin!" ); 
        	setIrk(p, Irk.DREDIUS);
        	saveIrkToConfig(p);
        	}
        if (e.getRawSlot() == 1) {
        	p.closeInventory();
        	e.setCancelled(true)
        	; e.setCursor(null);
        	p.sendMessage("Art�k " +ChatColor.BLUE + "Pharexia "+ ChatColor.WHITE + "milletinin bir �yesisin!");
        	setIrk(p, Irk.PHAREXIA);
        	saveIrkToConfig(p);
        	}
        if (e.getRawSlot() == 2) {p.closeInventory(); e.setCancelled(true); e.setCursor(null); p.sendMessage("Art�k " +ChatColor.GREEN + "Axius "+ ChatColor.WHITE + "milletinin bir �yesisin!"); setIrk(p, Irk.AXIUS); saveIrkToConfig(p); }
        if (e.getRawSlot() == 3) {p.closeInventory(); e.setCancelled(true); e.setCursor(null); p.sendMessage(ChatColor.MAGIC + "Art�k " +ChatColor.DARK_RED + "Immortuites"+ ChatColor.MAGIC + "milletinin bir �yesisin!"); setIrk(p, Irk.IMMORTUITES); saveIrkToConfig(p); }
        
    }
	
	
	
	
	@EventHandler
	public void exit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Irk irk = getIrk(p);
		if (irk != null || CokZorMobsInfo.getInstance().getConfig().get("Users."+p.getUniqueId().toString() + ".Irk") != null) {
			saveIrk(p);
		}
	}
	
	
	
	@EventHandler
	public void talk (AsyncPlayerChatEvent e) {
		String msg = e.getMessage();
		if (msg.equalsIgnoreCase(ChatColor.GOLD + "s") && getIrk(e.getPlayer()) == Irk.DREDIUS) {
			e.getPlayer().sendMessage("anan");
		}
	}
	
	
	
	//methods

	
	    private final Inventory inv;

	    public IrkSeciciListener() {
	        inv = Bukkit.createInventory(this, 9, "Irk Se�");
	    }

	    @NotNull
	    @Override
	    public Inventory getInventory() {
	        return inv;
	    }

	    // You can call this whenever you want to put the items in
	    public void initializeItems() {
	        inv.addItem(createGuiItem(Material.IRON_SWORD, ChatColor.RED + "Dredius",
	        		ChatColor.GRAY + "Gezgin k�l�� ustalar�n�n",
	        		ChatColor.GRAY + "milleti.",
	        		"-",
	        		ChatColor.GRAY + "�zellik: K�l�� ve �zel",
	        		ChatColor.GRAY + "k�l��lar�yla hasarlar�",
	        		ChatColor.GRAY + "10% artar.",
	        		ChatColor.GRAY + "�zellik: Biraz daha",
	        		ChatColor.GRAY + "h�zl� y�r�rler."));
	        
	        
	        inv.addItem(createGuiItem(Material.IRON_AXE, ChatColor.BLUE + "Pharexia",
	        		ChatColor.GRAY + "Barbarlardan olu�an asi topluluk.",
	        		"-",
	        		ChatColor.GRAY + "�zellik: Yak�ndan ald�klar�",
	        		ChatColor.GRAY + "hasar 35% ihtimalle 40% d��er.",
	        		ChatColor.GRAY + "�zellik: Et yediklerinde",
	        		ChatColor.GRAY + "bir s�reli�ine g��lenirler."));
	        
	        
	        inv.addItem(createGuiItem(Material.NETHER_STAR, ChatColor.GREEN + "Axius", 
	        		ChatColor.GRAY + "B�y�l� g�kadalar�nda",
	        		ChatColor.GRAY + "ya�ayan b�y�c� toplulu�u.",
	        		"-",
	        		ChatColor.GRAY + "�zellik: B�y� hasarlar�yla",
	        		ChatColor.GRAY + "10% artar.",
	        		ChatColor.GRAY + "�zellik: D��me hasar�",
	        		ChatColor.GRAY + "50% azal�r.",
	        		ChatColor.GRAY + "�zellik: D��erek �l�mc�l",
	        		ChatColor.GRAY + "hasar alamazlar."));
	        inv.addItem(createGuiItem(Material.NETHERRACK,   ChatColor.MAGIC.DARK_PURPLE +"Immortuites",
	        		ChatColor.GRAY + "Jud gvr vqeqagadglgoh...",
	        		ChatColor.MAGIC + "HAHAHAHAHAHAHAAHAHH",
	        		ChatColor.GRAY + "Wlqzcbe: Dtpdi nqb ux xiae zilufctgiwme."));
	        
	    }

	    // Nice little method to create a gui item with a custom name, and description
	    private ItemStack createGuiItem(Material material, String name, String...lore) {
	        ItemStack item = new ItemStack(material, 1);
	        ItemMeta meta = item.getItemMeta();
	        meta.setDisplayName(name);
	       ArrayList<String> metalore = new ArrayList<String>();    

	       for(String lorecomments : lore) {

	      metalore.add(lorecomments);

	}

	       meta.setLore(metalore);
	        item.setItemMeta(meta);
	        return item;
	    }

	    // You can open the inventory with this
	    public void openInventory(Player p) {
	        p.openInventory(inv);
	    }
	    
	    
	    
	    
	    
	    //irk methods
	    public  void setIrk(Player player, Irk Irk) {
		     irklar.put(player, Irk);
		}

		public static Irk getIrk(Player player) {
		     return irklar.get(player);
		}

		public void loadIrk(Player player) {
		    String irkString = CokZorMobsInfo.getInstance().getConfig().getString("Users."+player.getUniqueId().toString()+".Irk");
		    
		    if (irkString == null || irkString.equals("")) {
		    	setIrk(player, Irk.NONE);
		    	return;
		    }
		    if (irkString.equalsIgnoreCase("DREDIUS")) {
		    	player.setPlayerListName(ChatColor.RED +" [Dredius] " + ChatColor.GRAY + player.getName());
		    	setIrk(player, Irk.DREDIUS);
		    	return;
		    }
		    
		    if (irkString.equalsIgnoreCase("PHAREXIA")) {
		    	player.setPlayerListName(ChatColor.BLUE +" [Pharexia] " + ChatColor.GRAY + player.getName());
		    	setIrk(player, Irk.PHAREXIA);
		    	return;
		    }
		    if (irkString.equalsIgnoreCase("AXIUS")) {
		    	player.setPlayerListName(ChatColor.GREEN +" [Axius] " + ChatColor.GRAY + player.getName());
		    	setIrk(player, Irk.AXIUS);
		    	return;
		    }
		    if (irkString.equalsIgnoreCase("IMMORTUITES")) {
		    	player.setPlayerListName(ChatColor.RED +" [Immortuites] " + ChatColor.GRAY + player.getName());
		    	setIrk(player, Irk.IMMORTUITES);
		    	return;
		    }
		    if (irkString.equalsIgnoreCase("NONE")) {
		    	setIrk(player, Irk.NONE);
		    	return;
		    }
		 
		    
		    
		}

		public void saveIrk(Player player) {
			if (getIrk(player) == Irk.DREDIUS) {
				Irk suanIrk = Irk.DREDIUS;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.PHAREXIA) {
				Irk suanIrk = Irk.PHAREXIA;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.AXIUS) {
				Irk suanIrk = Irk.AXIUS;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.IMMORTUITES) {
				Irk suanIrk = Irk.IMMORTUITES;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.NONE) {
				Irk suanIrk = Irk.NONE;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
		}
		public void saveIrkToConfig(Player player) {
			if (getIrk(player) == Irk.DREDIUS) {
				Irk suanIrk = Irk.DREDIUS;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.PHAREXIA) {
				Irk suanIrk = Irk.PHAREXIA;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.AXIUS) {
				Irk suanIrk = Irk.AXIUS;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			  
			}
			if (getIrk(player) == Irk.IMMORTUITES) {
				Irk suanIrk = Irk.IMMORTUITES;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			
			}
			if (getIrk(player) == Irk.NONE) {
				Irk suanIrk = Irk.NONE;
				String irkString = suanIrk.toString();
				CokZorMobsInfo.getInstance().getConfig().set("Users."+player.getUniqueId().toString()+".Irk", irkString );
				CokZorMobsInfo.getInstance().saveConfig();
			    
			}
			
		}
		
		
}
