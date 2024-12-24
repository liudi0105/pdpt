import { Table } from "@common-module/common-antd";
import { UserService } from "@pdpt/lib";

const userService = new UserService();

export const UsersView = () => {
  return (
    <Table
      scroll={{ x: 1280 }}
      columns={[
        {
          title: "用户ID",
          dataIndex: "id",
          width: "8em",
        },
        {
          title: "用户名",
          dataIndex: "username",
          ellipsis: true,
        },
        {
          title: "密码哈希",
          dataIndex: "passhash",
          ellipsis: true,
        },
        {
          title: "密码盐",
          dataIndex: "secret",
          ellipsis: true,
        },
        {
          title: "邮箱",
          dataIndex: "email",
          ellipsis: true,
        },
        {
          title: "用户状态",
          dataIndex: "status",
          width: "10em",
        },
        {
          title: "IP地址",
          dataIndex: "ip",
          ellipsis: true,
        },
        {
          title: "上传量",
          dataIndex: "uploaded",
          width: "10em",
        },
        {
          title: "下载量",
          dataIndex: "downloaded",
          width: "10em",
        },
        {
          title: "上传时间",
          dataIndex: "seedtime",
          width: "10em",
        },
        {
          title: "下载时间",
          dataIndex: "leechtime",
          width: "10em",
        },
        {
          title: "用户头衔",
          dataIndex: "title",
          ellipsis: true,
        },
        {
          title: "国家ID",
          dataIndex: "country",
          width: "8em",
        },
        {
          title: "通知设置",
          dataIndex: "notifs",
          width: "12em",
        },
        {
          title: "管理员备注",
          dataIndex: "modcomment",
          ellipsis: true,
        },
        {
          title: "头像",
          dataIndex: "avatar",
          ellipsis: true,
        },
        {
          title: "角色",
          dataIndex: "className",
          ellipsis: true,
        },
        {
          title: "最大角色",
          dataIndex: "maxClassOnce",
          ellipsis: true,
        },
        {
          title: "隐私设置",
          dataIndex: "privacy",
          ellipsis: true,
        },
        {
          title: "样式表",
          dataIndex: "stylesheet",
          ellipsis: true,
        },
        {
          title: "图标",
          dataIndex: "caticon",
          ellipsis: true,
        },
        {
          title: "字体大小",
          dataIndex: "fontsize",
          ellipsis: true,
        },
        {
          title: "是否接受PM",
          dataIndex: "acceptpms",
          width: "10em",
        },
        {
          title: "允许评论PM",
          dataIndex: "commentpm",
          width: "12em",
        },
        {
          title: "最后登录时间",
          dataIndex: "lastLogin",
          width: "15em",
        },
        {
          title: "最后访问时间",
          dataIndex: "lastAccess",
          width: "15em",
        },
        {
          title: "最后论坛访问时间",
          dataIndex: "forumAccess",
          width: "15em",
        },
        {
          title: "最后管理信息",
          dataIndex: "lastStaffmsg",
          width: "15em",
        },
        {
          title: "最后私信时间",
          dataIndex: "lastPm",
          width: "15em",
        },
        {
          title: "最后评论时间",
          dataIndex: "lastComment",
          width: "15em",
        },
        {
          title: "最后发帖时间",
          dataIndex: "lastPost",
          width: "15em",
        },
        {
          title: "最后浏览时间",
          dataIndex: "lastBrowse",
          width: "15em",
        },
        {
          title: "最后听音乐时间",
          dataIndex: "lastMusic",
          width: "15em",
        },
        {
          title: "最后刷新时间",
          dataIndex: "lastCatchup",
          width: "15em",
        },
        {
          title: "编辑密码盐",
          dataIndex: "editSecret",
          ellipsis: true,
        },
        {
          title: "IP地址",
          dataIndex: "ipAddress",
          ellipsis: true,
        },
        {
          title: "语言设置",
          dataIndex: "language",
          width: "10em",
        },
        {
          title: "管理员备注文本",
          dataIndex: "modcommentText",
          ellipsis: true,
        },
      ]}
      request={(params) => userService.listPaged(params)}
    />
  );
};
