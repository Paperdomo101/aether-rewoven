package paperdomo101.aether_rewoven.item;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

public enum AetherToolMaterials implements ToolMaterial {
    
    SKYROOT(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    HOLYSTONE(1, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(AetherBlocks.HOLYSTONE);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private AetherToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    public int getDurability() {
       return this.itemDurability;
    }
 
    public float getMiningSpeedMultiplier() {
       return this.miningSpeed;
    }
 
    public float getAttackDamage() {
       return this.attackDamage;
    }
 
    public int getMiningLevel() {
       return this.miningLevel;
    }
 
    public int getEnchantability() {
       return this.enchantability;
    }
 
    public Ingredient getRepairIngredient() {
       return (Ingredient)this.repairIngredient.get();
    }
}