package com.pd.server.help.faq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqDTO {
    private Short id;
    private Short linkId;
    private Short langId;
    private String type;
    private String question;
    private String answer;
    private Byte flag;
    private Short categ;
    private Short order;
}
