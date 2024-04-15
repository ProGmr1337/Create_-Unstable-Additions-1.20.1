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

import static net.willdestroyer2.create_unstable_additions.block.ModBlocks.URANIUM_ORE;

public class ModItems {
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
    public static final Item REDSTONE_INGOT = registerItem("redstone_ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
    public static final Item REACTOR_INGOT = registerItem("reactor_ingot", new Item(new FabricItemSettings()));
    public static final Item COPPER_SPOOL = registerItem("copper_spool", new Item(new FabricItemSettings()));
    public static final Item COPPER_WIRE = registerItem("copper_wire", new Item(new FabricItemSettings()));
    public static final Item EMPTY_SPOOL = registerItem("empty_spool", new Item(new FabricItemSettings()));
    public static final Item IRON_ROD = registerItem("iron_rod", new Item(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new FabricItemSettings()));
    public static final Item INERT_URANIUM = registerItem("inert_uranium", new Item(new FabricItemSettings()));
    public static final Item REFINED_URANIUM = registerItem("refined_uranium", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN_INGOT);
        entries.add(RAW_TIN);
        entries.add(REDSTONE_INGOT);
        entries.add(BRONZE_INGOT);
        entries.add(REACTOR_INGOT);
        entries.add(COPPER_SPOOL);
        entries.add(EMPTY_SPOOL);
        entries.add(COPPER_WIRE);
        entries.add(IRON_ROD);
        entries.add(RAW_URANIUM);
        entries.add(INERT_URANIUM);
        entries.add(REFINED_URANIUM);
        entries.add(URANIUM_ORE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateUnstableAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateUnstableAdditions.LOGGER.info("Registering Mod Items for " + CreateUnstableAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
