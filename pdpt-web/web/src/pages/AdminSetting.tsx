import { Ant, Card, Table } from "@common-module/common-antd";

export const AdminSetting = () => {
  return (
    <Card title="管理员设置">
      <Ant.Tabs
        centered
        items={[
          {
            key: "home",
            label: "设定首页",
            children: (
              <Table<{ title: string; value: string }>
                pagination={false}
                search={false}
                showHeader={false}
                columns={[
                  { dataIndex: "title", width: "6em" },
                  { dataIndex: "value" },
                ]}
                dataSource={[
                  { title: "加入日期", value: "" },
                  { title: "邮箱地址", value: "" },
                  { title: "IP/地点", value: "" },
                  { title: "密钥", value: "" },
                  { title: "宣传链接", value: "" },
                  { title: "邀请", value: "" },
                  { title: "魔力值", value: "" },
                  { title: "评论数", value: "" },
                  { title: "SeedBox", value: "" },
                ]}
              />
            ),
          },
          {
            key: "personal",
            label: "个人设定",
            children: "",
          },
          {
            key: "website",
            label: "网站设定",
            children: "",
          },
          {
            key: "security",
            label: "安全设定",
            children: "",
          },
        ]}
      ></Ant.Tabs>
    </Card>
  );
};
