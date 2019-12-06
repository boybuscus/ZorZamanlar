package com.boybuscus.CokZorMOBS.irklar;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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
	public static Map<Player, Irk> getPlayers() {
		return IrkSeciciListener.irklar;
	}
	public static Irk getIrkPlayer(Player player) {
		Player oPlayer = Bukkit.getPlayer(player.getUniqueId());
		if (oPlayer == null) {
			return null;
		}
		return getPlayers().get(oPlayer);
	}
	
	
	public static boolean isAxiusPlayer(Player player) {
			if (getIrkPlayer(player) != Irk.AXIUS) {
				return false;
			}
		return true;
	}
	public static boolean isDrediusPlayer(Player player) {
			if (getIrkPlayer(player) != Irk.DREDIUS) {
				return false;
			}
			return true;
	}
}
