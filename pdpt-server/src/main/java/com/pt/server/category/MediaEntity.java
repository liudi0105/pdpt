package com.pt.server.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "media")
public class MediaEntity {
    @Id
    private Integer id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}
