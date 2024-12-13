import {
  AppPageParam,
  AppPageResult,
  BaseEntity,
  BaseService,
} from "@common-module/common-api";

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

export interface ForumsEntity extends BaseEntity {
  id: number;
  sort: number;
  name: string;
  minclassread: string;
  minclasswrite: string;
  minclasscreate: string;
  description: string;
  postcount: number;
  topiccount: number;
  forid: number;
  blockName: string;
}

export interface OverForumsEntity extends BaseEntity {
  id: number;
  name: string;
  description: string;
  minclassview: number;
  sort: number;
  forums: ForumsEntity[];
}

export interface TopicEntity extends BaseEntity {
  id: number;
  userid: number;
  subject: string;
  locked: string;
  forumid: number;
  firstpost: number;
  lastpost: number;
  sticky: string;
  hlcolor: number;
  views: number;
  blockName: string;
  forumName: string;
}

export interface PostsEntity extends BaseEntity {
  id: number;
  topicid: number;
  userid: number;
  username: string;
  added: number;
  body: string;
  oriBody: string;
  editedby: number;
  editdate: string;
}

export class ForumsService extends BaseService<never> {
  group = "forums";

  forumsStructure = () =>
    this.postJsonForJson<OverForumsEntity[]>("forum-structure");

  listTopicByForumId = (id: number) =>
    this.postValueForJson<TopicEntity[]>("list-topic-by-forum-id", id);

  listPostsByTopicId = (id: number) =>
    this.postValueForJson<PostsEntity[]>("list-posts-by-topic-id", id);

  getTopicById = (id: number) =>
    this.postValueForJson<TopicEntity>("get-topic-by-id", id);

  getForumById = (id: number) =>
    this.postValueForJson<ForumsEntity>("get-forum-by-id", id);
}

export interface LoginLogEntity extends BaseEntity {
  id: number;
  uid: number;
  ip: string;
  country: string;
  city: string;
  client: string;
  createdAt: string;
  updatedAt: string;
}

export interface SiteLogEntity extends BaseEntity {
  id: number;
  added: string;
  txt: string;
  securityLevel: string;
}

export class LogService extends BaseService<never> {
  group = "log";

  listSiteLogPaged = (params: AppPageParam) =>
    this.postJsonForJson<AppPageResult<SiteLogEntity>>(
      "list-site-log-paged",
      params
    );

  listLoginLogPaged = (params: AppPageParam) =>
    this.postJsonForJson<AppPageResult<LoginLogEntity>>(
      "list-login-log-paged",
      params
    );
}

export interface FaqEntity extends BaseEntity {
  id: number;
  linkeId: number;
  langId: number;
  type: string;
  question: string;
  answer: string;
  flag: number;
  categ: number;
  order: number;
}

export class HelpService extends BaseService<never> {
  group = "help";

  listFaq = () => this.postJsonForJson<FaqEntity[]>("list-faq");
}

export interface RequestsEntity extends BaseEntity {
  id: number;
}

export class RequestsService extends BaseService<RequestsEntity> {
  group = "requests";
}

export interface SubtitleEntity extends BaseEntity {
  id: number;
  torrentId: number;
  langId: number;
  title: string;
  filename: string;
  added: string;
  uppedby: number;
  uploadUsername: string;
  hits: number;
  size: number;
  ext: string;
}

export class SubtitleService extends BaseService<SubtitleEntity> {
  group = "subtitle";
}
