package me.zambie.asc.color;

import me.zambie.asc.language.Language;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ColorManager implements Listener {

    private final List<ColorSession> colorSessionList = new LinkedList<>();

    public void createSession(ArmorStandSession session, Language language, ColorSession.Slot slot){
        Inventory inventory = Bukkit.createInventory(null, 45, language.getTitle());
        Player player = session.getPlayer();

        //CONTROLS
        {
            ItemStack itemStack = new ItemStack(Material.ARROW, 1);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§c§l%s", language.getDecrease()));
            itemStack.setItemMeta(meta);
            inventory.setItem(0, itemStack);
            inventory.setItem(9, itemStack);
            inventory.setItem(18, itemStack);
        }
        {
            ItemStack itemStack = new ItemStack(Material.ARROW, 1);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§e§l%s", language.getIncrease()));
            itemStack.setItemMeta(meta);
            inventory.setItem(8, itemStack);
            inventory.setItem(17, itemStack);
            inventory.setItem(26, itemStack);
        }

        //COLOR PRESETS
        {
            //BLACK
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 0);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §8§l%s", language.getDyePreset(), language.getBlack()));
            itemStack.setItemMeta(meta);
            inventory.setItem(27, itemStack);
        }
        {
            //GRAY
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §7§l%s", language.getDyePreset(), language.getGray()));
            itemStack.setItemMeta(meta);
            inventory.setItem(28, itemStack);
        }
        {
            //WHITE
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 15);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §f§l%s", language.getDyePreset(), language.getWhite()));
            itemStack.setItemMeta(meta);
            inventory.setItem(29, itemStack);
        }
        {
            //YELLOW
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 11);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §e§l%s", language.getDyePreset(), language.getYellow()));
            itemStack.setItemMeta(meta);
            inventory.setItem(30, itemStack);
        }
        {
            //ORANGE
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §6§l%s", language.getDyePreset(), language.getOrange()));
            itemStack.setItemMeta(meta);
            inventory.setItem(31, itemStack);
        }
        {
            //RED
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 1);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §c§l%s", language.getDyePreset(), language.getRed()));
            itemStack.setItemMeta(meta);
            inventory.setItem(32, itemStack);
        }
        {
            //PURPLE
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 5);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §d§l%s", language.getDyePreset(), language.getPurple()));
            itemStack.setItemMeta(meta);
            inventory.setItem(33, itemStack);
        }
        {
            //BLUE
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 4);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §9§l%s", language.getDyePreset(), language.getBlue()));
            itemStack.setItemMeta(meta);
            inventory.setItem(34, itemStack);
        }
        {
            //GREEN
            ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 2);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format("§7%s§8: §a§l%s", language.getDyePreset(), language.getGreen()));
            itemStack.setItemMeta(meta);
            inventory.setItem(35, itemStack);
        }

        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null){
                ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§r");
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(i, itemStack);
            }
        }

        {
            ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§r");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(39, itemStack);
            inventory.setItem(41, itemStack);
        }

        player.openInventory(inventory);
        colorSessionList.add(new ColorSession(session, inventory, slot));
    }

    private ColorSession getSession(Player player){
        for (ColorSession session : colorSessionList){
            if (session.getArmorStandSession().getPlayer().getUniqueId().equals(player.getUniqueId())){
                return session;
            }
        }
        return null;
    }

    private boolean hasSession(Player player){
        return getSession(player) != null;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if (!hasSession(player)){
            return;
        }


        ColorSession session = getSession(player);
        if (session != null) {
            event.setResult(Event.Result.DENY);

            switch (event.getSlot()) {
                case 0: {
                    if (session.getB() != 0) {
                        session.setB(session.getB() - 36);
                    }
                    break;
                }
                case 8: {
                    if (session.getB() != 252) {
                        session.setB(session.getB() + 36);
                    }
                    break;
                }
                case 9: {
                    if (session.getG() != 0) {
                        session.setG(session.getG() - 36);
                    }
                    break;
                }
                case 17: {
                    if (session.getG() != 252) {
                        session.setG(session.getG() + 36);
                    }
                    break;
                }
                case 18: {
                    if (session.getR() != 0) {
                        session.setR(session.getR() - 36);
                    }
                    break;
                }
                case 26: {
                    if (session.getR() != 252) {
                        session.setR(session.getR() + 36);
                    }
                    break;
                }
                case 27: {
                    session.setB(36);
                    session.setG(36);
                    session.setR(36);
                    break;
                }
                case 28: {
                    session.setB(144);
                    session.setG(144);
                    session.setR(144);
                    break;
                }
                case 29: {
                    session.setB(252);
                    session.setG(252);
                    session.setR(252);
                    break;
                }
                case 30: {
                    session.setB(0);
                    session.setG(252);
                    session.setR(252);
                    break;
                }
                case 31: {
                    session.setB(0);
                    session.setG(144);
                    session.setR(252);
                    break;
                }
                case 32: {
                    session.setB(0);
                    session.setG(0);
                    session.setR(252);
                    break;
                }
                case 33: {
                    session.setB(252);
                    session.setG(0);
                    session.setR(252);
                    break;
                }
                case 34: {
                    session.setB(252);
                    session.setG(0);
                    session.setR(0);
                    break;
                }
                case 35: {
                    session.setB(0);
                    session.setG(252);
                    session.setR(0);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        ColorSession colorSession = getSession(player);

        if (colorSession == null)return;

        colorSession.getArmorStandSession().remove();
        colorSessionList.remove(colorSession);
    }
}
