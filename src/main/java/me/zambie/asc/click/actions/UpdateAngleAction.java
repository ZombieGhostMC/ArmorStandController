package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.util.EulerAngle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class UpdateAngleAction implements ClickAction {

    private final int slot;
    private final double x, y, z;
    private final String getMethod, setMethod;

    public UpdateAngleAction(int slot, double x, double y, double z, String getMethod, String setMethod) {
        this.slot = slot;
        this.x = x;
        this.y = y;
        this.z = z;
        this.getMethod = getMethod;
        this.setMethod = setMethod;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getGetMethod() {
        return getMethod;
    }

    public String getSetMethod() {
        return setMethod;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStandSession armorStandSession = session.getSession();

        ArmorStand armorStand = armorStandSession.getArmorStand();

        try {
            Method get = armorStand.getClass().getMethod(getMethod);
            Method set = armorStand.getClass().getMethod(setMethod, EulerAngle.class);

            EulerAngle eulerAngle = (EulerAngle) get.invoke(armorStand);

            if (event.getClick().equals(ClickType.RIGHT)) {
                set.invoke(armorStand, eulerAngle.add(x, y, z));
            } else if (event.getClick().equals(ClickType.LEFT)) {
                set.invoke(armorStand, eulerAngle.subtract(x, y, z));
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
