package dariomegaganzo.colzimod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
	public static final ColziteIngotItem COLZITEINGOT = new ColziteIngotItem(new FabricItemSettings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzi"), COLZI);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_ingot"), COLZITEINGOT);
	}
}
