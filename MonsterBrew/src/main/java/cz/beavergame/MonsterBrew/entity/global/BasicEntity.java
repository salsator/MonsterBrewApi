package cz.beavergame.MonsterBrew.entity.global;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BasicEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
        @PrePersist
        protected void onCreate(){
            this.createdAt = LocalDateTime.now();
            this.updatedAt = createdAt;
        }

        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = LocalDateTime.now();
        }

}
