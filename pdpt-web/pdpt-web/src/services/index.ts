import { BaseEntity, BaseService } from "@common-module/common-api";
import { AppPageParam, AppPageResult } from "@common-module/common-types";

export interface TorrentEntity extends BaseEntity {
  id: number;
  added: string;
  category: number;
  size: number;
  cover: string;
  name: string;
  descr: string;
  smallDescr: string;
  ownerName: string;
}

export class TorrentsService extends BaseService<TorrentEntity> {
  group = "torrents";

  listPaged = (param: AppPageParam) => {
    return this.postJsonForJson<AppPageResult<TorrentEntity>>(
      "list-paged",
      param
    );
  };
}
