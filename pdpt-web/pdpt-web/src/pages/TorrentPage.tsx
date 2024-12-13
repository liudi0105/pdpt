import { Ant, AntIcon, Pro, Table } from "@common-module/common-antd";
import { FileSizeConverter } from "@common-module/common-util";
import { useEffect, useState } from "react";
import {
  AllCategory,
  CategoryService,
  TorrentEntity,
  TorrentsService,
} from "../services";
import { styled, useNavigate } from "@common-module/common-react";

export const SBox = styled.div`
  background-color: #fff;
  padding: 24px;
  border-radius: 8px;
  box-sizing: content-box;
  display: flex;
  flex-direction: column;
  row-gap: 16px;
`;

const torrentService = new TorrentsService();
const categoryService = new CategoryService();

export const TorrentPage = () => {
  const [allCat, setAllCat] = useState<AllCategory>();

  const navigate = useNavigate();

  useEffect(() => {
    categoryService.listAllCategory().then(setAllCat);
  }, []);

  return (
    <SBox>
      <Ant.Collapse
        bordered={false}
        accordion
        defaultActiveKey="simple"
        items={[
          {
            key: "simple",
            label: "简单搜索",
            children: (
              <Pro.ProForm layout="inline">
                <Pro.ProFormText width="lg" />
              </Pro.ProForm>
            ),
          },
          {
            key: "full",
            label: "搜索工具箱",
            children: (
              <Pro.ProForm
                layout="horizontal"
                labelAlign="left"
                labelCol={{
                  span: 2,
                }}
                wrapperCol={{
                  span: 24,
                }}
              >
                <Pro.ProFormCheckbox.Group
                  label="分类"
                  options={allCat?.categories.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="音频编码"
                  options={allCat?.audioEncodings.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="编码"
                  options={allCat?.encodings.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="分辨率"
                  options={allCat?.resolutions.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormText label="关键字" />
              </Pro.ProForm>
            ),
          },
        ]}
      ></Ant.Collapse>
      <Table<TorrentEntity, TorrentEntity>
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
          {
            title: "操作",
            width: 48,
            align: "center",
            render: () => {
              return (
                <div>
                  <div>
                    <AntIcon.CloudDownloadOutlined
                      style={{ cursor: "pointer" }}
                    />
                  </div>
                  <div>
                    <AntIcon.HeartOutlined style={{ cursor: "pointer" }} />
                  </div>
                </div>
              );
            },
          },
          { title: "添加时间", dataIndex: "added", width: 170, ellipsis: true },
          {
            title: "大小",
            dataIndex: "size",
            render: (_, entity) => {
              return FileSizeConverter.ofByte(entity.size).gb() + "GB";
            },
            width: 70,
          },
          { title: "下载", dataIndex: "leechers", width: 48 },
          { title: "做种", dataIndex: "seeders", width: 48 },
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
