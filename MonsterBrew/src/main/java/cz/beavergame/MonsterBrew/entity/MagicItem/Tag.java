package cz.beavergame.MonsterBrew.entity.MagicItem;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magic_item_id")
    private MagicItem magicItem;


}
