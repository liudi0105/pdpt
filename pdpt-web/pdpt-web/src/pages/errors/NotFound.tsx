import { Ant, Button } from "@common-module/common-antd";
import { useNavigate } from "@common-module/common-react";

export const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Ant.Result
      status="404"
      title="404"
      subTitle="啊哈，您请求的页面不存在"
      extra={
        <Button type="primary" onClick={() => navigate("/home")}>
          返回首页
        </Button>
      }
    />
  );
};
