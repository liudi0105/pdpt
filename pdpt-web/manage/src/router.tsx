import { MenuPage } from "@common-module/common-antd";
import { RouterMenuItem } from "@common-module/common-api";
import { createBrowserRouter, Navigate } from "@common-module/common-react";
import { NotFound } from "@pdpt/lib";
import { DashboardView } from "./views/DashboardView";
import { ExamUsersView } from "./views/ExamUsersView";
import { RolesView } from "./views/RolesView";
import { UsersView } from "./views/UsersView";

export const routers: RouterMenuItem[] = [
  {
    path: "dashboard",
    name: "仪表板",
    element: <DashboardView />,
  },
  {
    path: "user",
    name: "用户",
    children: [
      {
        path: "users",
        name: "用户列表",
        element: <UsersView />,
      },
      {
        path: "exam-users",
        name: "用户考核",
        element: <ExamUsersView />,
      },
      {
        path: "hit-and-runs",
        name: "用户 H&R",
      },
      {
        path: "claims",
        name: "用户认领",
      },
      {
        path: "user-medals",
        name: "用户勋章",
      },
      {
        path: "user-invites",
        name: "用户邀请",
      },
      {
        path: "user-tools",
        name: "用户工具",
      },
      {
        path: "login-records",
        name: "登录记录",
      },
      {
        path: "magic-records",
        name: "魔力记录",
      },
      {
        path: "seeds-buy-records",
        name: "种子购买记录",
      },
      {
        path: "signed-records",
        name: "签到记录",
      },
      {
        path: "rename-records",
        name: "改名记录",
      },
    ],
  },
  {
    path: "torrent",
    name: "种子",
    children: [
      {
        path: "torrent-tags",
        name: "标签",
      },
      {
        path: "reject-reason",
        name: "拒绝原因",
      },
      {
        path: "torrent-operation-logs",
        name: "种子操作记录",
      },
    ],
  },
  {
    path: "role-permission",
    name: "角色与权限",
    children: [
      {
        path: "role",
        name: "角色",
        element: <RolesView />,
      },
      {
        path: "permission",
        name: "直接权限",
      },
    ],
  },
  {
    path: "other",
    name: "其他",
    children: [
      {
        path: "lucky-wheel",
        name: "幸运大转盘",
      },
      {
        path: "reward-record",
        name: "抽奖记录",
      },
    ],
  },
  {
    path: "section",
    name: "分类模块",
    children: [
      {
        path: "category-mode",
        name: "分类模式",
      },
      {
        path: "main-category",
        name: "主分类",
      },
      {
        path: "codec",
        name: "Codec",
      },
      {
        path: "audio-codec",
        name: "Audio Codec",
      },
      {
        path: "standard",
        name: "Standard",
      },
      {
        path: "team",
        name: "Team",
      },
      {
        path: "source",
        name: "Source",
      },
      {
        path: "media",
        name: "Media",
      },
      {
        path: "processing",
        name: "Processing",
      },
      {
        path: "category-icon",
        name: "分类图标",
      },
      {
        path: "second-icon",
        name: "第二图标",
      },
    ],
  },
  {
    path: "system",
    name: "系统设置",
    children: [
      {
        path: "audit",
        name: "考核",
      },
      {
        path: "medals",
        name: "勋章",
      },
      {
        path: "allow-client",
        name: "允许客户端",
      },
      {
        path: "deny-client",
        name: "拒绝客户端",
      },
      {
        path: "up-link-width",
        name: "上行带宽",
      },
      {
        path: "down-link-width",
        name: "下行带宽",
      },
      {
        path: "isp",
        name: "ISP",
      },
      {
        path: "seedbox",
        name: "SeedBox",
      },
      {
        path: "site-discount",
        name: "全站优惠",
      },
      {
        path: "settings",
        name: "设置",
      },
    ],
  },
];

export const AppRouter = createBrowserRouter(
  [
    {
      path: "/",
      element: <Navigate to="/torrents/all" />,
    },
    {
      path: "login",
      element: <NotFound />,
    },
    {
      path: "*",
      children: routers,
      element: <MenuPage routerMenuItems={routers} userEmail="ss" />,
    },
  ],
  {
    basename: import.meta.env.BASE_URL,
  }
);
