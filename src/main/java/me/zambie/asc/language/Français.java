package me.zambie.asc.language;

final class Français implements Language {

    @Override
    public String getDisplayName() {
        return "Français";
    }

    @Override
    public String getTitle() {
        return "ArmorStand Controller";
    }

    @Override
    public String getAuthor() {
        return "Auteur";
    }

    @Override
    public String getClick() {
        return "Cliquez pour %s";
    }

    @Override
    public String getRightClick() {
        return "Cliquez droit pour %s";
    }

    @Override
    public String getLeftClick() {
        return "Cliquez à gauche pour %s";
    }

    @Override
    public String getToggle() {
        return "Basculer";
    }

    @Override
    public String getIncrease() {
        return "Augmenter";
    }

    @Override
    public String getDecrease() {
        return "Diminution";
    }

    @Override
    public String getEnable() {
        return "Activer";
    }

    @Override
    public String getDisable() {
        return "Désactiver";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "Cliquez pour changer la langue";
    }

    @Override
    public String getClickToCloneTool() {
        return "Cliquez pour cloner le support d'armure";
    }

    @Override
    public String getClickToMoveTool() {
        return "Cliquez pour déplacer le support d'armure";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "Cliquez pour changer le nom de l'armure Stand";
    }

    @Override
    public String getClickToScrapTool() {
        return "Cliquez pour décoller le support d'armure";
    }


    @Override
    public String getRightClickToSwapEquipment() {
        return "Cliquez droit pour échanger l'équipement";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "Cliquez-gauche sur l'équipement couleur";
    }

    @Override
    public String getLanguage() {
        return "La langue";
    }

    @Override
    public String getDyePreset() {
        return "Colorant";
    }

    @Override
    public String getHelmet() {
        return "Casque d'équipement";
    }

    @Override
    public String getChestplate() {
        return "Poitrine d'équipement";
    }

    @Override
    public String getLeggings() {
        return "Leggings d'équipement";
    }

    @Override
    public String getBoots() {
        return "Bottes d'équipement";
    }

    @Override
    public String getRightArm() {
        return "Équipement Bras droit";
    }

    @Override
    public String getLocation() {
        return "Emplacement";
    }

    @Override
    public String getHeadPose() {
        return "Angle de tête";
    }

    @Override
    public String getBodyPose() {
        return "Angle du corps";
    }

    @Override
    public String getRightArmPose() {
        return "Angle de bras droit";
    }

    @Override
    public String getRightLegPose() {
        return "Angle de la jambe droite";
    }

    @Override
    public String getLeftArmPose() {
        return "Angle de bras gauche";
    }

    @Override
    public String getLeftLegPose() {
        return "Angle de la jambe gauche";
    }

    @Override
    public String getArmsToggleDisplay() {
        return "Bras";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "Plaque de base";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "La gravité";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "Petit";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "Visible";
    }

    @Override
    public String getCurrentName() {
        return "Nom actuel";
    }

    @Override
    public String getUntitled() {
        return "sans titre";
    }

    @Override
    public String getBlack() {
        return "Noir";
    }

    @Override
    public String getGray() {
        return "Gris";
    }

    @Override
    public String getWhite() {
        return "Blanc";
    }

    @Override
    public String getYellow() {
        return "Jaune";
    }

    @Override
    public String getOrange() {
        return "Orange";
    }

    @Override
    public String getRed() {
        return "Rouge";
    }

    @Override
    public String getPurple() {
        return "Violet";
    }

    @Override
    public String getBlue() {
        return "Bleu";
    }

    @Override
    public String getGreen() {
        return "Vert";
    }

    @Override
    public String getMessageArmorStandChangeName() {
        return "Tapez maintenant le nom de l'armure.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "§7Tapez §f§l\"remove\"§7 pour supprimer le nom.";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aLe nom de ArmorStand a été changé en §f§l\"%s\"";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "La portée doit être comprise entre [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "Le verrouillage %s est réglé sur %s";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "Remplacé avec succès Armor Stand";
    }

    @Override
    public String getMessageMove() {
        return "§eTapez \"done\" lorsque vous avez fini de déplacer le support d'armure.\n" +
                "§7Vous pouvez également modifier la portée en tapant un numéro.\n" +
                "§7Puede bloquear el eje escribiendo (x, y, z, tono o guiñada) por sí mismos.";
    }

    @Override
    public String getMessageScrap() {
        return "§6Stand d'armure mis au rebut";
    }
}
