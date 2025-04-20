package org.example.illusion.features.module.impl.movement;

import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.settings.KeyBinding;
import org.example.illusion.event.impl.player.MoveEntityEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;

@ModuleInfo(name = "Sprint", category = Category.MOVEMENT)
public class Sprint extends Module {

    // TODO: Use SprintEvent after I figure out why it flags.
    @Listen
    public final void onMoveEntity(MoveEntityEvent event) {
        KeyBinding.setKeyBindState(Wrapper.getSettings().keyBindSprint.getKeyCode(), true);
    }
}
