package me.zambie.asc.language;

final class English implements Language {

    @Override
    public String getDisplayName() {
        return "English";
    }

    @Override
    public String getTitle() {
        return "ArmorStand Controller";
    }

    @Override
    public String getAuthor() {
        return "Author";
    }

    @Override
    public String getClick() {
        return "Click To %s";
    }

    @Override
    public String getRightClick() {
        return "Right Click To %s";
    }

    @Override
    public String getLeftClick() {
        return "Left Click To %s";
    }

    @Override
    public String getToggle() {
        return "Toggle";
    }

    @Override
    public String getIncrease() {
        return "Increase";
    }

    @Override
    public String getDecrease() {
        return "Decrease";
    }

    @Override
    public String getEnable() {
        return "Enable";
    }

    @Override
    public String getDisable() {
        return "Disable";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "Click To Change Language";
    }

    @Override
    public String getClickToCloneTool() {
        return "Click To Clone ArmorStand";
    }

    @Override
    public String getClickToMoveTool() {
        return "Click To Move ArmorStand";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "Click To Change ArmorStand Name";
    }

    @Override
    public String getClickToScrapTool() {
        return "Click To Scrap ArmorStand";
    }

    @Override
    public String getRightClickToSwapEquipment() {
        return "Right Click To Swap Equipment";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "Left Click To Color Equipment";
    }

    @Override
    public String getLanguage() {
        return "Language";
    }

    @Override
    public String getDyePreset() {
        return "Dye Preset";
    }

    @Override
    public String getHelmet() {
        return "Equipment Helmet";
    }

    @Override
    public String getChestplate() {
        return "Equipment Chestplate";
    }

    @Override
    public String getLeggings() {
        return "Equipment Leggings";
    }

    @Override
    public String getBoots() {
        return "Equipment Boots";
    }

    @Override
    public String getRightArm() {
        return "Equipment Right Arm";
    }

    @Override
    public String getLocation() {
        return "Location";
    }

    @Override
    public String getHeadPose() {
        return "Head Angle";
    }

    @Override
    public String getBodyPose() {
        return "Body Angle";
    }

    @Override
    public String getRightArmPose() {
        return "Right Arm Angle";
    }

    @Override
    public String getRightLegPose() {
        return "Right Leg Angle";
    }

    @Override
    public String getLeftArmPose() {
        return "Left Arm Angle";
    }

    @Override
    public String getLeftLegPose() {
        return "Left Leg Angle";
    }

    @Override
    public String getArmsToggleDisplay() {
        return "Arms";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "BasePlate";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "Gravity";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "Small";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "Visible";
    }

    @Override
    public String getCurrentName() {
        return "Current Name";
    }

    @Override
    public String getUntitled() {
        return "untitled";
    }

    @Override
    public String getBlack() {
        return "Black";
    }

    @Override
    public String getGray() {
        return "Gray";
    }

    @Override
    public String getWhite() {
        return "White";
    }

    @Override
    public String getYellow() {
        return "Yellow";
    }

    @Override
    public String getOrange() {
        return "Orange";
    }

    @Override
    public String getRed() {
        return "Red";
    }

    @Override
    public String getPurple() {
        return "Purple";
    }

    @Override
    public String getBlue() {
        return "Blue";
    }

    @Override
    public String getGreen() {
        return "Green";
    }

    @Override
    public String getMessageArmorStandChangeName() {
        return "Now type the armorstands name.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "§7Type §f§l\"remove\"§7 to remove name.";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aArmorStand name was changed to §f§l\"%s\"";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "Range must be between [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "%s lock is set to %s";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "Successfully moved ArmorStand";
    }

    @Override
    public String getMessageMove() {
        return "§eType \"done\" when finished moving the ArmorStand.\n" +
                "§7You can also change the range by typing a number.\n" +
                "§7You can lock axis by typing (x, y, z, pitch, or yaw) by themselves.";
    }

    @Override
    public String getMessageScrap() {
        return "§6ArmorStand scrapped";
    }
}
