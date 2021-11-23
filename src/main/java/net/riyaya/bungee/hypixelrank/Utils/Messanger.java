package net.riyaya.bungee.hypixelrank.Utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class
Messanger {
    public static void sendMessage(ProxiedPlayer player, String message) {
        player.sendMessage(ChatColor.AQUA + "[HypixelRank] " + ChatColor.WHITE + message);
    }
}
