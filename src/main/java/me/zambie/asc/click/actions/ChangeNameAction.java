package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.name.NameChangeSession;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class ChangeNameAction implements ClickAction {

    @Override
    public int getSlot() {
        return 19;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        Player player = (Player) event.getWhoClicked();
        NameChangeSession.registerSession(session.getSession());

        player.closeInventory();

        player.sendMessage(String.format("§e%s", LanguageManager.getLanguage().getMessageArmorStandChangeName()));
        player.sendMessage(LanguageManager.getLanguage().getMessageRemoveNameChangeAction());
    }
}
