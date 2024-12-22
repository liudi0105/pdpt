import { Ant } from ".";
import { CardProps as Props } from "antd";

export type CardProps = {
  titlePosition?: "center" | "left";
} & Props;

export const Card = (props: CardProps) => {
  const { titlePosition = "center" } = props;
  return (
    <Ant.Card
      styles={{ ...props.styles, header: { textAlign: titlePosition } }}
      {...props}
      title={
        props.title && (
          <Ant.Typography.Title level={1}>{props.title}</Ant.Typography.Title>
        )
      }
    />
  );
};
