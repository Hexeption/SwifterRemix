package uk.co.hexeption.swifter.common.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.hexeption.swifter.ModInfo;
import uk.co.hexeption.swifter.common.blocks.BlockBase;

import java.util.Locale;

public class RegistationHelper {

    /**
     * Register a Block with out a ItemBlock
     *
     * @param blockClass
     * @return Registered Block with out a Item
     */
    public static Block registerBlock(Class<? extends Block> blockClass) {

        return registerBlock(blockClass, ItemBlock.class);
    }

    /**
     * Register a Blocks with also a ItemBlock
     *
     * @param blockClass
     * @param itemBlockClass
     * @return Registered Block
     */
    public static Block registerBlock(Class<? extends Block> blockClass, Class<? extends ItemBlock> itemBlockClass) {

        Block block = null;
        ItemBlock itemBlock;
        String internalName;

        try {

            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);

            internalName = ((BlockBase) block).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName));
            }

            if (internalName.isEmpty()) {
                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", blockClass.getCanonicalName()));
            }

            block.setRegistryName(ModInfo.MOD_ID, internalName);
            block.setUnlocalizedName(internalName);
            itemBlock.setRegistryName(block.getRegistryName());

            GameRegistry.register(block);
            GameRegistry.register(itemBlock);

            if (block instanceof IBlockRenderer && Platfrom.isClient()) {
                ((BlockBase) block).registerBlockItemRenderer();
                ((BlockBase) block).registerBlockRenderer();
            }

            LogHelper.info(String.format("Registered block (%s)", blockClass.getCanonicalName()));
        } catch (Exception e) {
            LogHelper.fatal(String.format("Fatal Error while registering block (%s)", blockClass.getCanonicalName()));
            e.printStackTrace();
        }

        return block;
    }

    /**
     * TODO:
     */

    /**
     * Register a Items
     *
     * @param itemClass
     * @return Registered Item
     */
    public static Item registerItem(Class<? extends Item> itemClass) {

        return Item.getItemById(2);
    }

}
