package aurum.aurum.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static aurum.aurum.Aurum.MODID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;


public class ModItems {
    // Crea un nuevo item de comida con el id "aurum:example_id", nutrición 1 y saturación 2
    public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS_REGISTRY.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(2f).build())));
    public static final RegistryObject<Item> WITHERED_GRASS_ITEM = block(ModBloques.WITHERED_GRASS_BLOCK);

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return ITEMS_REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
