package vondri.plugin.ustawienia;

import  vondri.plugin.ustawienia.UstawieniaGUI;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ustawienia extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("ustawienia").setExecutor(new UstawieniaGUI());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
