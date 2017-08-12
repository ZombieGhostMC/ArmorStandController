package me.zambie.asc.language;

final class Español implements Language {

    @Override
    public String getDisplayName() {
        return "Español";
    }

    @Override
    public String getTitle() {
        return "Controlador ArmorStand";
    }

    @Override
    public String getAuthor() {
        return "Autor";
    }

    @Override
    public String getClick() {
        return "Haga clic para %s";
    }

    @Override
    public String getRightClick() {
        return "Haga clic derecho para %s";
    }

    @Override
    public String getLeftClick() {
        return "Clic izquierdo para %s";
    }

    @Override
    public String getToggle() {
        return "Palanca";
    }

    @Override
    public String getIncrease() {
        return "Incrementar";
    }

    @Override
    public String getDecrease() {
        return "Disminución";
    }

    @Override
    public String getEnable() {
        return "Habilitar";
    }

    @Override
    public String getDisable() {
        return "Inhabilitar";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "Haga clic para cambiar el idioma";
    }

    @Override
    public String getClickToCloneTool() {
        return "Haga clic para eliminar el soporte de armadura";
    }

    @Override
    public String getClickToMoveTool() {
        return "Haga clic para mover el soporte de armadura";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "Haga clic para cambiar el nombre del soporte de armadura";
    }

    @Override
    public String getClickToScrapTool() {
        return "Haga clic para eliminar el soporte de armadura";
    }


    @Override
    public String getRightClickToSwapEquipment() {
        return "Clic derecho para intercambiar equipos";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "Clic izquierdo para colorear el equipo";
    }

    @Override
    public String getLanguage() {
        return "Idioma";
    }

    @Override
    public String getDyePreset() {
        return "Preselección de color";
    }

    @Override
    public String getHelmet() {
        return "Equipo Casco";
    }

    @Override
    public String getChestplate() {
        return "Caja de equipamiento";
    }

    @Override
    public String getLeggings() {
        return "Leggings de equipo";
    }

    @Override
    public String getBoots() {
        return "Botas de equipo";
    }

    @Override
    public String getRightArm() {
        return "Equipo Brazo Derecho";
    }

    @Override
    public String getLocation() {
        return "Ubicación";
    }

    @Override
    public String getHeadPose() {
        return "Angulo de la cabeza";
    }

    @Override
    public String getBodyPose() {
        return "Angulo del cuerpo";
    }

    @Override
    public String getRightArmPose() {
        return "Angulo del brazo derecho";
    }

    @Override
    public String getRightLegPose() {
        return "Angulo de la pierna derecha";
    }

    @Override
    public String getLeftArmPose() {
        return "Angulo del brazo izquierdo";
    }

    @Override
    public String getLeftLegPose() {
        return "Angulo de la pierna izquierda";
    }

    @Override
    public String getArmsToggleDisplay() {
        return "Brazos";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "Plato base";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "Gravedad";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "Pequeña";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "Visible";
    }

    @Override
    public String getCurrentName() {
        return "Nombre actual";
    }

    @Override
    public String getUntitled() {
        return "intitulado";
    }

    @Override
    public String getBlack() {
        return "Negro";
    }

    @Override
    public String getGray() {
        return "Gris";
    }

    @Override
    public String getWhite() {
        return "Blanco";
    }

    @Override
    public String getYellow() {
        return "Amarillo";
    }

    @Override
    public String getOrange() {
        return "Naranja";
    }

    @Override
    public String getRed() {
        return "Rojo";
    }

    @Override
    public String getPurple() {
        return "Púrpura";
    }

    @Override
    public String getBlue() {
        return "Azul";
    }

    @Override
    public String getGreen() {
        return "Verde";
    }

    @Override
    public String getMessageArmorStandChangeName() {
        return "Ahora escriba el nombre de la armadura.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "§7Escriba §f§l\"remove\"§7 para eliminar el nombre.";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aArmorStand nombre fue cambiado a §f§l\"%s\"";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "El rango debe estar entre [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "El bloqueo %s se establece en %s";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "Movido con éxito Armor Stand";
    }

    @Override
    public String getMessageMove() {
        return "§eEscriba \"done\" cuando termine de mover el ArmorStand.\n" +
                "§7También puede cambiar el rango escribiendo un número.\n" +
                "§7Puede bloquear el eje escribiendo (x, y, z, pitch o yaw) por sí mismos.";
    }

    @Override
    public String getMessageScrap() {
        return "§6Soporte de armadura desechado";
    }
}
