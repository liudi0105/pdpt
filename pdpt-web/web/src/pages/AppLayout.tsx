import { Ant, AntIcon, Button, GridList } from "@common-module/common-antd";
import { RouterMenuItem } from "@common-module/common-api";
import {
  Outlet,
  styled,
  useLocation,
  useNavigate,
} from "@common-module/common-react";
import { Files, joinPath } from "@common-module/common-util";
import {
  AuthService,
  LoginResult,
  PersonalInfoVO,
  UserService,
} from "@pdpt/lib";
import {
  ButtonProps,
  ConfigProvider,
  MenuProps,
  Popover,
  theme,
  Tooltip,
} from "antd";
import dayjs from "dayjs";
import { useEffect, useState } from "react";
import { routers } from "../router";

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

const UserInfoCard = styled(Ant.Card)`
  position: relative;
  .ant-card-body {
    display: flex;
    align-items: center;
  }
`;

const authService = new AuthService();
const userService = new UserService();

const LogoButton = (
  props: { path?: string; title: string; name: string } & ButtonProps
) => {
  const navigate = useNavigate();

  return (
    <Tooltip title={props.title}>
      <Button
        style={{ border: "none" }}
        onClick={(e) => {
          if (props.onClick) {
            props.onClick(e);
          } else if (props.path) {
            navigate(props.path);
          }
        }}
        icon={
          <Ant.Image
            preview={false}
            src={`/icons/buttons/${props.name}.svg`}
            width={26}
          />
        }
        {...props}
      />
    </Tooltip>
  );
};

const ButtonsRight = () => {
  const [date, setDate] = useState(dayjs());

  useEffect(() => {
    setInterval(() => {
      setDate(dayjs());
    }, 1000);
  }, []);

  return (
    <Ant.Flex style={{ position: "absolute", right: 8 }}>
      <Ant.Typography.Text>
        当前时间：
        <span style={{ fontWeight: "bold" }}>{date.format("HH:mm")}</span>
      </Ant.Typography.Text>
      <Button
        size="small"
        type="link"
        onClick={async () => {
          await authService.logout();
          Ant.message.info("退出成功");
          await authService.validate();
        }}
      >
        「退出」
      </Button>
    </Ant.Flex>
  );
};

export const AppLayout = () => {
  const items: MenuItem[] = routers
    .filter((v) => !v.hidden)
    .map((v) => toMenu(v));

  const navigate = useNavigate();

  const location = useLocation();

  const path = location.pathname.split("/");
  const key = path[path.length - 1];

  const [loginResult, setLoginResult] = useState<LoginResult>();

  const [personalInfo, setPersonalInfo] = useState<PersonalInfoVO>();

  useEffect(() => {
    authService.validate().then(setLoginResult);
    userService.personalInfo().then(setPersonalInfo);
  }, []);

  return (
    <SBackground>
      <SHomeBox>
        <SImg></SImg>
        <Ant.Affix>
          <ConfigProvider theme={{ algorithm: [theme.defaultAlgorithm] }}>
            <Ant.Menu
              style={{ justifyContent: "center", background: "#294d7f" }}
              activeKey={key}
              theme="dark"
              selectedKeys={path}
              onClick={(p) => {
                const s = ["/", ...p.keyPath.reverse()].filter(
                  (v) => "rc-menu-more" !== v
                );
                navigate(joinPath(...s));
              }}
              mode="horizontal"
              items={items}
            ></Ant.Menu>
          </ConfigProvider>
        </Ant.Affix>
        <SMainMenuBox>
          <UserInfoCard>
            <Ant.Flex gap={4} align="center">
              <Ant.Image
                style={{
                  position: "absolute",
                  top: -20,
                  left: 16,
                  width: 42,
                  height: 42,
                }}
                preview={false}
                src="/icons/avatar.svg"
              />
              <Ant.Typography.Text
                style={{
                  fontWeight: "bold",
                  color: "#14598D",
                  marginLeft: 56,
                  marginRight: 28,
                }}
              >
                {loginResult?.username}
              </Ant.Typography.Text>
              <Popover
                overlayStyle={{ width: "16em" }}
                placement="bottom"
                content={
                  <GridList
                    gutter={0}
                    columnSpan={[12, 12]}
                    items={[
                      ["竹笋保有量", personalInfo?.bambooShootAmount],
                      ["药品保有量", personalInfo?.inviteAmount],
                      ["勋章保有量", personalInfo?.medalAmount],
                      ["分享率", personalInfo?.shareRatio],
                      ["H&R", personalInfo?.hitAndRunAmount],
                      [
                        "上传量",
                        Files.formatFileSize(personalInfo?.uploadSize ?? 0),
                      ],
                      [
                        "下载量",
                        Files.formatFileSize(personalInfo?.downloadSize ?? 0),
                      ],
                      ["当前上传", personalInfo?.currentUploadAmount],
                      ["当前下载", personalInfo?.currentDownloadAmount],
                      ["做种积分", personalInfo?.seedScore],
                    ]}
                  />
                }
              >
                <Button
                  type="primary"
                  iconPosition="end"
                  icon={<AntIcon.DownCircleFilled />}
                >
                  我的数据
                </Button>
              </Popover>
              <LogoButton title="竹笋" name="1" path="/bamboo-shoot" />
              <LogoButton title="勋章" name="2" path="/medal" />
              <LogoButton title="邀请" name="3" path="/invite" />
              <LogoButton title="RSS" name="4" path="/rss" />
              <LogoButton title="收藏夹" name="5" />
              <LogoButton title="幸运大转盘" name="6" />
              <LogoButton title="地球仪" name="7" />
              <LogoButton title="心脏" name="8" />
              <Popover
                trigger="click"
                content={
                  <Ant.Flex vertical align="end">
                    <Ant.Space>
                      <Button type="primary">补签</Button>
                      <Button type="primary">签到</Button>
                    </Ant.Space>
                    <Ant.Calendar style={{ width: 300 }} fullscreen={false} />
                  </Ant.Flex>
                }
              >
                <LogoButton title="签到" name="9" />
              </Popover>
              <LogoButton title="消息" name="10" />
              <LogoButton title="纸飞机" name="11" />
              <LogoButton title="好朋友" name="12" />
              <Ant.Tooltip title="设置中心">
                <Button
                  icon={
                    <AntIcon.SettingOutlined style={{ fontSize: "1.5em" }} />
                  }
                  onClick={() => {
                    navigate("/setting-center");
                  }}
                />
              </Ant.Tooltip>
              <Ant.Tooltip title="管理员设置">
                <Button
                  href="/manage/"
                  target="_blank"
                  icon={
                    <AntIcon.ControlOutlined style={{ fontSize: "1.5em" }} />
                  }
                />
              </Ant.Tooltip>
              <ButtonsRight />
            </Ant.Flex>
          </UserInfoCard>
          {/* <Ant.Card>
            <p style={{ textAlign: "center" }}>
              <div>Telegram 官方交流群</div>
              <div>长期招聘官方web组发布成员 | Tracker异常反馈专贴</div>
              <div>官方求种区</div>
            </p>
          </Ant.Card> */}
          <Outlet />
        </SMainMenuBox>
      </SHomeBox>
    </SBackground>
  );
};
