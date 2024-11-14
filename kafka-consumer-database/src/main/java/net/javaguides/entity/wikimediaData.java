package net.javaguides.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_recent_change")

@Getter
@Setter

public class wikimediaData {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String wikiEventData;
}
