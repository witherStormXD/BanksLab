package org.lably.bankslab;

import org.bukkit.plugin.java.JavaPlugin;

public final class BanksLab extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCore pluginCore = new PluginCore(this);
        pluginCore.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
