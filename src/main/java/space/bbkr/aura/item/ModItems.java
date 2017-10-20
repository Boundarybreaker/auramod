package space.bbkr.aura.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.creativetab.CreativeTabs;
import space.bbkr.aura.Aura;

public class ModItems {

    public static ItemNote testNote = new ItemNote("test_note");
    public static ItemBase reactantCrystal = new ItemBase("reactant_crystal").setCreativeTab(Aura.creativeTab);
    public static ItemBase prismarineCluster = new ItemBase("prismarine_cluster").setCreativeTab(Aura.creativeTab);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
            testNote,
            reactantCrystal,
            prismarineCluster
        );
    }

    public static void registerModels() {
        testNote.registerItemModel();
        reactantCrystal.registerItemModel();
        prismarineCluster.registerItemModel();
    }
}
