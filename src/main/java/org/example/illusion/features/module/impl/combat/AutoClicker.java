package org.example.illusion.features.module.impl.combat;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.event.impl.render.Render3DEvent;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.features.module.impl.misc.Weapons;
import org.example.illusion.utils.Wrapper;

@ModuleInfo(name = "AutoClicker", category = Category.COMBAT)
public class AutoClicker extends Module {
    private CheckSetting weaponsOnly = new CheckSetting("Weapons Only", this, true);

    public AutoClicker() {
        addSetting(weaponsOnly);
    }

    @Listen
    public void onRender3D(Render3DEvent event) {
        Wrapper.addChatMessage("Current item is a weapon: " + Weapons.isWeapon(Wrapper.getPlayer().getHeldItem()));
    }
}
