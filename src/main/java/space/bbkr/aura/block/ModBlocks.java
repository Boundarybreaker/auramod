package space.bbkr.aura.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.creativetab.CreativeTabs;


public class ModBlocks {

    public static BlockReactor crystalReactor = new BlockReactor();
    public static BlockSmokestack smokestack = new BlockSmokestack();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                crystalReactor,
                smokestack
        );
        GameRegistry.registerTileEntity(crystalReactor.getTileEntityClass(), crystalReactor.getRegistryName().toString());
        GameRegistry.registerTileEntity(smokestack.getTileEntityClass(), smokestack.getRegistryName().toString());
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                crystalReactor.createItemBlock(),
                smokestack.createItemBlock()
        );
    }

    public static void registerModels() {
        crystalReactor.registerItemModel(Item.getItemFromBlock(crystalReactor));
        smokestack.registerItemModel(Item.getItemFromBlock(smokestack));
    }
}