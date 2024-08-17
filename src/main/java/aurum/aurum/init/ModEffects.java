package aurum.aurum.init;

import aurum.aurum.Aurum;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    private static final String AURUM_BLIGHT = "aurum_blight"; // Reemplaza con el ID de tu efecto
        public static final DeferredRegister<MobEffect> EFFECTS_REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Aurum.MODID);

    public static final RegistryObject<MobEffect> AurumBlightEffect = EFFECTS_REGISTRY.register(AURUM_BLIGHT,
            aurum.aurum.effectsPlayer.AurumBlight::new); // Color verde


    public static MobEffectInstance createEffectInstance(Holder<MobEffect> effect, int duration, int amplifier) {
        // Access the actual MobEffect instance from the holder
        return new MobEffectInstance(effect, duration, amplifier);
    }
}
