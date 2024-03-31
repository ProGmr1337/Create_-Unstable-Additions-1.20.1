package net.willdestroyer2.create_unstable_additions.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.willdestroyer2.create_unstable_additions.CreateUnstableAdditions;

public class ModItems {
    public static final Item TIN = registerItem("tin-ingot", new Item(new FabricItemSettings()));
    public static final Item REDSTONE_INGOT = registerItem("redstone-ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze-ingot", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN);
        entries.add(REDSTONE_INGOT);
        entries.add(BRONZE_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateUnstableAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateUnstableAdditions.LOGGER.info("Registering Mod Items for " + CreateUnstableAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
