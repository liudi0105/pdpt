import bbobHTML from "@bbob/html";
import presetHTML5 from "@bbob/preset-html5";
import { Ant, AntIcon, Button } from "@common-module/common-antd";
import { styled, useParams } from "@common-module/common-react";
import { ConfigProvider, Flex, theme } from "antd";
import { useEffect, useState } from "react";
import { ForumsService, PostsEntity, TopicEntity } from "../services";

const SAvatar = styled.div`
  width: 120px;
  height: 120px;
  background-image: url("/icons/user_avatar.svg");
  background-size: contain;
  background-position: center;
  border: 0.5px solid #c0c7d3;
  border-radius: 4px;
`;

const forumService = new ForumsService();

export const Posts = () => {
  const params = useParams<{ id: string }>();
  const [topic, setTopic] = useState<TopicEntity>();

  const [posts, setPosts] = useState<PostsEntity[]>();

  useEffect(() => {
    if (params.id) {
      forumService.listPostsByTopicId(+params.id).then(setPosts);
      forumService.getTopicById(+params.id).then(setTopic);
    }
  }, []);

  return (
    <ConfigProvider theme={{ algorithm: [theme.compactAlgorithm] }}>
      <Flex vertical gap={8}>
        <Ant.Card>
          <Ant.Breadcrumb
            items={
              topic
                ? [
                    { key: "forum", title: "论坛" },
                    { key: topic?.blockName, title: topic?.blockName },
                    { key: topic?.forumName, title: topic?.forumName },
                    { key: topic?.subject, title: topic?.subject },
                  ]
                : []
            }
          ></Ant.Breadcrumb>
        </Ant.Card>
        {posts?.map((v) => (
          <Ant.Card
            styles={{
              body: {
                padding: 0,
              },
            }}
            title={
              <Flex gap={24}>
                <span style={{ color: "red" }}>{v.username}</span>
                <span style={{ fontWeight: "normal" }}>{v.added}</span>
              </Flex>
            }
          >
            <Flex>
              <div
                style={{
                  width: 128,
                  backgroundColor: "#f2f5fe",
                  padding: "8px 0 8px 8px",
                }}
              >
                <SAvatar></SAvatar>
                <div>帖子：322</div>
                <div>上传：138 GB</div>
                <div>下载：358 GB</div>
                <div>分享率：5.23</div>
                <Ant.Space>
                  <Button size="small" icon={<AntIcon.MailOutlined />}>
                    P M
                  </Button>
                  <Button
                    size="small"
                    danger
                    type="primary"
                    icon={<AntIcon.ExclamationCircleOutlined />}
                  >
                    举报
                  </Button>
                </Ant.Space>
              </div>
              <Flex
                style={{ flexGrow: 1 }}
                vertical
                justify="stretch"
                align="stretch"
              >
                <pre
                  style={{ flexGrow: 1, padding: 16 }}
                  dangerouslySetInnerHTML={{
                    __html: bbobHTML(v.body, presetHTML5()),
                  }}
                ></pre>
                <div
                  style={{
                    width: "100%",
                    height: 28,
                    borderTop: "1px solid #c0c7d3",
                    position: "relative",
                  }}
                >
                  <Button
                    size="small"
                    type="primary"
                    style={{ position: "absolute", top: 4, right: 16 }}
                  >
                    引用
                  </Button>
                </div>
              </Flex>
            </Flex>
          </Ant.Card>
        ))}
      </Flex>
    </ConfigProvider>
  );
};
