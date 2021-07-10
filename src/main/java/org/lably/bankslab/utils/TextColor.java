package org.lably.bankslab.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class TextColor {

    public static String colorized(String path){
        return ChatColor.translateAlternateColorCodes('&', path);
    }

    public static List<String> listColorized(List<String> path){
        List<String> list = new ArrayList<>(path);
        list.replaceAll(line -> ChatColor.translateAlternateColorCodes('&', line));
        return list;
    }


}
