import { Ant, Button, Table } from "@common-module/common-antd";
import { RequestsEntity, RequestsService } from "../services";

const requestsService = new RequestsService();

export const TorrentRequest = () => {
  return (
    <Ant.Card>
      <Table<RequestsEntity, RequestsEntity>
        pagination={{ defaultPageSize: 10 }}
        toolBarRender={() => [<Button>添加求种</Button>]}
        request={(param) => {
          return requestsService
            .listPaged({
              pageSize: param.pageSize ?? 10,
              pageIndex: param.current ?? 1,
            })
            .then((v) => ({
              data: v.content,
              total: v.totalElements,
            }));
        }}
        columns={[
          {
            title: "名称",
            dataIndex: "request",
            ellipsis: true,
          },
          {
            title: "最新出价",
            dataIndex: "amount",
            width: 80,
          },
          {
            title: "原始出价",
            dataIndex: "oriAmount",
            width: 80,
            search: false,
          },
          {
            title: "评论数",
            dataIndex: "comments",
            search: false,
            width: 60,
          },
          {
            title: "应求数",
            dataIndex: "hits",
            search: false,
            width: 60,
          },
          {
            title: "求种者",
            dataIndex: "username",
            ellipsis: true,
            search: false,
            width: 120,
          },
          {
            title: "时间",
            search: false,
            dataIndex: "added",
            width: 200,
          },
          {
            title: "完成状态",
            search: false,
            dataIndex: "finish",
            width: 80,
          },
        ]}
      />
    </Ant.Card>
  );
};
