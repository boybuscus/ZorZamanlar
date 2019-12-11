package com.boybuscus.CokZorMOBS.customitems.axius;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.boybuscus.CokZorMOBS.CokZorMobsInfo;

public class BuzAsasi {

	public BuzAsasi(CokZorMobsInfo instance) {
		
		  ItemStack buzAsasi = new ItemStack(Material.WOODEN_SWORD, 1, (byte)1);
		 
		     ItemMeta buzAsasiMeta = buzAsasi.getItemMeta();
	
		     
		     buzAsasiMeta.setCustomModelData(101);
		    buzAsasiMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		     ArrayList<String> buzAsasilore4 = new ArrayList<String>();
		     buzAsasiMeta.setDisplayName(ChatColor.DARK_BLUE+ "Buz Asasý");
		     
		     buzAsasiMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		   
		        buzAsasilore4.add(ChatColor.BLUE + "Rakipleri kanýna kadar dondurmak için.");
		        buzAsasilore4.add(ChatColor.GRAY +"4 Saniye bekleme süresi.");
		 
		        buzAsasiMeta.setLore(buzAsasilore4);
		        buzAsasi.setItemMeta(buzAsasiMeta);
		        ShapelessRecipe buzAsasiY	= new ShapelessRecipe(buzAsasi);
		        buzAsasiY.addIngredient(Material.SNOW_BLOCK);
		        buzAsasiY.addIngredient(Material.STICK);
		        buzAsasiY.addIngredient(Material.DIAMOND);
		        
		        
		  instance.getServer().addRecipe(buzAsasiY);
	}
	
	public static String getName() {
		return ChatColor.DARK_BLUE+"Buz Asasý";
	}
	public static Long getCooldown() {
		return 4000L;
	}
	public static Integer getCustomWeaponData() {
		return 101;
	}
}
