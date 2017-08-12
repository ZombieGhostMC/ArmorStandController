package me.zambie.asc.controller;

import me.zambie.asc.color.ColorManager;
import me.zambie.asc.stand.ArmorStandSession;
import me.zambie.asc.click.ClickAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;


public interface ControllerSession {

    ArmorStandSession getSession();

    ColorManager getColorManager();

    Inventory getInventory();

    JavaPlugin getPlugin();

    ClickAction getAction(int slot);

    boolean hasAction(int slot);

    void onClick(InventoryClickEvent event, ControllerManager manager);

    void onOpen(InventoryOpenEvent event, ControllerManager manager);

    void onClose(InventoryCloseEvent event, ControllerManager manager);

    void updateWindow(Inventory inventory);
}
