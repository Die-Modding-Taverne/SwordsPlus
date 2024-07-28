package de.dmt.swordsplus.system;

import de.dmt.swordsplus.Log;
import de.dmt.swordsplus.item.AmethystSword;
import de.dmt.swordsplus.item.EggplantSword;
import de.dmt.swordsplus.item.EmeraldSword;
import de.dmt.swordsplus.item.base.ItemBase;
import de.dmt.swordsplus.item.base.SwordItemBase;
import de.dmt.swordsplus.system.SystemBase;
import net.minecraft.item.SwordItem;

import java.util.List;

public class ItemSystem extends SystemBase {

    public final static AmethystSword AMETHYST_SWORD = new AmethystSword();
    public final static EmeraldSword EMERALD_SWORD = new EmeraldSword();
    public final static EggplantSword EGGPLANT_SWORD = new EggplantSword();

    public final static List<ItemBase> ITEMS = List.of();
    public final static List<SwordItemBase> SWORD_ITEMS = List.of(AMETHYST_SWORD, EMERALD_SWORD, EGGPLANT_SWORD);

    public ItemSystem() {
        super("Items");
    }

    @Override
    public void doInitialize() {
        for (ItemBase item : ITEMS) {
            Log.infof("Registering item: \"%s\"", item.identifier.toString());
            item.register();
        }

        for (SwordItemBase swordItem : SWORD_ITEMS) {
            Log.infof("Registering item: \"%s\"", swordItem.identifier.toString());
            swordItem.register();
        }
    }
}
