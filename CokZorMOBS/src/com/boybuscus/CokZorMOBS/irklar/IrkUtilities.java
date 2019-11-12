package com.boybuscus.CokZorMOBS.irklar;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IrkUtilities {
	public static boolean isSwordInHand(Player player) {
		String checkerName = player.getInventory().getItemInMainHand().toString();
		if (checkerName.contains("SWORD")) {
			return true;
		}
		return false;
	}
	public static boolean isMeat(ItemStack mat) {
		if (mat == new ItemStack(Material.COOKED_BEEF) || mat == new ItemStack(Material.COOKED_CHICKEN) || mat == new ItemStack(Material.COOKED_COD) || mat == new ItemStack(Material.COOKED_MUTTON) || mat == new ItemStack(Material.COOKED_PORKCHOP) || mat == new ItemStack(Material.COOKED_RABBIT) || mat == new ItemStack(Material.COOKED_SALMON) || mat == new ItemStack(Material.RABBIT_STEW)) {
			return true;
		}
		return false;
	}
}
