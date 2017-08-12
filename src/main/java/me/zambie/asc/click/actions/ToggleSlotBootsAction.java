package me.zambie.asc.click.actions;

import me.zambie.asc.color.ColorSession;

public final class ToggleSlotBootsAction extends ToggleArmorSlotAction {

    public ToggleSlotBootsAction() {
        super(27, ColorSession.Slot.BOOTS, "setBoots");
    }
}
