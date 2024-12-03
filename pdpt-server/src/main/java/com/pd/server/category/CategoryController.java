package com.pd.server.category;

import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiGroup(path = "category")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private EncodingRepo encodingRepo;

    @Autowired
    private MediaRepo mediaRepo;

    @Autowired
    private ResolutionRepo resolutionRepo;

    @Autowired
    private SourceRepo sourceRepo;

    @Autowired
    private AudioEncodingRepo audioEncodingRepo;

    @Api(path = "list")
    public List<CategoryDTO> list() {
        return categoryRepo.list(UnaryOperator.identity());
    }

    @Api(path = "list-all-category")
    public AllCategoryDTO listAllCategory() {
        List<EncodingDTO> list = encodingRepo.list(UnaryOperator.identity());
        List<MediaDTO> list1 = mediaRepo.list(UnaryOperator.identity());
        List<ResolutionDTO> list2 = resolutionRepo.list(UnaryOperator.identity());
        List<SourceDTO> list3 = sourceRepo.list(UnaryOperator.identity());
        List<AudioEncodingDTO> list4 = audioEncodingRepo.list(UnaryOperator.identity());
        List<CategoryDTO> list5 = categoryRepo.list(UnaryOperator.identity());
        return new AllCategoryDTO()
                .setMedias(list1)
                .setCategories(list5)
                .setEncodings(list)
                .setResolutions(list2)
                .setSources(list3)
                .setAudioEncodings(list4);
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class AllCategoryDTO {
        private List<CategoryDTO> categories;
        private List<EncodingDTO> encodings;
        private List<MediaDTO> medias;
        private List<ResolutionDTO> resolutions;
        private List<SourceDTO> sources;
        private List<AudioEncodingDTO> audioEncodings;
    }
}
