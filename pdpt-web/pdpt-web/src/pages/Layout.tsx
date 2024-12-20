import { Ant, AntIcon, Button } from "@common-module/common-antd";
import { RouterMenuItem } from "@common-module/common-api";
import {
  Outlet,
  styled,
  useLocation,
  useNavigate,
} from "@common-module/common-react";
import { joinPath } from "@common-module/common-util";
import { ButtonProps, Flex, MenuProps } from "antd";
import { routers } from "../App";
import { AuthService, LoginResult } from "../services";
import { useEffect, useState } from "react";

type MenuItem = Required<MenuProps>["items"][number];

const SBackground = styled.div`
  box-sizing: content-box;
  display: flex;
  justify-content: center;
`;

const SHomeBox = styled.div`
  width: 100%;
  max-width: 1280px;
  height: 100%;
  border-radius: 8px;
  background-color: #d8e2ef;
`;

const SMainMenuBox = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  gap: 8px;
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
  height: 140px;
  background-size: cover;
  background-repeat: no-repeat;
  background-position-y: bottom;
`;

const authService = new AuthService();

const LogoButton = (props: { name: string } & ButtonProps) => {
  return (
    <Button
      style={{ border: "none" }}
      icon={<img src={`/icons/buttons/${props.name}.svg`} width={26} />}
      {...props}
    />
  );
};

export const Layout = () => {
  const items: MenuItem[] = routers
    .filter((v) => !v.hidden)
    .map((v) => toMenu(v));

  const naviate = useNavigate();

  const location = useLocation();

  const path = location.pathname.split("/");
  const key = path[path.length - 1];

  const [loginResult, setLoginResult] = useState<LoginResult>();

  useEffect(() => {
    authService.validate().then(setLoginResult);
  }, []);

  return (
    <SBackground>
      <SHomeBox>
        <SImg></SImg>
        <Ant.Affix>
          <Ant.Menu
            style={{ justifyContent: "center", background: "#294d7f" }}
            activeKey={key}
            theme="dark"
            selectedKeys={path}
            onClick={(p) => {
              const s = ["/", ...p.keyPath.reverse()].filter(
                (v) => "rc-menu-more" !== v
              );
              naviate(joinPath(...s));
            }}
            mode="horizontal"
            items={items}
          ></Ant.Menu>
        </Ant.Affix>
        <SMainMenuBox>
          <Ant.Card>
            <Ant.Flex gap={4} align="center">
              <Flex align="center">
                <Ant.Typography.Text
                  style={{
                    fontWeight: "bold",
                    color: "#14598D",
                    marginRight: 28,
                  }}
                >
                  {loginResult?.username}
                </Ant.Typography.Text>
              </Flex>
              <Button
                style={{ backgroundColor: "#14598D" }}
                type="primary"
                iconPosition="end"
                icon={<AntIcon.DownCircleFilled />}
              >
                我的数据
              </Button>
              <LogoButton name="1" />
              <LogoButton name="2" />
              <LogoButton name="3" />
              <LogoButton name="4" />
              <LogoButton name="5" />
              <LogoButton name="6" />
              <LogoButton name="7" />
              <LogoButton name="8" />
              <LogoButton name="9" />
              <LogoButton name="10" />
              <LogoButton name="11" />
              <LogoButton name="12" />
              <LogoButton name="13" />
            </Ant.Flex>
          </Ant.Card>
          <Ant.Card>
            <p style={{ textAlign: "center" }}>
              <div>Telegram 官方交流群</div>
              <div>长期招聘官方web组发布成员 | Tracker异常反馈专贴</div>
              <div>官方求种区</div>
            </p>
          </Ant.Card>
          <Outlet />
        </SMainMenuBox>
      </SHomeBox>
    </SBackground>
  );
};
