import { Table } from "@common-module/common-antd";
import { RoleEntity, Tagservice } from "@pdpt/lib";

const tagsService = new Tagservice();

export const TagsView = () => {
  return (
    <Table<RoleEntity>
      request={(params) => tagsService.listPaged(params)}
      columns={[
        {
          title: "ID",
          dataIndex: "id",
          valueType: "text",
          width: 80,
          search: false, // 不显示在搜索框
        },
        {
          title: "标签名称",
          dataIndex: "name",
          valueType: "text",
          ellipsis: true,
          width: 150,
        },
        {
          title: "颜色",
          dataIndex: "color",
          valueType: "color", // 显示颜色类型
          width: 100,
        },
        {
          title: "优先级",
          dataIndex: "priority",
          valueType: "digit", // 数字类型
          width: 100,
          sorter: true, // 可排序
        },
        {
          title: "创建时间",
          dataIndex: "createdAt",
          valueType: "dateTime", // 日期时间类型
          width: 180,
          search: false,
        },
        {
          title: "更新时间",
          dataIndex: "updatedAt",
          valueType: "dateTime",
          width: 180,
          search: false,
        },
        {
          title: "内边距",
          dataIndex: "padding",
          valueType: "text",
          ellipsis: true,
          width: 120,
          search: false,
        },
        {
          title: "外边距",
          dataIndex: "margin",
          valueType: "text",
          ellipsis: true,
          width: 120,
          search: false,
        },
        {
          title: "圆角",
          dataIndex: "borderRadius",
          valueType: "text",
          ellipsis: true,
          width: 120,
          search: false,
        },
        {
          title: "字体大小",
          dataIndex: "fontSize",
          valueType: "text",
          width: 100,
          search: false,
        },
        {
          title: "字体颜色",
          dataIndex: "fontColor",
          valueType: "color", // 显示颜色类型
          width: 100,
          search: false,
        },
        {
          title: "描述",
          dataIndex: "description",
          valueType: "textarea",
          ellipsis: true,
        },
        {
          title: "模式",
          dataIndex: "mode",
          valueType: "digit",
          width: 100,
          search: false,
        },
      ]}
    />
  );
};
