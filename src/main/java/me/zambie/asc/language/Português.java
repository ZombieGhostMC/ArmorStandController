package me.zambie.asc.language;

final class Português implements Language {

    @Override
    public String getDisplayName() {
        return "Português";
    }

    @Override
    public String getTitle() {
        return "ArmorStand Controller";
    }

    @Override
    public String getAuthor() {
        return "Autor";
    }

    @Override
    public String getClick() {
        return "Clique para %s";
    }

    @Override
    public String getRightClick() {
        return "Clique direito para %s";
    }

    @Override
    public String getLeftClick() {
        return "Clique esquerdo para %s";
    }

    @Override
    public String getToggle() {
        return "Alternancia";
    }

    @Override
    public String getIncrease() {
        return "Aumentar";
    }

    @Override
    public String getDecrease() {
        return "Diminuir";
    }

    @Override
    public String getEnable() {
        return "Habilitar";
    }

    @Override
    public String getDisable() {
        return "Desativar";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "Clique para Alterar Idioma";
    }

    @Override
    public String getClickToCloneTool() {
        return "Clique para Clone Armor Stand";
    }

    @Override
    public String getClickToMoveTool() {
        return "Clique para Mover o Stand da Armadura";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "Clique para mudar o nome do armadura Stand";
    }

    @Override
    public String getClickToScrapTool() {
        return "Clique para cortar o suporte da armadura";
    }

    @Override
    public String getRightClickToSwapEquipment() {
        return "Clique direito para trocar equipamentos";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "Clique com o botão esquerdo para colorir equipamento";
    }

    @Override
    public String getLanguage() {
        return "Língua";
    }

    @Override
    public String getDyePreset() {
        return "Predefinição de tintura";
    }

    @Override
    public String getHelmet() {
        return "Capacete de equipamento";
    }

    @Override
    public String getChestplate() {
        return "Equipamento Peitoral";
    }

    @Override
    public String getLeggings() {
        return "Calças de equipamento";
    }

    @Override
    public String getBoots() {
        return "Botas de equipamento";
    }

    @Override
    public String getRightArm() {
        return "Equipamento Braço Direito";
    }

    @Override
    public String getLocation() {
        return "Localização";
    }

    @Override
    public String getHeadPose() {
        return "Ângulo da cabeça";
    }

    @Override
    public String getBodyPose() {
        return "Ângulo do corpo";
    }

    @Override
    public String getRightArmPose() {
        return "Ângulo do braço direito";
    }

    @Override
    public String getRightLegPose() {
        return "Ângulo direito do perna";
    }

    @Override
    public String getLeftArmPose() {
        return "Ângulo do braço esquerdo";
    }

    @Override
    public String getLeftLegPose() {
        return "Ângulo da perna esquerda";
    }

    @Override
    public String getArmsToggleDisplay() {
        return "Braços";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "Placa base";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "Gravidade";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "Pequeno";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "Visível";
    }

    @Override
    public String getCurrentName() {
        return "Nome atual";
    }

    @Override
    public String getUntitled() {
        return "sem título";
    }

    @Override
    public String getBlack() {
        return "Preto";
    }

    @Override
    public String getGray() {
        return "Cinzento";
    }

    @Override
    public String getWhite() {
        return "Branco";
    }

    @Override
    public String getYellow() {
        return "Amarelo";
    }

    @Override
    public String getOrange() {
        return "laranja";
    }

    @Override
    public String getRed() {
        return "Vermelho";
    }

    @Override
    public String getPurple() {
        return "Roxa";
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
        return "Agora digite o nome do armadura.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "§7Digite §f§l\"remove\"§7 para remover o nome.";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aO nome do ArmorStand foi alterado para §f§l\"%s\"";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "O intervalo deve estar entre [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "%s lock está definido para %s";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "Suporte armadura com sucesso";
    }

    @Override
    public String getMessageMove() {
        return "§eDigite \"done\" quando terminar de mover o suporte da armadura.\n" +
                "§7Você também pode alterar o intervalo digitando um número.\n" +
                "§7Você pode bloquear o eixo, digitando (x, y, z, pitch ou yaw) sozinhos.";
    }

    @Override
    public String getMessageScrap() {
        return "§6Stand de armadura desfeito";
    }
}
