import { Table } from "@common-module/common-antd";
import { AppPageResult } from "@common-module/common-types";
import {
  FileSizeConverter
} from "@common-module/common-util";
import { useEffect, useState } from "react";
import { TorrentEntity, TorrentsService } from "../services";

const torrentService = new TorrentsService();

const categoryMap = new Map<number, string>();
categoryMap.set(417, "animation");
categoryMap.set(402, "film");

export const TorrentPage = () => {
  const [data, setData] = useState<AppPageResult<TorrentEntity>>();

  useEffect(() => {
    torrentService
      .listPaged({
        pageSize: 10,
        pageIndex: 1,
      })
      .then((v) => setData(v));
  }, []);

  console.log(data);
  return (
    <div>
      <div>
        {[
          "sports",
          "mv",
          "game",
          "mv",
          "other",
          "tv",
          "book",
          "animation",
          "film",
          "music",
        ].map((v) => (
          <img src={`/icons/category/${v}.svg`}></img>
        ))}
      </div>
      <div>
        {[
          "bd",
          "cd",
          "dvdr",
          "encode",
          "hddvd",
          "hdtv",
          "minibd",
          "remux",
          "track",
          "uhdbd",
          "uhdtv",
          "webdl",
        ].map((v) => (
          <img src={`/icons/edition/${v}.svg`}></img>
        ))}
      </div>
      <Table
        size="small"
        search={false}
        pagination={{
          total: data?.totalElements,
        }}
        columns={[
          {
            title: "类别",
            render: (_, entity) => {
              return (
                <img
                  src={`/icons/category/${categoryMap.get(
                    entity.category
                  )}.svg`}
                ></img>
              );
            },
          },
          {
            title: "封面",
            dataIndex: "cover",
            render: (_, entity) => {
              return <img width={40} src={entity.cover}></img>;
            },
          },
          { title: "名称", dataIndex: "name" },
          { title: "添加时间", dataIndex: "added" },
          {
            title: "大小",
            dataIndex: "size",
            render: (_, entity) => {
              return FileSizeConverter.ofByte(entity.size).gb() + "GB";
            },
          },
          { title: "下载数", dataIndex: "leechers" },
          { title: "做种数", dataIndex: "seeders" },
          { title: "上传者", dataIndex: "ownerName" },
        ]}
        dataSource={data?.content}
      />
    </div>
  );
};
