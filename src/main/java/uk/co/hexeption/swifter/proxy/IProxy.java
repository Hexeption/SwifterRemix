package uk.co.hexeption.swifter.proxy;

import java.io.File;

public interface IProxy {

    void registerBlocks();

    void registerItems();

    void registerFurnaceRecipes();

    void registerCraftingRecipes();

    void registerEvents();

    void registerRenderers();

    void registerConfiguration(File configFile);
}
