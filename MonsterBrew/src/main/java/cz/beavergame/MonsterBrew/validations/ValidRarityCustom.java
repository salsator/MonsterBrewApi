package cz.beavergame.MonsterBrew.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RarityCustomValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRarityCustom {
    String message() default "If rarity is OTHER, RarityCustom is required.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}