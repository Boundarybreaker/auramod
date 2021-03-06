package space.bbkr.aura.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMachine extends BlockBase {

    public BlockMachine(String name) {
        super(Material.ROCK, name);

        setHardness(3f);
        setResistance(5f);
    }

    @Override
    public BlockMachine setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
