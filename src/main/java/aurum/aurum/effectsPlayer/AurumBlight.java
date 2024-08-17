package aurum.aurum.effectsPlayer;

import net.minecraft.core.Holder;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;

public class AurumBlight extends MobEffect {


    public AurumBlight() {
        super(MobEffectCategory.HARMFUL, -26113);
    }

    @Override
    public String getDescriptionId() {
        return "effect.asherah.aurum_blight";
    }
}

