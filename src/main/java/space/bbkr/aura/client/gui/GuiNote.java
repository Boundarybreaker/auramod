package space.bbkr.aura.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import space.bbkr.aura.Aura;

public class GuiNote extends GuiScreen {
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Aura.modId, "textures/gui/note_background.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - 248) / 2;
        int y = (height - 166) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, 248, 166);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
    }
}
