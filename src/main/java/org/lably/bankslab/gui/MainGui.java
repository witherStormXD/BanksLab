package org.lably.bankslab.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.gui.builders.GUIBuilder;
import org.lably.bankslab.gui.builders.ItemBuilder;
import org.lably.bankslab.manager.FileManager;

public class MainGui {
    private final PluginCore core;

    public MainGui(PluginCore core){
        this.core = core;
    }

    public void createGui(Player player) {
        GUIBuilder guiBuilder = new GUIBuilder();

        FileManager gui = core.getFilesLoader().getGui();

        Inventory inventory = guiBuilder.create(gui.getInt("Size-Gui"), gui.getString("Title-Gui"));

        for (String path : gui.getConfigurationSection("Icons").getKeys(false)) {

            ItemBuilder builder = new ItemBuilder();
            builder.create(
                    gui.getString("Icons." + path + ".Material-Item"),
                    gui.getString("Icons." + path + ".Item-Name"),
                    1,
                    gui.getStringList("Icons." + path + ".Lore-Item")
            );

            inventory.setItem(
                    gui.getInt("Icons." + path + ".Slot"),
                    builder.getItemStack()
            );

        }

        player.openInventory(inventory);

    }

}
