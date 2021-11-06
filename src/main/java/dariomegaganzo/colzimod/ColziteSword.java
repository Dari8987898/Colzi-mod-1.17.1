package dariomegaganzo.colzimod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ColziteSword implements ToolMaterial{

    public static final ColziteSword INSTANCE = new ColziteSword();
    
    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0.0F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 19;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }


}
