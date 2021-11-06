package dariomegaganzo.colzimod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.impl.object.builder.BlockSettingsInternals;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColziMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");

	public static final ColziItem COLZI = new ColziItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final ColziteIngotItem COLZITE_INGOT = new ColziteIngotItem(new FabricItemSettings().group(ItemGroup.MATERIALS));
	public static final Block COLZITE_ORE = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));


	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzi"), COLZI);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_ingot"), COLZITE_INGOT);
		Registry.register(Registry.BLOCK, new Identifier("colzimod", "colzite_ore"), COLZITE_ORE);
	}
}
