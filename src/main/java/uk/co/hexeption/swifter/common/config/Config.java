package uk.co.hexeption.swifter.common.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import scala.actors.threadpool.Arrays;
import uk.co.hexeption.swifter.ModInfo;
import uk.co.hexeption.swifter.Swifter;

import java.io.File;

public class Config extends GuiConfig {

    public static Configuration configuration;

    public Config(GuiScreen parentScreen) {

        super(parentScreen, Arrays.asList(new IConfigElement[]{
                new ConfigElement(Swifter.configuration.getCategory("TestData"))
        }), ModInfo.MOD_ID, false, false, ModInfo.MOD_NAME + " Configuration");
        titleLine2 = Swifter.configuration.getConfigFile().getAbsolutePath();
    }

    public static Configuration intiConfig(File configFile) {

        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

        return configuration;
    }

    public static void loadConfiguration() {

        ConfigTest.init(configuration);

        configuration.save();
    }


}
