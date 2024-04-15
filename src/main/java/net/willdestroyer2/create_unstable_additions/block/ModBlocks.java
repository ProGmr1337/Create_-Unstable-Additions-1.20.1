package net.willdestroyer2.create_unstable_additions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.willdestroyer2.create_unstable_additions.CreateUnstableAdditions;

public class ModBlocks {
    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(0,0)));

    public static final Block TIN_ORE = registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(0,0)));

    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE), UniformIntProvider.create(0,0)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CreateUnstableAdditions.MOD_ID, name), block );
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CreateUnstableAdditions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CreateUnstableAdditions.LOGGER.info("Registering ModBlocks for " + CreateUnstableAdditions.MOD_ID);
    }
}
