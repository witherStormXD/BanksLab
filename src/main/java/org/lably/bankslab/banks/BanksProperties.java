package org.lably.bankslab.banks;

import org.lably.bankslab.PluginCore;
import org.lably.bankslab.loader.FilesLoader;
import org.lably.bankslab.manager.FileManager;

public class BanksProperties {
    private final PluginCore core;

    public BanksProperties(PluginCore core){
        this.core = core;
    }

    public void createBank(String bankName){
        FileManager gui = core.getFilesLoader().getGui();
        gui.set("BanksFile.Banks.",bankName);
        gui.set("BanksFile.Banks."+bankName+".deposito-por-comision: ",2);
        gui.set("BanksFile.Banks."+bankName+".deposito-por-retiro: ",2);
        gui.save();
        gui.reload();
    }
    public boolean bankExist(String bankName){
        FileManager gui = core.getFilesLoader().getGui();
    if(gui.contains("BanksFile.Banks."+bankName)){
        return gui.contains("BanksFile.Banks."+bankName);
    }
        return !gui.contains("BanksFile.Banks."+bankName);
    }

}
