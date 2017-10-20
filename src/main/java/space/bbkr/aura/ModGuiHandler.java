package space.bbkr.aura;

import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import space.bbkr.aura.client.gui.GuiNote;

public class ModGuiHandler implements IGuiHandler {
    public static final int NOTE_TUTORIAL = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case NOTE_TUTORIAL:
                return new GuiNote();
            default:
                return null;
        }
    }
}
