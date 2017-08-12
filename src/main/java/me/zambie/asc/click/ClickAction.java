package me.zambie.asc.click;

import me.zambie.asc.controller.ControllerSession;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface ClickAction {
    int getSlot();
    void execute(InventoryClickEvent event, ControllerSession session);
}
