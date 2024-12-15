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

  const [simpleSearchForm] = Pro.ProForm.useForm();
  const [searchForm] = Pro.ProForm.useForm();

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
              <Pro.ProForm layout="inline" form={simpleSearchForm}>
                <Pro.ProFormText width="md" name="keyWord" />
              </Pro.ProForm>
            ),
          },
          {
            key: "full",
            label: "搜索工具箱",
            children: (
              <Pro.ProForm
                submitter={{
                  render: (_, doms) => {
                    return (
                      <Ant.Flex justify="center">
                        <Ant.Space>{doms}</Ant.Space>
                      </Ant.Flex>
                    );
                  },
                }}
                form={searchForm}
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
                  name="category"
                  options={allCat?.categories.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="音频编码"
                  name="audioEncoding"
                  options={allCat?.audioEncodings.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="编码"
                  name="encoding"
                  options={allCat?.encodings.map((v) => ({
                    label: v.name,
                    value: v.id,
                  }))}
                />
                <Pro.ProFormCheckbox.Group
                  label="分辨率"
                  name="resolution"
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
        pagination={{
          defaultPageSize: 50,
          pageSizeOptions: [20, 50, 100],
          showLessItems: true,
        }}
        request={async (params) => {
          const data = await torrentService.listPaged({
            pageSize: params.pageSize ?? 50,
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
            width: "7.5em",
            render: (_, entity) => {
              return (
                <Ant.Flex>
                  <img src={`/icons/category/${entity.categoryCode}.svg`}></img>
                  <img src={`/icons/source/${entity.source}.svg`}></img>
                </Ant.Flex>
              );
            },
          },
          {
            title: "封面",
            width: "4.5em",
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
                <Ant.Flex vertical align="start">
                  <span
                    style={{ fontWeight: "bold", cursor: "pointer" }}
                    onClick={() => navigate(`/torrent/detail/${entity.id}`)}
                  >
                    {dom}
                  </span>
                  <Ant.Tooltip title={entity.smallDescr}>
                    <Ant.Typography.Text ellipsis>
                      {entity.smallDescr}
                    </Ant.Typography.Text>
                  </Ant.Tooltip>
                </Ant.Flex>
              );
            },
          },
          {
            title: "操作",
            width: "4em",
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
                    <AntIcon.StarOutlined style={{ cursor: "pointer" }} />
                  </div>
                </div>
              );
            },
          },
          { title: "时间", dataIndex: "added", ellipsis: true, width: "8em" },
          {
            title: "大小",
            width: "5em",
            dataIndex: "size",
            render: (_, entity) => {
              return FileSizeConverter.ofByte(entity.size).gb() + "GB";
            },
          },
          {
            title: "下载",
            width: "3em",
            dataIndex: "leechers",
            render: (dom) => (
              <Ant.Flex>
                {dom} <AntIcon.ArrowDownOutlined />
              </Ant.Flex>
            ),
          },
          {
            title: "做种",
            width: "3em",
            dataIndex: "seeders",
            render: (dom) => (
              <Ant.Flex>
                {dom} <AntIcon.ArrowUpOutlined />
              </Ant.Flex>
            ),
          },
          {
            title: "上传者",
            width: "6em",
            dataIndex: "ownerName",
            ellipsis: true,
          },
        ]}
      />
    </SBox>
  );
};
