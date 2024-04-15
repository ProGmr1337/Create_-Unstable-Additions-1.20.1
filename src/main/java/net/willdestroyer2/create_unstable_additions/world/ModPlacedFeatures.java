package net.willdestroyer2.create_unstable_additions.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.willdestroyer2.create_unstable_additions.CreateUnstableAdditions;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registryKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registryKey("uranium_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, //Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-65), YOffset.fixed(165))));
        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, //Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-90), YOffset.fixed(-5))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CreateUnstableAdditions.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
