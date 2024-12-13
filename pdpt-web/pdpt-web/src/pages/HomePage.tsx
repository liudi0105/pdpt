import { Ant } from "@common-module/common-antd";
import { styled } from "@common-module/common-react";
import { Messages } from "./home/Messages";
import { Vote } from "./home/Vote";
import { HappyBox } from "./home/HappyBox";
import { ChatRoom } from "./home/ChatRoom";
import { Disclaimers } from "./home/Disclaimers";

const SBox = styled.div`
  display: flex;
  flex-direction: column;
  row-gap: 8px;
`;

export const HomePage = () => {
  return (
    <SBox>
      <Ant.Card title="最近消息">
        <Messages />
      </Ant.Card>
      <Ant.Card title="趣味盒">
        <HappyBox />
      </Ant.Card>
      <Ant.Card title="群聊区">
        <ChatRoom />
      </Ant.Card>
      <Ant.Card title="幸运大转盘"></Ant.Card>
      <Ant.Card title="投票">
        <Vote />
      </Ant.Card>
      <Ant.Card title="免责条款">
        <Disclaimers />
      </Ant.Card>
      <Ant.Card title="友情链接"></Ant.Card>
    </SBox>
  );
};
