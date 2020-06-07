package shadows.apotheosis;

import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.registries.ObjectHolder;
import shadows.apotheosis.ench.altar.BlockPrismaticAltar;
import shadows.apotheosis.ench.altar.TilePrismaticAltar;
import shadows.apotheosis.ench.anvil.EnchantmentSplitting;
import shadows.apotheosis.ench.anvil.TileAnvil;
import shadows.apotheosis.ench.enchantments.EnchantmentBerserk;
import shadows.apotheosis.ench.enchantments.EnchantmentDepths;
import shadows.apotheosis.ench.enchantments.EnchantmentHellInfused;
import shadows.apotheosis.ench.enchantments.EnchantmentIcyThorns;
import shadows.apotheosis.ench.enchantments.EnchantmentKnowledge;
import shadows.apotheosis.ench.enchantments.EnchantmentLifeMend;
import shadows.apotheosis.ench.enchantments.EnchantmentMagicProt;
import shadows.apotheosis.ench.enchantments.EnchantmentMounted;
import shadows.apotheosis.ench.enchantments.EnchantmentNatureBless;
import shadows.apotheosis.ench.enchantments.EnchantmentRebounding;
import shadows.apotheosis.ench.enchantments.EnchantmentReflective;
import shadows.apotheosis.ench.enchantments.EnchantmentScavenger;
import shadows.apotheosis.ench.enchantments.EnchantmentShieldBash;
import shadows.apotheosis.ench.enchantments.EnchantmentStableFooting;
import shadows.apotheosis.ench.enchantments.EnchantmentTempting;
import shadows.apotheosis.ench.objects.BlockHellBookshelf;
import shadows.apotheosis.ench.objects.ItemScrapTome;
import shadows.apotheosis.ench.objects.ItemTypedBook;
import shadows.apotheosis.ench.table.EnchantingTableTileEntityExt;
import shadows.apotheosis.ench.table.EnchantmentContainerExt;
import shadows.apotheosis.garden.EnderLeashItem;
import shadows.apotheosis.potion.EnchantmentTrueInfinity;
import shadows.apotheosis.potion.InvisCharmItem;
import shadows.apotheosis.potion.ItemLuckyFoot;
import shadows.apotheosis.potion.potions.KnowledgeEffect;
import shadows.apotheosis.potion.potions.PotionSundering;
import shadows.apotheosis.spawn.enchantment.EnchantmentCapturing;
import shadows.apotheosis.village.fletching.FletchingContainer;
import shadows.apotheosis.village.fletching.arrows.BroadheadArrowEntity;
import shadows.apotheosis.village.fletching.arrows.BroadheadArrowItem;
import shadows.apotheosis.village.fletching.arrows.ObsidianArrowEntity;
import shadows.apotheosis.village.fletching.arrows.ObsidianArrowItem;

