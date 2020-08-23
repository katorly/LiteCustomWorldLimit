package com.gmail.zhushijie.litecustomworldlimit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("litecustomworldlimit")) {
            FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
            if (args.length < 1) { //若只输入了个/lcwl则弹出插件帮助
                if (!(sender instanceof Player)) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"litecustomworldlimit help");
                } else {
                    Player player = (Player) sender;
                    player.performCommand("litecustomworldlimit help");
                }
            } else if (Objects.equals(args[0], "reload")) { //重载插件配置的指令 lcwl reload
                LiteCustomWorldLimit.INSTANCE.reloadConfig();
                LiteCustomWorldLimit.INSTANCE.saveConfig();
                sender.sendMessage(config.getString("plugin-prefix").replace("&","§") + config.getString("reload-success").replace("&","§"));
            } else if (Objects.equals(args[0], "help")) { //查看插件帮助的指令 lcwl help
                List<String> helpmessage = config.getStringList("help-message");
                int i = 0;
                for (int length = helpmessage.size(); i < length; i++) {
                    sender.sendMessage(helpmessage.get(i).replace("&","§"));
                }
            } else { //若指令输入错误
                if (!(sender instanceof Player)) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"litecustomworldlimit help");
                } else {
                    Player player = (Player) sender;
                    player.performCommand("litecustomworldlimit help");
                }
            }
        }
        return true;
    }
}
