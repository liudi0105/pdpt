import { Table } from "@common-module/common-antd";
import { LoginLogEntity, LogService } from "@pdpt/lib";

const logService = new LogService();

export const LoginLog = () => {
  return (
    <Table<LoginLogEntity>
      pagination={{ defaultPageSize: 10 }}
      request={(params) => {
        return logService.listLoginLogPaged(params);
      }}
      search={false}
      columns={[
        {
          title: "用户",
          dataIndex: "username",
        },
        {
          title: "登录时间",
          dataIndex: "createdAt",
        },
        {
          title: "IP",
          dataIndex: "ip",
        },
        {
          title: "Client",
          dataIndex: "client",
        },
        {
          title: "Country",
          dataIndex: "country",
        },
        {
          title: "City",
          dataIndex: "city",
        },
      ]}
    ></Table>
  );
};
