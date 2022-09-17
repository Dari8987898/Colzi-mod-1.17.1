package dariomegaganzo.colzimod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColziMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("ColziMod");

	//ITEMS
	public static final ColziItem COLZI = new ColziItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final ColziteIngot COLZITE_INGOT = new ColziteIngot(new FabricItemSettings().group(ItemGroup.MATERIALS));
	//tools
	public static ToolItem COLZITE_SWORD = new SwordItem(ColziItem.INSTANCE, 8, -1.8F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem COLZITE_PICKAXE = new ColzitePickaxe(ColziItem.INSTANCE, 6, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem COLZITE_SHOVEL = new ColziteShovel(ColziItem.INSTANCE, 4, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem COLZITE_AXE = new ColziteAxe(ColziItem.INSTANCE, 10, -3F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem COLZITE_HOE = new ColziteHoe(ColziItem.INSTANCE, 0, 1F, new Item.Settings().group(ItemGroup.TOOLS));

	//BLOCKS
	public static final Block COLZITE_ORE = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());

	//WORLD GENERATION
	private static ConfiguredFeature<?, ?> COLZITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, COLZITE_ORE.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0),YOffset.fixed(64)))).spreadHorizontally().repeat(10));

	@Override
	public void onInitialize() {
		//ITEMS
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzi"), COLZI);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_ingot"), COLZITE_INGOT);
		//tools
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_sword"), COLZITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_pickaxe"), COLZITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_shovel"), COLZITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_axe"), COLZITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_hoe"), COLZITE_HOE);

		//BLOCKS
		Registry.register(Registry.BLOCK, new Identifier("colzimod", "colzite_ore"), COLZITE_ORE);
		Registry.register(Registry.ITEM, new Identifier("colzimod", "colzite_ore"), new BlockItem(COLZITE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		//WORLD GENERATION
		RegistryKey<ConfiguredFeature<?, ?>> colziteOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("colzimod", "colzite_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, colziteOreOverworld.getValue(), COLZITE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, colziteOreOverworld);
	}
}
