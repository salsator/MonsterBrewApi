package cz.beavergame.MonsterBrew.dto;

import cz.beavergame.MonsterBrew.entity.MagicItem.Tag;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record MagicItemDto(
        Long id,

        @NotBlank
        @Size(max = 100)
        String name,

        @Size(max = 5000)
        String description,

        @NotNull
        Rarity rarity,
        @Size(max = 50)
        String rarityCustom,

        @NotNull
        Type type,
        @Size(max = 50)
        String typeCustom,

        @NotNull
        Boolean attunement,

        List<Tag> tags,

        int price
) {

}
