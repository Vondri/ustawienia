package vondri.plugin.ustawieniaspigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class UstawieniaSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("ustawienia").setExecutor(new UstawieniaGUI());
        getServer().getPluginManager().registerEvents(new UstawieniaGUIHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UstawieniaSpigot getInstance(){
        return getPlugin(UstawieniaSpigot.class);
    }
}
