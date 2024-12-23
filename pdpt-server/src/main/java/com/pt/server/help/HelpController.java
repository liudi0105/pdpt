package com.pt.server.help;

import com.pt.server.help.faq.FaqDTO;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@ApiGroup(path = "help")
public class HelpController {

    @Autowired
    private HelpService helpService;

    @Api("list-faq")
    public List<FaqDTO> listFaq() {
        return helpService.listFaq();
    }

}
