package aurum.aurum.init;

import aurum.aurum.block.Withered_grass_block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static aurum.aurum.Aurum.MODID;

public class ModBloques {

    // Crea un Registro Diferido para mantener los ModBloques que se registrarán bajo el espacio de nombres "aurum"
    public static final DeferredRegister<Block> BLOCKS_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Crea un Registro Diferido para mantener los ModItems que se registrarán bajo el espacio de nombres "aurum"
    // Crea un Registro Diferido para mantener las Pestañas de Modo Creativo que se registrarán bajo el espacio de nombres "examplemod"
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Crea un nuevo Bloque con el id "aurum:example_block", combinando el espacio de nombres y la ruta
    public static final RegistryObject<Block> WITHERED_GRASS_BLOCK = BLOCKS_REGISTRY.register("withered_grass_block", Withered_grass_block::new);

    // Crea un nuevo BlockItem con el id "aurum:example_block", combinando el espacio de nombres y la ruta
    //public static final RegistryObject<Item> WITHERED_GRASS_BLOCK_ITEM = ITEMS.register("withered_grass_block", () -> new BlockItem(WITHERED_GRASS_BLOCK.get(), new Item.Properties()));
}
