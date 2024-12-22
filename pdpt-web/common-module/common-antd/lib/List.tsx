import { ReactNode } from "react";
import { Ant } from ".";

export interface GridListProps {
  gutter: number;
  items: ReactNode[][];
  columnSpan: number[];
}

export const GridList = (props: GridListProps) => {
  return (
    <Ant.List>
      {props.items.map((row) => (
        <Ant.List.Item>
          <Ant.Row style={{ width: "100%" }}>
            {row.map((v, idx) => (
              <Ant.Col span={props.columnSpan[idx]}>{v}</Ant.Col>
            ))}
          </Ant.Row>
        </Ant.List.Item>
      ))}
    </Ant.List>
  );
};
