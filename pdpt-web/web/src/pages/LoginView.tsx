import { Ant, MenuButton, Pro } from "@common-module/common-antd";
import { Form, styled, useNavigate } from "@common-module/common-react";
import { Strings } from "@common-module/common-util";
import { Tabs } from "antd";
import { AuthService } from "@pdpt/lib";

const SBack = styled.div`
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const SFrame = styled.div`
  background-color: #fff;
  height: 560px;
  width: 1080px;
  border-radius: 16px;
  display: flex;
`;

const SPicture = styled.div`
  background-image: url("/images/login/1.jpg");
  background-size: cover;
  height: 100%;
  width: 60%;
  border-radius: 16px 0 0 16px;
  flex-shrink: 0;
`;

const SFuncArea = styled.div`
  padding: 48px;
  padding-bottom: 0;
  max-height: 100%;
  width: 50%;

  &::before {
    content: "";
    background-image: url("/login-logo.png");
    background-size: contain;
    background-repeat: no-repeat;
    background-position: right;
    display: block;
    width: 100%;
    height: 80px;
  }
`;

const authService = new AuthService();

export const LoginView = () => {
  const navigate = useNavigate();

  return (
    <SBack>
      <SFrame>
        <SPicture></SPicture>
        <SFuncArea>
          <Tabs
            tabBarExtraContent={`您还有[10]次尝试机会`}
            items={[
              {
                key: "login",
                label: "登录",
                children: (
                  <Pro.ProForm<{ username: string; password: string }>
                    submitter={false}
                    onFinish={async (value) => {
                      const { username, password } = value;
                      if (Strings.isAnyEmpty([username, password])) {
                        Ant.message.warning("请输入用户名和密码");
                      } else {
                        const r = await authService.login(value);
                        if (r.username) {
                          navigate("/");
                        }
                      }
                    }}
                  >
                    <Pro.ProFormText
                      name="username"
                      placeholder="账号"
                      required
                    />
                    <Pro.ProFormText.Password
                      name="password"
                      placeholder="密码"
                    />
                    <Pro.ProFormText
                      fieldProps={{
                        addonBefore: "二次验证",
                      }}
                      name="captcher"
                    />
                    <Pro.ProFormGroup>
                      <Pro.ProFormCheckbox
                        name="autoLogout"
                        addonAfter="15分钟后自动登出"
                      />
                      <Pro.ProFormCheckbox
                        name="onlyThisIp"
                        addonAfter="限制只能使用本IP登录"
                      />
                    </Pro.ProFormGroup>
                    <MenuButton
                      style={{ marginBottom: 8 }}
                      htmlType="submit"
                      type="primary"
                    >
                      登录
                    </MenuButton>
                    <MenuButton htmlType="reset" type="default">
                      重置
                    </MenuButton>
                  </Pro.ProForm>
                ),
              },
              {
                key: "register",
                label: "注册",
                children: <Form></Form>,
              },
            ]}
          ></Tabs>
        </SFuncArea>
      </SFrame>
    </SBack>
  );
};
