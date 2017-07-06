package uk.co.hexeption.swifter.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import uk.co.hexeption.swifter.common.blocks.test.BlockTest;
import uk.co.hexeption.swifter.common.utils.RegistationHelper;

public enum Blocks {

    TEST_BLOCK(BlockTest.class);

    private final Class<? extends BlockBase> blockClass;

    private final Class<? extends ItemBlock> itemBlockClass;

    private Block block;

    Blocks(Class<? extends BlockBase> blockClass) {

        this(blockClass, ItemBlock.class);
    }

    Blocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass) {

        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    public static void registerBlocks() {

        for (Blocks blocks : Blocks.values()) {
            blocks.registerBlock();
        }
    }

    private void registerBlock() {

        block = RegistationHelper.registerBlock(blockClass, itemBlockClass);
    }
}
