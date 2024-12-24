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

export interface LoginResult {
  username: string;
  email: string;
  userId: string;
}

export class AuthService extends BaseService<never> {
  group = "auth";

  login = (param: { username: string; password: string }) =>
    this.postJsonForJson<LoginResult>("login", param);

  validate = () => this.postJsonForJson<LoginResult>("validate");

  logout = () => {
    return this.postJsonForJson("logout");
  };
}

export interface UserEntity extends BaseEntity {
  id: number; // 用户ID
  username: string; // 用户名
  passhash: string; // 密码哈希
  secret: Uint8Array; // 密码盐（使用 Uint8Array 表示 byte[]）
  email: string; // 用户邮箱
  status: string; // 用户状态（例如：pending, confirmed）
  ip: string; // 用户IP地址
  uploaded: number; // 上传量
  downloaded: number; // 下载量
  seedtime: number; // 上传时间（种子时间）
  leechtime: number; // 下载时间（做种时间）
  title: string; // 用户头衔
  country: number; // 国家ID
  notifs: string; // 通知设置
  modcomment: string; // 管理员备注
  avatar: string; // 用户头像
  className: string; // 用户角色（权限级别）
  maxClassOnce: string; // 最大角色（权限）一次性
  privacy: string; // 隐私设置
  stylesheet: string; // 样式表
  caticon: string; // 图标
  fontsize: string; // 字体大小
  acceptpms: string; // 是否接受PM
  commentpm: string; // 是否允许评论PM
  lastLogin: string; // 最后登录时间
  lastAccess: string; // 最后访问时间
  forumAccess: string; // 最后论坛访问时间
  lastStaffmsg: string; // 最后管理信息
  lastPm: string; // 最后私信时间
  lastComment: string; // 最后评论时间
  lastPost: string; // 最后发帖时间
  lastBrowse: string; // 最后浏览时间
  lastMusic: string; // 最后听音乐时间
  lastCatchup: string; // 最后刷新时间
  editSecret: string; // 编辑密码盐
  ipAddress: string; // 当前用户的IP地址
  language: string; // 用户的语言设置
  modcommentText: string; // 管理员备注文本
}

export class UserService extends BaseService<UserEntity> {
  group = "users";
}
