import { Button, Card, Space } from "antd";
import { useEffect, useState } from "react";
import { TorrentEntity, TorrentsService } from "../services";
import { SBox } from "./TorrentPage";
import { useParams } from "@common-module/common-react";
import { Table } from "@common-module/common-antd";

const torrentService = new TorrentsService();

export const DetailPage = () => {
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
      <Card>
        <p style={{ textAlign: "center" }}>
          <div>Telegram 官方交流群</div>
          <div>长期招聘官方web组发布成员 | Tracker异常反馈专贴</div>
          <div>官方求种区</div>
        </p>
      </Card>
      <div>{torrent?.name}</div>
      <Table
        pagination={false}
        search={false}
        size="small"
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
            width: 1080,
            render: (dom, entity) => {
              if (entity.name == "简介") {
                return <pre style={{ textWrap: "wrap" }}>{dom}</pre>;
              }
              return entity.value;
            },
          },
        ]}
        dataSource={[
          { name: "下载", value: torrent?.filename },
          { name: "副标题", value: torrent?.smallDescr },
          { name: "标签", value: torrent?.tags },
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