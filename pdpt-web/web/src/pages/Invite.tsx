import { Ant, Card, Table } from "@common-module/common-antd";

export const Invite = () => {
  return (
    <Card title="邀请系统">
      <Ant.Tabs
        centered
        items={[
          {
            key: "status",
            label: "被邀请者当前状态",
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
            key: "sent",
            label: "已发邀请状态",
            children: "",
          },
          { key: "temperal", label: "临时邀请状态", children: "" },
        ]}
      ></Ant.Tabs>
    </Card>
  );
};
