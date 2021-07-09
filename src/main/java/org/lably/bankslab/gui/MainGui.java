package org.lably.bankslab.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.lably.bankslab.BanksLab;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.manager.FileManager;
import org.lably.bankslab.utils.TextColor;

import java.util.ArrayList;
import java.util.List;

public class MainGui {
    private final PluginCore core;

    public MainGui(PluginCore core){
        this.core = core;
    }
    public void createGui(Player player){
        GUIBuilder guiBuilder = new GUIBuilder();
        FileManager gui = core.getFilesLoader().getGui();
        Inventory inventory = guiBuilder.create(player,36,gui.getString("Title-Gui"));
        List<String> depositlore2 = gui.getStringList("Lore-Deposit-Item");
        for (String depositLore:gui.getStringList("Lore-Deposit-Item")){
            depositlore2.add(TextColor.colorized(depositLore));
            ItemStack depositItem = new ItemBuilder().create("IRON_INGOT",gui.getString("Deposit-Item-Name"),1,depositlore2);
            inventory.setItem(gui.getInt("Deposit-slot"),depositItem);
        }
        List<String> leaveMoneylore = gui.getStringList("LeaveMoney-Item-lore");
        for(String leaveMoneyFor: gui.getStringList("LeaveMoney-Item-lore")){
            leaveMoneylore.add(TextColor.colorized(leaveMoneyFor));
            ItemStack leaveMoney = new ItemBuilder().create("REDSTONE",gui.getString("LeaveMoney-Item-Name"),1,leaveMoneylore);
            inventory.setItem(gui.getInt("LeaveMoney-slot"),leaveMoney);
        }
        player.openInventory(inventory);




    }

}
