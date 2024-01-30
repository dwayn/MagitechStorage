package com.r4ndomize.magitech.storage.item;

import com.r4ndomize.magitech.storage.Constants;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item RED_CRYSTAL_CANDY = registerItem("red_crystal_candy",
            new Item(
                    new FabricItemSettings().group(CreativeModeTab.TAB_MISC)
            )
    );

    public static final Item BLUE_CRYSTAL_CANDY = registerItem("blue_crystal_candy",
            new Item(
                    new FabricItemSettings().group(CreativeModeTab.TAB_MISC)
            )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, Constants.MOD_ID + ":" + name, item);
    }

    public static void registerModItems() {
        Constants.LOG.debug("Loading items for " + Constants.MOD_NAME);
    }
}
