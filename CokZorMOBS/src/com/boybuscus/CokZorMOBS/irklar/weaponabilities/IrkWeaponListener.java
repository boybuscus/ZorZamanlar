package com.boybuscus.CokZorMOBS.irklar.weaponabilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.boybuscus.CokZorMOBS.ParticleEffect;
import com.boybuscus.CokZorMOBS.customitems.axius.BuzAsasi;
import com.boybuscus.CokZorMOBS.customitems.dredius.KisKilici;
import com.boybuscus.CokZorMOBS.irklar.Irk;
import com.boybuscus.CokZorMOBS.irklar.IrkPlayer;
import com.boybuscus.CokZorMOBS.irklar.IrkSeciciListener;
import com.boybuscus.CokZorMOBS.irklar.weaponabilities.axius.BuzAsasiAbility;

public class IrkWeaponListener implements Listener {
	
	@EventHandler
	public void rightClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		String weapon = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			Integer customWeaponData = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
		}
		
	}
	@EventHandler
	public void leftClick(PlayerAnimationEvent e) {
		Player player = e.getPlayer();
		String weapon = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
	
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			Integer customWeaponData = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
			if (canUse(player, weapon) && weapon.equalsIgnoreCase(BuzAsasi.getName()) && customWeaponData == BuzAsasi.getCustomWeaponData() && IrkSeciciListener.getIrk(player) == Irk.AXIUS) {
				new BuzAsasiAbility(player);
			}
		}
	}
	
	   
    @EventHandler
    public void sneak (PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if(player.isSneaking())
            return;
		String weapon = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			Integer customWeaponData = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
		}
		
    }
	
	@EventHandler
	public void attackEntity(EntityDamageByEntityEvent e) {
	Entity player =	e.getDamager();
	Entity kole = e.getEntity();
	if (player instanceof Player && kole instanceof Monster) {
		String weapon = ((HumanEntity) player).getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		if (((HumanEntity) player).getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {	
					if (weapon.equalsIgnoreCase(KisKilici.getName()) && canUse((Player) player, weapon)) {
						IrkPlayer.getIrkPlayer(player.getName()).addBeklemeSuresi(KisKilici.getName(), KisKilici.getCooldown());
						e.setCancelled(true);
						WeaponUtils.damageEntity((Player) player, kole, e.getDamage(), Irk.DREDIUS, weapon);
				for (Entity entity : WeaponUtils.getEntitiesAroundPoint(kole.getLocation(), 5)) {
					if (entity instanceof Monster && entity.getUniqueId() != player.getUniqueId() && entity.getUniqueId() != kole.getUniqueId()) {
						WeaponUtils.damageEntity((Player) player, entity,  (((LivingEntity)entity).getMaxHealth() /20) +5, Irk.DREDIUS, weapon);
						  ParticleEffect.SNOW_SHOVEL.display(entity.getLocation().add(0.05D, 3, 0.05D), 6);
						  ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 24*5, 2));
					}
				}
			}
		}
	}
	}
	
	
	
	
	
	
	
	
	
	
	public boolean canUse(Player player, String weapon) {
		IrkPlayer iPlayer = IrkPlayer.getIrkPlayer(player.getName());
		if (iPlayer == null) {
			player.sendMessage("aga kalk null");
			return false;
		}
		if (iPlayer.isOnBeklemeSuresi(weapon)) {
			return false;
		}
		return true;
	}
}
