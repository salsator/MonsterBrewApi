package cz.beavergame.MonsterBrew.entity.MagicItem;

import cz.beavergame.MonsterBrew.entity.global.BasicEntity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Rarity;
import cz.beavergame.MonsterBrew.enums.MagicItem.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MagicItem extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Descritpion is required.")
    private String description;

    private Type type;
    private String typeCustom;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;
    private String rarityCustom;

    @NotNull
    private boolean attunement;

    @Min(value = 0)
    private int price;

    @Column(nullable = true)
    private Long createdByUser;

    @OneToMany(mappedBy = "magicItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags = new ArrayList<>();


}