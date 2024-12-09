package com.pd.server.forum.overforums;

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
@Table(name = "overforums")
public class OverForumsEntity {
    @Id
    private Short id;
    private String name;
    private String description;
    private Byte minclassview;
    private Byte sort;
}
