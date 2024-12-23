package com.pt.server.messages.shoutbox;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "shoutbox")
public class ShoutBoxPO {
    @Id
    private Integer id;
    private Integer userid;
    private Integer date;
    private String text;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        sb, hb
    }
}
