import { RouterMenuItem } from "@common-module/common-api";
import { Outlet, styled, useNavigate } from "@common-module/common-react";
import { ConfigProvider, Menu, MenuProps, theme } from "antd";
import { routers } from "../App";

type MenuItem = Required<MenuProps>["items"][number];

const SBackground = styled.div`
  padding: 24px;
  box-sizing: content-box;
  display: flex;
  justify-content: center;
`;

const SHomeBox = styled.div`
  width: 80%;
  height: 100%;
  border-radius: 8px;
  background-color: #d8e2ef;
`;

const SMainMenuBox = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
`;

function toMenu(router: RouterMenuItem): MenuItem {
  return {
    key: router.path,
    label: router.name,
    children: router.children?.map((v) => toMenu(v)),
  };
}

export const Layout = () => {
  const items: MenuItem[] = routers
    .filter((v) => !v.hidden)
    .map((v) => toMenu(v));

  const naviate = useNavigate();

  return (
    <SBackground>
      <SHomeBox>
        <SMainMenuBox>
          <Menu
            style={{
              display: "flex",
              justifyContent: "center",
              backgroundColor: "#d8e2ef",
            }}
            onClick={(p) => {
              naviate(p.keyPath.reverse().join("/"));
            }}
            mode="horizontal"
            items={items}
          ></Menu>
          <ConfigProvider
            theme={{
              algorithm: [theme.compactAlgorithm],
            }}
          >
            <Outlet />
          </ConfigProvider>
        </SMainMenuBox>
      </SHomeBox>
    </SBackground>
  );
};
