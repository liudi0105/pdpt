import {
  ProTable,
  ProTableProps
} from "@ant-design/pro-components";
import {
  AppPageParam,
  AppPageResult,
  BaseEntity
} from "@common-module/common-api";
import { ReactNode, useState } from "react";
import { Ant } from ".";
import { TriggerModal, TriggerModalProps } from "./Modal";

export type TableProps<DataType> = {
  request?: (param: AppPageParam) => Promise<AppPageResult<DataType>>;
} & Omit<ProTableProps<DataType, DataType, DataType>, "request">;

export const Table = <DataType extends BaseEntity>(
  props: TableProps<DataType>
) => {
  const {
    rowKey = "id",
    options = false,
    request,
    pagination = { defaultCurrent: 1, defaultPageSize: 10 },
    ...tableProps
  } = props;

  let r: ProTableProps<DataType, DataType, DataType>["request"];

  if (request) {
    r = (params) => {
      if (pagination) {
        const {
          current = pagination.defaultCurrent ?? 1,
          pageSize = pagination.defaultPageSize ?? 10,
          ...rest
        } = params;
        return request({
          pageIndex: current,
          pageSize,
          ...rest,
        }).then((v) => ({ total: v.totalElements, data: v.content }));
      } else {
        return request(params as any).then((v) => ({
          total: v.totalElements,
          data: v.content,
        }));
      }
    };
  }

  return (
    <ProTable<DataType, DataType, DataType>
      {...tableProps}
      size="small"
      rowKey={rowKey}
      options={options}
      request={r}
    ></ProTable>
  );
};

// export type CrudTableProps<DataType extends BaseEntity> = {
//   crud?: boolean;
//   createForm?: ProFormInstance;
//   updateForm?: ProFormInstance;
//   service: BaseService<DataType>;
//   columns: (ProColumns & {
//     create?: boolean;
//     readonly?: boolean;
//   })[];
// } & Omit<TableProps<DataType>, "columns">;

// export const CrudTable = <DataType extends BaseEntity>(
//   props: CrudTableProps<DataType>
// ) => {
//   const { toolbar = {}, crud = true, service } = props;
//   const { actions = [] } = toolbar;

//   const [createForm] = ProForm.useForm(props.createForm);

//   const ref = useRef<ActionType>();

//   const columns: CrudTableProps<DataType>["columns"] = [
//     ...props.columns,
//     {
//       dataIndex: "id",
//       title: "ID",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       dataIndex: "createdBy",
//       title: "Created By",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       dataIndex: "createdDate",
//       title: "Created Date",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       dataIndex: "lastModifiedBy",
//       title: "Last Modified By",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       dataIndex: "lastModifiedDate",
//       title: "Last Modified Date",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       dataIndex: "version",
//       title: "Version",
//       hidden: true,
//       search: false,
//       create: false,
//       readonly: true,
//     },
//     {
//       title: "操作",
//       search: false,
//       width: 80,
//       render: (_1, entity: BaseEntity, _2, action) => {
//         return (
//           <Ant.Space>
//             <ButtonModalFrom<DataType>
//               title="更新"
//               buttonSize="small"
//               buttonType="link"
//               initialValues={entity}
//               onFinish={async (values) => {
//                 await service.createOrUpdate(values);
//                 Ant.message.success("更新成功");
//                 await action?.reload();
//                 return true;
//               }}
//             >
//               {columns
//                 .filter((v) => v.dataIndex)
//                 .map((v) => (
//                   <ProFormText
//                     readonly={v.readonly}
//                     key={v.dataIndex?.toString()}
//                     name={v.dataIndex}
//                     label={v.title?.toString() ?? v.dataIndex}
//                   />
//                 ))}
//             </ButtonModalFrom>
//             <Ant.Popconfirm
//               title={`确定要删除该数据吗？`}
//               onConfirm={async () => {
//                 // await service.deleteById(entity.id);
//                 Ant.message.success("删除成功");
//                 await action?.reload();
//                 return true;
//               }}
//             >
//               <Button size="small" type="link" danger>
//                 删除
//               </Button>
//             </Ant.Popconfirm>
//           </Ant.Space>
//         );
//       },
//     },
//   ];

//   return (
//     <Table<DataType>
//       {...props}
//       size="small"
//       actionRef={ref}
//       columns={columns}
//       request={(params) => service.listPaged(params)}
//       toolbar={{
//         ...toolbar,
//         actions: [
//           crud && (
//             <ButtonModalFrom<DataType>
//               title="添加"
//               form={createForm}
//               onFinish={async (values) => {
//                 await service.createOrUpdate(values);
//                 Ant.message.success("添加成功");
//                 ref.current?.reload();
//                 return true;
//               }}
//             >
//               {columns
//                 .filter(
//                   (v) => v.dataIndex && (v.create === undefined || v.create)
//                 )
//                 .map((v) => (
//                   <ProFormText
//                     key={v.dataIndex?.toString()}
//                     name={v.dataIndex}
//                     label={v.title?.toString() ?? v.dataIndex}
//                   />
//                 ))}
//             </ButtonModalFrom>
//           ),
//           ...actions,
//         ],
//       }}
//     />
//   );
// };

export type DrawerTableProps<DataSource extends BaseEntity> = {
  trigger: ReactNode;
  drawerTitle: ReactNode;
  drawerWidth?: string | number;
} & Ant.DrawerProps &
  TableProps<DataSource>;

export const DrawerTable = <DataSource extends BaseEntity>(
  props: DrawerTableProps<DataSource>
) => {
  const { drawerWidth, trigger, drawerTitle } = props;
  const [open, setOpen] = useState(false);

  return (
    <>
      <div onClick={() => setOpen(true)}>{trigger}</div>
      <Ant.Drawer
        title={drawerTitle}
        destroyOnClose
        width={drawerWidth}
        open={open}
        onClose={() => setOpen(false)}
      >
        <Table {...props} />
      </Ant.Drawer>
    </>
  );
};

export type ModalTableProps<DataSource extends BaseEntity> = {
  trigger: ReactNode;
  drawerTitle: ReactNode;
  drawerWidth?: string | number;
} & TriggerModalProps &
  TableProps<DataSource>;

export const ModalTable = <DataSource extends BaseEntity>(
  props: ModalTableProps<DataSource>
) => {
  const { drawerWidth, drawerTitle, ...tableProps } = props;
  const [open, setOpen] = useState(false);

  return (
    <TriggerModal
      title={drawerTitle}
      destroyOnClose
      width={drawerWidth}
      open={open}
      onClose={() => setOpen(false)}
      {...props}
    >
      <Table {...tableProps} />
    </TriggerModal>
  );
};
