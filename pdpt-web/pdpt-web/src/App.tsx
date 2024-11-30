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
import { Layout } from "./pages/Layout";
import { LoginPage } from "./pages/LoginPage";
import { TorrentPage } from "./pages/TorrentPage";
import { DetailPage } from "./pages/DetailPage";
import { HomePage } from "./pages/HomePage";

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
    element: <TorrentPage />,
  },
  {
    path: "torrents",
    name: "综合",
    element: <TorrentPage />,
    children: [
      {
        path: "all",
        name: "所有",
        element: <TorrentPage />,
      },
      {
        path: "film",
        name: "电影",
        element: <TorrentPage />,
      },
    ],
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
    element: <TorrentPage />,
  },
  {
    path: "subtitle",
    name: "字幕",
    element: <TorrentPage />,
  },
  {
    path: "entertainment",
    name: "娱乐",
    element: <TorrentPage />,
  },
  {
    path: "top",
    name: "排行榜",
    element: <TorrentPage />,
  },
  {
    path: "log",
    name: "日志",
    element: <TorrentPage />,
  },
  {
    path: "help",
    name: "帮助",
    element: <TorrentPage />,
  },
  {
    path: "contact-us",
    name: "联系管理组",
    element: <TorrentPage />,
  },
  {
    path: "torrent/detail/:id",
    element: <DetailPage />,
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
    <ConfigProvider
      theme={{
        algorithm: [],
        token: {},
        components: {
          Button: {},
        },
      }}
    >
      <RouterProvider router={AppRouter} />
      <SGlobalStyle />
      <FloatButtonGroup />
    </ConfigProvider>
  );
}

export default App;
