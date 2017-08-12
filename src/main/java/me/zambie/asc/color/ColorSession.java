package me.zambie.asc.color;

import me.zambie.asc.language.Language;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import org.apache.commons.codec.language.bm.Lang;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class ColorSession {

    private final ArmorStandSession armorStandSession;
    private final Inventory inventory;
    private final Slot slot;

    private int r;
    private int g;
    private int b;

    ColorSession(ArmorStandSession armorStandSession, Inventory inventory, Slot slot) {
        this.armorStandSession = armorStandSession;
        this.inventory = inventory;
        this.slot = slot;

        ArmorStand armorStand = armorStandSession.getArmorStand();
        ItemStack armor = null;
        switch (slot){
            case HELMET:
                if (armorStand.getHelmet() == null || !(armorStand.getHelmet().getType().equals(slot.getMaterial()))) {
                    armor = new ItemStack(slot.getMaterial());
                }else {
                    armor = armorStand.getHelmet();
                }
                break;
            case CHESTPLATE:
                if (armorStand.getChestplate() == null || !(armorStand.getChestplate().getType().equals(slot.getMaterial()))) {
                    armor = new ItemStack(slot.getMaterial());
                }else {
                    armor = armorStand.getChestplate();
                }
                break;
            case LEGGINGS:
                if (armorStand.getLeggings() == null || !(armorStand.getLeggings().getType().equals(slot.getMaterial()))) {
                    armor = new ItemStack(slot.getMaterial());
                }else {
                    armor = armorStand.getLeggings();
                }
                break;
            case BOOTS:
                if (armorStand.getBoots() == null || !(armorStand.getBoots().getType().equals(slot.getMaterial()))) {
                    armor = new ItemStack(slot.getMaterial());
                }else {
                    armor = armorStand.getBoots();
                }
                break;
        }

        if (armor != null) {
            LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
            Color color = meta.getColor();
            if (color.getRed()%36 == 0){
                setR(color.getRed());
            }else {
                setR(252);
            }
            if (color.getGreen()%36 == 0){
                setG(color.getGreen());
            }else {
                setG(252);
            }
            if (color.getBlue()%36 == 0){
                setB(color.getBlue());
            }else {
                setB(252);
            }
        }
    }

    public ArmorStandSession getArmorStandSession() {
        return armorStandSession;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Slot getSlot() {
        return slot;
    }

    int getR() {
        return r;
    }

    @SuppressWarnings("deprecation")
    void setR(int r) {
        //Update Color
        this.r = r;

        //Update Window
        String string = "§4R§8 -§c§l %s";
        {
            ItemStack itemStack = new ItemStack(Material.STAINED_GLASS, 1, (short) 14);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, r));
            itemStack.setItemMeta(meta);
            inventory.setItem(19, itemStack);
            inventory.setItem(20, itemStack);
            inventory.setItem(21, itemStack);
            inventory.setItem(22, itemStack);
            inventory.setItem(23, itemStack);
            inventory.setItem(24, itemStack);
            inventory.setItem(25, itemStack);
        }

        {
            ItemStack itemStack = new ItemStack(Material.getMaterial(159), 1, (short) 14);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, r));
            itemStack.setItemMeta(meta);
            for (int i = 0; i < r / 36; i++) {
                inventory.setItem(i + 19, itemStack);
            }
        }

        //Update ArmorStand
        update();
    }

    int getG() {
        return g;
    }

    @SuppressWarnings("deprecation")
    void setG(int g) {
        this.g = g;

        String string = "§2G§8 -§a§l %s";
        {
            ItemStack itemStack = new ItemStack(Material.STAINED_GLASS, 1, (short) 13);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, g));
            itemStack.setItemMeta(meta);
            inventory.setItem(10, itemStack);
            inventory.setItem(11, itemStack);
            inventory.setItem(12, itemStack);
            inventory.setItem(13, itemStack);
            inventory.setItem(14, itemStack);
            inventory.setItem(15, itemStack);
            inventory.setItem(16, itemStack);
        }
        {
            ItemStack itemStack = new ItemStack(Material.getMaterial(159), 1, (short) 13);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, g));
            itemStack.setItemMeta(meta);
            for (int i = 0; i < g / 36; i++) {
                inventory.setItem(i + 10, itemStack);
            }
        }

        //Update ArmorStand
        update();
    }

    int getB() {
        return b;
    }

    @SuppressWarnings("deprecation")
    void setB(int b) {
        this.b = b;

        String string = "§1B§8 -§9§l %s";
        {
            ItemStack itemStack = new ItemStack(Material.STAINED_GLASS, 1, (short) 9);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, b));
            itemStack.setItemMeta(meta);
            inventory.setItem(1, itemStack);
            inventory.setItem(2, itemStack);
            inventory.setItem(3, itemStack);
            inventory.setItem(4, itemStack);
            inventory.setItem(5, itemStack);
            inventory.setItem(6, itemStack);
            inventory.setItem(7, itemStack);
        }
        {
            ItemStack itemStack = new ItemStack(Material.getMaterial(159), 1, (short) 11);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(String.format(string, b));
            itemStack.setItemMeta(meta);
            for (int i = 0; i < b / 36; i++) {
                inventory.setItem(i + 1, itemStack);
            }
        }

        //Update ArmorStand
        update();
    }

    private void update() {
        ArmorStand armorStand = armorStandSession.getArmorStand();
        switch (slot){
            case HELMET: {
                ItemStack itemStack = armorStand.getHelmet();

                if (itemStack == null || !itemStack.getType().equals(Material.LEATHER_HELMET)) {
                    itemStack = new ItemStack(Material.LEATHER_HELMET);
                }

                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                Color color = Color.fromBGR(getB(), getG(), getR());

                meta.setColor(color);
                itemStack.setItemMeta(meta);
                armorStand.setHelmet(itemStack);
                break;
            }
            case CHESTPLATE: {
                ItemStack itemStack = armorStand.getChestplate();

                if (itemStack == null || !itemStack.getType().equals(Material.LEATHER_CHESTPLATE)) {
                    itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
                }

                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                Color color = Color.fromBGR(getB(), getG(), getR());

                meta.setColor(color);
                itemStack.setItemMeta(meta);
                armorStand.setChestplate(itemStack);
                break;
            }
            case LEGGINGS: {
                ItemStack itemStack = armorStand.getLeggings();

                if (itemStack == null || !itemStack.getType().equals(Material.LEATHER_LEGGINGS)) {
                    itemStack = new ItemStack(Material.LEATHER_LEGGINGS);
                }

                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                Color color = Color.fromBGR(getB(), getG(), getR());

                meta.setColor(color);
                itemStack.setItemMeta(meta);
                armorStand.setLeggings(itemStack);
                break;
            }
            case BOOTS: {
                ItemStack itemStack = armorStand.getBoots();

                if (itemStack == null || !itemStack.getType().equals(Material.LEATHER_BOOTS)) {
                    itemStack = new ItemStack(Material.LEATHER_BOOTS);
                }

                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                Color color = Color.fromBGR(getB(), getG(), getR());

                meta.setColor(color);
                itemStack.setItemMeta(meta);
                armorStand.setBoots(itemStack);
                break;
            }
        }


        {
            ItemStack itemStack = new ItemStack(slot.getMaterial(), 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§f§l" + slot.getName(LanguageManager.getLanguage()));
            itemMeta.setLore(
                    Arrays.asList(
                            String.format("  §c§lR§8 - §f§l%s", getR()),
                            String.format("  §a§lG§8 - §f§l%s", getG()),
                            String.format("  §9§lB§8 - §f§l%s", getB())));
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(40, itemStack);
        }
    }

    private void remove(){
        armorStandSession.remove();

    }

    public enum Slot {
        HELMET(Material.LEATHER_HELMET),
        CHESTPLATE(Material.LEATHER_CHESTPLATE),
        LEGGINGS(Material.LEATHER_LEGGINGS),
        BOOTS(Material.LEATHER_BOOTS);

        private Material material;

        Slot(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }

        public String getName(Language language){
            switch (this){
                case HELMET:
                    return language.getHelmet();
                case CHESTPLATE:
                    return language.getChestplate();
                case LEGGINGS:
                    return language.getLeggings();
                case BOOTS:
                    return language.getBoots();
            }
            return "";
        }
    }
}
