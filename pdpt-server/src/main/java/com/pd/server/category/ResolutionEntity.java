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
@Table(name = "standards")
public class ResolutionEntity {
    @Id
    private Byte id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}