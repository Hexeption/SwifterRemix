package uk.co.hexeption.swifter.common.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import uk.co.hexeption.swifter.common.utils.IBlockRenderer;

public abstract class BlockTileBase extends BlockBase implements ITileEntityProvider, IBlockRenderer {

    protected BlockTileBase(Material material, String resourcePath) {

        super(material, resourcePath);
    }
}
