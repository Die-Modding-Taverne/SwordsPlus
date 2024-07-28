package de.dmt.swordsplus.item.material;

import de.dmt.swordsplus.system.ItemSystem;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class AmethystMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 205;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.5F;
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemSystem.AMETHYST_SWORD, Items.AMETHYST_SHARD);
    }
}
