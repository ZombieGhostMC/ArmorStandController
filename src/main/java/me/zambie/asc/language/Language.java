package me.zambie.asc.language;

public interface Language {

    String getDisplayName();
    String getTitle();
    String getAuthor();

    String getClick();
    String getRightClick();
    String getLeftClick();

    String getToggle();
    String getIncrease();
    String getDecrease();

    String getEnable();
    String getDisable();

    String getClickToChangeLanguage();
    String getClickToCloneTool();
    String getClickToMoveTool();
    String getClickToChangeNameTool();
    String getClickToScrapTool();
    String getRightClickToSwapEquipment();
    String getLeftClickToColorEquipment();

    String getLanguage();
    String getDyePreset();

    String getHelmet();
    String getChestplate();
    String getLeggings();
    String getBoots();
    String getRightArm();

    String getLocation();
    String getHeadPose();
    String getBodyPose();
    String getRightArmPose();
    String getRightLegPose();
    String getLeftArmPose();
    String getLeftLegPose();

    String getArmsToggleDisplay();
    String getBasePlateToggleDisplay();
    String getGravityToggleDisplay();
    String getSmallToggleDisplay();
    String getVisibleToggleDisplay();
    String getCurrentName();
    String getUntitled();

    String getBlack();
    String getGray();
    String getWhite();
    String getYellow();
    String getOrange();
    String getRed();
    String getPurple();
    String getBlue();
    String getGreen();

    String getMessageArmorStandChangeName();
    String getMessageRemoveNameChangeAction();
    String getMessageCompleteNameChangeAction();
    String getMessageInvalidRepositionRange();
    String getMessageRepositionLock();
    String getMessageRepositionSuccess();

    String getMessageMove();
    String getMessageScrap();
}
