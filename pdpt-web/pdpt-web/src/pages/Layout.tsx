import { Ant } from "@common-module/common-antd";
import { RouterMenuItem } from "@common-module/common-api";
import {
  Outlet,
  styled,
  useLocation,
  useNavigate,
} from "@common-module/common-react";
import { joinPath } from "@common-module/common-util";
import { MenuProps } from "antd";
import { routers } from "../App";

type MenuItem = Required<MenuProps>["items"][number];

const SBackground = styled.div`
  padding: 0 24px 24px 24px;
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
  padding: 8px;
`;

function toMenu(router: RouterMenuItem): MenuItem {
  return {
    key: router.path,
    label: router.name,
    theme: "light",
    children: router.children?.map((v) => toMenu(v)),
  };
}

const SImg = styled.div`
  width: 100%;
  background-image: url("/images/top_bar.png");
  height: 210px;
  background-size: cover;
  background-repeat: no-repeat;
`;

export const Layout = () => {
  const items: MenuItem[] = routers
    .filter((v) => !v.hidden)
    .map((v) => toMenu(v));

  const naviate = useNavigate();

  const location = useLocation();

  const path = location.pathname.split("/");
  const key = path[path.length - 1];

  return (
    <SBackground>
      <SHomeBox>
        <SImg></SImg>
        <Ant.Menu
          style={{ background: "#294d7f" }}
          activeKey={key}
          theme="dark"
          selectedKeys={path}
          onClick={(p) => {
            const s = ["/", ...p.keyPath.reverse()];
            naviate(joinPath(...s));
          }}
          mode="horizontal"
          items={items}
        ></Ant.Menu>
        <SMainMenuBox>
          <Ant.Card style={{ marginBottom: 8 }}>
            <div>
              欢迎回来, bluegemld开站纪念 [ 控制面板 ] [收藏] 魔力值 [使用]:
              104,760.5 [签到得魔力] [勋章] 邀请 [发送]: 0(0)
            </div>
            <div>
              分享率: 1.353 上传量: 3.509 TB 下载量: 2.594 TB 当前活动: Torrents
              seeding9 Torrents leeching1 可连接:是 连接数：无限制 H&R: [0/0/]
              认领: [0/5000]
            </div>
          </Ant.Card>
          <Outlet />
        </SMainMenuBox>
      </SHomeBox>
    </SBackground>
  );
};
