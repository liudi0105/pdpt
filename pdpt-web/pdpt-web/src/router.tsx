import { RouterMenuItem } from "@common-module/common-api";
import { createBrowserRouter, Navigate } from "@common-module/common-react";
import { ContactUs } from "./pages/ContactUs";
import { SettingCenter } from "./pages/ControlCenter";
import { Entertain } from "./pages/Entertain";
import { NotFound } from "./pages/errors/NotFound";
import { Faq } from "./pages/Faq";
import { Forum } from "./pages/Forum";
import { HomePage } from "./pages/HomePage";
import { Log } from "./pages/Log";
import { LoginLog } from "./pages/log/LoginLog";
import { SiteLog } from "./pages/log/SiteLog";
import { LoginView } from "./pages/LoginView";
import { Posts } from "./pages/Posts";
import { Publish } from "./pages/Publish";
import { Subtitle } from "./pages/Subtitle";
import { Top } from "./pages/Top";
import { Topic } from "./pages/Topic";
import { TorrentDetailPage } from "./pages/TorrentDetailPage";
import { TorrentRequest } from "./pages/TorrentRequest";
import { TorrentPage } from "./pages/TorrentView";
import { AppLayout } from "./pages/AppLayout";
import { Invite } from "./pages/Invite";
import { BambooShoot } from "./pages/BambooShoot";
import { Medal } from "./pages/Medal";
import { RSS } from "./pages/RSS";
import { AdminSetting } from "./pages/AdminSetting";

export const routers: RouterMenuItem[] = [
  {
    path: "*",
    element: <NotFound />,
    hidden: true,
  },
  {
    path: "home",
    name: "首页",
    element: <HomePage />,
  },
  {
    path: "forum",
    name: "论坛",
    element: <Forum />,
  },
  {
    path: "torrents",
    name: "种子",
    children: [
      {
        path: "all",
        name: "综合",
        element: <TorrentPage />,
      },
      {
        path: "official",
        name: "官方",
        element: <TorrentPage />,
      },
      {
        path: "dead-torrents",
        name: "断种",
        element: <TorrentPage />,
      },
      {
        path: "offers",
        name: "候选",
        element: <TorrentPage />,
      },
    ],
  },
  {
    path: "request",
    name: "求种",
    element: <TorrentRequest />,
  },
  {
    path: "publish",
    name: "发布",
    element: <Publish />,
  },
  {
    path: "subtitle",
    name: "字幕",
    element: <Subtitle />,
  },
  {
    path: "entertainment",
    name: "娱乐",
    element: <Entertain />,
  },
  {
    path: "top",
    name: "排行榜",
    element: <Top />,
  },
  {
    path: "log",
    name: "日志",
    element: <Log />,
    children: [
      {
        path: "login-log",
        name: "登录日志",
        element: <LoginLog />,
      },
      {
        path: "site-log",
        name: "站点日志",
        element: <SiteLog />,
      },
    ],
  },
  {
    path: "help",
    name: "帮助",
    children: [
      {
        path: "faq",
        name: "常见问题",
        element: <Faq />,
      },
    ],
  },
  {
    path: "contact-us",
    name: "联系管理组",
    element: <ContactUs />,
  },
  {
    path: "forum/topics/:id",
    element: <Topic />,
    hidden: true,
  },
  {
    path: "forum/posts/:id",
    element: <Posts />,
    hidden: true,
  },
  {
    path: "torrent/detail/:id",
    element: <TorrentDetailPage />,
    hidden: true,
  },
  {
    path: "invite",
    element: <Invite />,
    hidden: true,
  },
  {
    path: "setting-center",
    element: <SettingCenter />,
    hidden: true,
  },
  {
    path: "admin-setting",
    element: <AdminSetting />,
    hidden: true,
  },
  {
    path: "rss",
    element: <RSS />,
    hidden: true,
  },
  {
    path: "medal",
    element: <Medal />,
    hidden: true,
  },
  {
    path: "bamboo-shoot",
    element: <BambooShoot />,
    hidden: true,
  },
];

export const AppRouter = createBrowserRouter([
  {
    path: "login",
    element: <LoginView />,
  },
  {
    path: "/",
    element: <Navigate to="/torrents" />,
  },
  {
    path: "*",
    element: <AppLayout />,
    children: routers,
  },
]);
