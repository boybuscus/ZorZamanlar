package com.boybuscus.CokZorMOBS.irklar.weaponabilities;

import java.util.UUID;

import com.boybuscus.CokZorMOBS.irklar.IrkPlayer;

public class CooldownManager implements Runnable{
	private static CooldownManager instance;
	long time;
	long interval;
	
	
	public CooldownManager() {
		instance = this;
		time = System.currentTimeMillis();
	}
	public static CooldownManager getInstance() {
		return instance;
	}
	public void handleCooldowns() {
		for (UUID uuid : IrkPlayer.getPlayers().keySet()) {
			IrkPlayer iPlayer = IrkPlayer.getPlayers().get(uuid);
			for (String weap : iPlayer.getBeklemeSureleri().keySet()) {
				if (System.currentTimeMillis() >= iPlayer.getBeklemeSuresi(weap)) {
					iPlayer.kaldirBeklemeSuresi(weap);
				}
			}
		}
	}
	@Override
	public void run() {
		handleCooldowns();
	}

}
