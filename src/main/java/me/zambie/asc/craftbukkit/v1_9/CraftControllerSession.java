package me.zambie.asc.craftbukkit.v1_9;

import me.zambie.asc.Main;
import me.zambie.asc.click.ClickAction;
import me.zambie.asc.click.actions.*;
import me.zambie.asc.color.ColorManager;
import me.zambie.asc.controller.ControllerManager;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import me.zambie.asc.utils.Items;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CraftControllerSession implements ControllerSession {

    private final ArmorStandSession session;
    private final ColorManager colorManager;
    private final Main plugin;
    private final List<ClickAction> actionList;
    private Inventory inventory;

    public CraftControllerSession(ArmorStandSession session, ColorManager colorManager, Inventory inventory, Main plugin) {
        this.session = session;
        this.colorManager = colorManager;
        this.inventory = inventory;
        this.plugin = plugin;

        List<ClickAction> actionList = new LinkedList<>();

        actionList.add(new ToggleArmsAction());
        actionList.add(new ToggleBasePlateAction());
        actionList.add(new ToggleGravityAction());
        actionList.add(new ToggleSizeAction());
        actionList.add(new ToggleVisibilityAction());

        actionList.add(new ChangeNameAction());
        actionList.add(new MoveAction());
        actionList.add(new CloneAction());
        actionList.add(new ScrapAction());

        actionList.add(new ToggleSlotHelmetAction());
        actionList.add(new ToggleSlotChestplateAction());
        actionList.add(new ToggleSlotLeggingsAction());
        actionList.add(new ToggleSlotBootsAction());
        actionList.add(new ToggleSlotArmAction());

        actionList.add(new UpdateLocationAction(11, 0.1, 0.0, 0.0));
        actionList.add(new UpdateLocationAction(20, 0.0, 0.1, 0.0));
        actionList.add(new UpdateLocationAction(29, 0.0, 0.0, 0.1));

        actionList.add(new UpdateHeadAngleAction(12, 0.1, 0.0, 0.0));
        actionList.add(new UpdateHeadAngleAction(21, 0.0, 0.1, 0.0));
        actionList.add(new UpdateHeadAngleAction(30, 0.0, 0.0, 0.1));

        actionList.add(new UpdateBodyAngleAction(13, 0.1, 0.0, 0.0));
        actionList.add(new UpdateBodyAngleAction(22, 0.0, 0.1, 0.0));
        actionList.add(new UpdateBodyAngleAction(31, 0.0, 0.0, 0.1));

        actionList.add(new UpdateRightArmAngleAction(14, 0.1, 0.0, 0.0));
        actionList.add(new UpdateRightArmAngleAction(23, 0.0, 0.1, 0.0));
        actionList.add(new UpdateRightArmAngleAction(32, 0.0, 0.0, 0.1));

        actionList.add(new UpdateRightLegAngleAction(15, 0.1, 0.0, 0.0));
        actionList.add(new UpdateRightLegAngleAction(24, 0.0, 0.1, 0.0));
        actionList.add(new UpdateRightLegAngleAction(33, 0.0, 0.0, 0.1));

        actionList.add(new UpdateLeftArmAngleAction(16, 0.1, 0.0, 0.0));
        actionList.add(new UpdateLeftArmAngleAction(25, 0.0, 0.1, 0.0));
        actionList.add(new UpdateLeftArmAngleAction(34, 0.0, 0.0, 0.1));

        actionList.add(new UpdateLeftLegAngleAction(17, 0.1, 0.0, 0.0));
        actionList.add(new UpdateLeftLegAngleAction(26, 0.0, 0.1, 0.0));
        actionList.add(new UpdateLeftLegAngleAction(35, 0.0, 0.0, 0.1));

        actionList.add(new LanguageToggleAction());
        this.actionList = actionList;
    }

    @Override
    public ArmorStandSession getSession() {
        return session;
    }

    @Override
    public ColorManager getColorManager() {
        return colorManager;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public Main getPlugin() {
        return plugin;
    }

    @Override
    public ClickAction getAction(int slot) {
        for (ClickAction action : actionList){
            if (action.getSlot() == slot){
                return action;
            }
        }
        return null;
    }

    @Override
    public boolean hasAction(int slot) {
        return getAction(slot) != null;
    }

    @Override
    public void onClick(InventoryClickEvent event, ControllerManager manager) {
        Player player = (Player) event.getWhoClicked();

        if (hasAction(event.getSlot())){
            getAction(event.getSlot()).execute(event, this);

            updateWindow(event.getClickedInventory());

            player.playSound(player.getLocation(), Sound.valueOf("UI_BUTTON_CLICK"), 1, 1);
        }

        event.setResult(Event.Result.DENY);

        player.updateInventory();
    }

    @Override
    public void onOpen(InventoryOpenEvent event, ControllerManager manager) {
        Player player = (Player) event.getPlayer();
        player.playSound(player.getLocation(), Sound.valueOf("BLOCK_CHEST_OPEN"), 1, 1);
    }

    @Override
    public void onClose(InventoryCloseEvent event, ControllerManager manager) {
        Player player = (Player) event.getPlayer();

        player.playSound(player.getLocation(), Sound.valueOf("BLOCK_CHEST_CLOSE"), 1, 1);

        manager.removeSession(this);
    }

    @Override
    public void updateWindow(Inventory inventory) {
        ArmorStand armorStand = session.getArmorStand();

        inventory.setItem(1, Items.getCloneTool());
        inventory.setItem(2, Items.getToggleItem(LanguageManager.getLanguage().getArmsToggleDisplay(), armorStand.hasArms()));
        inventory.setItem(3, Items.getToggleItem(LanguageManager.getLanguage().getBasePlateToggleDisplay(), armorStand.hasBasePlate()));
        inventory.setItem(4, Items.getToggleItem(LanguageManager.getLanguage().getGravityToggleDisplay(), armorStand.hasGravity()));
        inventory.setItem(5, Items.getToggleItem(LanguageManager.getLanguage().getSmallToggleDisplay(), armorStand.isSmall()));
        inventory.setItem(6, Items.getToggleItem(LanguageManager.getLanguage().getVisibleToggleDisplay(), armorStand.isVisible()));

        inventory.setItem(10, Items.getMoveTool());

        inventory.setItem(11, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getLocation()), armorStand.getLocation().getX(), Material.WOOL, 14));
        inventory.setItem(12, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getHeadPose()), armorStand.getHeadPose().getX(), Material.WOOL, 14));
        inventory.setItem(13, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getBodyPose()), armorStand.getBodyPose().getX(), Material.WOOL, 14));
        inventory.setItem(14, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getRightArmPose()), armorStand.getRightArmPose().getX(), Material.WOOL, 14));
        inventory.setItem(15, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getRightLegPose()), armorStand.getRightLegPose().getX(), Material.WOOL, 14));
        inventory.setItem(16, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getLeftArmPose()), armorStand.getLeftArmPose().getX(), Material.WOOL, 14));
        inventory.setItem(17, Items.getDoubleItem(String.format("%s X", LanguageManager.getLanguage().getLeftLegPose()), armorStand.getLeftLegPose().getX(), Material.WOOL, 14));

        inventory.setItem(19, Items.getNameChangeTool(armorStand));

        inventory.setItem(20, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getLocation()), armorStand.getLocation().getY(), Material.WOOL, 5));
        inventory.setItem(21, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getHeadPose()), armorStand.getHeadPose().getY(), Material.WOOL, 5));
        inventory.setItem(22, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getBodyPose()), armorStand.getBodyPose().getY(), Material.WOOL, 5));
        inventory.setItem(23, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getRightArmPose()), armorStand.getRightArmPose().getY(), Material.WOOL, 5));
        inventory.setItem(24, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getRightLegPose()), armorStand.getRightLegPose().getY(), Material.WOOL, 5));
        inventory.setItem(25, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getLeftArmPose()), armorStand.getLeftArmPose().getY(), Material.WOOL, 5));
        inventory.setItem(26, Items.getDoubleItem(String.format("%s Y", LanguageManager.getLanguage().getLeftLegPose()), armorStand.getLeftLegPose().getY(), Material.WOOL, 5));

        inventory.setItem(28, Items.getScrapTool());

        inventory.setItem(29, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getLocation()), armorStand.getLocation().getZ(), Material.WOOL, 3));
        inventory.setItem(30, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getHeadPose()), armorStand.getHeadPose().getZ(), Material.WOOL, 3));
        inventory.setItem(31, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getBodyPose()), armorStand.getBodyPose().getZ(), Material.WOOL, 3));
        inventory.setItem(32, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getRightArmPose()), armorStand.getRightArmPose().getZ(), Material.WOOL, 3));
        inventory.setItem(33, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getRightLegPose()), armorStand.getRightLegPose().getZ(), Material.WOOL, 3));
        inventory.setItem(34, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getLeftArmPose()), armorStand.getLeftArmPose().getZ(), Material.WOOL, 3));
        inventory.setItem(35, Items.getDoubleItem(String.format("%s Z", LanguageManager.getLanguage().getLeftLegPose()), armorStand.getLeftLegPose().getZ(), Material.WOOL, 3));

        inventory.setItem(0, Items.getEquipmentItem(LanguageManager.getLanguage().getHelmet(), Material.LEATHER_HELMET, armorStand.getHelmet() != null ? armorStand.getHelmet().getType() : Material.AIR, true));
        inventory.setItem(9, Items.getEquipmentItem(LanguageManager.getLanguage().getChestplate(), Material.LEATHER_CHESTPLATE, armorStand.getChestplate() != null ? armorStand.getBoots().getType() : Material.AIR, true));
        inventory.setItem(18, Items.getEquipmentItem(LanguageManager.getLanguage().getLeggings(), Material.LEATHER_LEGGINGS, armorStand.getLeggings() != null ? armorStand.getLeggings().getType() : Material.AIR, true));
        inventory.setItem(27, Items.getEquipmentItem(LanguageManager.getLanguage().getBoots(), Material.LEATHER_BOOTS, armorStand.getBoots() != null ? armorStand.getBoots().getType() : Material.AIR, true));
        inventory.setItem(36, Items.getEquipmentItem(LanguageManager.getLanguage().getRightArm(), Material.WOOD_SWORD, armorStand.getItemInHand() != null ? armorStand.getItemInHand().getType() : Material.AIR, false));

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
        }

        {
            ItemStack itemStack = new ItemStack(Material.ARMOR_STAND, 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            PluginDescriptionFile file = getPlugin().getDescription();
            itemMeta.setDisplayName(String.format("§e§l%s §8-§7 %s", LanguageManager.getLanguage().getTitle(), getPlugin().getDescription().getVersion()));
            List<String> lore = new LinkedList<>();
            lore.add(String.format("§7%s: %s", LanguageManager.getLanguage().getAuthor(), file.getAuthors().get(0)));

            lore.add(" ");

            if (getPlugin().isPlotSquaredSupport()){
                lore.add("§aPlotSquared Found");
            }

            itemStack.setItemMeta(itemMeta);
            inventory.setItem(40, itemStack);
        }

        inventory.setItem(41, Items.getLanguageItem());
    }
}
