package vondri.plugin.ustawieniaspigot;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class UstawieniaGUIHandler  implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player p = (Player)e.getPlayer();
        if(p.hasMetadata("OpenedMenuNoPixelUstawienia")){
            p.removeMetadata("OpenedMenuNoPixelUstawienia", UstawieniaSpigot.getInstance());
        }
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(p.hasMetadata("OpenedMenuNoPixelUstawienia")) {
            e.setCancelled(true);



            String playerName = p.getName();

            switch(e.getSlot()){
                case 2: //Scoreboard
                    p.performCommand("featherboard toggle");
                    break;
                case 3: //PrivMSG
                    p.performCommand("toggle pm");
                    break;

                case 5: //TP toggle

                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "cmi options %player% acceptingtpa toggle".replace("%player", playerName));
                    break;
                case 6: //Pay toggle
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "cmi options %player% acceptingmoney toggle".replace("%player", playerName));
                    break;

                case 13: //Wyjdz
                    e.setCancelled(true);
                    p.closeInventory();
                    Bukkit.getScheduler().runTaskLater(UstawieniaSpigot.getInstance(), () -> p.updateInventory(), 5);
                    break;
            }

        }
    }
}
