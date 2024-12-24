import { RouterMenuItem } from "@common-module/common-api";
import { createBrowserRouter, Navigate } from "@common-module/common-react";
import { NotFound } from "@pdpt/lib";
import { DashboardView } from "./views/DashboardView";
import { MenuPage } from "@common-module/common-antd";

export const routers: RouterMenuItem[] = [
  {
    path: "login",
    element: <NotFound />,
  },
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
        element: <DashboardView />,
      },
      {
        path: "exam-users",
        name: "用户考核",
      },
      {
        path: "hit-and-runs",
        name: "Hit And Run",
      },
      {
        path: "claims",
        name: "用户认领",
      },
      {
        path: "user-medals",
        name: "用户勋章",
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
      path: "*",
      children: routers,
      element: (
        <MenuPage routerMenuItems={routers} title="sss" userEmail="ss" />
      ),
    },
  ],
  {
    basename: import.meta.env.BASE_URL,
  }
);
