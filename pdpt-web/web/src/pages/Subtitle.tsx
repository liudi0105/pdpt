import { Ant, Button, Table } from "@common-module/common-antd";
import { Files } from "@common-module/common-util";
import { SubtitleEntity, SubtitleService } from "@pdpt/lib";

const subtitleService = new SubtitleService();

export const Subtitle = () => {
  return (
    <Ant.Card>
      <Table<SubtitleEntity>
        toolBarRender={() => [<Button>上传字幕</Button>]}
        request={(param) => subtitleService.listPaged(param)}
        columns={[
          {
            title: "语言",
            dataIndex: "language",
            width: "6em",
          },
          {
            title: "标题",
            dataIndex: "title",
            ellipsis: true,
          },
          {
            title: "时间",
            width: "12em",
            search: false,
            ellipsis: true,
            dataIndex: "added",
          },
          {
            title: "上传者",
            search: false,
            width: "8em",
            dataIndex: "uploadUsername",
            ellipsis: true,
          },
          {
            title: "大小",
            search: false,
            width: "6em",
            dataIndex: "size",
            render: (_, entity) => Files.formatFileSize(entity.size),
          },
        ]}
      />
    </Ant.Card>
  );
};
