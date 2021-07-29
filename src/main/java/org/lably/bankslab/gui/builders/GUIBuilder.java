package org.lably.bankslab.gui.builders;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lably.bankslab.utils.TextColor;

public class GUIBuilder {

    public Inventory create(int size, String title) {

        return Bukkit.createInventory(null, size, TextColor.colorized(title));

    }

}
