package org.lably.bankslab.loader;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.manager.FileManager;

import java.util.ArrayList;
import java.util.List;

public class CreateInventory {
    private PluginCore pluginCore;

    public CreateInventory(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }
    public void createInventory(Player player){
        FileManager messages = new FileManager(pluginCore.getPlugin(), "messages");
        Inventory inventory = Bukkit.createInventory(null,36,messages.getString("Title-Menu"));
        ItemStack deposito = new ItemStack(Material.IRON_INGOT);
        ItemMeta depositometa = deposito.getItemMeta();
        depositometa.setDisplayName(colorize("&aClick aqui para depositar dinero a otro jugador"));
        List<String> depositolore = new ArrayList<>();
        depositolore.add(colorize("&7Advertencia al dar &a&lConfirmar &7no podras recuperar tu dinero amenos que el jugador te lo deposite"));

    }
    public String colorize(String text){
        return ChatColor.translateAlternateColorCodes('&',text);
    }
}
