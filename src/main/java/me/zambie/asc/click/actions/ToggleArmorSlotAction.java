package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.color.ColorManager;
import me.zambie.asc.color.ColorSession;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.Language;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ToggleArmorSlotAction implements ClickAction {

    private final int slot;
    private final ColorSession.Slot slotType;
    private final String setMethod;

    public ToggleArmorSlotAction(int slot, ColorSession.Slot slotType, String setMethod) {
        this.slot = slot;
        this.slotType = slotType;
        this.setMethod = setMethod;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    private ColorSession.Slot getSlotType() {
        return slotType;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStandSession armorStandSession = session.getSession();
        ColorManager colorManager = session.getColorManager();

        ArmorStand armorStand = armorStandSession.getArmorStand();
        Language language = LanguageManager.getLanguage();
        Player player = (Player) event.getWhoClicked();

        try {
            Method method = armorStand.getClass().getMethod(setMethod, ItemStack.class);

            switch (event.getClick()) {
                case RIGHT:
                    method.invoke(armorStand, player.getItemInHand());
                    break;
                case LEFT:
                    colorManager.createSession(armorStandSession, language, getSlotType());
                    break;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
