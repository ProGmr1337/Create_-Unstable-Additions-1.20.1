package net.willdestroyer2.create_unstable_additions;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.willdestroyer2.create_unstable_additions.datagen.ModBlockTagProvider;
import net.willdestroyer2.create_unstable_additions.datagen.ModItemTagProvider;
import net.willdestroyer2.create_unstable_additions.datagen.ModLootTableProvider;
import net.willdestroyer2.create_unstable_additions.datagen.ModWorldGenerator;
import net.willdestroyer2.create_unstable_additions.world.ModConfiguredFeatures;
import net.willdestroyer2.create_unstable_additions.world.ModPlacedFeatures;

public class CreateUnstableAdditionsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModWorldGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
