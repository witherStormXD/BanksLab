package org.lably.bankslab.loader;

import org.lably.bankslab.PluginCore;
import org.lably.bankslab.api.Loader;

public class ManagerLoader implements Loader {

    private PluginCore pluginCore;

    public ManagerLoader(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {

    }
}
