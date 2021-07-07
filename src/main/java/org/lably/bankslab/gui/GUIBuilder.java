package org.lably.bankslab.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lably.bankslab.utils.TextColor;

public class GUIBuilder {

    public Inventory create(Player player, int size, String title) {

        return Bukkit.createInventory(player, size, TextColor.colorized(title));

    }

}
