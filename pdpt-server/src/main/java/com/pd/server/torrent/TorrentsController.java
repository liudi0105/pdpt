package com.pd.server.torrent;

import com.pd.server.torrent.torrent.TorrentsDTO;
import com.pd.server.torrent.torrent.TorrentsRepo;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import common.module.webmvc.ValueWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@ApiGroup("torrents")
public class TorrentsController {

    @Autowired
    private TorrentsService torrentsService;
    @Autowired
    private TorrentsRepo torrentsRepo;

    @Api("list-paged")
    public AppPageResult<TorrentsDTO> listPaged(@RequestBody AppPageParam appPageParam) {
        return torrentsService.listPaged(appPageParam);
    }

    @Api("get-one-by-id")
    public TorrentsDTO getOneById(@RequestBody @ValueWrapper.NotNull ValueWrapper<Integer> id) {
        return torrentsService.getOneById(id.getValue());
    }
}
