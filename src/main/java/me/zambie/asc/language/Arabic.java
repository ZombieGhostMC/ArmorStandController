package me.zambie.asc.language;

public final class Arabic implements Language {

    @Override
    public String getDisplayName() {
        return "عربى";
    }

    @Override
    public String getTitle() {
        return "أرمورستاند المراقب المالي";
    }

    @Override
    public String getAuthor() {
        return "مؤلف";
    }

    @Override
    public String getClick() {
        return "انقر ل %s";
    }

    @Override
    public String getRightClick() {
        return "انقر بزر الماوس الأيمن على %s";
    }

    @Override
    public String getLeftClick() {
        return "انقر بزر الماوس الأيمن على %s";
    }

    @Override
    public String getToggle() {
        return "تبديل";
    }

    @Override
    public String getIncrease() {
        return "زيادة";
    }

    @Override
    public String getDecrease() {
        return "تخفيض";
    }

    @Override
    public String getEnable() {
        return "مكن";
    }

    @Override
    public String getDisable() {
        return "تعطيل";
    }

    @Override
    public String getClickToChangeLanguage() {
        return "انقر لتغيير اللغة";
    }

    @Override
    public String getClickToCloneTool() {
        return "انقر لاستنساخ أرمورستاند";
    }

    @Override
    public String getClickToMoveTool() {
        return "انقر لتحريك حامل الدروع";
    }

    @Override
    public String getClickToChangeNameTool() {
        return "انقر لتغيير درع الوقوف اسم";
    }

    @Override
    public String getClickToScrapTool() {
        return "انقر على خردة الدروع الوقوف";
    }

    @Override
    public String getRightClickToSwapEquipment() {
        return "انقر بزر الماوس الأيمن لمبادلة المعدات";
    }

    @Override
    public String getLeftClickToColorEquipment() {
        return "اليسار انقر لتلوين المعدات";
    }

    @Override
    public String getLanguage() {
        return "لغة";
    }

    @Override
    public String getDyePreset() {
        return "صبغ مسبقا";
    }

    @Override
    public String getHelmet() {
        return "معدات خوذة";
    }

    @Override
    public String getChestplate() {
        return "معدات تشيستبلات";
    }

    @Override
    public String getLeggings() {
        return "معدات طماق";
    }

    @Override
    public String getBoots() {
        return "معدات الأحذية";
    }

    @Override
    public String getRightArm() {
        return "المعدات الذراع اليمنى";
    }

    @Override
    public String getLocation() {
        return "موقعك";
    }

    @Override
    public String getHeadPose() {
        return "زاوية الرأس";
    }

    @Override
    public String getBodyPose() {
        return "Body Angle";
    }

    @Override
    public String getRightArmPose() {
        return "زاوية الذراع اليمنى";
    }

    @Override
    public String getRightLegPose() {
        return "زاوية الساق اليمنى";
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
        return "أسلحة";
    }

    @Override
    public String getBasePlateToggleDisplay() {
        return "لوحة القاعدة";
    }

    @Override
    public String getGravityToggleDisplay() {
        return "الجاذبية";
    }

    @Override
    public String getSmallToggleDisplay() {
        return "صغير";
    }

    @Override
    public String getVisibleToggleDisplay() {
        return "مرئي";
    }

    @Override
    public String getCurrentName() {
        return "الاسم الحالي";
    }

    @Override
    public String getUntitled() {
        return "بدون عنوان";
    }

    @Override
    public String getBlack() {
        return "أسود";
    }

    @Override
    public String getGray() {
        return "رمادي";
    }

    @Override
    public String getWhite() {
        return "أبيض";
    }

    @Override
    public String getYellow() {
        return "الأصفر";
    }

    @Override
    public String getOrange() {
        return "البرتقالي";
    }

    @Override
    public String getRed() {
        return "أحمر";
    }

    @Override
    public String getPurple() {
        return "أرجواني";
    }

    @Override
    public String getBlue() {
        return "أزرق";
    }

    @Override
    public String getGreen() {
        return "أخضر";
    }

    @Override
    public String getMessageArmorStandChangeName() {
        return "الآن اكتب الدروع يقف الاسم.";
    }

    @Override
    public String getMessageRemoveNameChangeAction() {
        return "اكتب \"remove\" لإزالة الاسم.7§";
    }

    @Override
    public String getMessageCompleteNameChangeAction() {
        return "§aتم تغيير اسم أرمورستاند إلى §f§l\"%s\"";
    }

    @Override
    public String getMessageInvalidRepositionRange() {
        return "يجب أن يكون النطاق بين [1-99]";
    }

    @Override
    public String getMessageRepositionLock() {
        return "%s تم تعيين القفل على %s";
    }

    @Override
    public String getMessageRepositionSuccess() {
        return "تم نقل الدرع بنجاح";
    }

    @Override
    public String getMessageMove() {
        return "§eاكتب \"عمله\" عند الانتهاء من تحريك حامل الدروع.\n" +
                "§7يمكنك أيضا تغيير النطاق عن طريق كتابة رقم.\n" +
                "§7يمكنك قفل المحور عن طريق كتابة (x، y، z، pitch، yaw) بأنفسهم.";
    }

    @Override
    public String getMessageScrap() {
        return "§6درع الوقوف ألغت";
    }

}
