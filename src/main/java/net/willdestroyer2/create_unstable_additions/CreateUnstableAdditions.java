package net.willdestroyer2.create_unstable_additions;

import net.fabricmc.api.ModInitializer;

import net.willdestroyer2.create_unstable_additions.block.ModBlocks;
import net.willdestroyer2.create_unstable_additions.item.ModItems;
import net.willdestroyer2.create_unstable_additions.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUnstableAdditions implements ModInitializer {
public static final String MOD_ID = "create-unstable-additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}