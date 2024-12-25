import { Ant, AntIcon, Pro, Table } from "@common-module/common-antd";
import { styled, useNavigate } from "@common-module/common-react";
import { Files } from "@common-module/common-util";
import { useEffect, useState } from "react";
import {
  AllCategory,
  CategoryService,
  TorrentEntity,
  TorrentsService,
} from "@pdpt/lib";

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
      <Table<TorrentEntity>
        pagination={{
          defaultPageSize: 50,
          pageSizeOptions: [20, 50, 100],
          showLessItems: true,
        }}
        request={(params) => {
          return torrentService.listPaged(params);
        }}
        search={false}
        columns={[
          {
            title: "类别",
            width: "4em",
            render: (_, entity) => {
              return (
                <Ant.Image src={`/icons/category/${entity.categoryCode}.svg`} />
              );
            },
          },
          {
            title: "封面",
            width: "4.5em",
            dataIndex: "cover",
            render: (_, entity) => {
              return (
                <Ant.Image
                  fallback="data:image/png;base64,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"
                  style={{ borderRadius: 4 }}
                  width={40}
                  src={entity.cover}
                />
              );
            },
          },
          {
            title: "名称",
            dataIndex: "name",
            ellipsis: true,
            render: (_, entity) => {
              return (
                <Ant.Flex vertical align="start">
                  <span
                    style={{ fontWeight: "bold", cursor: "pointer" }}
                    onClick={() => navigate(`/torrent/detail/${entity.id}`)}
                  >
                    <Ant.Tooltip title={entity.name}>{entity.name}</Ant.Tooltip>
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
              return Files.formatFileSize(entity.size);
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
