package com.boybuscus.CokZorMOBS.irklar;

import org.bukkit.ChatColor;

public enum Irk {
    NONE(""),
    DREDIUS(ChatColor.RED + "[Dredius]"),
    PHAREXIA(ChatColor.AQUA + "[Pharexia]"),
    AXIUS(ChatColor.BLUE + "[Axius]"),
	IMMORTUITES(ChatColor.DARK_RED + "[Immortuites]");
	
    private final String prefix;

    Irk(String prefix) {
        this.prefix = prefix;
    }
}
