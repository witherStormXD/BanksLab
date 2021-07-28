package org.lably.bankslab.loader;

import org.lably.bankslab.BanksLab;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.manager.FileManager;

public class FilesLoader implements Loader {

    private final BanksLab plugin;
    private FileManager config;
    private FileManager messages;
    private FileManager gui;

    public FilesLoader(BanksLab plugin){
        this.plugin = plugin;
    }

    @Override
    public void load() {
        // config.yml file
        config = new FileManager(plugin, "config.yml");
        // messages.yml file
        messages = new FileManager(plugin,"messages.yml");
        // gui.yml file
        gui = new FileManager(plugin, "gui.yml");

    }

    public FileManager getConfig() {
        return config;
    }

    public FileManager getMessages() {
        return messages;
    }

    public FileManager getGui() {
        return gui;
    }
}
