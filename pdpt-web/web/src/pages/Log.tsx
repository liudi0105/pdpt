import { Ant } from "@common-module/common-antd";
import { Outlet, useLocation } from "@common-module/common-react";
import { lastElement } from "@common-module/common-util";
import { Flex } from "antd";

const map = new Map([
  ["login-log", "登录日志"],
  ["site-log", "站点日志"],
]);

export const Log = () => {
  const s = lastElement(useLocation().pathname.split("/"));

  return (
    <Flex vertical gap={8}>
      <Ant.Card title={false}>
        <Ant.Breadcrumb
          items={[
            { key: "log", title: "日志" },
            { key: s, title: map.get(s) },
          ]}
        ></Ant.Breadcrumb>
      </Ant.Card>
      <Ant.Card title={false}>
        <Outlet />
      </Ant.Card>
    </Flex>
  );
};
