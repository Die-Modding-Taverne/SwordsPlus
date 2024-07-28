package de.dmt.swordsplus.item.base;

import de.dmt.swordsplus.Log;
import de.dmt.swordsplus.Swordsplus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class SwordItemBase extends SwordItem {

    public final String id;
    public final RegistryKey<ItemGroup> itemGroup;
    public final Identifier identifier;

    private Item registeredItem;

    public SwordItemBase(String id, ToolMaterial toolMaterial, Item.Settings settings, int baseDamage, float attackSpeed, RegistryKey<ItemGroup> itemGroup) {
        super(toolMaterial, settings.attributeModifiers(SwordItem.createAttributeModifiers(toolMaterial, baseDamage, attackSpeed)));

        this.id = id;
        this.itemGroup = itemGroup;
        this.identifier = Identifier.of(Swordsplus.MOD_ID, id);

        this.registeredItem = null;
    }

    public void register() {
        if(registeredItem != null) {
            Log.warnf("Tried to register Item \"%s\" multiple times. Ignoring...", identifier.toString());
            return;
        }

        this.registeredItem = Registry.register(Registries.ITEM, identifier, this);
        registerEvents();
    }

    private void registerEvents() {
        if(registeredItem == null) {
            Log.warnf("Tried to register Events for Item \"%s\" before registering the Item itself. Ignoring...", identifier.toString());
            return;
        }

        ItemGroupEvents.modifyEntriesEvent(itemGroup).register((itemGroup) -> itemGroup.add(registeredItem));
    }

    public Optional<Item> getRegisteredItem() {
        return Optional.ofNullable(registeredItem);
    }
}
