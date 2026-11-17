package com.celestial;

import com.celestial.gui.Theme;
import com.celestial.module.ModuleManager;
import com.celestial.modules.TriggerBot;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class CelestialClient implements ClientModInitializer {
    public static final String MOD_ID = "celestial";
    public static MinecraftClient mc;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
        
        // Регистрация модулей
        ModuleManager.INSTANCE.addModule(new TriggerBot());

        // Регистрация HUD
        HudElementRegistry.attachElementBefore(
            VanillaHudElements.CHAT,
            Identifier.fromNamespaceAndPath(MOD_ID, "celestial_hud"),
            (context, tickCounter) -> {
                int x = 10;
                int y = 10;
                
                context.drawTextWithShadow(mc.textRenderer, "Celestial", x, y, Theme.current.accent);
                context.drawTextWithShadow(mc.textRenderer, "Theme: " + Theme.current.displayName, x, y + 12, 0xFFFFFF);
                context.drawTextWithShadow(mc.textRenderer, "FPS: " + mc.getCurrentFps(), x, y + 24, 0xFFFFFF);
                
                TriggerBot tb = ModuleManager.INSTANCE.getModule(TriggerBot.class);
                if (tb != null) {
                    String status = "TriggerBot: " + (tb.isEnabled() ? "ON" : "OFF");
                    int color = tb.isEnabled() ? Theme.current.accent : 0xFF5555;
                    context.drawTextWithShadow(mc.textRenderer, status, x, y + 36, color);
                }
            }
        );
    }
}
