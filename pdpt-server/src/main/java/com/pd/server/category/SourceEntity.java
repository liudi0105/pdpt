package com.pd.server.category;

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
@Table(name = "categories")
public class SourceEntity {
    @Id
    private Byte id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}
