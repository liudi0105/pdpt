import { styled } from "@common-module/common-react";
import { RouterMenuItem } from "@common-module/common-api";
import { Tabs } from "antd";

const SBackground = styled.div`
  background-color: #006633;
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
`;

const SHomeBox = styled.div`
  width: 80%;
  height: 100%;
  margin-top: 100px;
  background-color: #c6e3c6;
`;

const SMainMenuBox = styled.div`
  padding: 8px;
  display: flex;
  justify-content: center;
`;

const r: RouterMenuItem[] = [
  {
    path: "home",
    name: "首页",
  },
  {
    path: "forum",
    name: "论坛",
  },
  {
    path: "all",
    name: "综合",
  },
  {
    path: "official",
    name: "官方",
  },
  {
    path: "dead-torrents",
    name: "断种",
  },
  {
    path: "offers",
    name: "候选",
  },
  {
    path: "request",
    name: "求种",
  },
  {
    path: "subtitle",
    name: "字幕",
  },
  {
    path: "entertainment",
    name: "娱乐",
  },
  {
    path: "top",
    name: "排行榜",
  },
  {
    path: "log",
    name: "日志",
  },
  {
    path: "help",
    name: "帮助",
  },
  {
    path: "contact-us",
    name: "联系管理组",
  },
];

export const Layout = () => {
  return (
    <SBackground>
      <SHomeBox>
        <SMainMenuBox>
          <Tabs
            type="card"
            items={r.map((v) => ({
              key: v.path,
              label: v.name,
              children: "sssss",
            }))}
          ></Tabs>
        </SMainMenuBox>
      </SHomeBox>
    </SBackground>
  );
};
