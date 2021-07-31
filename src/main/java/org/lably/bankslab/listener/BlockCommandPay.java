package org.lably.bankslab.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.lably.bankslab.PluginCore;

public class BlockCommandPay implements Listener {
    private final PluginCore pluginCore;

    public BlockCommandPay(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }
    @EventHandler
    public void blockPay(PlayerCommandPreprocessEvent event){
        if(event.getMessage().equals("/pay")){
            event.setCancelled(true);
        }

    }
}
