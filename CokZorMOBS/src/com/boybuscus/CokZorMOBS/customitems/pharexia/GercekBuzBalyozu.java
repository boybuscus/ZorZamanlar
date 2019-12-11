package com.boybuscus.CokZorMOBS.customitems.pharexia;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.boybuscus.CokZorMOBS.CokZorMobsInfo;

public class GercekBuzBalyozu {

	public GercekBuzBalyozu(CokZorMobsInfo instance) {
		  ItemStack ucusSponge = new ItemStack(Material.IRON_AXE, 1, (byte)1);
			 
		     ItemMeta ucusSpongeMeta = ucusSponge.getItemMeta();
	
		     ucusSpongeMeta.setCustomModelData(401);
		    ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> ucusSpongelore4 = new ArrayList<String>();
		     ucusSpongeMeta.setDisplayName(ChatColor.DARK_BLUE+ "Gerçek Buz Balyozu");
		     
		     ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		   
		        ucusSpongelore4.add(ChatColor.BLUE + "BÝ' O YANA BÝ' BU YANA SALLA.");
		        ucusSpongelore4.add(ChatColor.GRAY + "Özel Yetenek Bekleme Süresi: 8 saniye.");
		 
		        ucusSpongeMeta.setLore(ucusSpongelore4);
		        ucusSponge.setItemMeta(ucusSpongeMeta);
		        ShapelessRecipe ucusSpongeY	= new ShapelessRecipe(ucusSponge);
		        ucusSpongeY.addIngredient(Material.SNOW_BLOCK);
		        ucusSpongeY.addIngredient(Material.IRON_INGOT);
		        ucusSpongeY.addIngredient(Material.STICK);
	
		
		        
		        
		  instance.getServer().addRecipe(ucusSpongeY);
	}
	public static String getName() {
		return ChatColor.DARK_BLUE+"Gerçek Buz Balyozu";
	}
	public static Long getCooldown() {
		return 8000L;
	}
}
