import { Ant, Button, Card, Table } from "@common-module/common-antd";

type BambooTableEntity = {
  title: string;
  description: string;
  price: number;
};

export const BambooShoot = () => {
  return (
    <Card title="竹笋系统">
      <Table<BambooTableEntity, BambooTableEntity>
        search={false}
        pagination={false}
        columns={[
          { title: "项目", render: (_, _2, idx) => idx + 1 },
          {
            title: "简介",
            render: (_, entity) => (
              <Ant.List.Item.Meta
                title={entity.title}
                description={entity.description}
              />
            ),
          },
          { title: "价格", dataIndex: "price" },
          { title: "交换", render: () => <Button type="primary">交换</Button> },
        ]}
        dataSource={[
          {
            title: "1.0 GB上传量",
            description:
              "如果有足够的魔力值，你可以用它来换取上传量。交易完成后，你的魔力值会减少，上传量则会增加。",
            price: 1200,
          },
          {
            title: "5.0 GB上传量",
            description:
              "如果有足够的魔力值，你可以用它来换取上传量。交易完成后，你的魔力值会减少，上传量则会增加。",
            price: 1200,
          },
          {
            title: "10.0 GB上传量",
            description:
              "如果有足够的魔力值，你可以用它来换取上传量。交易完成后，你的魔力值会减少，上传量则会增加。",
            price: 1200,
          },
          {
            title: "100.0 GB上传量",
            description:
              "如果有足够的魔力值，你可以用它来换取上传量。交易完成后，你的魔力值会减少，上传量则会增加。",
            price: 1200,
          },
          {
            title: "10.0 GB 下载量",
            description:
              "如果有足够的魔力值，你可以用它来换取下载量。交易完成后，你的魔力值会减少，下载量则会增加。",
            price: 1200,
          },
          {
            title: "100.0 GB 下载量",
            description:
              "如果有足够的魔力值，你可以用它来换取下载量。交易完成后，你的魔力值会减少，下载量则会增加。",
            price: 1200,
          },
          {
            title: "100.0 GB上传量",
            description:
              "如果有足够的魔力值，你可以用它来换取上传量。交易完成后，你的魔力值会减少，上传量则会增加。",
            price: 1200,
          },
          {
            title: "1个邀请名额",
            description:
              "如果有足够的魔力值，你可以用它来换取邀请名额。交易完成后，你的魔力值会减少，邀请名额数则会增加。",
            price: 1200,
          },
          {
            title: "1个临时邀请名额",
            description:
              "如果有足够的魔力值，你可以用它来换取临时邀请名额，有效期 7 天。交易完成后，你的魔力值会减少，邀请临时名额数则会增加。",
            price: 1200,
          },
        ]}
      />
    </Card>
  );
};
