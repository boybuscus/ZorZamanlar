package com.boybuscus.CokZorMOBS.customitems.immortuites;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.boybuscus.CokZorMOBS.CokZorMobsInfo;

public class KarabuzKargisi {

	public KarabuzKargisi(CokZorMobsInfo instance) {
		
		  ItemStack ucusSponge = new ItemStack(Material.DIAMOND_SWORD, 1, (byte)1);
		 
		     ItemMeta ucusSpongeMeta = ucusSponge.getItemMeta();
	
		     ucusSpongeMeta.setCustomModelData(301);
		    ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> ucusSpongelore4 = new ArrayList<String>();
		     ucusSpongeMeta.setDisplayName(ChatColor.DARK_BLUE+ "Karabuz Mýzraðý");
		     
		     ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		   
		        ucusSpongelore4.add(ChatColor.BLUE + "Lanet... Hepsini bulmalý.");
		        ucusSpongelore4.add(ChatColor.GRAY + "Özel Ölüm Damgasý: Maksimum 3 canlý");
		 
		        ucusSpongeMeta.setLore(ucusSpongelore4);
		        ucusSponge.setItemMeta(ucusSpongeMeta);
		        ShapelessRecipe ucusSpongeY	= new ShapelessRecipe(ucusSponge);
		        ucusSpongeY.addIngredient(Material.SNOW_BLOCK);
		        ucusSpongeY.addIngredient(Material.IRON_SWORD);
		        ucusSpongeY.addIngredient(Material.SNOWBALL);
		        
		        
		  instance.getServer().addRecipe(ucusSpongeY);
		}
	public static String getName() {
		return ChatColor.DARK_BLUE+"Karabuz Mýzraðý";
	}
}


