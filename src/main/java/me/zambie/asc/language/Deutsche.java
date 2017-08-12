package me.zambie.asc.language;

final class Deutsche implements Language {

    @Override
    public String getDisplayName() {
        return "Deutsche";
    }

    @Override
    public String getTitle() {
        return "Rüstungsständer Regler";
    }

    @Override
    public String getAuthor() {
        return "Autor";
    }

    @Override
    public String getClick() {
        return "Klicke um %s";
    }

    @Override
    public String getRightClick() {
        return "Rechtsklick Nach %s";
    }

    @Override
    public String getLeftClick() {
        return "Linksklick Nach %s";
    }

    @Override
    public String getToggle() {
        return "Umschalten";
    }

    @Override
    public String getIncrease() {
        return "Erhöhen";
    }

    @Override
    public String getDecrease() {
        return "Verringern";
    }

    @Override
    public String getEnable() {
        return "Aktivieren";
    }

    @Override
    public String getDisable() {
        return "Deaktivieren";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "Klicken Sie, um die Sprache zu ändern";
    }

    @Override
    public String getClickToCloneTool() {
        return "Klicken Sie, um den Rüstungsstand zu klonen";
    }

    @Override
    public String getClickToMoveTool() {
        return "Klicken, um den Rüstungsstand zu bewegen";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "Klicken Sie, um den Rüstungsstandnamen zu ändern";
    }

    @Override
    public String getClickToScrapTool() {
        return "Klicken Sie auf Schrott Rüstung stehen";
    }


    @Override
    public String getRightClickToSwapEquipment() {
        return "Klicken Sie mit der rechten Maustaste";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "Linksklick auf Farbausrüstung";
    }

    @Override
    public String getLanguage() {
        return "Sprache";
    }

    @Override
    public String getDyePreset() {
        return "Farbvorgabe";
    }

    @Override
    public String getHelmet() {
        return "Ausrüstung Helm";
    }

    @Override
    public String getChestplate() {
        return "Ausrüstung Brustplatte";
    }

    @Override
    public String getLeggings() {
        return "Ausrüstung Hosen";
    }

    @Override
    public String getBoots() {
        return "Ausrüstung Stiefel";
    }

    @Override
    public String getRightArm() {
        return "Ausrüstung Rechter Arm";
    }

    @Override
    public String getLocation() {
        return "Ort";
    }

    @Override
    public String getHeadPose() {
        return "Kopfwinkel";
    }

    @Override
    public String getBodyPose() {
        return "Körperwinkel";
    }

    @Override
    public String getRightArmPose() {
        return "Rechter Armwinkel";
    }

    @Override
    public String getRightLegPose() {
        return "Rechter Beinwinkel";
    }

    @Override
    public String getLeftArmPose() {
        return "Linker Armwinkel";
    }

    @Override
    public String getLeftLegPose() {
        return "Linker Beinwinkel";
    }

    @Override
    public String getArmsToggleDisplay() {
        return "Arme";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "Grundplatte";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "Schwerkraft";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "Klein";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "Sichtbar";
    }

    @Override
    public String getCurrentName() {
        return "Aktueller Name";
    }

    @Override
    public String getUntitled() {
        return "ohne Titel";
    }

    @Override
    public String getBlack() {
        return "Schwarz";
    }

    @Override
    public String getGray() {
        return "Grau";
    }

    @Override
    public String getWhite() {
        return "Weiß";
    }

    @Override
    public String getYellow() {
        return "Gelb";
    }

    @Override
    public String getOrange() {
        return "Orange";
    }

    @Override
    public String getRed() {
        return "Rot";
    }

    @Override
    public String getPurple() {
        return "Lila";
    }

    @Override
    public String getBlue() {
        return "Blau";
    }

    @Override
    public String getGreen() {
        return "Grün";
    }

    @Override
    public String getMessageArmorStandChangeName() {
        return "Geben Sie nun den Namen der Rüstungen ein.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "§7Geben Sie §f§l\"remove\"§7 ein, um den Namen zu entfernen.";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aArmorStand Name wurde in §f§l\"%s\"§a geändert";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "Bereich muss zwischen [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "%s-Sperre ist auf %S gesetzt";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "Erfolgreicher Rüstungsstand";
    }

    @Override
    public String getMessageMove() {
        return "§eGeben Sie \"done\" ein, wenn Sie den Rüstungsstand beendet haben.\n" +
                "§7Sie können den Bereich auch ändern, indem Sie eine Zahl eingeben.\n" +
                "§7Sie können die Achse durch die Eingabe von (x, y, z, pitch oder yaw) selbst verriegeln.";
    }

    @Override
    public String getMessageScrap() {
        return "§6Rüstungsstand verschrottet";
    }
}
