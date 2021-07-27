package org.lably.bankslab.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.manager.FileManager;

import java.util.Set;

public class InventoryClickListener implements Listener {

    private final PluginCore pluginCore;

    public InventoryClickListener(PluginCore pluginCore) {
        this.pluginCore = pluginCore;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        FileManager gui = pluginCore.getFilesLoader().getGui();

        if (!event.getCurrentItem().hasItemMeta()) return;


        for (String path : gui.getConfigurationSection("Icons").getKeys(false)) {

            if(event.getCurrentItem().getItemMeta().getDisplayName()
                    .equals(gui.getString("Icons." + path + ".Item-Name"))) {

                /*

                Pending to propose the movements or actions when clicking on an item in the main menu.

                */

            }

        }

    }


}
