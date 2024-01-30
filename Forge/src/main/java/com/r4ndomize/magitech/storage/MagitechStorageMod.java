package com.r4ndomize.magitech.storage;

import com.r4ndomize.magitech.storage.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class MagitechStorageMod {

    public MagitechStorageMod() {

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

        // Some code like events require special initialization from the
        // loader specific code.
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Constants.LOG.debug("Common setup called in " + Constants.MOD_NAME);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Constants.LOG.debug("OnClientSetup called for " + Constants.MOD_NAME);
        }
    }

    // This method exists as a wrapper for the code in the Common project.
    // It takes Forge's event object and passes the parameters along to
    // the Common listener.
    private void onItemTooltip(ItemTooltipEvent event) {

        CommonClass.onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }


}
