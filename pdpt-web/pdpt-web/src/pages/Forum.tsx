import { Ant, Table } from "@common-module/common-antd";
import { useNavigate } from "@common-module/common-react";
import { ConfigProvider, theme } from "antd";
import { useEffect, useState } from "react";
import { ForumsEntity, ForumsService, OverForumsEntity } from "../services";

const forumsService = new ForumsService();

export const Forum = () => {
  const [forums, setForums] = useState<OverForumsEntity[]>();

  useEffect(() => {
    forumsService.forumsStructure().then(setForums);
  }, []);

  const navigate = useNavigate();

  return (
    <ConfigProvider theme={{ algorithm: [theme.defaultAlgorithm] }}>
      <Ant.Flex vertical gap={8}>
        {forums?.map((v) => {
          return (
            <Ant.Card>
              <Table<ForumsEntity, ForumsEntity>
                pagination={false}
                search={false}
                dataSource={v.forums}
                columns={[
                  {
                    title: v.name,
                    render: (dom, entity) => {
                      return (
                        <div>
                          <div>
                            <span
                              style={{ cursor: "pointer", fontWeight: "bold" }}
                              onClick={() =>
                                navigate(`/forum/topics/${entity.id}`)
                              }
                            >
                              {entity.name}
                            </span>
                          </div>
                          <div>{entity.description}</div>
                        </div>
                      );
                    },
                  },
                  {
                    title: "主题",
                    dataIndex: "topiccount",
                    width: 100,
                  },
                  {
                    title: "帖子",
                    dataIndex: "postcount",
                    width: 100,
                  },
                  {
                    title: "最近回复",
                    dataIndex: "lastAnswer",
                    width: 100,
                  },
                  {
                    title: "版主",
                    width: 100,
                    dataIndex: "admin",
                  },
                ]}
              ></Table>
            </Ant.Card>
          );
        })}
      </Ant.Flex>
    </ConfigProvider>
  );
};
