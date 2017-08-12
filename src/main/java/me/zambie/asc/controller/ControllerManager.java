package me.zambie.asc.controller;

import me.zambie.asc.Main;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;
import java.util.List;

public class ControllerManager implements Listener {

    private final List<ControllerSession> sessionList = new LinkedList<>();
    private final Main plugin;

    public ControllerManager(Main plugin) {
        this.plugin = plugin;
    }

    public void register(Player player, ArmorStand armorStand){
        Inventory inventory = Bukkit.createInventory(null, 45, LanguageManager.getLanguage().getTitle());
        player.openInventory(inventory);

        ControllerSession session;
        ArmorStandSession armorStandSession = ArmorStandSession.registerSession(player, armorStand);

        if (Bukkit.getServer().getVersion().contains("1.8")){
            session = new me.zambie.asc.craftbukkit.v1_8.CraftControllerSession(armorStandSession, getPlugin().getColorManager(), inventory, plugin);
        }else {
            session = new me.zambie.asc.craftbukkit.v1_9.CraftControllerSession(armorStandSession, getPlugin().getColorManager(), inventory, plugin);
        }

        session.updateWindow(inventory);
        sessionList.add(session);
    }

    public ControllerSession getSession(Inventory inventory){
        for (ControllerSession session : sessionList){
            if (session.getInventory().equals(inventory)){
                return session;
            }
        }
        return null;
    }

    public void removeSession(ControllerSession session){
        sessionList.remove(session);
    }

    private boolean isSession(Inventory inventory){
        return getSession(inventory) != null;
    }

    private Main getPlugin() {
        return plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event){
        Inventory inventory = event.getClickedInventory();
        if (isSession(inventory)){
            getSession(inventory).onClick(event, this);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onOpen(InventoryOpenEvent event){
        Inventory inventory = event.getInventory();
        if (isSession(inventory)){
            getSession(inventory).onOpen(event, this);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClose(InventoryCloseEvent event){
        Inventory inventory = event.getInventory();
        if (isSession(inventory)){
            getSession(inventory).onClose(event, this);
        }
    }
}
