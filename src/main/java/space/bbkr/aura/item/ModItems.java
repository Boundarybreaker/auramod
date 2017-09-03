package space.bbkr.aura.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.creativetab.CreativeTabs;
import space.bbkr.aura.Aura;

public class ModItems {

    public static ItemNote testNote = new ItemNote("test_note");
    public static ItemBase reactantCrystal = new ItemBase("reactant_crystal");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
            testNote,
            reactantCrystal
        );
    }

    public static void registerModels() {
        testNote.registerItemModel();
        reactantCrystal.registerItemModel();
    }
}
