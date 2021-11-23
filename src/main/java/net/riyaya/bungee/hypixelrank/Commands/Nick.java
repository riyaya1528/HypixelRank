package net.riyaya.bungee.hypixelrank.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.riyaya.bungee.hypixelrank.HypixelRank;
import net.riyaya.bungee.hypixelrank.Utils.Messanger;

public class Nick extends Command {

    public Nick() {
        super("nick");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if (!sender.hasPermission("HypixelRank.command.nick")) {
                Messanger.sendMessage((ProxiedPlayer) sender, ChatColor.RED + "必要なパーミッションがありません");
                return;
            }
            if (args.length == 0) {
                Messanger.sendMessage((ProxiedPlayer) sender, ChatColor.RED + "パラメータが必要です");
                return;
            }
            HypixelRank.config.set(((ProxiedPlayer) sender).getUniqueId() + ".name", args[0]);
            if(HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".rank") == null) {
                ((ProxiedPlayer) sender).setDisplayName("[" + HypixelRank.getLuckPerms().getUserManager().getUser(((ProxiedPlayer) sender).getUniqueId()).getCachedData().getMetaData().getPrefix() + "]" + args[0]);
            }else {
                ((ProxiedPlayer) sender).setDisplayName("[" + HypixelRank.config.getString(((ProxiedPlayer) sender).getUniqueId() + ".rank") + "]" + args[0]);
            }
        }else {
            HypixelRank.getInstance().getLogger().info("コンソール上のコマンド送信は対応してません");
        }
    }
}
