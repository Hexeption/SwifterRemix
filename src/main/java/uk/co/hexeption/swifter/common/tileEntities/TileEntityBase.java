package uk.co.hexeption.swifter.common.tileEntities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityBase extends TileEntity {

    /**
     * TODO:
     */

    private String customName;

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean hasCustomName() {

        return (this.customName != null) && (this.customName.length() > 0);
    }
}
