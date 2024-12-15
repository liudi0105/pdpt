import { Table } from "@common-module/common-antd";
import { LogService, SiteLogEntity } from "../../services";

const logService = new LogService();

export const SiteLog = () => {
  return (
    <Table<SiteLogEntity, SiteLogEntity>
      pagination={{ defaultPageSize: 10, showSizeChanger: true }}
      request={(params) => {
        return logService
          .listSiteLogPaged({
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
          title: "时间",
          dataIndex: "added",
        },
        {
          title: "安全等级",
          dataIndex: "securityLevel",
        },
        {
          title: "日志",
          dataIndex: "txt",
        },
      ]}
    ></Table>
  );
};
