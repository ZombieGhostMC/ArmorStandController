package me.zambie.asc.utils;

import me.zambie.asc.language.LanguageManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Items {

    private static final DecimalFormat format = new DecimalFormat("#,###.#");

    public static ItemStack getLanguageItem(){
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner("Seska_Rotan");
        meta.setDisplayName(String.format("§f§l%s", LanguageManager.getLanguage().getClickToChangeLanguage()));
        meta.setLore(Arrays.asList(
                String.format("§7%s§8:§e§l %s", LanguageManager.getLanguage().getLanguage(), LanguageManager.getLanguage().getDisplayName()),
                " ",
                "§4§lWarning§c this plugin was created",
                "§cin English and by a native English",
                "§cspeaker, any other language may",
                "§ccontain grammatical errors."));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getToggleItem(String title, boolean toggle){
        ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) (toggle ? 10 : 8));
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format(ChatColor.GRAY + "%s %s: %s", LanguageManager.getLanguage().getToggle(), title, toggle ?
                String.format("§a§l%s", LanguageManager.getLanguage().getEnable()) : String.format("§c§l%s", LanguageManager.getLanguage().getDisable())));
        meta.setLore(Collections.singletonList(String.format("§e§l%s", String.format(LanguageManager.getLanguage().getClick(), LanguageManager.getLanguage().getToggle()))));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getDoubleItem(String title, Double value, Material material, int color){
        ItemStack itemStack = new ItemStack(material, 1, (short) color);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format("§7%s -§f§l %s", title, format.format(value)));
        meta.setLore(Arrays.asList(
                String.format("§e§l%s", String.format(LanguageManager.getLanguage().getRightClick(), LanguageManager.getLanguage().getIncrease())),
                String.format("§6§l%s", String.format(LanguageManager.getLanguage().getLeftClick(), LanguageManager.getLanguage().getDecrease()))));
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public static ItemStack getEquipmentItem(String title, Material material, Material from, boolean hasColor){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + String.format("%s: %s", title, from.name()));
        List<String> stringList = new LinkedList<>();
        stringList.add(String.format("§e§l%s", LanguageManager.getLanguage().getRightClickToSwapEquipment()));
        if (hasColor){
            stringList.add(String.format("§6§l%s", LanguageManager.getLanguage().getLeftClickToColorEquipment()));
        }
        meta.setLore(stringList);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getCloneTool(){
        ItemStack itemStack = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format("§f§l%s", LanguageManager.getLanguage().getClickToCloneTool()));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getMoveTool(){
        ItemStack itemStack = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format("§f§l%s", LanguageManager.getLanguage().getClickToMoveTool()));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getScrapTool(){
        ItemStack itemStack = new ItemStack(Material.TNT);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format("§c§l%s", LanguageManager.getLanguage().getClickToScrapTool()));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getNameChangeTool(ArmorStand armorStand){
        ItemStack itemStack = new ItemStack(Material.NAME_TAG);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(String.format("§f§l%s", LanguageManager.getLanguage().getClickToChangeNameTool()));
        meta.setLore(Collections.singletonList(
                String.format("§7%s§8:§r %s", LanguageManager.getLanguage().getCurrentName(), armorStand.getName() == null
                        ? String.format("§7%s", LanguageManager.getLanguage().getUntitled()) : armorStand.getName())));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
