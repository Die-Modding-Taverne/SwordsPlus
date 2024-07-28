package de.dmt.swordsplus.item.material;

import de.dmt.swordsplus.system.ItemSystem;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class EmeraldMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1769;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.5F;
    }

    @Override
    public float getAttackDamage() {
        return 3.5F;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemSystem.EMERALD_SWORD, Items.EMERALD);
    }
}
