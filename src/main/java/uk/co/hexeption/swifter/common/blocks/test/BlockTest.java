package uk.co.hexeption.swifter.common.blocks.test;

import net.minecraft.block.material.Material;
import uk.co.hexeption.swifter.SwifterCreativeTabs;
import uk.co.hexeption.swifter.common.blocks.BlockBase;

public class BlockTest extends BlockBase {

    public BlockTest() {

        super(Material.ROCK, "test/testblock");
        this.setCreativeTab(SwifterCreativeTabs.tabGeneral);
        this.setInternalName("test_block");
    }


}
