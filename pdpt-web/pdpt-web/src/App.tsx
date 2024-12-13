import { FloatButtonGroup } from "@common-module/common-antd";
import { RouterMenuItem } from "@common-module/common-api";
import {
  createBrowserRouter,
  createGlobalStyle,
  Navigate,
  RouterProvider,
} from "@common-module/common-react";
import { ConfigProvider } from "antd";
import "./App.css";
import { TorrentDetailPage } from "./pages/TorrentDetailPage";
import { Entertain } from "./pages/Entertain";
import { Faq } from "./pages/Faq";
import { Forum } from "./pages/Forum";
import { HomePage } from "./pages/HomePage";
import { Layout } from "./pages/Layout";
import { Log } from "./pages/Log";
import { LoginLog } from "./pages/log/LoginLog";
import { SiteLog } from "./pages/log/SiteLog";
import { LoginPage } from "./pages/LoginPage";
import { Posts } from "./pages/Posts";
import { Publish } from "./pages/Publish";
import { Subtitle } from "./pages/Subtitle";
import { Top } from "./pages/Top";
import { Topic } from "./pages/Topic";
import { TorrentPage } from "./pages/TorrentPage";
import { TorrentRequest } from "./pages/TorrentRequest";
import { ContactUs } from "./pages/ContactUs";

const SGlobalStyle = createGlobalStyle`
  html, body, #root {
    height: 100%;
    width: 100%;
    margin: 0;
    padding: 0;
  }

  pre {
    font-family: 'Cascadia Mono', 'Consolas', 'Courier New', Courier, monospace;
    margin: 0;
  }
`;

export const routers: RouterMenuItem[] = [
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
    name: "综合",
    element: <TorrentPage />,
    // children: [
    //   {
    //     path: "all",
    //     name: "所有",
    //     element: <TorrentPage />,
    //   },
    //   {
    //     path: "film",
    //     name: "电影",
    //     element: <TorrentPage />,
    //   },
    // ],
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
];

const AppRouter = createBrowserRouter([
  {
    path: "login",
    element: <LoginPage />,
  },
  {
    path: "/",
    element: <Navigate to="/torrents/all" />,
  },
  {
    path: "*",
    element: <Layout />,
    children: routers,
  },
]);

function App() {
  return (
    <ConfigProvider>
      <RouterProvider router={AppRouter} />
      <SGlobalStyle />
      <FloatButtonGroup />
    </ConfigProvider>
  );
}

export default App;
