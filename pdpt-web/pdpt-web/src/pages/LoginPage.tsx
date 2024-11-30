import { MenuButton, Pro } from "@common-module/common-antd";
import { Form, styled } from "@common-module/common-react";
import { Tabs } from "antd";

const SBack = styled.div`
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const SFrame = styled.div`
  background-color: #fff;
  height: 480px;
  width: 960px;
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
  height: 100%;
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

export const LoginPage = () => {
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
                  <Form>
                    <Pro.ProFormText name="username" placeholder="账号" />
                    <Pro.ProFormText name="password" placeholder="密码" />
                    <Pro.ProFormField
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
                        name="autoLogout"
                        addonAfter="限制只能使用本IP登录"
                      />
                    </Pro.ProFormGroup>
                    <MenuButton style={{ marginBottom: 8 }} type="primary">
                      登录
                    </MenuButton>
                    <MenuButton type="default">重置</MenuButton>
                  </Form>
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
