package org.lably.bankslab.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.manager.FileManager;

public class InventoryClickListener implements Listener {

    private final PluginCore core;

    public InventoryClickListener(PluginCore core) {
        this.core = core;
    }

    @EventHandler
    public void onClickGeneralGui(InventoryClickEvent event) {
        FileManager gui = core.getFilesLoader().getGui();

        if (!event.getCurrentItem().hasItemMeta()) return;
        if(!event.getInventory().getTitle().equals(gui.getString("General.Title-Gui"))) return;
        event.setCancelled(true);

        String itemName = event.getCurrentItem().getItemMeta().getDisplayName();

        if(itemName.equals(gui.getString("General.Icons.Deposit.Item-Name"))) {

            core.getMainGui().depositGui((Player) event.getWhoClicked());
            return;
        }

        if(itemName.equals(gui.getString("General.Icons.Leave.Item-Name"))) {

            event.getWhoClicked().closeInventory();
        }
    }
}
