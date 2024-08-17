package aurum.aurum.eventHandler;

import aurum.aurum.init.ModEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static aurum.aurum.init.ModEffects.AurumBlightEffect;

public class BlockChecker {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.side.isServer()) {
            Player player = event.player;
            // Solo en el lado del servidor
            BlockState blockState = player.getBlockStateOn();
            Block block = blockState.getBlock();

            if (block.getDescriptionId().equals("block.aurum.withered_grass_block")) {
                // Aquí puedes realizar cualquier acción con el bloque encontrado
                if (AurumBlightEffect.getHolder().isPresent()) {
                    player.addEffect(ModEffects.createEffectInstance(AurumBlightEffect.getHolder().get(), 30, 1));
                }
            }
        }
    }
}
