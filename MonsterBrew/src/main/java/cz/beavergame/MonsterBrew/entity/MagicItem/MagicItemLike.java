package cz.beavergame.MonsterBrew.entity.MagicItem;

import cz.beavergame.MonsterBrew.entity.global.BasicEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "magic_item_like", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId", "magicItemId"})
})
public class MagicItemLike extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private long magicItemId;

    private final LocalDateTime likedAt = LocalDateTime.now();
}
