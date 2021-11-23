package net.riyaya.bungee.hypixelrank.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;
import net.riyaya.bungee.hypixelrank.HypixelRank;
import net.riyaya.bungee.hypixelrank.Utils.LuckPermsPrefix;
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
                Messanger.sendMessage((ProxiedPlayer) sender, ChatColor.RED + "パラメータが必要です");
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
