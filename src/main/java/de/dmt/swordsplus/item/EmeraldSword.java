package de.dmt.swordsplus.item;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;


public final class EmeraldSword extends ItemBase implements ToolMaterial {

    public EmeraldSword() {
        super("emerald_sword", new Item.Settings(), ItemGroups.COMBAT);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.of(""));
        tooltip.add(Text.of("When in Main Hand:").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.of(" 7 Attack Damage").copy().formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.of(" 1.6 Attack Speed").copy().formatted(Formatting.DARK_GREEN));
    }

    @Override
    public int getDurability() {
        return 1754;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.0F;
    }

    @Override
    public float getAttackDamage() {
        return 7.0F;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(this, Items.EMERALD);
    }
}