@ObjectHolder(Apotheosis.MODID)
public class ApotheosisObjects {
	public static final BlockHellBookshelf HELLSHELF = null;
	public static final Item PRISMATIC_WEB = null;
	public static final EnchantmentHellInfused HELL_INFUSION = null;
	public static final EnchantmentMounted MOUNTED_STRIKE = null;
	public static final EnchantmentDepths DEPTH_MINER = null;
	public static final EnchantmentStableFooting STABLE_FOOTING = null;
	public static final EnchantmentScavenger SCAVENGER = null;
	public static final EnchantmentLifeMend LIFE_MENDING = null;
	public static final EnchantmentIcyThorns ICY_THORNS = null;
	public static final EnchantmentTempting TEMPTING = null;
	public static final EnchantmentShieldBash SHIELD_BASH = null;
	public static final EnchantmentReflective REFLECTIVE = null;
	public static final EnchantmentBerserk BERSERK = null;
	public static final EnchantmentCapturing CAPTURING = null;
	public static final EnchantmentTrueInfinity TRUE_INFINITY = null;
	public static final Potion RESISTANCE = null;
	public static final Potion LONG_RESISTANCE = null;
	public static final Potion STRONG_RESISTANCE = null;
	public static final Potion ABSORPTION = null;
	public static final Potion LONG_ABSORPTION = null;
	public static final Potion STRONG_ABSORPTION = null;
	public static final Potion HASTE = null;
	public static final Potion LONG_HASTE = null;
	public static final Potion STRONG_HASTE = null;
	public static final Potion FATIGUE = null;
	public static final Potion LONG_FATIGUE = null;
	public static final Potion STRONG_FATIGUE = null;
	@ObjectHolder("witherskelefix:fragment")
	public static final Item SKULL_FRAGMENT = null;
	public static final Potion WITHER = null;
	public static final Potion LONG_WITHER = null;
	public static final Potion STRONG_WITHER = null;
	public static final PotionSundering SUNDERING = null;
	@ObjectHolder("apotheosis:sundering")
	public static final Potion T_SUNDERING = null;
	public static final Potion LONG_SUNDERING = null;
	public static final Potion STRONG_SUNDERING = null;
	public static final EnchantmentKnowledge KNOWLEDGE = null;
	public static final EnchantmentSplitting SPLITTING = null;
	public static final EnchantmentNatureBless NATURES_BLESSING = null;
	public static final EnchantmentRebounding REBOUNDING = null;
	public static final ItemTypedBook NULL_BOOK = null;
	public static final ItemTypedBook ARMOR_HEAD_BOOK = null;
	public static final ItemTypedBook ARMOR_CHEST_BOOK = null;
	public static final ItemTypedBook ARMOR_LEGS_BOOK = null;
	public static final ItemTypedBook ARMOR_FEET_BOOK = null;
	public static final ItemTypedBook WEAPON_BOOK = null;
	public static final ItemTypedBook DIGGER_BOOK = null;
	public static final ItemTypedBook FISHING_ROD_BOOK = null;
	public static final ItemTypedBook BOW_BOOK = null;
	public static final BlockPrismaticAltar PRISMATIC_ALTAR = null;
	public static final SoundEvent ALTAR_SOUND = null;
	@ObjectHolder("apotheosis:knowledge")
	public static final KnowledgeEffect P_KNOWLEDGE = null;
	@ObjectHolder("apotheosis:knowledge")
	public static final Potion T_KNOWLEDGE = null;
	public static final Potion LONG_KNOWLEDGE = null;
	public static final Potion STRONG_KNOWLEDGE = null;
	public static final ItemLuckyFoot LUCKY_FOOT = null;
	public static final EnchantmentMagicProt MAGIC_PROTECTION = null;
	public static final ItemScrapTome SCRAP_TOME = null;
	public static final EnderLeashItem FARMERS_LEASH = null;
	public static final TileEntityType<TileAnvil> ANVIL = null;
	@ObjectHolder("apotheosis:prismatic_altar")
	public static final TileEntityType<TilePrismaticAltar> ALTAR_TYPE = null;
	public static final ContainerType<FletchingContainer> FLETCHING = null;
	public static final ObsidianArrowItem OBSIDIAN_ARROW = null;
	public static final EntityType<ObsidianArrowEntity> OB_ARROW_ENTITY = null;
	public static final Effect BLEEDING = null;
	public static final EntityType<BroadheadArrowEntity> BH_ARROW_ENTITY = null;
	public static final BroadheadArrowItem BROADHEAD_ARROW = null;
	public static final InvisCharmItem INVISIBILITY_CHARM = null;
	public static final Feature<NoFeatureConfig> DEADLY_WORLD_GEN = null;
	@ObjectHolder("minecraft:enchanting_table")
	public static final TileEntityType<EnchantingTableTileEntityExt> ENCHANTING_TABLE = null;
	public static final ContainerType<EnchantmentContainerExt> ENCHANTING = null;

}