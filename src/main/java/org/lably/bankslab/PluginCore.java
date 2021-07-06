package org.lably.bankslab;

import org.lably.bankslab.api.Core;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.loader.CommandsLoader;
import org.lably.bankslab.loader.FilesLoader;
import org.lably.bankslab.loader.ListenersLoader;
import org.lably.bankslab.loader.ManagerLoader;

public class PluginCore implements Core{

    private final BanksLab plugin;

    private FilesLoader filesLoader;
    private ManagerLoader managerLoader;

    public PluginCore(BanksLab plugin){
        this.plugin = plugin;
    }

    @Override
    public void init() {
        filesLoader = new FilesLoader(plugin);
        filesLoader.load();

        managerLoader = new ManagerLoader(this);
        managerLoader.load();

        initLoaders(
                new CommandsLoader(this),
                new ListenersLoader(this));
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
}
