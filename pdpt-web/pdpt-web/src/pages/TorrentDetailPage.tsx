import bbobHTML from "@bbob/html";
import presetHTML5 from "@bbob/preset-html5";
import { Ant, Table } from "@common-module/common-antd";
import { styled, useParams } from "@common-module/common-react";
import { Button, Space } from "antd";
import { useEffect, useState } from "react";
import { TorrentEntity, TorrentsService } from "../services";
import { SBox } from "./TorrentView";

const torrentService = new TorrentsService();

const SDescription = styled.div`
  img {
    max-width: 1000px;
  }
`;

export const TorrentDetailPage = () => {
  const [torrent, setTorrent] = useState<TorrentEntity>();

  const params = useParams<{ id: string }>();

  useEffect(() => {
    if (!params.id) {
      return;
    }
    torrentService.getOneById(+params.id).then(setTorrent);
  }, []);

  return (
    <SBox>
      <Table
        title={() => (
          <Ant.Typography.Title level={2} ellipsis title={torrent?.name}>
            {torrent?.name}
          </Ant.Typography.Title>
        )}
        pagination={false}
        search={false}
        tableLayout="fixed"
        showHeader={false}
        columns={[
          {
            dataIndex: "name",
            width: 100,
            minWidth: 100,
            render: (dom) => {
              return <div style={{ position: "absolute", top: 8 }}>{dom}</div>;
            },
          },
          {
            dataIndex: "value",
            render: (dom, entity) => {
              if (entity.name == "简介") {
                const v = entity.value as string;
                return v ? (
                  <SDescription>
                    <pre
                      style={{
                        textWrap: "wrap",
                      }}
                      dangerouslySetInnerHTML={{
                        __html: bbobHTML(v, presetHTML5()),
                      }}
                    ></pre>
                  </SDescription>
                ) : (
                  "-"
                );
              }
              return dom;
            },
          },
        ]}
        dataSource={[
          { name: "下载", value: torrent?.filename },
          { name: "副标题", value: torrent?.smallDescr },
          { name: "标签", value: torrent?.tags.length ? torrent?.tags : "-" },
          {
            name: "基本信息",
            value: (
              <Space>
                大小：1.72 GB 类型: 电视剧 媒介: WEB-DL 分辨率: 2160p/4K 编码:
                HEVC/H.265/x265 音频编码: AAC 制作组:
                AilMWeb(PANDA流媒体组-分集) 地区: CHN(中国大陆)
              </Space>
            ),
          },
          {
            name: "行为",
            value: (
              <Space>
                <Button type="primary">下载种子</Button>
                <Button type="primary">举报种子</Button>
              </Space>
            ),
          },
          { name: "简介", value: torrent?.descr },
        ]}
      ></Table>
    </SBox>
  );
};
