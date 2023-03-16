package net.aedi.firstmod.ui;

import com.mojang.blaze3d.platform.ScreenManager;
import net.aedi.firstmod.FirstMod;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

import static org.jline.utils.Signals.register;

public class ModMenuTypes {
    private static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, FirstMod.MOD_ID);
    public static final RegistryObject<MenuType<ChooseMagicMenu>> CHOOSE_MAGIC_MENU =
            registerMenuType(ChooseMagicMenu.FACTORY, "choose_magic_menu");
    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>>
    registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}


