package com.pd.server.help;

import com.pd.server.help.faq.FaqDTO;
import com.pd.server.help.faq.FaqEntity;
import com.pd.server.help.faq.FaqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelpService {

    @Autowired
    private FaqRepo faqRepo;

    public List<FaqDTO> listFaq() {
        return faqRepo.listQuery(v -> v.orderBy(FaqEntity::getOrder)
                .where(c -> c.eq(FaqEntity::getLangId, 25))
        );
    }

}