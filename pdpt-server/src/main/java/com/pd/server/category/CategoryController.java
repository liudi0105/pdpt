package com.pd.server.category;

import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiGroup(path = "category")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Api(path = "list")
    public List<CategoryDTO> list() {
        return categoryRepo.list(UnaryOperator.identity());
    }

}
