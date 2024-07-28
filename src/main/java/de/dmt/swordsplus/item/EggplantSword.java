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


public final class EggplantSword extends SwordItemBase {

    public EggplantSword() {
        super("eggplant_sword", ModMaterial.EGGPLANT_MATERIAL, new Item.Settings(), 2, -2.4F, ItemGroups.COMBAT);
    }
}
