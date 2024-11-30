import { styled, Table, useNavigate } from "@common-module/common-antd";
import { FileSizeConverter } from "@common-module/common-util";
import { useEffect, useState } from "react";
import { CategoryEntity, CategoryService, TorrentsService } from "../services";

export const SBox = styled.div`
  background-color: #fff;
  padding: 24px;
  border-radius: 8px;
  box-sizing: content-box;
`;

const torrentService = new TorrentsService();
const categoryService = new CategoryService();

export const TorrentPage = () => {
  const [categories, setCategories] = useState<CategoryEntity[]>();

  const navigate = useNavigate();

  useEffect(() => {
    categoryService.list().then(setCategories);
  }, []);

  return (
    <SBox>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {categories?.map((v) => (
          <img
            key={v.id}
            src={`/icons/category/${v.className}.svg`}
            alt={v.name}
          ></img>
        ))}
      </div>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {[0, 1, 2, 3, 7, 8].map((v) => (
          <img key={v} src={`/icons/source/${v}.svg`}></img>
        ))}
      </div>
      <Table
        pagination={{ defaultPageSize: 10 }}
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
            width: 48,
            render: (_, entity) => {
              return (
                <img src={`/icons/category/${entity.categoryCode}.svg`}></img>
              );
            },
          },
          {
            title: "来源",
            width: 48,
            render: (_, entity) => {
              return <img src={`/icons/source/${entity.source}.svg`}></img>;
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
          {
            title: "名称",
            dataIndex: "name",
            ellipsis: true,
            render: (dom, entity) => {
              return (
                <div>
                  <div
                    style={{ fontWeight: "bold", cursor: "pointer" }}
                    onClick={() => navigate(`/torrent/detail/${entity.id}`)}
                  >
                    {dom}
                  </div>
                  <div>{entity.smallDescr}</div>
                </div>
              );
            },
          },
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
