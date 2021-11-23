package net.riyaya.bungee.hypixelrank.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.riyaya.bungee.hypixelrank.HypixelRank;
import net.riyaya.bungee.hypixelrank.Utils.Messanger;

public class RankNick extends Command {
    public RankNick() {
    super("ranknick");
}

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if (!sender.hasPermission("HypixelRank.command.nick")) {
                Messanger.sendMessage((ProxiedPlayer) sender, ChatColor.RED + "必要なパーミッションがありません");
                return;
            }
            if (args.length == 0) {
                HypixelRank.config.set(((ProxiedPlayer) sender).getUniqueId() + ".rank", HypixelRank.getLuckPerms().getUserManager().getUser(((ProxiedPlayer) sender).getUniqueId()).getCachedData().getMetaData().getPrefix());
                Messanger.sendMessage((ProxiedPlayer) sender, ChatColor.GREEN + "リセットしました");
                if(HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".name") == null) {
                    ((ProxiedPlayer) sender).setDisplayName("[" + HypixelRank.getLuckPerms().getUserManager().getUser(((ProxiedPlayer) sender).getUniqueId()).getCachedData().getMetaData().getPrefix() + "] " + sender.getName());
                }else {
                    ((ProxiedPlayer) sender).setDisplayName("[" + HypixelRank.getLuckPerms().getUserManager().getUser(((ProxiedPlayer) sender).getUniqueId()).getCachedData().getMetaData().getPrefix() + "] " + HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".name"));
                }
                return;
            }
            HypixelRank.config.set(((ProxiedPlayer) sender).getUniqueId() + ".rank", args[0]);
            if(HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".name") == null) {
                ((ProxiedPlayer) sender).setDisplayName("[" + args[0] + "] " + sender.getName());
            }else {
                ((ProxiedPlayer) sender).setDisplayName("[" + args[0] + "] " + HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".name"));
            }

        }else {
            HypixelRank.getInstance().getLogger().info("コンソール上のコマンド送信は対応してません");
        }
    }
}
