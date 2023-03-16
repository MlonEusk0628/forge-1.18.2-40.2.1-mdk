package net.aedi.firstmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public final class KeyMappings {
    public static final String KEY_CATEGORY_FIRSTMOD = "key.category.firstmod.first";
    public static final String KEY_OPEN_MENU = "key.firstmod.open_menu";
    public static final KeyMapping OPEN_MAGIC_MENU = registerKey(new KeyMapping(KEY_OPEN_MENU, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, KEY_CATEGORY_FIRSTMOD));
    public static KeyMapping registerKey(KeyMapping key){
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
