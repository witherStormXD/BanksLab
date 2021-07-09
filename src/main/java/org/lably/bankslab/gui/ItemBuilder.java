package org.lably.bankslab.gui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lably.bankslab.utils.TextColor;

import java.util.List;

public class ItemBuilder {

    public ItemStack create(String material, String displayName, int amount, List<String> lore) {

        ItemStack itemStack = new ItemStack(Material.valueOf(material), amount);

        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(TextColor.colorized(displayName));

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
