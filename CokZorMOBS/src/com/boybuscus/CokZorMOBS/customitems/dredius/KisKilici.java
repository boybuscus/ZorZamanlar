package com.boybuscus.CokZorMOBS.customitems.dredius;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.boybuscus.CokZorMOBS.CokZorMobsInfo;

public class KisKilici {

	public KisKilici(CokZorMobsInfo instance) {
		
		  ItemStack ucusSponge = new ItemStack(Material.IRON_SWORD, 1, (byte)1); 
		 
		     ItemMeta ucusSpongeMeta = ucusSponge.getItemMeta();
	
		     ucusSpongeMeta.setCustomModelData(201);
		    ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		     ArrayList<String> ucusSpongelore4 = new ArrayList<String>();
		     ucusSpongeMeta.setDisplayName(ChatColor.DARK_BLUE+ "K�� K�l�c�");
		     
		     ucusSpongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		   
		        ucusSpongelore4.add(ChatColor.BLUE + "So�u�u kesik yaralar�nda hissetmeliler!");
		        ucusSpongelore4.add(ChatColor.GRAY + "�zel Sald�r�: 6 Saniye bekleme s�resi");
		 
		        ucusSpongeMeta.setLore(ucusSpongelore4);
		        ucusSponge.setItemMeta(ucusSpongeMeta);
		        ShapelessRecipe ucusSpongeY	= new ShapelessRecipe(ucusSponge);
		        ucusSpongeY.addIngredient(Material.SNOW_BLOCK);
		        ucusSpongeY.addIngredient(Material.IRON_SWORD);
		        ucusSpongeY.addIngredient(Material.DIAMOND);
		        
		        
		  instance.getServer().addRecipe(ucusSpongeY);
	}

	
	public static String getName() {
		return ChatColor.DARK_BLUE+"K�� K�l�c�";
	}
	public static Long getCooldown() {
		return 6000L;
	}
	public static Integer getCustomWeaponData() {
		return 201;
	}
}
