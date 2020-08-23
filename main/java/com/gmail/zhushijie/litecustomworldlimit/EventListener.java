package com.gmail.zhushijie.litecustomworldlimit;

import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.*;

import java.util.List;

public class EventListener implements Listener {
    //限制玩家权限
    //每次触发事件时必须重新获取一次config,否则游戏内/lcwl reload是没有实际作用的
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockPlaceEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.place" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("place");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockBreakEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.break" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("break");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerDropItemEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.dropitem" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("drop-item");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(EntityPickupItemEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            String w = p.getWorld().getName();
            if (!p.isOp() && !p.hasPermission("litecustomworldlimit.pickitem" + p.getWorld().getName())) {
                List<String> worlds = config.getStringList("pick-item");
                if (worlds.contains(w)) {
                    e.setCancelled(true);
                    p.sendTitle(notify1,notify2,10,70,20);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerMoveEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.move" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("move");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerInteractEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.interact" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("interact");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerInteractEntityEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.interactentity" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("interact-entity");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerEditBookEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.editbook" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("edit-book");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerEggThrowEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.throwegg" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("throw-egg");
            if (worlds.contains(w)) {
                e.setHatching(false);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(PlayerFishEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        String notify1 = config.getString("prefix").replace("&","§");
        String notify2 = config.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.fish" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("fish");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    //防止某些事件
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(LeavesDecayEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("leaves-decay");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockFadeEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-fade");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockIgniteEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-ignite");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockBurnEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-burn");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockExplodeEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-explode");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockSpreadEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-spread");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockFormEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-change");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockGrowEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("grow");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockPistonExtendEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("piston");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(BlockPistonRetractEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("piston");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(EntityBlockFormEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("entity-form");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlaceBlock(EntityBreakDoorEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Entity entity = e.getEntity();
        String w = entity.getWorld().getName();
        List<String> worlds = config.getStringList("break-door");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }
}