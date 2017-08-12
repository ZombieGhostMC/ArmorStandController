package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.LanguageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class MoveAction implements ClickAction {

    @Override
    public int getSlot() {
        return 10;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        Player player = (Player) event.getWhoClicked();

        session.getSession().setRepositioning(true);

        player.closeInventory();
        player.sendMessage(LanguageManager.getLanguage().getMessageMove());
    }
}
