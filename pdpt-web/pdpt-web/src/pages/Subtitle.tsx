import { Ant, Button, Table } from "@common-module/common-antd";
import { SubtitleEntity, SubtitleService } from "../services";
import { FileSizeConverter } from "@common-module/common-util";

const subtitleService = new SubtitleService();

export const Subtitle = () => {
  return (
    <Ant.Card>
      <Table<SubtitleEntity, SubtitleEntity>
        pagination={{ defaultPageSize: 10 }}
        toolBarRender={() => [<Button>上传字幕</Button>]}
        request={(param) => {
          return subtitleService
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
            title: "语言",
            dataIndex: "language",
            width: 80,
          },
          {
            title: "标题",
            dataIndex: "title",
            ellipsis: true,
          },
          {
            title: "时间",
            search: false,
            dataIndex: "added",
          },
          {
            title: "上传者",
            search: false,
            dataIndex: "uploadUsername",
            ellipsis: true,
          },
          {
            title: "大小",
            search: false,
            dataIndex: "size",
            render: (_, entity) =>
              new FileSizeConverter(entity.size).kb() + "KB",
          },
        ]}
      />
    </Ant.Card>
  );
};
