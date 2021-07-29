package org.lably.bankslab;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.lably.bankslab.api.Core;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.enums.Color;
import org.lably.bankslab.gui.MainGui;
import org.lably.bankslab.loader.CommandsLoader;
import org.lably.bankslab.loader.FilesLoader;
import org.lably.bankslab.loader.ListenersLoader;
import org.lably.bankslab.loader.ManagerLoader;

import java.util.logging.Logger;

public class PluginCore implements Core{

    private final BanksLab plugin;
    private static final Logger log = Logger.getLogger("Minecraft");
    private FilesLoader filesLoader;
    private ManagerLoader managerLoader;
    private MainGui mainGui;
    private static Economy econ = null;

    public PluginCore(BanksLab plugin){
        this.plugin = plugin;
    }

    @Override
    public void init() {
        if(!setupEconomy()){
        log.info(Color.RED+"Vault Not installed");
            log.info(Color.RED_DARK+"Disabling");
            getPlugin().getServer().getPluginManager().disablePlugin(getPlugin());
        }else{
            filesLoader = new FilesLoader(plugin);
            filesLoader.load();

            managerLoader = new ManagerLoader(this);
            managerLoader.load();

            mainGui = new MainGui(this);

            initLoaders(
                    new CommandsLoader(this),
                    new ListenersLoader(this));
        }

    }


    private void initLoaders(Loader... loaders){
        for (Loader loader : loaders){
            loader.load();
        }
    }

    public FilesLoader getFilesLoader() {
        return filesLoader;
    }

    public BanksLab getPlugin(){
        return plugin;
    }

    public ManagerLoader getManagers(){
        return managerLoader;
    }

    public MainGui getMainGui() {
        return mainGui;
    }
    private boolean setupEconomy() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    public static Economy getEconomy() {
        return econ;
    }
}
