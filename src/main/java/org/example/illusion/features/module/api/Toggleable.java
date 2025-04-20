package org.example.illusion.features.module.api;

import org.example.illusion.IllusionClient;

// ill move to general api when
// I find it suitable for another feature
public class Toggleable {
    private boolean enabled;

    public final void toggle() {
        setEnabled(!enabled);
    }

    public final void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;

            if (enabled) {
                onEnable();
                IllusionClient.getInstance().getEventBus().subscribe(this);
            } else {
                IllusionClient.getInstance().getEventBus().unsubscribe(this);
                onDisable();
            }
        }
    }

    public final boolean isEnabled(){
        return enabled;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }
}