package cz.beavergame.MonsterBrew.filter;

import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;

public record MagicItemFilter(String name, Type type, Rarity rarity, Boolean attunement) {
}
