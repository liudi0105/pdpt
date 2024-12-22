package com.pd.server.help.faq;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "faq")
public class FaqPO {
    @Id
    private Short id;
    private Short linkId;
    private Short langId;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String question;
    private String answer;
    private Byte flag;
    private Short categ;
    private Short order;

    public enum Type {
        categ, item
    }
}
