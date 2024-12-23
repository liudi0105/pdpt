package com.pt.server.language;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageDTO {
    private Short id;
    private String langName;
    private String flagpic;
    private Byte subLang;
    private Byte ruleLang;
    private Byte siteLang;
    private String siteLangFolder;
    private LanguageEntity.TransState transState;
}
