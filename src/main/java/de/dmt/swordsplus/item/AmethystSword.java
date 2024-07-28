package de.dmt.swordsplus.item;

import de.dmt.swordsplus.item.base.ItemBase;
import de.dmt.swordsplus.item.base.SwordItemBase;
import de.dmt.swordsplus.item.material.ModMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;


public final class AmethystSword extends SwordItemBase {

    public AmethystSword() {
        super("amethyst_sword", ModMaterial.AMETHYST_MATERIAL, new Item.Settings(), 3, -2.4F, ItemGroups.COMBAT);
    }
}
