package space.bbkr.aura.recipe;

import space.bbkr.aura.item.ModItems;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(ModItems.prismarineCluster, new ItemStack(ModItems.reactantCrystal), 0.7f);
    }
}
