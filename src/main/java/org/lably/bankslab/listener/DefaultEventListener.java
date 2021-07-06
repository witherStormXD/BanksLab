package org.lably.bankslab.listener;

import org.lably.bankslab.PluginCore;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class DefaultEventListener implements Listener {

    private PluginCore pluginCore;

    public DefaultEventListener(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }
    // Event model
    @EventHandler
    public void onBreak(BlockBreakEvent event){

    }
}
