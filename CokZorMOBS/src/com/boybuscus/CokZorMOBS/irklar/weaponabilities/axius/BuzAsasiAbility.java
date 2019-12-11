package com.boybuscus.CokZorMOBS.irklar.weaponabilities.axius;

import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.boybuscus.CokZorMOBS.ParticleEffect;
import com.boybuscus.CokZorMOBS.customitems.axius.BuzAsasi;
import com.boybuscus.CokZorMOBS.irklar.Irk;
import com.boybuscus.CokZorMOBS.irklar.IrkPlayer;
import com.boybuscus.CokZorMOBS.irklar.weaponabilities.WeaponUtils;

public class BuzAsasiAbility {
	
	
	 private static final ConcurrentHashMap<Integer, BuzAsasiAbility> instances = new ConcurrentHashMap<Integer, BuzAsasiAbility>();
	 
	
	private Player player;
	private Location blast;
    private Location origin;
    private Vector dir;
    private IrkPlayer iPlayer;
    private FallingBlock fb;
	double alpha;
	  public static int ID = Integer.MIN_VALUE;
	    public int id;
	public BuzAsasiAbility(Player player) {
		this.player = player;
		if (!player.isSneaking()) {
			return;
		}
		iPlayer = IrkPlayer.getIrkPlayer(player.getName());
		if (iPlayer.isOnBeklemeSuresi(BuzAsasi.getName())) {
			return;
		}
		blast = WeaponUtils.getTargetedLocation(player, 35, Material.GRASS, Material.SNOW, Material.WATER, Material.AIR , Material.VOID_AIR, Material.CAVE_AIR, Material.TALL_GRASS);
		
		origin = player.getEyeLocation().add(Math.random(), 7, Math.random());
		fb = origin.getWorld().spawnFallingBlock(origin, Material.BLUE_ICE, (byte)1);
		fb.setCustomName("cigdebug");
		fb.setCustomNameVisible(false);
		fb.setDropItem(false);
		dir = birNoktadanDigerineVec(fb.getLocation(), blast, 0.05);
		if (iPlayer.isOnBeklemeSuresi("buzasafinal")) {
			iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
			iPlayer.kaldirBeklemeSuresi("buzasa1");
			iPlayer.kaldirBeklemeSuresi("buzasa2");
			iPlayer.kaldirBeklemeSuresi("buzasafinal");
		}
		if (iPlayer.isOnBeklemeSuresi("buzasa2")) {
			iPlayer.addBeklemeSuresi("buzasafinal", 4000);
		}
		if (iPlayer.isOnBeklemeSuresi("buzasa1")) {
			iPlayer.addBeklemeSuresi("buzasa2", 4000);
		}
		if (!iPlayer.isOnBeklemeSuresi("buzasa1")) {
			iPlayer.addBeklemeSuresi("buzasa1", 4000);
		}
		
		
	
	
		if (blast == null) {
			dir = player.getEyeLocation().getDirection().multiply(0.34);
		}
		
		alpha = 0;
		player.getLocation().getWorld().playSound(player.getLocation(), Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE, 0.6f, 0.01f);
		createInstance();
	}

	
	
	
    private void createInstance() {
        id = ID;
        instances.put(id, this);
        if (ID == Integer.MAX_VALUE ) {
            ID = Integer.MIN_VALUE;
        }
        ID++;
    }
   
    public static void repeat() {
        for (int i : instances.keySet()) {
            if (!instances.get(i).progress()) {
                instances.remove(i);
            }
        }
    }
    
    
    public boolean progress() {
    	if (!player.isSneaking()) {
    		iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    		return false;
    	}
    	if (player.isDead() || !player.isOnline()) {
    		iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    		return false;
    	}
    	if (player.getLocation().distance(blast) > 80) {
    		iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    		return false;
    	}
    	if (!player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(BuzAsasi.getName())) {
    		iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    		return false;
    	}
    	if (fb.isOnGround()) {
    		iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    		return false;
    	}
     	fb.setVelocity(dir);
    	alpha += Math.PI / 16;

        
        Location loc = fb.getLocation();
        Location firstLocation = loc.clone().add( Math.cos( alpha ), Math.sin( alpha ) + 1, Math.sin( alpha ) );
        Location secondLocation = loc.clone().add( Math.cos( alpha + Math.PI ), Math.sin( alpha ) + 1, Math.sin( alpha + Math.PI ) );
        
        
       ParticleEffect.SNOW_SHOVEL.display(secondLocation, 1);
       ParticleEffect.SNOW_SHOVEL.display(firstLocation, 1);

    	for (Entity entity : WeaponUtils.getEntitiesAroundPoint(fb.getLocation(), 6)) {
    		if (entity instanceof LivingEntity && entity.getUniqueId() != player.getUniqueId()) {
    			entity.getLocation().getWorld().playSound(entity.getLocation(), Sound.BLOCK_SNOW_PLACE, 1f, 0.3f);
    			WeaponUtils.damageEntity(player, entity, ((LivingEntity) entity).getHealth()/10 + 2, Irk.AXIUS, BuzAsasi.getName());
    			iPlayer.addBeklemeSuresi(BuzAsasi.getName(), BuzAsasi.getCooldown());
    			entity.setVelocity(dir.multiply(0.3));
    			return false;
    		}
    	}
    	
    	return true;
    }
	public static void birNoktadanDigerine(Location ilk, Entity ilkEnt, Location ikinci, double guc) {
		Vector pos = ilkEnt.getLocation().toVector();
        Vector target = ikinci.toVector();
        Vector velocity = target.subtract(pos);
        ilkEnt.setVelocity(velocity.normalize().multiply(guc));
	}
    public static Vector birNoktadanDigerineVec(Location ilk, Location ikinci, double guc) {
    	Vector pos = ilk.toVector();
        Vector target = ikinci.toVector();
        Vector velocity = target.subtract(pos).multiply(guc);
        return velocity;
    }

}
