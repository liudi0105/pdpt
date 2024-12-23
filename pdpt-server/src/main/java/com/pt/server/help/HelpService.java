package com.pt.server.help;

import com.pt.server.help.faq.FaqDTO;
import com.pt.server.help.faq.FaqPO;
import com.pt.server.help.faq.FaqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelpService {

    @Autowired
    private FaqRepo faqRepo;

    public List<FaqDTO> listFaq() {
        return faqRepo.listQuery(v -> v.orderBy(FaqPO::getOrder)
                .where(c -> c.eq(FaqPO::getLangId, 25))
        );
    }

}
