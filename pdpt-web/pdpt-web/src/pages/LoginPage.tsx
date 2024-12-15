import { MenuButton, Pro } from "@common-module/common-antd";
import { Form, styled } from "@common-module/common-react";
import { Tabs } from "antd";
import { useForm } from "antd/es/form/Form";

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

export const LoginPage = () => {
  const [form] = useForm();

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
                  <Pro.ProForm
                    form={form}
                    submitter={false}
                    layout="horizontal"
                    labelCol={{ span: 0 }}
                  >
                    <Pro.ProFormText
                      name="username"
                      label="账号"
                      placeholder="账号"
                      required
                      rules={[{ required: true }]}
                    />
                    <Pro.ProFormText
                      name="password"
                      label="密码"
                      placeholder="密码"
                      rules={[{ required: true }]}
                    />
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
                        name="onlyThisIp"
                        addonAfter="限制只能使用本IP登录"
                      />
                    </Pro.ProFormGroup>
                    <MenuButton
                      style={{ marginBottom: 8 }}
                      type="primary"
                      onClick={async () => {
                        const v = await form.validateFields();
                        console.log(v);
                      }}
                    >
                      登录
                    </MenuButton>
                    <MenuButton
                      type="default"
                      onClick={() => form.resetFields()}
                    >
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
