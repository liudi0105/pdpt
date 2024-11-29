package com.pd.server.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    private Short id;
    private Byte mode;
    private String className;
    private String name;
    private String image;
    private Short sortIndex;
    private Integer iconId;
}
