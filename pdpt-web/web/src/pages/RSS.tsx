import { Card, GridList, Pro } from "@common-module/common-antd";

export const RSS = () => {
  return (
    <Card title='RSS订阅系统'>
      <GridList
        gutter={8}
        columnSpan={[4, 20]}
        items={[
          [
            "检索分类",
            <Pro.ProForm submitter={false} layout="horizontal" noValidate>
              <Pro.ProFormCheckbox.Group
                name="category"
                options={[
                  { label: "电影", value: "" },
                  { label: "电视", value: "tv" },
                ]}
              ></Pro.ProFormCheckbox.Group>
            </Pro.ProForm>,
          ],
          ["显示收藏", <div> sdfdf </div>],
          ["置顶", <div> sdfdf </div>],
          ["项目标题格式", <div> sdfdf </div>],
          ["每页条数", <div> sdfdf </div>],
          ["关键字", <div> sdfdf </div>],
        ]}
      />
    </Card>
  );
};
