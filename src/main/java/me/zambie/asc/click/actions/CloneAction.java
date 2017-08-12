package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.Language;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class CloneAction implements ClickAction {

    @Override
    public int getSlot() {
        return 1;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        Player player = (Player) event.getWhoClicked();
        ArmorStand armorStand  = session.getSession().clone();

        player.closeInventory();
        session.getSession().remove();

        ArmorStandSession cloneSession = ArmorStandSession.registerSession(player, armorStand);
        cloneSession.setRepositioning(true);

        player.sendMessage(LanguageManager.getLanguage().getMessageMove());
    }
}
