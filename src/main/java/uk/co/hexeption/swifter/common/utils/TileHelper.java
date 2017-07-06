package uk.co.hexeption.swifter.common.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

public class TileHelper {

    @Nullable
    public static <T> T getTileEntity(IBlockAccess world, BlockPos blockPos, Class<T> clazz) {

        TileEntity tileEntity = world.getTileEntity(blockPos);
        return !clazz.isInstance(tileEntity) ? null : (T) tileEntity;
    }

}
