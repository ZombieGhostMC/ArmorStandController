package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class ToggleSlotArmAction implements ClickAction {

    @Override
    public int getSlot() {
        return 36;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStand armorStand = session.getSession().getArmorStand();
        Player player = (Player) event.getWhoClicked();

        armorStand.setItemInHand(player.getItemInHand());
    }
}
