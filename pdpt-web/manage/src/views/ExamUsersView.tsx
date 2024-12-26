import { Table } from "@common-module/common-antd";
import { ExamUsersEntity, ExamUsersService } from "@pdpt/lib";

const examUsersService = new ExamUsersService();

export const ExamUsersView = () => {
  return (
    <Table<ExamUsersEntity>
      scroll={{ x: 1280 }}
      request={(params) => examUsersService.listExamUsersPaged(params)}
      columns={[
        {
          title: "主键ID",
          dataIndex: "id",
          key: "id",
          width: "8em",
        },
        {
          title: "用户ID",
          dataIndex: "uid",
          key: "uid",
          width: "8em",
        },
        {
          title: "考核ID",
          dataIndex: "examId",
          key: "examId",
          width: "8em",
        },
        {
          title: "考核状态",
          dataIndex: "status",
          key: "status",
          width: "10em",
          render: (_, entity) => {
            const statusMap = {
              0: "未开始",
              1: "进行中",
              2: "已完成",
            };
            return statusMap[entity.status] || "未知状态";
          },
        },
        {
          title: "考核开始时间",
          dataIndex: "begin",
          key: "begin",
          width: "14em",
          render: (_, entity) =>
            entity.begin ? new Date(entity.begin).toLocaleString() : "-",
        },
        {
          title: "考核结束时间",
          dataIndex: "end",
          key: "end",
          width: "14em",
          render: (_, entity) =>
            entity.end ? new Date(entity.end).toLocaleString() : "-",
        },
        {
          title: "考核进度",
          dataIndex: "progress",
          key: "progress",
          ellipsis: true,
        },
        {
          title: "是否完成",
          dataIndex: "isDone",
          key: "isDone",
          width: "8em",
          render: (_, entity) => (entity.isDone === 1 ? "是" : "否"),
        },
        {
          title: "创建时间",
          dataIndex: "createdAt",
          key: "createdAt",
          width: "14em",
          render: (_, entity) =>
            entity.createdAt
              ? new Date(entity.createdAt).toLocaleString()
              : "-",
        },
        {
          title: "更新时间",
          dataIndex: "updatedAt",
          key: "updatedAt",
          width: "14em",
          render: (_, entity) =>
            entity.updatedAt
              ? new Date(entity.updatedAt).toLocaleString()
              : "-",
        },
      ]}
    />
  );
};
