package space.bbkr.aura.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.creativetab.CreativeTabs;
import space.bbkr.aura.Aura;


public class ModBlocks {

    public static BlockMachine auraSmelter = new BlockMachine("aura_smelter").setCreativeTab(Aura.creativeTab);
    public static BlockMachine smokestack = new BlockMachine("smokestack").setCreativeTab(Aura.creativeTab);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                auraSmelter,
                smokestack
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                auraSmelter.createItemBlock(),
                smokestack.createItemBlock()
        );
    }

    public static void registerModels() {
        auraSmelter.registerItemModel(Item.getItemFromBlock(auraSmelter));
        smokestack.registerItemModel(Item.getItemFromBlock(smokestack));
    }
}
