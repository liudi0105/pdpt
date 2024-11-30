import { Ant } from "@common-module/common-antd";
import { styled } from "@common-module/common-react";

const SBox = styled.div`
  display: flex;
  flex-direction: column;
  row-gap: 8px;
`;

export const HomePage = () => {
  return (
    <SBox>
      <Ant.Card title="最近消息"></Ant.Card>
      <Ant.Card title="趣味盒"></Ant.Card>
      <Ant.Card title="群聊区"></Ant.Card>
      <Ant.Card title="幸运大转盘"></Ant.Card>
      <Ant.Card title="投票"></Ant.Card>
      <Ant.Card title="免责条款"></Ant.Card>
      <Ant.Card title="友情链接"></Ant.Card>
    </SBox>
  );
};
