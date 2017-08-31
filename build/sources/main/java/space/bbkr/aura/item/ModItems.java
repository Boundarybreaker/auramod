package space.bbkr.aura.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.creativetab.CreativeTabs;

public class ModItems {

    public static ItemBase tempItem = new ItemBase("temp_item").setCreativeTab(CreativeTabs.MATERIALS);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
        tempItem
        );
    }

    public static void registerModels() {
        tempItem.registerItemModel();
    }
}
