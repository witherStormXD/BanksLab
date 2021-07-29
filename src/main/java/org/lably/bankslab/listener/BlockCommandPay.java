package org.lably.bankslab.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import sun.jvm.hotspot.CommandProcessor;

public class BlockCommandPay implements Listener {

    @EventHandler
    public void blockPay(AsyncPlayerChatEvent event){
        if(event.getMessage().equals("/pay")){
            event.setCancelled(true);
        }

    }
}
