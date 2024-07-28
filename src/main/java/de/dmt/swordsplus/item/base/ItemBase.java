package de.dmt.swordsplus.item.base;

import de.dmt.swordsplus.Log;
import de.dmt.swordsplus.Swordsplus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import javax.tools.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class ItemBase extends Item {

    public final String id;
    public final RegistryKey<ItemGroup> itemGroup;
    public final Identifier identifier;

    private Item registeredItem;

    public ItemBase(String id, Item.Settings settings, RegistryKey<ItemGroup> itemGroup) {
        super(settings);

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
