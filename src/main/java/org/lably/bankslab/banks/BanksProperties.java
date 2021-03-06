package org.lably.bankslab.banks;

import org.lably.bankslab.PluginCore;
import org.lably.bankslab.loader.FilesLoader;
import org.lably.bankslab.manager.FileManager;

public class BanksProperties {
    private final PluginCore core;

    public BanksProperties(PluginCore core) {
        this.core = core;
    }

    public void createBank(String bankName) {
        FileManager gui = core.getFilesLoader().getGui();
        gui.set("BanksFile.banks." + bankName + ".deposito-por-comision: ", 2);
        gui.set("BanksFile.banks." + bankName + ".deposito-por-retiro: ", 2);
        gui.save();
        gui.reload();
    }

    public boolean bankExist(String bankName) {
        FileManager gui = core.getFilesLoader().getGui();
        return gui.contains("BanksFile.Banks." + bankName);
    }
}



