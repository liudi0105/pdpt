import { Table } from "@common-module/common-antd";
import { FileSizeConverter } from "@common-module/common-util";
import { CategoryEntity, CategoryService, TorrentsService } from "../services";
import { useEffect, useState } from "react";

const torrentService = new TorrentsService();
const categoryService = new CategoryService();

export const TorrentPage = () => {
  const [categories, setCategories] = useState<CategoryEntity[]>();

  useEffect(() => {
    categoryService.list().then(setCategories);
  }, []);

  return (
    <div>
      <div>
        {categories?.map((v) => (
          <img src={`/icons/category/${v.className}.svg`}></img>
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
        request={async (params) => {
          const data = await torrentService.listPaged({
            pageSize: params.pageSize ?? 10,
            pageIndex: params.current ?? 1,
          });
          return {
            total: data.totalElements,
            data: data.content,
          };
        }}
        size="small"
        search={false}
        columns={[
          {
            title: "类别",
            render: (_, entity) => {
              return (
                <img src={`/icons/category/${entity.categoryCode}.svg`}></img>
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
      />
    </div>
  );
};
