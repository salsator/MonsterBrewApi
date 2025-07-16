package cz.beavergame.MonsterBrew.validations;


import cz.beavergame.MonsterBrew.dto.MagicItemDto;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RarityCustomValidator implements ConstraintValidator<ValidRarityCustom, MagicItemDto> {

    @Override
    public boolean isValid(MagicItemDto dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }

        if (dto.rarity() == Rarity.OTHER) {
            return dto.rarityCustom() != null && !dto.rarityCustom().isBlank();
        }
        if (dto.type() == Type.OTHER) {
            return dto.typeCustom() != null && !dto.typeCustom().isBlank();
        }

        return true;
    }
}
