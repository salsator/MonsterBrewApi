package cz.beavergame.MonsterBrew.specification;

import cz.beavergame.MonsterBrew.entity.MagicItem.MagicItem;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;
import org.springframework.data.jpa.domain.Specification;

public class MagicItemSpecification {

    public static Specification<MagicItem> haveAttunement(Boolean attunement){
        return ((root, query, criteriaBuilder)
                -> attunement == null ? null : criteriaBuilder.equal(root.get("attunement"), attunement));

    }
    public static Specification<MagicItem> haveType(Type type){
        return ((root, query, criteriaBuilder)
                -> type == null ? null : criteriaBuilder.equal(root.get("type"), type));

    }
    public static Specification<MagicItem> haveRarity(Rarity rarity){
        return ((root, query, criteriaBuilder)
                -> rarity == null ? null : criteriaBuilder.equal(root.get("rarity"), rarity));

    }
    public static Specification<MagicItem> haveName(String name){
        return ((root, query, criteriaBuilder)
                -> name == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));

    }
}
