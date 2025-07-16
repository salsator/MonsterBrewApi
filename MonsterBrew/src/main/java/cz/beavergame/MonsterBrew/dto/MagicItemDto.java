package cz.beavergame.MonsterBrew.dto;

import cz.beavergame.MonsterBrew.entity.MagicItem.Tag;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;
import cz.beavergame.MonsterBrew.validations.ValidRarityCustom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@ValidRarityCustom
public record MagicItemDto(
        Long id,

        @NotBlank
        @Size(max = 100)
        @NotBlank(message = "Name is required")
        String name,

        @Size(max = 5000)
        @NotBlank(message = "Description is required")
        String description,

        @NotNull
        @NotBlank(message = "Rarity is required")
        Rarity rarity,

        @Size(max = 50)
        String rarityCustom,

        @NotNull
        @NotBlank(message = "Type is required")
        Type type,

        @Size(max = 50)
        String typeCustom,

        @NotNull
        @NotBlank(message = "Attunement is required")
        Boolean attunement,

        List<Tag> tags,

        int price
) {

}
