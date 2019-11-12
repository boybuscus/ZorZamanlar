package com.boybuscus.CokZorMOBS.irklar;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class IrkListener implements Listener {
	
	@EventHandler
	public void entityHasarToEntity(EntityDamageByEntityEvent e) {
		Entity ent = e.getEntity();
		Entity hasarci = e.getDamager();
		if (hasarci instanceof Player) {
			if (IrkSeciciListener.getIrk((Player) hasarci) == Irk.DREDIUS && IrkUtilities.isSwordInHand((Player) hasarci)) {
				e.setDamage(e.getDamage() * 1.10);
				hasarci.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, ent.getLocation(), 4, 0.05F, 1 + Math.random(), 0.05F);
					}
		}
		if (ent instanceof Player) {
			if (IrkSeciciListener.getIrk((Player) ent) == Irk.PHAREXIA && hasarci.getLocation().distance(ent.getLocation()) <= 4) {
				Random rand = new Random();
				if (rand.nextInt(100) <= 35) {
				((Player)ent).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(net.md_5.bungee.api.ChatColor.DARK_GREEN + "Son vuruþu blokladýn!"));
				e.setDamage(e.getDamage()*0.50);
					hasarci.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, ent.getLocation(), 4, 0.05F, 1 + Math.random(), 0.05F);
				}
			}
		}
	}

	@EventHandler
	public void consumeFood(PlayerItemConsumeEvent e) {
		Player player = e.getPlayer();
		ItemStack food = e.getItem();
		if (IrkSeciciListener.getIrk(player) == Irk.PHAREXIA) {
			if (food.getType().toString().contains("COOKED") || food.getType().toString().contains("RAW") || food.getType() == Material.COOKED_BEEF) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*15, 0));
				player.sendMessage(ChatColor.RED +"Sonunda... Yemek.");
				Entity ent = player.getWorld().dropItemNaturally(player.getEyeLocation(), new ItemStack(Material.BONE));
				Vector vel = player.getEyeLocation().getDirection().multiply(0.87);
				ent.setVelocity(vel);
			}
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
			if (IrkSeciciListener.getIrk(player) == Irk.DREDIUS) {
				player.setWalkSpeed(0.241F);
			}
	}
	
	@EventHandler
	public void onGetDamage(EntityDamageEvent e) {
		Entity ent = e.getEntity();
		if (ent instanceof Player) {
			if (IrkSeciciListener.getIrk((Player) ent) == Irk.AXIUS) {
				if (e.getCause() == DamageCause.FALL) {
					if (((Player) ent).getHealth() <= e.getDamage()) {
						e.setDamage(0);
						((Player) ent).setHealth(1);
						e.setCancelled(true);
					} else {
						e.setDamage(e.getDamage()/2);
					}
				}
			}
		}
	}
}
