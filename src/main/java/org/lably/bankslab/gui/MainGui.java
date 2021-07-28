package org.lably.bankslab.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.gui.builders.GUIBuilder;
import org.lably.bankslab.gui.builders.ItemBuilder;
import org.lably.bankslab.manager.FileManager;

public class MainGui {

    private final FileManager gui;

    public MainGui(PluginCore core){
        this.gui = core.getFilesLoader().getGui();
    }

    public void generalGui(Player player) {
        GUIBuilder guiBuilder = new GUIBuilder();

        Inventory inventory = guiBuilder.create(gui.getInt("General.Size-Gui"), gui.getString("General.Title-Gui"));

        for (String path : gui.getConfigurationSection("General.Icons").getKeys(false)) {

            ItemBuilder builder = new ItemBuilder();
            builder.create(
                    gui.getString("General.Icons." + path + ".Material-Item"),
                    gui.getString("General.Icons." + path + ".Item-Name"),
                    1,
                    gui.getStringList("General.Icons." + path + ".Lore-Item")
            );

            inventory.setItem(
                    gui.getInt("General.Icons." + path + ".Slot"),
                    builder.getItemStack()
            );

        }

        player.openInventory(inventory);
    }

    public void depositGui(Player player) {
        GUIBuilder guiBuilder = new GUIBuilder();

        Inventory inventory = guiBuilder.create(gui.getInt("Deposit.Size-Gui"), gui.getString("Deposit.Title-Gui"));

        for (String path : gui.getConfigurationSection("Deposit.Icons").getKeys(false)) {

            ItemBuilder builder = new ItemBuilder();
            builder.create(
                    gui.getString("Deposit.Icons." + path + ".Material-Item"),
                    gui.getString("Deposit.Icons." + path + ".Item-Name"),
                    1,
                    gui.getStringList("Deposit.Icons." + path + ".Lore-Item")
            );

            inventory.setItem(
                    gui.getInt("Deposit.Icons." + path + ".Slot"),
                    builder.getItemStack()
            );

        }

        player.openInventory(inventory);
    }

}
