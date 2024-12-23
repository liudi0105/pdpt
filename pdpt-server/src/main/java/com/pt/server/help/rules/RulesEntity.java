package com.pt.server.help.rules;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "rules")
public class RulesEntity {
    @Id
    private Short id;
    private Short langId;
    private String title;
    private String text;
}
