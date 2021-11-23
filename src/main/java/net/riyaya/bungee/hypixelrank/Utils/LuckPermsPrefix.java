package net.riyaya.bungee.hypixelrank.Utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.riyaya.bungee.hypixelrank.HypixelRank;

public class LuckPermsPrefix {
    public static String getPrefix(ProxiedPlayer player) {
        return HypixelRank.getLuckPerms().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
    }
}
