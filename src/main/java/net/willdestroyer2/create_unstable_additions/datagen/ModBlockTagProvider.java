package net.willdestroyer2.create_unstable_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.willdestroyer2.create_unstable_additions.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.URANIUM_ORE)
            .add(ModBlocks.TIN_ORE)
            .add(ModBlocks.DEEPSLATE_TIN_ORE);

    getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
    ;

    getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
    ;

    getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
    ;

    getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
    ;

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.TIN_ORE)
            .add(ModBlocks.DEEPSLATE_TIN_ORE)
            .add(ModBlocks.URANIUM_ORE);

    getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
    }
}
