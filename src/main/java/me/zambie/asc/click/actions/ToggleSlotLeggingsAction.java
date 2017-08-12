package me.zambie.asc.click.actions;

import me.zambie.asc.color.ColorSession;

public final class ToggleSlotLeggingsAction extends ToggleArmorSlotAction {

    public ToggleSlotLeggingsAction() {
        super(18, ColorSession.Slot.LEGGINGS, "setLeggings");
    }
}
