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
    </Ant.Card>
  );
};
