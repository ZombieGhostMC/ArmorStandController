package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class ToggleVisibilityAction implements ClickAction {

    @Override
    public int getSlot() {
        return 6;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStand armorStand = session.getSession().getArmorStand();
        armorStand.setVisible(!armorStand.isVisible());
    }
}
