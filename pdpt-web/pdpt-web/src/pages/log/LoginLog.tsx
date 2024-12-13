import { Ant, Table } from "@common-module/common-antd";
import { LoginLogEntity, LogService } from "../../services";

const logService = new LogService();

export const LoginLog = () => {
  return (
    <Ant.Card title={false}>
      <Table<LoginLogEntity, LoginLogEntity>
        pagination={{ defaultPageSize: 10 }}
        request={(params) => {
          return logService
            .listLoginLogPaged({
              pageSize: params.pageSize ?? 10,
              pageIndex: params.current ?? 1,
            })
            .then((d) => ({
              total: d.totalElements,
              data: d.content,
            }));
        }}
        search={false}
        columns={[
          {
            title: "用户",
            width: 160,
            dataIndex: "username",
          },
          {
            title: "登录时间",
            width: 200,
            dataIndex: "createdAt",
          },
          {
            title: "IP",
            width: 160,
            dataIndex: "ip",
          },
          {
            title: "Client",
            width: 80,
            dataIndex: "client",
          },
          {
            title: "Country",
            width: 180,
            dataIndex: "country",
          },
          {
            title: "City",
            dataIndex: "city",
          },
        ]}
      ></Table>
    </Ant.Card>
  );
};
