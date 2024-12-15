import { Ant, Pro } from "@common-module/common-antd";
import { Card, Flex } from "antd";
import { useEffect, useState } from "react";
import { CategoryEntity, CategoryService } from "../services";

const categoryService = new CategoryService();

export const Publish = () => {
  const [categories, setCategories] = useState<CategoryEntity[]>([]);

  const [form] = Pro.ProForm.useForm();

  useEffect(() => {
    categoryService.list().then(setCategories);
  }, []);

  return (
    <Card>
      <Pro.ProForm
        form={form}
        layout="horizontal"
        labelCol={{ span: 4 }}
        submitter={{
          render: (props, doms) => {
            return (
              <Flex justify="center">
                <Ant.Space>{doms}</Ant.Space>
              </Flex>
            );
          },
        }}
        onFinish={async (formData) => {
          console.log(formData);
        }}
      >
        <Pro.ProFormUploadButton
          label="种子文件"
          name="torrent"
          rules={[{ required: true }]}
        />
        <Pro.ProFormText
          label="标题"
          name="title"
          rules={[{ required: true }]}
        />
        <Pro.ProFormText
          label="副标题"
          name="subTitle"
          rules={[{ required: true }]}
        />
        <Pro.ProFormText
          label="IMDb链接"
          name="imdb"
          rules={[{ required: true }]}
        />
        <Pro.ProFormUploadButton
          label="NFO文件"
          name="nfo"
          rules={[{ required: true }]}
        />
        <Pro.ProFormTextArea
          rules={[{ required: true }]}
          label="MediaInfo"
          name="mediaInfo"
          tooltip="MediaInfo 来自软件 MediaInfo，用该软件打开文件，语言选择英语，点击菜单视图(View)->文件(Text)，在框中右键->全选，再右键->复制，粘贴到这里来。"
        />
        <Pro.ProFormSelect
          label="类型"
          name="type"
          options={categories.map((v) => ({
            label: v.name,
            value: v.id,
          }))}
          rules={[{ required: true }]}
        />
        <Pro.ProFormCheckbox
          rules={[{ required: true }]}
          initialValue={false}
          label="候选发布"
          name="candidate"
          tooltip="将此种子发布到候选区"
        />
        <Pro.ProFormCheckbox
          rules={[{ required: true }]}
          initialValue={false}
          label="匿名发布"
          name="anonymous"
          tooltip="不要在发布者项目中显示我的用户名"
        />
        <Pro.ProFormCheckbox
          rules={[{ required: true }]}
          label="我已经阅读过规则"
          name="rulesRead"
        />
      </Pro.ProForm>
    </Card>
  );
};
