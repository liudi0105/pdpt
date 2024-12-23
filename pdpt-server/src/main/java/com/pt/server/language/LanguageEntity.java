package com.pt.server.language;

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
@Table(name = "language")
public class LanguageEntity {
    @Id
    private Short id;
    private String langName;
    private String flagpic;
    private Byte subLang;
    private Byte ruleLang;
    private Byte siteLang;
    private String siteLangFolder;
//    private TransState transState;

    @Getter
    public enum TransState {
        UP_TO_DATE("up-to-date"),
        outdate("outdate"),
        incomplete("incomplete"),
        NEED_NEW("need-new"),
        unavailable("unavailable"),
        ;
        private final String code;

        TransState(String code) {
            this.code = code;
        }
    }

}
