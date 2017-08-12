package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class UpdateLocationAction implements ClickAction {

    private final int slot;
    private final double x, y, z;

    public UpdateLocationAction(int slot, double x, double y, double z) {
        this.slot = slot;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    private double getX() {
        return x;
    }

    private double getY() {
        return y;
    }

    private double getZ() {
        return z;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStandSession armorStandSession = session.getSession();

        ArmorStand armorStand = armorStandSession.getArmorStand();
        Location location = armorStand.getLocation();

        if (event.getClick().equals(ClickType.RIGHT)) {
            armorStand.teleport(location.add(getX(), getY(), getZ()));
        } else if (event.getClick().equals(ClickType.LEFT)) {
            armorStand.teleport(location.subtract(getX(), getY(), getZ()));
        }
    }
}
