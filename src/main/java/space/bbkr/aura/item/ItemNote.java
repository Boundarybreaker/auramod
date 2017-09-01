package space.bbkr.aura.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import space.bbkr.aura.Aura;

public class ItemNote extends ItemBase {


    protected String name;

    public ItemNote(String name) {
        super(name);
        setMaxStackSize(1);
        setCreativeTab(Aura.creativeTab);
    }


    public EnumActionResult onItemUse(EntityPlayer p, World w, BlockPos pos, EnumHand h, EnumFacing f, float x, float y, float z) {
        if(!w.isRemote) {
            p.sendMessage(new TextComponentTranslation("aura.note.start"));
        }
        return EnumActionResult.SUCCESS;
    }


}