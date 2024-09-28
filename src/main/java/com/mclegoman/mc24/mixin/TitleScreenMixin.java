package com.mclegoman.mc24.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)I"), method = "render")
	private int bob_render(DrawContext context, TextRenderer textRenderer, String string, int x, int y, int color) {
		context.drawTextWithShadow(textRenderer, "This is a Developer Recreation of some features shown at Minecraft Live 2024", 2, 2, color);
		return context.drawTextWithShadow(textRenderer, string, x, y, color);
	}
}