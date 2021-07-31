package org.lably.bankslab.listener;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.lably.bankslab.BanksLab;
import org.lably.bankslab.PluginCore;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.manager.FileManager;
import org.lably.bankslab.utils.TextColor;

import java.util.ArrayList;
import java.util.List;

public class InventoryClickListener implements Listener {

    private final PluginCore core;

    public InventoryClickListener(PluginCore core) {
        this.core = core;
    }
    List<String> inList = new ArrayList<>();
    @EventHandler
    public void onClickGeneralGui(InventoryClickEvent event) {
        FileManager gui = core.getFilesLoader().getGui();

        if (!event.getCurrentItem().hasItemMeta()) return;
        if(!event.getInventory().getTitle().equals(gui.getString("General.Title-Gui"))) return;

        event.setCancelled(true);

        String itemName = event.getCurrentItem().getItemMeta().getDisplayName();

        if(itemName.equals(gui.getString("General.Deposit.Item-Name"))) {

            core.getMainGui().depositGui((Player) event.getWhoClicked());
            return;
            
        }

        if(itemName.equals(gui.getString("General.Leave.Item-Name"))) {

            event.getWhoClicked().closeInventory();
        }
    }
    @EventHandler
    public void onDepositlGui(InventoryClickEvent event) {
        FileManager gui = core.getFilesLoader().getGui();

        if (!event.getCurrentItem().hasItemMeta()) return;
        if(!event.getInventory().getTitle().equals(gui.getString("Deposit.Title-Gui"))) return;

        event.setCancelled(true);

        String itemName = event.getCurrentItem().getItemMeta().getDisplayName();

        if(itemName.equals(gui.getString("Deposit.Deposit.Item-Name"))) {
            Player player = (Player) event.getWhoClicked();
           player.closeInventory();
            player.sendMessage(TextColor.colorized("Ingrese el valor"));
            return;

        }

        if(itemName.equals(gui.getString("Deposit.Leave.Item-Name"))) {

            event.getWhoClicked().closeInventory();
        }
    }
    @EventHandler
    public void receiveQuantity(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        Economy economy = PluginCore.getEconomy();
        if(inList.contains(player)){
            String count = event.getMessage();
            double doublecount = Double.parseDouble(count);
            double money = economy.getBalance(player);
            if(money <= doublecount){
                economy.withdrawPlayer(player,doublecount);
                inList.remove(player);
                player.sendMessage(TextColor.colorized("&aThat's great! you just deposited "+doublecount+"$ from your bank account"));
            }
        }
    }
}
