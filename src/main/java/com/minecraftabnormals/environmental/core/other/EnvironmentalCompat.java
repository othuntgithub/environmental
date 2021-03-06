package com.minecraftabnormals.environmental.core.other;

import java.util.Arrays;

import com.minecraftabnormals.environmental.common.entity.DuckEggEntity;
import com.minecraftabnormals.environmental.common.entity.MudBallEntity;
import com.minecraftabnormals.environmental.core.Environmental;
import com.minecraftabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.minecraftabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.abnormals_core.core.registry.LootInjectionRegistry;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;

import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.registries.ForgeRegistries;

public class EnvironmentalCompat {
	
	public static final Item TURKEY_EGG = ForgeRegistries.ITEMS.getValue(new ResourceLocation("autumnity", "turkey_egg"));

	public static void registerLootInjectors() {
		LootInjectionRegistry.LootInjector injector = new LootInjectionRegistry.LootInjector(Environmental.MODID);
		injector.registerLootInjection(injector.buildLootPool("shipwreck_supply", 1, 0), LootTables.CHESTS_SHIPWRECK_SUPPLY);
		injector.registerLootInjection(injector.buildLootPool("simple_dungeon", 1, 0), LootTables.CHESTS_SIMPLE_DUNGEON);
	}
	
	public static void registerCompostables() {
		DataUtils.registerCompostable(EnvironmentalItems.YAK_HAIR.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.YAK_HAIR_BLOCK.get(), 0.85F);
		DataUtils.registerCompostable(EnvironmentalBlocks.YAK_HAIR_RUG.get(), 0.50F);

		DataUtils.registerCompostable(EnvironmentalBlocks.LARGE_LILY_PAD.get(), 0.85F);
		DataUtils.registerCompostable(EnvironmentalBlocks.GIANT_LILY_PAD.get(), 1.0F);

		DataUtils.registerCompostable(EnvironmentalBlocks.WILLOW_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WILLOW_SAPLING.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WILLOW_LEAF_CARPET.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.HANGING_WILLOW_LEAVES.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalBlocks.CHERRY_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CHERRY_SAPLING.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CHERRY_LEAF_CARPET.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalItems.CHERRIES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalItems.CHERRY_PIE.get(), 1.0F);
		DataUtils.registerCompostable(EnvironmentalItems.APPLE_PIE.get(), 1.0F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CHERRY_CRATE.get(), 1.0F);

		DataUtils.registerCompostable(EnvironmentalItems.RICE.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.RICE_SACK.get(), 1.0F);
		DataUtils.registerCompostable(EnvironmentalItems.CATTAIL_SEEDS.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL_SEED_SACK.get(), 1.0F);

		DataUtils.registerCompostable(EnvironmentalBlocks.DUCKWEED.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.TALL_CATTAIL.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.GIANT_TALL_GRASS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.MYCELIUM_SPROUTS.get(), 0.50F);

		DataUtils.registerCompostable(EnvironmentalBlocks.TWIG_NEST.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.HAY_NEST.get(), 0.65F);

		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL_THATCH.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL_THATCH_STAIRS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.CATTAIL_THATCH_VERTICAL_SLAB.get(), 0.65F);

		DataUtils.registerCompostable(EnvironmentalBlocks.DUCKWEED_THATCH.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.DUCKWEED_THATCH_STAIRS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.DUCKWEED_THATCH_VERTICAL_SLAB.get(), 0.65F);

		DataUtils.registerCompostable(EnvironmentalBlocks.GRASS_THATCH.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.GRASS_THATCH_SLAB.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.GRASS_THATCH_STAIRS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.GRASS_THATCH_VERTICAL_SLAB.get(), 0.65F);

		DataUtils.registerCompostable(EnvironmentalBlocks.BLUE_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_WISTERIA_LEAVES.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalBlocks.BLUE_HANGING_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_HANGING_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_HANGING_WISTERIA_LEAVES.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalBlocks.BLUE_WISTERIA_SAPLING.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_WISTERIA_SAPLING.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_WISTERIA_SAPLING.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_WISTERIA_SAPLING.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalBlocks.BLUE_WISTERIA_LEAF_CARPET.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_WISTERIA_LEAF_CARPET.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_WISTERIA_LEAF_CARPET.get(), 0.30F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_WISTERIA_LEAF_CARPET.get(), 0.30F);

