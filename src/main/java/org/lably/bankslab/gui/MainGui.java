package org.lably.bankslab.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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

        Inventory inventory = guiBuilder.create(player,36,gui.getString("Title-Gui"));

        ItemStack depositItem = new ItemBuilder().create("IRON_INGOT",
                gui.getString("Deposit-Item-Name"),
                1,
                gui.getStringList("Lore-Deposit-Item"));


        inventory.setItem(gui.getInt("Deposit-slot"), depositItem);

        ItemStack leaveMoney = new ItemBuilder().create(
                "REDSTONE",
                gui.getString("LeaveMoney-Item-Name"),
                1,
                gui.getStringList("LeaveMoney-Item-lore"));

        inventory.setItem(gui.getInt("LeaveMoney-slot"), leaveMoney);

        player.openInventory(inventory);




    }

}
