package com.gmail.zhushijie.litecustomworldlimit;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public final class LiteCustomWorldLimit extends JavaPlugin {
    public static LiteCustomWorldLimit INSTANCE;
    public LiteCustomWorldLimit() {
        INSTANCE = this;
    }

    public void pluginupdater() {
        String currentversion = "1.0";
        getLogger().info("正在检查更新......");
        try {
            URL url = new URL("https://cdn.jsdelivr.net/gh/main-world/litecustom@update/LiteCustomWorldLimit/version.txt");
            InputStream is = url.openStream();
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);
            String version = br.readLine();
            if (version.equals(currentversion)) {
                getLogger().info("插件已是最新版本!");
            } else {
                getLogger().info("检查到插件有新版本!");
                getLogger().info("请前往相应网页下载更新!");
            }
        } catch (Throwable t) {
            getLogger().info("更新检查失败!");
        }
    }

    public ConfigReader Messagesconfig;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        Messagesconfig = new ConfigReader(this,"messages.yml");
        Messagesconfig.saveDefaultConfig();
        Messagesconfig.reloadConfig();
        getLogger().info("LiteCustomWorldLimit已成功加载!");
        getLogger().info("作者:主世界");
        getLogger().info("本插件已免费发布并在Gitee上开源");
        pluginupdater();
        LiteCustomWorldLimit.INSTANCE.getCommand("litecustomworldlimit").setExecutor(new CommandHandler());
        getServer().getPluginManager().registerEvents(new EventListener(),this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        reloadConfig();
        Messagesconfig.saveConfig();
        Messagesconfig.reloadConfig();
        HandlerList.unregisterAll(this);
        getLogger().info("LiteCustomWorldLimit已成功卸载!");
    }
}
