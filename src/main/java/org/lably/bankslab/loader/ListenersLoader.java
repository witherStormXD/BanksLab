package org.lably.bankslab.loader;

import org.lably.bankslab.PluginCore;
import org.lably.bankslab.BanksLab;
import org.lably.bankslab.api.Loader;
import org.lably.bankslab.listener.DefaultEventListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;


public class ListenersLoader implements Loader {

    private final PluginCore pluginCore;

    public ListenersLoader(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        registerListeners(
                new DefaultEventListener(pluginCore));
    }

    public void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        BanksLab pluginModel = pluginCore.getPlugin();

        for (Listener listener : listeners){
            pluginManager.registerEvents(listener, pluginModel);
        }
    }
}