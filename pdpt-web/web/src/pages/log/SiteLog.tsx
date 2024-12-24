import { Table } from "@common-module/common-antd";
import { LogService, SiteLogEntity } from "@pdpt/lib";

const logService = new LogService();

export const SiteLog = () => {
  return (
    <Table<SiteLogEntity, SiteLogEntity>
      pagination={{ defaultPageSize: 10, showSizeChanger: true }}
      request={(params) => {
        return logService.listSiteLogPaged(params);
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
