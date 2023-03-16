package net.aedi.firstmod.network.packets;

import net.aedi.firstmod.FirstMod;
import net.aedi.firstmod.ui.ChooseMagicMenu;
import net.aedi.firstmod.ui.ChooseMagicScreen;
import net.aedi.firstmod.ui.ModMenuTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;
import org.w3c.dom.Text;

import java.util.function.Supplier;

import static com.mojang.realmsclient.util.task.LongRunningTask.setScreen;

public class OpenMagicMenuPacket {
    private static final MenuProvider CHOOSE_MAGIC_MENU_PROVIDER = new SimpleMenuProvider((containerId, playerInventory, player)
            -> new ChooseMagicMenu(containerId, playerInventory), new TranslatableComponent("choose_magic_menu_title"));
    public OpenMagicMenuPacket() {

    }

    public OpenMagicMenuPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            Player player = context.getSender();
            Level level = player.getLevel();

            if (!level.isClientSide()){
                NetworkHooks.openGui((ServerPlayer) player, new SimpleMenuProvider(
                        (containerId, playerInventory, player1) -> new ChooseMagicMenu(containerId, playerInventory),
                        new TranslatableComponent("choose_magic_menu_title")));
            }
        });
        return true;
    }

}
