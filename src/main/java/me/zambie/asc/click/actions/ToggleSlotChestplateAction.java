package me.zambie.asc.click.actions;

import me.zambie.asc.color.ColorSession;

public final class ToggleSlotChestplateAction extends ToggleArmorSlotAction {

    public ToggleSlotChestplateAction() {
        super(9, ColorSession.Slot.CHESTPLATE, "setChestplate");
    }
}
