import { Table } from "@common-module/common-antd";
import { LoginLogEntity, LogService } from "@pdpt/lib";

const loginLogService = new LogService();

export const LoginLogView = () => {
  return (
    <Table<LoginLogEntity>
      request={(params) => loginLogService.listLoginLogPaged(params)}
      columns={[
        {
          title: "ID",
          dataIndex: "id",
          valueType: "text",
          search: false, // 不显示在搜索框
        },
        {
          title: "用户ID",
          dataIndex: "userId",
          valueType: "text",
          sorter: true, // 可排序
          search: true, // 允许搜索
        },
        {
          title: "IP地址",
          dataIndex: "ip",
          valueType: "text",
          ellipsis: true,
        },
        {
          title: "用户代理",
          dataIndex: "userAgent",
          valueType: "text",
          ellipsis: true,
          search: false,
        },
        {
          title: "登录时间",
          dataIndex: "createdAt",
          valueType: "dateTime", // 日期时间类型
          sorter: true, // 可排序
          search: false,
        },
        {
          title: "是否成功",
          dataIndex: "success",
          valueType: "select", // 下拉选择
          valueEnum: {
            true: { text: "成功", status: "Success" },
            false: { text: "失败", status: "Error" },
          },
        },
      ]}
    />
  );
};
