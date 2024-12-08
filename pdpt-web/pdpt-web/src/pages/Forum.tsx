import { Table } from "@common-module/common-antd";

export const Forum = () => {
  return (
    <Table
      search={false}
      columns={[
        {
          title: "Title",
          dataIndex: "title",
        },
        {
          title: "Subject",
          dataIndex: "subject",
        },
        {
          title: "Message",
          dataIndex: "message",
        },
        {
          title: "Last Answer",
          dataIndex: "lastAnswer",
        },
        {
          title: "Admin",
          dataIndex: "admin",
        },
      ]}
    ></Table>
  );
};
