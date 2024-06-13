package vondri.plugin.ustawienia;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;



public class UstawieniaGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {commandSender.sendMessage("Musisz być graczem aby użyć tej komendy!"); return true;}

        Player p = (Player)commandSender;

        Inventory inv = Bukkit.getServer().createInventory(p, 9, "Ustawienia NoPixel");

        // SCOREBOARD

        String placeholder_featherboard = "";
        placeholder_featherboard = PlaceholderAPI.setBracketPlaceholders(p, placeholder_featherboard);

        String placeholder_featherboard_endis;
        if (placeholder_featherboard.equalsIgnoreCase("true")){
            placeholder_featherboard_endis = "Włączone";
        } else {
            placeholder_featherboard_endis = "Wyłączone";
        }

        ItemStack scoreboard = new ItemStack(Material.END_PORTAL_FRAME, 1);
        ItemMeta scoreboardMeta = scoreboard.getItemMeta();
        scoreboardMeta.setDisplayName("✿ Scoreboard");
        scoreboardMeta.setLore(Arrays.asList("• Status ".concat(placeholder_featherboard_endis), "➜ Kliknij aby zmienić"));
        scoreboard.setItemMeta(scoreboardMeta);
        // MSG TOGGLE

        String placeholder_togglemsg = "%cmi_user_togglename_msg%";
        placeholder_togglemsg = PlaceholderAPI.setPlaceholders(p, placeholder_togglemsg);

        String placeholder_togglemsg_endis;
        if(placeholder_togglemsg.equalsIgnoreCase("true")){
            placeholder_togglemsg_endis = "Włączone";
        } else {
            placeholder_togglemsg_endis = "Wyłączone";
        }

        ItemStack privMessages = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta togglemsgMeta = privMessages.getItemMeta();

        togglemsgMeta.setDisplayName("✿ Wiadomości prywatne");
        togglemsgMeta.setLore(Arrays.asList("• Status ".concat(placeholder_togglemsg_endis), "➜ Kliknij aby zmienić"));
        privMessages.setItemMeta(togglemsgMeta);

        // TP TOGGLE

        ItemStack tp = new ItemStack(Material.COMPASS, 1);

        String placeholder_toggletp = "%cmi_user_togglename_tp%";
        placeholder_toggletp = PlaceholderAPI.setPlaceholders(p, placeholder_toggletp);

        String placeholder_toggletp_endis;

        if(placeholder_toggletp.equalsIgnoreCase("true")){
            placeholder_toggletp_endis = "Włączone";
        } else {
            placeholder_toggletp_endis = "Wyłączone";
        }

        ItemMeta toggletpMeta = tp.getItemMeta();
        toggletpMeta.setDisplayName("✿ Teleportacje do graczy");
        toggletpMeta.setLore(Arrays.asList("• Status ".concat(placeholder_toggletp_endis), "➜ Kliknij aby zmienić"));
        tp.setItemMeta(toggletpMeta);
        // Pay Toggle

        ItemStack payment = new ItemStack(Material.GOLD_NUGGET, 1);

        String placeholder_paytoggle = "%cmi_user_togglename_pay%";
        placeholder_paytoggle = PlaceholderAPI.setPlaceholders(p, placeholder_paytoggle);

        String placeholder_paytoggle_endis;
        if(placeholder_paytoggle.equalsIgnoreCase("true")){
            placeholder_paytoggle_endis = "Włączone";
        } else {
            placeholder_paytoggle_endis = "Wyłączone";
        }

        ItemMeta payMeta = payment.getItemMeta();
        payMeta.setDisplayName("✿ Przelewy od graczy");
        payMeta.setLore(Arrays.asList("• Status ".concat(placeholder_paytoggle_endis), "➜ Kliknij aby zmienić"));
        payment.setItemMeta(payMeta);

        // Exit

        ItemStack exit = new ItemStack(Material.BARRIER, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("Wyjdź");
        exitMeta.setLore(Arrays.asList("➜ Kliknij aby wyjść"));
        exit.setItemMeta(exitMeta);

        inv.setItem(2, scoreboard);
        inv.setItem(3, privMessages);
        inv.setItem(4, tp);
        inv.setItem(5, payment);
        inv.setItem(6, exit);

        p.openInventory(inv);

        return false;
    }
}
