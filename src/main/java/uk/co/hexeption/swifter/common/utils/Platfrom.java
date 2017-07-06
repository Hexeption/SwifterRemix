package uk.co.hexeption.swifter.common.utils;

import net.minecraft.block.properties.IProperty;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Map;

public class Platfrom {

    /**
     * Checks if the code is running on a client.
     *
     * @return True if running on a client
     */
    public static boolean isClient() {

        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    /**
     * Checks if the code is running on a server.
     *
     * @return True if running on a server
     */
    public static boolean isServer() {

        return FMLCommonHandler.instance().getEffectiveSide().isServer();

    }

    /**
     * Checks if the code is running in a IDE
     *
     * @return True if running in a dev environment
     */
    public static boolean isDev() {

        return (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
    }


    public static String getPropertyString(Map<IProperty<?>, Comparable<?>> values, String... extrasArgs) {

        StringBuilder stringbuilder = new StringBuilder();

        for (Map.Entry<IProperty<?>, Comparable<?>> entry : values.entrySet()) {
            if (stringbuilder.length() != 0) {
                stringbuilder.append(",");
            }

            IProperty<?> iproperty = (IProperty) entry.getKey();
            stringbuilder.append(iproperty.getName());
            stringbuilder.append("=");
            stringbuilder.append(getPropertyName(iproperty, (Comparable) entry.getValue()));
        }

        if (stringbuilder.length() == 0) {
            stringbuilder.append("inventory");
        }

        for (String args : extrasArgs) {
            if (stringbuilder.length() != 0)
                stringbuilder.append(",");
            stringbuilder.append(args);
        }

        return stringbuilder.toString();
    }

    private static <T extends Comparable<T>> String getPropertyName(IProperty<T> p_187489_1_, Comparable<?> p_187489_2_) {

        return p_187489_1_.getName((T) p_187489_2_);
    }
}
