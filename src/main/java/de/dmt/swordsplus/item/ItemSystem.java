package de.dmt.swordsplus.item;

import de.dmt.swordsplus.Log;
import de.dmt.swordsplus.system.SystemBase;

import java.util.List;

public class ItemSystem extends SystemBase {

    public final List<ItemBase> items = List.of(
            new AmethystSword(),
            new EmeraldSword()
    );

    public ItemSystem() {
        super("Items");
    }

    @Override
    public void doInitialize() {
        for (ItemBase itemBase : items) {
            Log.infof("Registering item: %s", itemBase.identifier.toString());
            itemBase.register();
        }
    }
}
