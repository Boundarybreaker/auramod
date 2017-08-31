package space.bbkr.aura.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static BlockBase auraSmelter = new BlockMachine("aura_smelter").setCreativeTab(CreativeTabs.MATERIALS);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                auraSmelter
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                auraSmelter.createItemBlock()
        );
    }

    public static void registerModels() {
        auraSmelter.registerItemModel(Item.getItemFromBlock(auraSmelter));
    }
}
