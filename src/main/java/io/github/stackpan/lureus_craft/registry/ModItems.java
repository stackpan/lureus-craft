package io.github.stackpan.lureus_craft.registry;

import io.github.stackpan.lureus_craft.LureusCraft;
import io.github.stackpan.lureus_craft.component.type.ModFoodComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item NASI_PADANG;

    static {
        NASI_PADANG = register("nasi_padang", Item::new, (new Item.Settings()).maxCount(1).food(ModFoodComponents.NASI_PADANG).useRemainder(Items.BOWL));
    }

    public static Item register(String id, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        var itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LureusCraft.MOD_ID, id));

        var item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {}

}
