import { useEffect, useState } from "react";
import { FaqEntity, HelpService } from "../services";
import { Flex } from "antd";
import { Ant } from "@common-module/common-antd";

const helpService = new HelpService();

export const Faq = () => {
  const [faq, setFaq] = useState<FaqEntity[]>([]);

  useEffect(() => {
    helpService.listFaq().then(setFaq);
  }, []);

  return (
    <Flex vertical gap={8}>
      <Ant.Card>
        <Ant.Typography.Title>常见问题</Ant.Typography.Title>
        <Ant.Typography.Paragraph>
          我们的目标是提供纯粹高品质的东西。因此，只有授权的用户才能发布种子。如果你有0-day资源的来源，请不要迟疑联系我们！
        </Ant.Typography.Paragraph>
        <Ant.Typography.Paragraph>
          这是非公开BT站点，你必须注册后才能访问。在PANDA干任何事前，我们建议你先阅读站点的规则！规则只有简单几条，但我们要求用户严格遵照。
        </Ant.Typography.Paragraph>
        <Ant.Typography.Paragraph>
          在使用前，请阅读PANDA用户协定。
        </Ant.Typography.Paragraph>
      </Ant.Card>
      <Ant.Card>
        <Ant.Anchor
          style={{ maxHeight: "unset" }}
          affix={false}
          items={faq.map((v, idx) => ({
            key: v.id,
            href: `#anchor-${v.id}`,
            title: (
              <span id={`index-${v.id}`}>
                {idx}. {v.question}
              </span>
            ),
          }))}
        />
      </Ant.Card>
      <Ant.Card>
        <Ant.List>
          {faq.map((v, idx) => (
            <Ant.List.Item
              id={`anchor-${v.id}`}
              key={v.id}
              style={{
                flexDirection: "column",
                justifyContent: "start",
                alignItems: "start",
              }}
            >
              <div style={{ fontWeight: "bold", cursor: "pointer" }}>
                <Ant.Typography.Link
                  style={{ color: "black" }}
                  href={`#index-${v.id}`}
                >
                  {idx + 1 + ". " + v.question}
                </Ant.Typography.Link>
              </div>
              <div dangerouslySetInnerHTML={{ __html: v.answer }}></div>
            </Ant.List.Item>
          ))}
        </Ant.List>
      </Ant.Card>
    </Flex>
  );
};
