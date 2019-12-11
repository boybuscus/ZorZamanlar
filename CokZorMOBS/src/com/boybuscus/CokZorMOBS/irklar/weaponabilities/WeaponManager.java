package com.boybuscus.CokZorMOBS.irklar.weaponabilities;

import com.boybuscus.CokZorMOBS.irklar.weaponabilities.axius.BuzAsasiAbility;

public class WeaponManager implements Runnable{
	@Override
	public void run() {
		BuzAsasiAbility.repeat();
	}
}
