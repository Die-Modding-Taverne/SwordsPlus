package de.dmt.swordsplus.item;

import de.dmt.swordsplus.item.base.ItemBase;
import de.dmt.swordsplus.item.base.SwordItemBase;
import de.dmt.swordsplus.item.material.ModMaterial;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;


public final class EmeraldSword extends SwordItemBase {

    public EmeraldSword() {
        super("emerald_sword", ModMaterial.EMERALD_MATERIAL, new Item.Settings(), 3, -2.4F, ItemGroups.COMBAT);
    }
}
