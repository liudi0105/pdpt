import { AppPageParam, AppPageResult, BaseEntity, BaseService } from "@common-module/common-api";

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
  categoryCode: string;
  source: number;
  filename: string;
  tags: string[];
}

export class TorrentsService extends BaseService<TorrentEntity> {
  group = "torrents";

  getOneById = (id: number) => {
    return this.postValueForJson<TorrentEntity>("get-one-by-id", id);
  };

  listPaged = (param: AppPageParam) => {
    return this.postJsonForJson<AppPageResult<TorrentEntity>>(
      "list-paged",
      param
    );
  };
}

export interface CategoryEntity extends BaseEntity {
  id: number;
  mode: number;
  className: string;
  name: string;
}

export interface AllCategory extends BaseEntity {
  categories: CategoryEntity[];
  encodings: CategoryEntity[];
  medias: CategoryEntity[];
  resolutions: CategoryEntity[];
  sources: CategoryEntity[];
  audioEncodings: CategoryEntity[];
}

export class CategoryService extends BaseService<CategoryEntity> {
  group = "category";

  list = () => this.postJsonForJson<CategoryEntity[]>("list");

  listAllCategory = () =>
    this.postJsonForJson<AllCategory>("list-all-category");
}
