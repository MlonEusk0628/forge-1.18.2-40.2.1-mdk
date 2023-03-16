package net.aedi.firstmod.ui;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.IContainerFactory;
import org.antlr.v4.runtime.atn.BlockEndState;

import java.awt.*;
import java.util.logging.Level;

public class ChooseMagicMenu extends AbstractContainerMenu {

    public static final IContainerFactory<ChooseMagicMenu> FACTORY = (windowId, inv, data) -> {
        return new ChooseMagicMenu(windowId, inv);
    };
    public ChooseMagicMenu(int pContainerId, Inventory inv){
        super(ModMenuTypes.CHOOSE_MAGIC_MENU.get(), pContainerId);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}

