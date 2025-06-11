package cz.beavergame.MonsterBrew.repository.MagicItem;

import cz.beavergame.MonsterBrew.entity.MagicItem.MagicItem;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MagicItemRepository extends JpaRepository<MagicItem, Long>, JpaSpecificationExecutor<MagicItem> {

    List<MagicItem> findByNameContainingIgnoreCase(String name);

    List<MagicItem> findByRarity(Rarity rarity);

    List<MagicItem> findByTyp(String typ);

    List<MagicItem> findByAttunement(boolean attunement);

    List<MagicItem> findByTagsIn(List<String> tags);

}
