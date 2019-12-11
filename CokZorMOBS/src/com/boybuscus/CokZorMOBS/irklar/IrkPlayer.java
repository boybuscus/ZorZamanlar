package com.boybuscus.CokZorMOBS.irklar;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IrkPlayer {
	
	private static ConcurrentHashMap<UUID, IrkPlayer> players = new ConcurrentHashMap<>();
	private UUID uuid;
	private String name;
	private Irk irklar;
	private ConcurrentHashMap<String, Long> beklemeSuresi;
	private boolean uyanmis;
	
	
	
	
	public IrkPlayer(UUID uuid, String playerName, Irk irklar, boolean uyanmis) {
		this.uuid = uuid;
		this.name = playerName;
		this.irklar = irklar;
		this.uyanmis = uyanmis;
		beklemeSuresi = new ConcurrentHashMap<String, Long>();
		
		
		players.put(uuid, this);
	}
	
	public static Map<UUID, IrkPlayer> getPlayers() {
		return players;
	}


	public static IrkPlayer getIrkPlayer(String player) {
			Player oPlayer = Bukkit.getPlayer(player);
			return IrkPlayer.getPlayers().get(oPlayer.getUniqueId());
		}

	public void addBeklemeSuresi(String weapon, long cooldown) {
		//PlayerBeklemeSuresiChangeEvent event = new PlayerCooldownChangeEvent(Bukkit.getPlayer(uuid), ability, cooldown, Result.ADDED);
		//Bukkit.getServer().getPluginManager().callEvent(event);
		//if (!event.isCancelled()) {
			this.beklemeSuresi.put(weapon, cooldown + System.currentTimeMillis());
	//	}
	}
	public boolean isOnBeklemeSuresi(String weapon) {
		return this.beklemeSuresi.containsKey(weapon);
	}
	public long getBeklemeSuresi(String weapon) {
		if (beklemeSuresi.containsKey(weapon)) {
			return beklemeSuresi.get(weapon);
		}
		return -1;
	}
	public ConcurrentHashMap<String, Long> getBeklemeSureleri() {
		return beklemeSuresi;
	}
	public void kaldirBeklemeSuresi(String weapon) {
		beklemeSuresi.remove(weapon);
	}

}
