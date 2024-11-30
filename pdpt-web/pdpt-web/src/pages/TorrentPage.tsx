import { styled, Table } from "@common-module/common-antd";
import { FileSizeConverter } from "@common-module/common-util";
import { CategoryEntity, CategoryService, TorrentsService } from "../services";
import { useEffect, useState } from "react";

const SBox = styled.div`
  background-color: #f2f6fe;
  margin: 24px;
  padding: 24px;
  border-radius: 8px;
  box-sizing: content-box;
`;

const torrentService = new TorrentsService();
const categoryService = new CategoryService();

export const TorrentPage = () => {
  const [categories, setCategories] = useState<CategoryEntity[]>();

  useEffect(() => {
    categoryService.list().then(setCategories);
  }, []);

  return (
    <SBox>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {categories?.map((v) => (
          <img src={`/icons/category/${v.className}.svg`} alt={v.name}></img>
        ))}
      </div>
      <div style={{ display: "flex", justifyContent: "center" }}>
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
            title: "序号",
            width: 40,
            render: (dom, enetity, index) => {
              return index;
            },
          },
          {
            title: "类别",
            width: 60,
            render: (_, entity) => {
              return (
                <img src={`/icons/category/${entity.categoryCode}.svg`}></img>
              );
            },
          },
          {
            title: "封面",
            width: 60,
            dataIndex: "cover",
            render: (_, entity) => {
              return (
                <img
                  style={{ borderRadius: 4 }}
                  width={40}
                  src={entity.cover}
                ></img>
              );
            },
          },
          { title: "名称", dataIndex: "name", ellipsis: true },
          { title: "添加时间", dataIndex: "added", width: 160, ellipsis: true },
          {
            title: "大小",
            dataIndex: "size",
            render: (_, entity) => {
              return FileSizeConverter.ofByte(entity.size).gb() + "GB";
            },
            width: 70,
          },
          { title: "下载", dataIndex: "leechers", width: 40 },
          { title: "做种", dataIndex: "seeders", width: 40 },
          {
            title: "上传者",
            dataIndex: "ownerName",
            width: 100,
            ellipsis: true,
          },
        ]}
      />
    </SBox>
  );
};
