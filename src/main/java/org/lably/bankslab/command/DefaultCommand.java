package org.lably.bankslab.command;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.lably.bankslab.PluginCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.lably.bankslab.banks.BanksProperties;
import org.lably.bankslab.manager.FileManager;
import org.lably.bankslab.utils.TextColor;

public class DefaultCommand  implements CommandExecutor{

    private final PluginCore core;

    public DefaultCommand(PluginCore core){
        this.core = core;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       FileManager messages = core.getFilesLoader().getMessages();
        Economy economy = PluginCore.getEconomy();
        if(!(sender instanceof Player)){
          sender.sendMessage("Este comando solo puede ser ejecutado por un jugador");
           return false;


       }

       Player player = (Player) sender;
        BanksProperties banksProperties = new BanksProperties(core);
       if(!player.hasPermission("bankslab.usage")){
           player.sendMessage(TextColor.colorized(messages.getString("no-perms")));
           return false;
       }

       if (!(args.length > 0)) {

           core.getMainGui().generalGui(player);
           return true;
       }

         
    return false;

    }
}

