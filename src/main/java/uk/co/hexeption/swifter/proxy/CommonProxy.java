package uk.co.hexeption.swifter.proxy;

import uk.co.hexeption.swifter.common.blocks.Blocks;

import java.io.File;

public class CommonProxy implements IProxy {

    @Override
    public void registerBlocks() {

        Blocks.registerBlocks();
    }

    @Override
    public void registerItems() {

    }

    @Override
    public void registerFurnaceRecipes() {

    }

    @Override
    public void registerCraftingRecipes() {

    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerRenderers() {

    }

    @Override
    public void registerConfiguration(File configFile) {

    }
}
