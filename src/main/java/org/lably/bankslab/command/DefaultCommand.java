package org.lably.bankslab.command;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.lably.bankslab.BanksLab;
import org.lably.bankslab.PluginCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.lably.bankslab.manager.FileManager;

public class DefaultCommand implements CommandExecutor{

    private PluginCore pluginCore;

    public DefaultCommand(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       FileManager messages = new FileManager(pluginCore.getPlugin(), "messages");
        if(!(sender instanceof Player)){
          sender.sendMessage("Este comando solo puede ser ejecutado por un jugador");
           return false;
       }
       Player player = (Player) sender;
       if(!player.hasPermission("BanksLab.usage")){
        messages.getString("no-perms");
           return false;
       }


        return false;
    }
}

