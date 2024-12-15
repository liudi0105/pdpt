import { Ant, Table } from "@common-module/common-antd";
import { ForumsEntity, ForumsService, TopicEntity } from "../services";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "@common-module/common-react";
import { Card, ConfigProvider, Flex, theme } from "antd";

const forumService = new ForumsService();

export const Topic = () => {
  const [topics, setTopics] = useState<TopicEntity[]>();

  const [forum, setForum] = useState<ForumsEntity>();

  const params = useParams<{ id: string }>();

  const navigate = useNavigate();

  useEffect(() => {
    if (params.id) {
      forumService.listTopicByForumId(+params.id).then(setTopics);
      forumService.getForumById(+params.id).then(setForum);
    }
  }, []);

  return (
    <ConfigProvider theme={{ algorithm: [theme.defaultAlgorithm] }}>
      <Flex vertical gap={8}>
        <Card>
          <Ant.Breadcrumb
            items={
              forum
                ? [
                    { key: "forum", title: "论坛" },
                    { key: forum?.blockName, title: forum?.blockName },
                    { key: forum?.name, title: forum?.name },
                  ]
                : []
            }
          ></Ant.Breadcrumb>
        </Card>
        <Ant.Card>
          <Table<TopicEntity, TopicEntity>
            dataSource={topics}
            search={false}
            columns={[
              {
                title: "主题",
                dataIndex: "subject",
                render: (dom, entity) => {
                  return (
                    <span
                      style={{ cursor: "pointer" }}
                      onClick={() => {
                        navigate(`/forum/posts/${entity.id}`);
                      }}
                    >
                      {dom}
                    </span>
                  );
                },
              },
              {
                title: "回复/查看",
                width: 100,
                render: (_, entity) => ` ${entity.lastpost} / ${entity.views}`,
              },
              {
                title: "作者",
                width: 100,
                dataIndex: "author",
              },
            ]}
          ></Table>
        </Ant.Card>
      </Flex>
    </ConfigProvider>
  );
};
