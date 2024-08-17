package aurum.aurum;

import aurum.aurum.eventHandler.BlockChecker;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static aurum.aurum.init.ModBloques.*;
import static aurum.aurum.init.ModEffects.EFFECTS_REGISTRY;
import static aurum.aurum.init.ModItems.EXAMPLE_ITEM;
import static aurum.aurum.init.ModItems.ITEMS_REGISTRY;

// El valor aquí debe coincidir con una entrada en el archivo META-INF/mods.toml
@Mod(Aurum.MODID)
public class Aurum {

    // Define el id del mod en un lugar común para que todo lo referencie
    public static final String MODID = "aurum";
    // Referencia directa a un logger slf4j
    private static final Logger LOGGER = LogUtils.getLogger();





    // Crea una pestaña creativa con el id "examplemod:INTERFAZ_CREATIVO" para el item de ejemplo, que se coloca después de la pestaña de combate
    public static final RegistryObject<CreativeModeTab> INTERFAZ_CREATIVO = CREATIVE_MODE_TABS.register("interfaz_creativo", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + MODID + ".interfaz_creativo"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Añade el item de ejemplo a la pestaña. Para tus propias pestañas, este método es preferido sobre el evento
                output.accept(WITHERED_GRASS_BLOCK.get()); // Añade el item de bloque de ejemplo a la pestaña
            }).build());

    public Aurum() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registra el método commonSetup para la carga del mod
        modEventBus.addListener(this::commonSetup);

        // Registra el Registro Diferido al bus de eventos del mod para que los ModBloques se registren
        BLOCKS_REGISTRY.register(modEventBus);

        // Registra el Registro Diferido al bus de eventos del mod para que los ModItems se registren
        ITEMS_REGISTRY.register(modEventBus);

        // Registra el Registro Diferido al bus de eventos del mod para que los ModEffects se registren
        EFFECTS_REGISTRY.register(modEventBus);


        // Registra el Registro Diferido al bus de eventos del mod para que las pestañas se registren
        CREATIVE_MODE_TABS.register(modEventBus);

        // Nos registramos para los eventos del servidor y otros eventos del juego que nos interesan
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(BlockChecker::onPlayerTick);
        // Registra el item a una pestaña creativa
        modEventBus.addListener(this::addCreative);

        // Registra la ForgeConfigSpec de nuestro mod para que Forge pueda crear y cargar el archivo de configuración por nosotros
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Algun código de configuración común
        LOGGER.info("HOLA DESDE LA CONFIGURACIÓN COMÚN");
        LOGGER.info("BLOQUE DE TIERRA >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

    }

    // Añade el item de bloque de ejemplo a la pestaña de ModBloques de construcción
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(WITHERED_GRASS_BLOCK.get());
    }
    // Puedes usar SubscribeEvent y dejar que el Event Bus descubra métodos para llamar
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Haz algo cuando el servidor comienza
        LOGGER.info("HOLA desde el inicio del servidor");
    }

    // Puedes usar EventBusSubscriber para registrar automáticamente todos los métodos estáticos en la clase anotada con @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Algun código de configuración del cliente
            LOGGER.info("HOLA DESDE LA CONFIGURACIÓN DEL CLIENTE");
            LOGGER.info("NOMBRE DE MINECRAFT >> {}", Minecraft.getInstance().getUser().getName());
            LOGGER.info("Pack de recursos activos DE MINECRAFT >> {}", Minecraft.getInstance().getDownloadedPackSource());


        }
    }



}
