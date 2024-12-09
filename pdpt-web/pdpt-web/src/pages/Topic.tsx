import { Ant, Table } from "@common-module/common-antd";
import { ForumsService, TopicEntity } from "../services";
import { useEffect, useState } from "react";
import { useParams } from "@common-module/common-react";
import { ConfigProvider, theme } from "antd";

const forumService = new ForumsService();

export const Topic = () => {
  const [topics, setTopics] = useState<TopicEntity[]>();

  const params = useParams<{ id: string }>();

  useEffect(() => {
    if (params.id) {
      forumService.listTopicByForumId(+params.id).then(setTopics);
    }
  }, []);

  return (
    <ConfigProvider theme={{ algorithm: [theme.defaultAlgorithm] }}>
      <Ant.Card>
        <Table<TopicEntity, TopicEntity>
          dataSource={topics}
          search={false}
          columns={[
            {
              title: "主题",
              dataIndex: "subject",
              render: (dom) => {
                return (
                  <span style={{ cursor: "pointer", fontWeight: "bold" }}>
                    {dom}
                  </span>
                );
              },
            },
            {
              title: "回复/查看",
              width: 100,
              render: (dom, entity) => ` ${entity.lastpost} / ${entity.views}`,
            },
            {
              title: "作者",
              width: 100,
              dataIndex: "author",
            },
          ]}
        ></Table>
      </Ant.Card>
    </ConfigProvider>
  );
};