		DataUtils.registerCompostable(EnvironmentalBlocks.CARTWHEEL.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.VIOLET.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.DIANTHUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.RED_LOTUS_FLOWER.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_LOTUS_FLOWER.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.BLUEBELL.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.YELLOW_HIBISCUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.ORANGE_HIBISCUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.RED_HIBISCUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_HIBISCUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.MAGENTA_HIBISCUS.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_HIBISCUS.get(), 0.65F);

		DataUtils.registerCompostable(EnvironmentalBlocks.BLUE_DELPHINIUM.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.WHITE_DELPHINIUM.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PINK_DELPHINIUM.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.PURPLE_DELPHINIUM.get(), 0.65F);
		DataUtils.registerCompostable(EnvironmentalBlocks.BIRD_OF_PARADISE.get(), 0.65F);
	}

	public static void registerFlammables() {
		DataUtils.registerFlammable(EnvironmentalBlocks.YAK_HAIR_BLOCK.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.YAK_HAIR_RUG.get(), 30, 60);

		DataUtils.registerFlammable(EnvironmentalBlocks.RICE_SACK.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.CATTAIL_SEED_SACK.get(), 30, 60);

		DataUtils.registerFlammable(EnvironmentalBlocks.GRASS_THATCH.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.GRASS_THATCH_STAIRS.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.GRASS_THATCH_SLAB.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.GRASS_THATCH_VERTICAL_SLAB.get(), 60, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.CATTAIL_THATCH.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CATTAIL_THATCH_STAIRS.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CATTAIL_THATCH_VERTICAL_SLAB.get(), 60, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.DUCKWEED_THATCH.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.DUCKWEED_THATCH_STAIRS.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.DUCKWEED_THATCH_VERTICAL_SLAB.get(), 60, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.TWIG_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.TWIG_CHICKEN_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.TWIG_DUCK_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.TWIG_TURKEY_NEST.get(), 60, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.HAY_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.HAY_CHICKEN_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.HAY_DUCK_NEST.get(), 60, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.HAY_TURKEY_NEST.get(), 60, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.CHICKEN_EGG_CRATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.DUCK_EGG_CRATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.TURTLE_EGG_CRATE.get(), 5, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.HANGING_WILLOW_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_WILLOW_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_WILLOW_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_STAIRS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_FENCE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_FENCE_GATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.VERTICAL_WILLOW_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_VERTICAL_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_BOOKSHELF.get(), 30, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WILLOW_BEEHIVE.get(), 5, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_CHERRY_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_CHERRY_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_STAIRS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_FENCE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_FENCE_GATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.VERTICAL_CHERRY_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_VERTICAL_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_BOOKSHELF.get(), 30, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_CRATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.CHERRY_BEEHIVE.get(), 5, 20);

		DataUtils.registerFlammable(EnvironmentalBlocks.GIANT_TALL_GRASS.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.MYCELIUM_SPROUTS.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.TALL_DEAD_BUSH.get(), 60, 100);

		DataUtils.registerFlammable(EnvironmentalBlocks.BLUE_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WHITE_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PINK_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PURPLE_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.BLUE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WHITE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PINK_HANGING_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_WISTERIA_LOG.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.STRIPPED_WISTERIA_WOOD.get(), 5, 5);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_STAIRS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_FENCE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_FENCE_GATE.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.BLUE_DELPHINIUM.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.WHITE_DELPHINIUM.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.PINK_DELPHINIUM.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.PURPLE_DELPHINIUM.get(), 60, 100);
		DataUtils.registerFlammable(EnvironmentalBlocks.VERTICAL_WISTERIA_PLANKS.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.BLUE_WISTERIA_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WHITE_WISTERIA_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PINK_WISTERIA_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.PURPLE_WISTERIA_LEAF_CARPET.get(), 30, 60);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_VERTICAL_SLAB.get(), 5, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_BOOKSHELF.get(), 30, 20);
		DataUtils.registerFlammable(EnvironmentalBlocks.WISTERIA_BEEHIVE.get(), 5, 20);
	}

	public static void registerDispenserBehaviors() {
		Environmental.REGISTRY_HELPER.processSpawnEggDispenseBehaviors();
		
		DispenserBlock.registerDispenseBehavior(EnvironmentalItems.DUCK_EGG.get(), new ProjectileDispenseBehavior() {
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				return new DuckEggEntity(worldIn, position.getX(), position.getY(), position.getZ());
			}
		});

		DispenserBlock.registerDispenseBehavior(EnvironmentalItems.MUD_BALL.get(), new ProjectileDispenseBehavior() {
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				return new MudBallEntity(worldIn, position.getX(), position.getY(), position.getZ());
			}
		});

		DispenserBlock.registerDispenseBehavior(EnvironmentalItems.SLABFISH_BUCKET.get(), new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				BucketItem bucket = (BucketItem) stack.getItem();
				BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
				World world = source.getWorld();

				if (bucket.tryPlaceContainedLiquid(null, world, pos, null)) {
					bucket.onLiquidPlaced(world, stack, pos);
					return new ItemStack(Items.BUCKET);
				} else {
					return super.dispense(source, stack);
				}
			}
		});
	}
	


	public static void setRenderLayers() {
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.SLABFISH_EFFIGY.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.ICE_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.ICE_CHAIN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.SAWMILL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.TALL_DEAD_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.YAK_HAIR_BLOCK.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.YAK_HAIR_RUG.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_LADDER.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.HANGING_WILLOW_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WILLOW_SAPLING.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_LADDER.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CHERRY_SAPLING.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.MYCELIUM_SPROUTS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GIANT_TALL_GRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.LARGE_LILY_PAD.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GIANT_LILY_PAD.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL_SPROUTS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.TALL_CATTAIL.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GRASS_THATCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GRASS_THATCH_SLAB.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GRASS_THATCH_STAIRS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.GRASS_THATCH_VERTICAL_SLAB.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL_THATCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL_THATCH_STAIRS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CATTAIL_THATCH_VERTICAL_SLAB.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DUCKWEED_THATCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DUCKWEED_THATCH_STAIRS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DUCKWEED_THATCH_VERTICAL_SLAB.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.CARTWHEEL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.VIOLET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.RED_LOTUS_FLOWER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_LOTUS_FLOWER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DIANTHUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUEBELL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.YELLOW_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.ORANGE_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.RED_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.MAGENTA_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_HIBISCUS.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_CARTWHEEL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_VIOLET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_RED_LOTUS_FLOWER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_WHITE_LOTUS_FLOWER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_DIANTHUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_BLUEBELL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_YELLOW_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_ORANGE_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_RED_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PINK_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_MAGENTA_HIBISCUS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PURPLE_HIBISCUS.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.RICE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.TALL_RICE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.DUCKWEED.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_CATTAIL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_WILLOW_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WISTERIA_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WISTERIA_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WISTERIA_LADDER.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUE_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BIRD_OF_PARADISE.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_WHITE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_BLUE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PINK_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PURPLE_DELPHINIUM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_BIRD_OF_PARADISE.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_HANGING_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUE_HANGING_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_HANGING_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get(), RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.WHITE_WISTERIA_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.BLUE_WISTERIA_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PINK_WISTERIA_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.PURPLE_WISTERIA_SAPLING.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_WHITE_WISTERIA_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_BLUE_WISTERIA_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PINK_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(EnvironmentalBlocks.POTTED_PURPLE_WISTERIA_SAPLING.get(), RenderType.getCutout());
	}

	public static void registerBlockColors() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.get(0.5D, 1.0D), Arrays.asList(EnvironmentalBlocks.GIANT_TALL_GRASS));
		DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.get(0.5D, 1.0D), Arrays.asList(EnvironmentalBlocks.WILLOW_LEAVES, EnvironmentalBlocks.WILLOW_LEAF_CARPET, EnvironmentalBlocks.HANGING_WILLOW_LEAVES));

		DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? 2129968 : 7455580, Arrays.asList(EnvironmentalBlocks.LARGE_LILY_PAD, EnvironmentalBlocks.GIANT_LILY_PAD));

		DataUtils.registerBlockItemColor(itemColors, (p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().getDefaultState();
			return blockColors.getColor(blockstate, (IBlockDisplayReader) null, (BlockPos) null, p_210235_2_);
		}, Arrays.asList(EnvironmentalBlocks.LARGE_LILY_PAD, EnvironmentalBlocks.GIANT_LILY_PAD));

		DataUtils.registerBlockItemColor(itemColors, (color, items) -> GrassColors.get(0.5D, 1.0D), Arrays.asList(EnvironmentalBlocks.GIANT_TALL_GRASS));
		DataUtils.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.get(0.5D, 1.0D), Arrays.asList(EnvironmentalBlocks.WILLOW_LEAVES, EnvironmentalBlocks.WILLOW_LEAF_CARPET, EnvironmentalBlocks.HANGING_WILLOW_LEAVES));
	}
}
