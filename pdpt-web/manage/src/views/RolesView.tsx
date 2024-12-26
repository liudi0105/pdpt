import { Table } from "@common-module/common-antd";
import { RoleEntity, RoleService } from "@pdpt/lib";

const roleService = new RoleService();

export const RolesView = () => {
  return (
    <Table<RoleEntity>
      request={(params) => roleService.listPaged(params)}
      columns={[
        {
          title: "角色ID",
          dataIndex: "id",
          valueType: "digit",
          search: false, // 是否支持搜索
          width: "6em",
        },
        {
          title: "角色名称",
          dataIndex: "name",
          valueType: "text",
          search: true, // 支持搜索
          ellipsis: true, // 超出部分省略
          width: "14em",
        },
        {
          title: "创建时间",
          dataIndex: "createdAt",
          valueType: "dateTime",
          search: false, // 不支持搜索
          sorter: true, // 支持排序
          width: "14em",
        },
        {
          title: "更新时间",
          dataIndex: "updatedAt",
          valueType: "dateTime",
          search: false, // 不支持搜索
          sorter: true, // 支持排序
        },
      ]}
    />
  );
};
