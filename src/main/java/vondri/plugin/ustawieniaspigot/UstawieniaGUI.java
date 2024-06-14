package vondri.plugin.ustawieniaspigot;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class UstawieniaGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {commandSender.sendMessage("Musisz być graczem aby użyć tej komendy!"); return false;}
        if(!(commandSender.hasPermission("nopixel.ustawienia"))) { commandSender.sendMessage("Ustawienia >> Nie masz do tego permisji."); return false;}

        Player p = (Player)commandSender;


        Inventory inv = Bukkit.getServer().createInventory(p, 18, "Ustawienia NoPixel");

        // SCOREBOARD

        String placeholder_featherboard = "";
        placeholder_featherboard = PlaceholderAPI.setBracketPlaceholders(p, placeholder_featherboard);

        String placeholder_featherboard_endis;
        if (placeholder_featherboard.equalsIgnoreCase("true")){
            placeholder_featherboard_endis = ChatColor.GREEN + "Włączone";
        } else {
            placeholder_featherboard_endis = ChatColor.RED + "Wyłączone";
        }

        ItemStack scoreboard = new ItemStack(Material.END_PORTAL_FRAME, 1);
        ItemMeta scoreboardMeta = scoreboard.getItemMeta();
        scoreboardMeta.setDisplayName("§e§l✿ §f§lScoreboard");
        scoreboardMeta.setLore(Arrays.asList("", "§8• §7Status §8".concat(placeholder_featherboard_endis) + "§r", "", "§8➜ §eKliknij aby zmienić"));
        scoreboard.setItemMeta(scoreboardMeta);
        // MSG TOGGLE

        String placeholder_togglemsg = "%cmi_user_togglename_msg%";
        placeholder_togglemsg = PlaceholderAPI.setPlaceholders(p, placeholder_togglemsg);

        String placeholder_togglemsg_endis;
        if(placeholder_togglemsg.equalsIgnoreCase("true")){
            placeholder_togglemsg_endis = ChatColor.GREEN + "Włączone";
        } else {
            placeholder_togglemsg_endis = ChatColor.RED + "Wyłączone";
        }

        ItemStack privMessages = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta togglemsgMeta = privMessages.getItemMeta();

        togglemsgMeta.setDisplayName("§e§l✿ §f§lWiadomości prywatne");
        togglemsgMeta.setLore(Arrays.asList("", "§8• §7Status §8".concat(placeholder_togglemsg_endis) + "§r", "", "§8➜ §eKliknij aby zmienić"));
        privMessages.setItemMeta(togglemsgMeta);

        // TP TOGGLE

        ItemStack tp = new ItemStack(Material.COMPASS, 1);

        String placeholder_toggletp = "%cmi_user_togglename_tp%";
        placeholder_toggletp = PlaceholderAPI.setPlaceholders(p, placeholder_toggletp);

        String placeholder_toggletp_endis;

        if(placeholder_toggletp.equalsIgnoreCase("true")){
            placeholder_toggletp_endis = ChatColor.GREEN + "Włączone";
        } else {
            placeholder_toggletp_endis = ChatColor.RED + "Wyłączone";
        }

        ItemMeta toggletpMeta = tp.getItemMeta();
        toggletpMeta.setDisplayName("§e§l✿ §f§lTeleportacje do graczy");
        toggletpMeta.setLore(Arrays.asList("", "§8• §7Status §8".concat(placeholder_toggletp_endis) + "§r", "", "§8➜ §eKliknij aby zmienić"));
        tp.setItemMeta(toggletpMeta);
        // Pay Toggle

        ItemStack payment = new ItemStack(Material.GOLD_NUGGET, 1);

        String placeholder_paytoggle = "%cmi_user_togglename_pay%";
        placeholder_paytoggle = PlaceholderAPI.setPlaceholders(p, placeholder_paytoggle);

        String placeholder_paytoggle_endis;
        if(placeholder_paytoggle.equalsIgnoreCase("true")){
            placeholder_paytoggle_endis = ChatColor.GREEN + "Włączone";
        } else {
            placeholder_paytoggle_endis = ChatColor.RED + "Wyłączone";;
        }

        ItemMeta payMeta = payment.getItemMeta();
        payMeta.setDisplayName("§e§l✿ §f§lPrzelewy od graczy");
        payMeta.setLore(Arrays.asList("", "§8• §7Status §8".concat(placeholder_paytoggle_endis) + "§r", "", "§8➜ §eKliknij aby zmienić"));
        payment.setItemMeta(payMeta);

        //

        // Exit

        ItemStack exit = new ItemStack(Material.BARRIER, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cWyjdź");
        exitMeta.setLore(Arrays.asList("", "§8➜ §7Kliknij aby wyjść"));
        exit.setItemMeta(exitMeta);

        // Tło

        ItemStack FiolSzyba = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemMeta FiolSzybaMeta = FiolSzyba.getItemMeta();
        FiolSzybaMeta.setDisplayName("");
        FiolSzyba.setItemMeta(FiolSzybaMeta);

        ItemStack MagSzyba = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1);
        ItemMeta MagSzybaMeta = MagSzyba.getItemMeta();
        MagSzybaMeta.setDisplayName("");
        MagSzyba.setItemMeta(MagSzybaMeta);

        ItemStack BialSzyba = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta BialSzybaMeta = BialSzyba.getItemMeta();
        BialSzybaMeta.setDisplayName("");
        BialSzyba.setItemMeta(BialSzybaMeta);


        // Ustawianie itemów

        inv.setItem(0, FiolSzyba);
        inv.setItem(1, BialSzyba);

        inv.setItem(2, scoreboard);
        inv.setItem(3, privMessages);

        inv.setItem(4, BialSzyba);

        inv.setItem(5, tp);
        inv.setItem(6, payment);

        inv.setItem(7, BialSzyba);
        inv.setItem(8, FiolSzyba);

        inv.setItem(9, FiolSzyba);
        inv.setItem(10, MagSzyba);
        inv.setItem(11, BialSzyba);
        inv.setItem(12, BialSzyba);

        inv.setItem(13, exit);

        inv.setItem(14, BialSzyba);
        inv.setItem(15, BialSzyba);

        inv.setItem(16, MagSzyba);
        inv.setItem(17, FiolSzyba);

        p.openInventory(inv);
        p.setMetadata("OpenedMenuNoPixelUstawienia", new FixedMetadataValue(UstawieniaSpigot.getInstance(), true));

        return true;
    }
}
