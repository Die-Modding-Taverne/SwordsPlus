package de.dmt.swordsplus.item;

import de.dmt.swordsplus.Log;
import de.dmt.swordsplus.Swordsplus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class ItemBase {

    public final String id;
    public final Item item;
    public final RegistryKey<ItemGroup> itemGroup;
    public final Identifier identifier;
    private Item registeredItem;

    public ItemBase(String id, Item item, RegistryKey<ItemGroup> itemGroup) {
        this.id = id;
        this.item = item;
        this.itemGroup = itemGroup;
        this.identifier = Identifier.of(Swordsplus.MOD_ID, id);
        this.registeredItem = null;
    }

    public void register() {
        if(registeredItem != null) {
            Log.warning("Tried to register Item: " + identifier.toString() + " multiple times || IGNORING");
            return;
        }

        this.registeredItem = Registry.register(Registries.ITEM, identifier, item);
        registerEvents();
    }

    private void registerEvents() {
        if(registeredItem != null) {
            Log.warning("Tried to register Events for Item: " + identifier.toString() + " before registering the Item itself");
            return;
        }

        ItemGroupEvents.modifyEntriesEvent(itemGroup).register((itemGroup) -> itemGroup.add(registeredItem));
    }

    public Optional<Item> getRegisteredItem() {
        return Optional.ofNullable(registeredItem);
    }
}
