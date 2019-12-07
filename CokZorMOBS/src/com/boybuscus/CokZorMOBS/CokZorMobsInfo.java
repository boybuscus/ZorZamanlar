package com.boybuscus.CokZorMOBS;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.boybuscus.CokZorMOBS.irklar.IrkListener;
import com.boybuscus.CokZorMOBS.irklar.IrkSeciciListener;
	
public class CokZorMobsInfo extends JavaPlugin {
	   static CokZorMobsInfo instance;

	   public static ItemStack konsantreElmas;
	public CokZorMobsInfo plugin;

	@SuppressWarnings("deprecation")
	public void onEnable() {
		 //******************************************************SHAPEDRECIPEEEEEEEEEEEEEEEE
		NamespacedKey spongeUcus = new NamespacedKey(this, "sponge_ucus");
		ItemStack bottle = new ItemStack(Material.SPONGE, 6);
		ShapedRecipe spongeY = new ShapedRecipe(spongeUcus, bottle);
		 
		spongeY.shape("*%*","%B%","*%*");
		
		
		
		
		
		
		
		spongeY.setIngredient('*', Material.DIRT);
		spongeY.setIngredient('%', Material.SAND);
		spongeY.setIngredient('B', Material.DIAMOND);
		 
		getServer().addRecipe(spongeY);
		//********************************************************
		
		NamespacedKey konsantreDiamond = new NamespacedKey(this, "consantre_diamond");
		konsantreElmas = new ItemStack(Material.DIAMOND, 1);
		ItemMeta konsantreMeta = konsantreElmas.getItemMeta();
	    konsantreMeta.setDisplayName(ChatColor.BLUE +"Konsantre Elmas");
	    konsantreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    ArrayList<String> diamondLore = new ArrayList<String>();
	    diamondLore.add(ChatColor.AQUA + "Kusursuz görünüyor.");
	    konsantreMeta.setLore(diamondLore);
	    konsantreMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
	    konsantreElmas.setItemMeta(konsantreMeta);
		ShapedRecipe FocusedDY = new ShapedRecipe(konsantreDiamond, konsantreElmas);
		
		FocusedDY.shape("%%%","%*%","%%%");
	
		

		FocusedDY.setIngredient('*', Material.DIAMOND_BLOCK);
		FocusedDY.setIngredient('%', Material.IRON_BLOCK);
		getServer().addRecipe(FocusedDY);
		//************************************************************

	
	    
	
		//**********************************************************                  ---UNSHAPEDRECIPE---
		
		 ItemStack ucmag = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
	     ItemMeta ucmagMeta = ucmag.getItemMeta();
	     ArrayList<String> lore = new ArrayList<String>();
	        ucmagMeta.setDisplayName(ChatColor.DARK_GREEN + "Uçmag Totemi");
	        lore.add(ChatColor.GRAY + "Uçmaga ulaþmýþ birinin totemi. Bunu iyi kullan.");
	        ucmagMeta.setLore(lore);
	        ucmag.setItemMeta(ucmagMeta);
		
	        ShapelessRecipe ucmagY	= new ShapelessRecipe(ucmag);
	        ucmagY.addIngredient(Material.TOTEM_OF_UNDYING);
	        ucmagY.addIngredient(Material.SPONGE);
	        ucmagY.addIngredient(Material.DIRT);
		getServer().addRecipe(ucmagY);
		//************************************************************	
		
		 ItemStack Olum = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
	     ItemMeta olumMeta = Olum.getItemMeta();
	     ArrayList<String> lore1 = new ArrayList<String>();
	     olumMeta.setDisplayName(ChatColor.DARK_RED + "Ölüm Totemi");
	        lore1.add(ChatColor.GRAY + "Ölüm yakýn, totemi ise daha da yakýn.");
	        olumMeta.setLore(lore1);
	        Olum.setItemMeta(olumMeta);
	        ShapelessRecipe olumY	= new ShapelessRecipe(Olum);
	        olumY.addIngredient(Material.TOTEM_OF_UNDYING);
	        olumY.addIngredient(Material.REDSTONE);
	        olumY.addIngredient(Material.REDSTONE_TORCH);
	
	        getServer().addRecipe(olumY);
	        //*************************************************************
	        ItemStack ab = new ItemStack (Material.TOTEM_OF_UNDYING, 1);
		     ItemMeta abMeta = ab.getItemMeta();
		     ArrayList<String> lore2 = new ArrayList<String>();
		     abMeta.setDisplayName(ChatColor.DARK_RED+ "Zebani Totemi");
		        lore2.add(ChatColor.LIGHT_PURPLE + "Cehennem yaratýðýnýn totemi.");
		        lore2.add(ChatColor.LIGHT_PURPLE + "Kýrmýzý bir ýþýkla parýldýyor.");
		        abMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     abMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        abMeta.setLore(lore2);
		        ab.setItemMeta(abMeta);
		        ShapelessRecipe abY	= new ShapelessRecipe(ab);
		        abY.addIngredient(Material.TOTEM_OF_UNDYING);
		        abY.addIngredient(Material.GHAST_TEAR);
		        abY.addIngredient(Material.GOLD_NUGGET);
		        abY.addIngredient(Material.NETHERRACK);
		        abY.addIngredient(Material.MAGMA_BLOCK);
		        abY.addIngredient(Material.SOUL_SAND);
	        
	        getServer().addRecipe(abY);
	      //*************************************************************
	        ItemStack band = new ItemStack (Material.PAPER, 1);
		     ItemMeta baMeta = band.getItemMeta();
		     ArrayList<String> lore3 = new ArrayList<String>();
		     baMeta.setDisplayName(ChatColor.AQUA+ "Bandaj");
		        lore3.add(ChatColor.GRAY + "Yaralanmalara karþý en iyi dost.");
		        baMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     baMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        baMeta.setLore(lore3);
		        band.setItemMeta(baMeta);
		        ShapelessRecipe bandY	= new ShapelessRecipe(band);
		        bandY.addIngredient(Material.BONE_MEAL);
		        bandY.addIngredient(Material.PAPER);

	        
	        getServer().addRecipe(bandY);
		 //*******************************************************************       
	        
	        ItemStack tazi = new ItemStack (Material.STICK, 1);
		     ItemMeta taziMeta = tazi.getItemMeta();
		     taziMeta.setUnbreakable(true); // On versions 1.11 and above
		     taziMeta.spigot().setUnbreakable(true); 
		     tazi.setDurability((short)1);
		     taziMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> tazilore4 = new ArrayList<String>();
		     taziMeta.setDisplayName(ChatColor.DARK_RED+ "Cehennem Tazýsý Asasý");
		     taziMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     taziMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        tazilore4.add(ChatColor.RED + "Ölümü ertelemek için iyi bir yol...");
		        tazilore4.add(ChatColor.LIGHT_PURPLE + "Mu acaba?");
		 
		        taziMeta.setLore(tazilore4);
		        tazi.setItemMeta(taziMeta);
		        ShapelessRecipe taziY	= new ShapelessRecipe(tazi);
		        taziY.addIngredient(Material.NETHERRACK);
		        taziY.addIngredient(Material.SOUL_SAND);
		        taziY.addIngredient(Material.STICK);
		        
		        
		  getServer().addRecipe(taziY);
		 //*****************************************************************************
		  ItemStack ucusSponge = new ItemStack (Material.STICK, 1);
		     ItemMeta ucusSpongeMeta = ucusSponge.getItemMeta();
		     ucusSpongeMeta.setUnbreakable(true); // On versions 1.11 and above
		     ucusSpongeMeta.spigot().setUnbreakable(true); 
		     ucusSponge.setDurability((short)1);
		     ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> ucusSpongelore4 = new ArrayList<String>();
		     ucusSpongeMeta.setDisplayName(ChatColor.DARK_BLUE+ "Kanat Asasý");
		     ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     ucusSpongeMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        ucusSpongelore4.add(ChatColor.BLUE + "GÖKLERE!");
		 
		        ucusSpongeMeta.setLore(ucusSpongelore4);
		        ucusSponge.setItemMeta(ucusSpongeMeta);
		        ShapelessRecipe ucusSpongeY	= new ShapelessRecipe(ucusSponge);
		        ucusSpongeY.addIngredient(Material.GLASS);
		        ucusSpongeY.addIngredient(Material.SPONGE);
		        ucusSpongeY.addIngredient(Material.STICK);
		        
		        
		  getServer().addRecipe(ucusSpongeY);
		  ////**********************************************************************************
		  ItemStack ucluYay = new ItemStack (Material.BOW, 1);
		     ItemMeta ucluYayMeta = ucluYay.getItemMeta();
		     ucluYayMeta.setUnbreakable(true); // On versions 1.11 and above
		     ucluYayMeta.spigot().setUnbreakable(true); 
		     ucluYay.setDurability((short)1);
		     ucluYayMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> ucluYaylore4 = new ArrayList<String>();
		     ucluYayMeta.setDisplayName(ChatColor.DARK_BLUE+ "Rünlü Yay");
		     ucluYayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     ucluYayMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        ucluYaylore4.add(ChatColor.BLUE + "Ýnanýlmaz bir güçle parýldýyor!");
		 
		        ucluYayMeta.setLore(ucluYaylore4);
		        ucluYay.setItemMeta(ucluYayMeta);
		        ShapelessRecipe ucluYayY	= new ShapelessRecipe(ucluYay);
		        ucluYayY.addIngredient(Material.BOW);
		        ucluYayY.addIngredient(Material.DIAMOND);
		        ucluYayY.addIngredient(Material.REDSTONE);
		        
		        
		  getServer().addRecipe(ucluYayY);
		  
		  
		  ///**********************************************************************************
		  
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
		        ShapelessRecipe runaanYayY	= new ShapelessRecipe(runaanYay);
		        runaanYayY.addIngredient(Material.BOW);
		        runaanYayY.addIngredient(Material.DIAMOND);
		        runaanYayY.addIngredient(Material.SPONGE);
		        
		        
		  getServer().addRecipe(runaanYayY);
		  
		///**********************************************************************************
		  
		  
		  
		  ItemStack shieldObsidian = new ItemStack (Material.SHIELD, 1);
		     ItemMeta shieldObsidianMeta = shieldObsidian.getItemMeta();
		     shieldObsidianMeta.setUnbreakable(true); // On versions 1.11 and above
		     shieldObsidianMeta.spigot().setUnbreakable(true); 
		     shieldObsidian.setDurability((short)1);
		     shieldObsidianMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> shieldObsidianlore4 = new ArrayList<String>();
		     shieldObsidianMeta.setDisplayName(ChatColor.LIGHT_PURPLE+ "Obsidyen Kalkan");
		     shieldObsidianMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		     shieldObsidianMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		        shieldObsidianlore4.add(ChatColor.YELLOW + "Hala sýcak hissettiriyor.");
		 
		        shieldObsidianMeta.setLore(shieldObsidianlore4);
		        shieldObsidian.setItemMeta(shieldObsidianMeta);
		        ShapelessRecipe shieldObsidianY	= new ShapelessRecipe(shieldObsidian);
		        shieldObsidianY.addIngredient(Material.OBSIDIAN);
		        shieldObsidianY.addIngredient(Material.DIAMOND);
		        shieldObsidianY.addIngredient(Material.SHIELD);
		        
		        
		  getServer().addRecipe(shieldObsidianY);
		  
		  
		  
		  
		  ///**********************************************************************************
		  
	
	
		  
		  ///**********************************************************************************
			  
		  
	        plugin = this;
	        getConfig().options().copyDefaults(true);
	  
	       saveConfig();
		getServer().getPluginManager().registerEvents(new CokZorMobsListener(), this);
		getServer().getPluginManager().registerEvents(new IrkSeciciListener(), this);
		getServer().getPluginManager().registerEvents(new IrkListener(), this);
		
		
		
	}
	
	public void onDisable() {
		
	}

	
	public static CokZorMobsInfo getInstance(){
        return instance;
    }

    public CokZorMobsInfo(){
        instance = this;
    }
	
}
