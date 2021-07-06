package org.lably.bankslab.loader;

import org.lably.bankslab.BanksLab;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.manager.FileManager;

public class FilesLoader implements Loader {

    private final BanksLab plugin;
    private FileManager configFile;

    public FilesLoader(BanksLab plugin){
        this.plugin = plugin;
    }
    @Override
    public void load() {
        // config.yml file
        configFile = new FileManager(plugin, "config.yml");

    }


    public FileManager getConfigFile() {
        return configFile;
    }
}
