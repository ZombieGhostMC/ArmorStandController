package me.zambie.asc.click.actions;

import me.zambie.asc.color.ColorSession;

public final class ToggleSlotHelmetAction extends ToggleArmorSlotAction {

    public ToggleSlotHelmetAction() {
        super(0, ColorSession.Slot.HELMET, "setHelmet");
    }
}
