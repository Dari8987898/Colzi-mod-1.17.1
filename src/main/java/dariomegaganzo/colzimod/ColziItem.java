package dariomegaganzo.colzimod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ColziItem extends Item implements ToolMaterial {
    
    public static final ColziItem INSTANCE = new ColziItem(new FabricItemSettings().group(ItemGroup.MISC));

    public ColziItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getDurability() {
        return 3069;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 16.9F;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(this.INSTANCE);
    }

    
}
