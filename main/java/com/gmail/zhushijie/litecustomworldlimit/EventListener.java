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
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.*;

import java.util.List;

public class EventListener implements Listener {
    //限制玩家权限
    //每次触发事件时必须重新获取一次config,否则游戏内/lcwl reload是没有实际作用的
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onBlockBreakEvent(BlockBreakEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerDropItemEvent(PlayerDropItemEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onEntityPickupItemEvent(EntityPickupItemEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerTeleportEvent(PlayerTeleportEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.teleport" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("teleport");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.swaphanditems" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("swap-hand-items");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.enterbed" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("enter-bed");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerEditBookEvent(PlayerEditBookEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerEggThrowEvent(PlayerEggThrowEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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
    public void onPlayerShearEntityEvent(PlayerShearEntityEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.shear" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("shear");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerFishEvent(PlayerFishEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerPickupArrowEvent(PlayerPickupArrowEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        FileConfiguration mconfig = LiteCustomWorldLimit.Messagesconfig.getConfig();
        String notify1 = mconfig.getString("prefix").replace("&","§");
        String notify2 = mconfig.getString("no-permission").replace("&","§");
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        if (!p.isOp() && !p.hasPermission("litecustomworldlimit.pickarrow" + p.getWorld().getName())) {
            List<String> worlds = config.getStringList("pick-arrow");
            if (worlds.contains(w)) {
                e.setCancelled(true);
                p.sendTitle(notify1,notify2,10,70,20);
            }
        }
    }

    //防止某些事件
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeavesDecayEvent(LeavesDecayEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("leaves-decay");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockFadeEvent(BlockFadeEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-fade");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockIgniteEvent(BlockIgniteEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-ignite");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBurnEvent(BlockBurnEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-burn");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockExplodeEvent(BlockExplodeEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-explode");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityExplodeEvent(EntityExplodeEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Entity entity = e.getEntity();
        String w = entity.getWorld().getName();
        List<String> worlds = config.getStringList("entity-explode");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockSpreadEvent(BlockSpreadEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-spread");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockFormEvent(BlockFormEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("block-change");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockGrowEvent(BlockGrowEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("grow");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPistonExtendEvent(BlockPistonExtendEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("piston");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPistonRetractEvent(BlockPistonRetractEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("piston");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityBlockFormEvent(EntityBlockFormEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Block b = e.getBlock();
        String w = b.getWorld().getName();
        List<String> worlds = config.getStringList("entity-form");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityBreakDoorEvent(EntityBreakDoorEvent e) {
        FileConfiguration config = LiteCustomWorldLimit.INSTANCE.getConfig();
        Entity entity = e.getEntity();
        String w = entity.getWorld().getName();
        List<String> worlds = config.getStringList("break-door");
        if (worlds.contains(w)) {
            e.setCancelled(true);
        }
    }
}