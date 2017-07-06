package uk.co.hexeption.swifter;

import com.google.common.base.Stopwatch;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.hexeption.swifter.common.config.Config;
import uk.co.hexeption.swifter.common.utils.LogHelper;
import uk.co.hexeption.swifter.proxy.IProxy;

import java.util.concurrent.TimeUnit;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, dependencies = ModInfo.DEPENDENCIES, version = ModInfo.BUILD_VERION)
public class Swifter {


    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(ModInfo.MOD_ID)
    public static Swifter INSTANCE;

    /**
     *
     */
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    /**
     * This is the configuration for the mod.
     */
    public static Configuration configuration;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        final Stopwatch stopwatch = Stopwatch.createStarted();
        LogHelper.info("Pre Initialization (Started)");

        proxy.registerConfiguration(event.getSuggestedConfigurationFile());

        proxy.registerBlocks();

        proxy.registerItems();

        proxy.registerFurnaceRecipes();

        proxy.registerEvents();

        proxy.registerRenderers();

        LogHelper.info("Pre Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        final Stopwatch stopwatch = Stopwatch.createStarted();
        LogHelper.info("Initialization (Started)");

        proxy.registerCraftingRecipes();

        LogHelper.info("Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        final Stopwatch stopwatch = Stopwatch.createStarted();
        LogHelper.info("Post Initialization (Started)");


        LogHelper.info("Post Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onConfigChangedOnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {

        if (event.getModID().equalsIgnoreCase(ModInfo.MOD_ID)) {
            Config.loadConfiguration();
        }
    }
}
