package space.bbkr.aura.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import space.bbkr.aura.Aura;
import space.bbkr.aura.block.ModBlocks;

public class AuraTab extends CreativeTabs {

    public AuraTab() {
        super(Aura.modId);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.crystalReactor);
    }
}
