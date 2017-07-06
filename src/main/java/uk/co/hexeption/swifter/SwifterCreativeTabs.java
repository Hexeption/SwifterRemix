package uk.co.hexeption.swifter;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SwifterCreativeTabs {

    public static final CreativeTabs tabGeneral = new CreativeTabs(ModInfo.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {

            return Items.ARROW.getDefaultInstance();
        }

        @Override
        public String getTabLabel() {

            return ModInfo.MOD_ID + ".general";
        }
    };

}
