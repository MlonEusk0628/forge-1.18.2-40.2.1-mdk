package net.aedi.firstmod.event;

import net.aedi.firstmod.FirstMod;
import net.aedi.firstmod.network.ModMessages;
import net.aedi.firstmod.network.packets.OpenMagicMenuPacket;
import net.aedi.firstmod.util.KeyMappings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static org.jline.utils.Signals.register;
public class ClientEvents {
    @Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void clientTick(TickEvent.ClientTickEvent event) {
            var player = Minecraft.getInstance().player;
            if (KeyMappings.OPEN_MAGIC_MENU.consumeClick()) {
                ModMessages.sendToServer(new OpenMagicMenuPacket());
            }
        }
    }
}
