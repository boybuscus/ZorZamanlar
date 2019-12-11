package com.boybuscus.CokZorMOBS.irklar.weaponabilities;

import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.util.Vector;

import com.boybuscus.CokZorMOBS.irklar.Irk;

public class WeaponUtils {
	public static Integer[] nonOpaque = { 0, 6, 8, 9, 10, 11, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 51, 55, 59, 66, 68, 69, 70, 72, 75, 76, 77, 78, 83, 90, 93, 94, 104, 105, 106, 111, 115, 119, 127, 131, 132, 175 };
	
	public static Location getTargetedLocation(final Player player, final double range,  final Material... nonOpaque2) {
		final Location origin = player.getEyeLocation();
		final Vector direction = origin.getDirection();

		HashSet<Material> trans = new HashSet<Material>();
		trans.add(Material.AIR);
		trans.add(Material.CAVE_AIR);
		trans.add(Material.VOID_AIR);

		if (nonOpaque2 != null) {
			for (final Material material : nonOpaque2) {
				trans.add(material);
			}
		}
		
		Location location = origin.clone();
		Vector vec = direction.normalize().multiply(0.2);
		
		for (double i = 0; i < range; i += 0.2) {
			location.add(vec);
			
			Block block = location.getBlock();
			
			if (trans.contains(block.getType())) {
				continue;
			}  else {
				location.subtract(vec);
				break;
			}
		}

		return location;
	}
	public static void damageEntity(Player player, Entity entity, double damage, Irk irk,  String weapon) {
		if (entity instanceof LivingEntity) {
			//if (((LivingEntity) entity).getHealth() - damage <= 0 && entity instanceof Player && !entity.isDead()) {
				//PlayerWeaponCauseDeathEvent event = new PlayerWeaponCauseDeathEvent((Player) entity, player, damage, irk, weapon);
				//Bukkit.getServer().getPluginManager().callEvent(event);
			//}
			((LivingEntity) entity).damage(damage, player);
			entity.setLastDamageCause(new EntityDamageByEntityEvent(player, entity, DamageCause.CUSTOM, damage));
			
		}
	}
	public static List<Entity> getEntitiesAroundPoint(Location location, double radius) {
		List<Entity> entities = location.getWorld().getEntities();
		List<Entity> list = location.getWorld().getEntities();

		for (Entity entity : entities) {
			if (entity.getWorld() != location.getWorld()) {
				list.remove(entity);
			} else if (entity instanceof Player && ((Player) entity).getGameMode().equals(GameMode.SPECTATOR)) {
				list.remove(entity);
			} else if (entity.getLocation().distance(location) > radius) {
				list.remove(entity);
			}
		}
		return list;
	}
}
