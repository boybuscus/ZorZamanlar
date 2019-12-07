package com.boybuscus.CokZorMOBS.customentity;

import org.bukkit.entity.Zombie;

import net.minecraft.server.v1_14_R1.ChatComponentText;
import net.minecraft.server.v1_14_R1.EntityChicken;
import net.minecraft.server.v1_14_R1.EntityCow;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityPig;
import net.minecraft.server.v1_14_R1.EntitySheep;
import net.minecraft.server.v1_14_R1.EntityZombie;
import net.minecraft.server.v1_14_R1.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_14_R1.PathfinderGoalLeapAtTarget;
import net.minecraft.server.v1_14_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_14_R1.World;

public class HayatSomuren extends EntityZombie {

	
	@SuppressWarnings("deprecation")
	
	public HayatSomuren(World world) {
		super(world);
		
		Zombie craftZombie = (Zombie) this.getBukkitEntity();
		
		this.setBaby(true);
		
		craftZombie.setMaxHealth(50);
		
		this.setHealth(50);
		ChatComponentText chatComponentText = new ChatComponentText("Hayat Sömüren");
	
		
		
	
	
		this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityPig>(this, EntityPig.class, true));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityChicken>(this, EntityChicken.class, true));
		this.targetSelector.a(4, new PathfinderGoalNearestAttackableTarget<EntityCow>(this, EntityCow.class, true));
		this.targetSelector.a(5, new PathfinderGoalNearestAttackableTarget<EntitySheep>(this, EntitySheep.class, true));
		this.targetSelector.a(6, new PathfinderGoalLeapAtTarget(this, 0.3f));

		this.targetSelector.a(1, new PathfinderGoalAvoidTarget<EntityHuman>(this, EntityHuman.class, 2, 2, 2));

		this.getWorld().addEntity(this);
	}

}