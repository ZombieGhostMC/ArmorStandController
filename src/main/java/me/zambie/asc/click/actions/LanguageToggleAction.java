package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.LanguageManager;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class LanguageToggleAction implements ClickAction {
    @Override
    public int getSlot() {
        return 41;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        if (event.getWhoClicked().hasPermission("armorstandcontroller.admin")) {
            LanguageManager.toggle();
            session.updateWindow(event.getClickedInventory());
        }
    }
}
