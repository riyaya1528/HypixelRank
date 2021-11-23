package net.riyaya.bungee.hypixelrank;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public final class HypixelRank extends Plugin {
    private static HypixelRank instance;
    public static HypixelRank getInstance() {
        return instance;
    }
    public static Configuration config;

    private static final LuckPerms luckPerms = LuckPermsProvider.get();
    public static LuckPerms getLuckPerms() {
        return luckPerms;
    }

    @Override
    public void onEnable() {
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLuckPerms();
        instance = this;
        getLogger().info("The plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }
}
