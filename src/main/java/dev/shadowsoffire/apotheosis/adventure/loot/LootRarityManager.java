package dev.shadowsoffire.apotheosis.adventure.loot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.adventure.AdventureModule;
import dev.shadowsoffire.apotheosis.adventure.affix.Affix;
import dev.shadowsoffire.apotheosis.adventure.affix.AffixManager;
import dev.shadowsoffire.apotheosis.adventure.affix.AffixType;
import dev.shadowsoffire.apotheosis.adventure.loot.LootRarity.LootRule;
import dev.shadowsoffire.apotheosis.adventure.loot.LootRarity.RarityStub;
import dev.shadowsoffire.placebo.reload.DynamicRegistryObject;
import dev.shadowsoffire.placebo.reload.PlaceboJsonReloadListener;
import net.minecraft.world.item.ItemStack;

/**
 * Handles loading the configurable portion of rarities.
 */
public class LootRarityManager extends PlaceboJsonReloadListener<RarityStub> {

    public static final LootRarityManager INSTANCE = new LootRarityManager();

    public static final DynamicRegistryObject<RarityStub> COMMON = INSTANCE.registryObject(Apotheosis.loc("common"));
    public static final DynamicRegistryObject<RarityStub> UNCOMMON = INSTANCE.registryObject(Apotheosis.loc("uncommon"));
    public static final DynamicRegistryObject<RarityStub> RARE = INSTANCE.registryObject(Apotheosis.loc("rare"));
    public static final DynamicRegistryObject<RarityStub> EPIC = INSTANCE.registryObject(Apotheosis.loc("epic"));
    public static final DynamicRegistryObject<RarityStub> MYTHIC = INSTANCE.registryObject(Apotheosis.loc("mythic"));
    public static final DynamicRegistryObject<RarityStub> ANCIENT = INSTANCE.registryObject(Apotheosis.loc("ancient"));

    protected Map<String, LootRarity> byId = new HashMap<>();
    protected List<LootRarity> list = new ArrayList<>(6);

    private LootRarityManager() {
        super(AdventureModule.LOGGER, "rarities", false, false);
    }

    @Override
    protected void onReload() {
        super.onReload();
        Preconditions.checkArgument(COMMON.get() != null, "Common rarity not registered!");
        Preconditions.checkArgument(UNCOMMON.get() != null, "Uncommon rarity not registered!");
        Preconditions.checkArgument(RARE.get() != null, "Rare rarity not registered!");
        Preconditions.checkArgument(EPIC.get() != null, "Epic rarity not registered!");
        Preconditions.checkArgument(MYTHIC.get() != null, "Mythic rarity not registered!");
        Preconditions.checkArgument(ANCIENT.get() != null, "Ancient rarity not registered!");
        Preconditions.checkArgument(this.registry.size() == 6, "Registration of additional rarity levels is not supported!");
        Preconditions.checkArgument(this.registry.values().stream().mapToInt(RarityStub::getWeight).sum() > 0, "The total weight of all rarities must be above 0");

        LootRarity.COMMON.update(COMMON.get());
        LootRarity.UNCOMMON.update(UNCOMMON.get());
        LootRarity.RARE.update(RARE.get());
        LootRarity.EPIC.update(EPIC.get());
        LootRarity.MYTHIC.update(MYTHIC.get());
        // LootRarity.ANCIENT.update(ANCIENT.get()); Ancient is NYI, so changes should not be reflected.

        for (LootRarity rarity : LootRarity.values()) {
            if (rarity == LootRarity.ANCIENT) continue;
            Map<AffixType, List<LootRule>> sorted = new HashMap<>();
            rarity.rules().stream().filter(r -> r.type().needsValidation()).forEach(rule -> {
                sorted.computeIfAbsent(rule.type(), r -> new ArrayList<>());
                sorted.get(rule.type()).add(rule);
            });
            sorted.forEach((type, rules) -> {
                for (LootCategory cat : LootCategory.VALUES) {
                    if (cat.isNone()) continue;
                    List<Affix> affixes = AffixManager.INSTANCE.getValues().stream().filter(a -> a.canApplyTo(ItemStack.EMPTY, cat, rarity) && a.getType() == type).toList();

                    if (affixes.size() < rules.size()) {
                        var errMsg = new StringBuilder();
                        errMsg.append("Insufficient number of affixes to satisfy the loot rules (ignoring backup rules) of rarity " + rarity.id() + " for category " + cat.getName());
                        errMsg.append("Required: " + rules.size());
                        errMsg.append("; Provided: " + affixes.size());
                        // errMsg.append("The following affixes exist for this category/rarity combination: ");
                        // affixes.forEach(a -> errMsg.append(a.getId() + " "));
                        AdventureModule.LOGGER.error(errMsg.toString());
                    }
                }
            });
        }
    }

    @Override
    protected void registerBuiltinSerializers() {
        this.registerSerializer(DEFAULT, RarityStub.SERIALIZER);
    }

    @Override
    protected void validateItem(RarityStub item) {
        super.validateItem(item);
        Preconditions.checkArgument(item.getWeight() >= 0, "A rarity may not have negative weight!");
        Preconditions.checkArgument(item.getQuality() >= 0, "A rarity may not have negative quality!");
        Preconditions.checkArgument(!item.rules().isEmpty(), "A rarity may not have no rules!");
    }

}
