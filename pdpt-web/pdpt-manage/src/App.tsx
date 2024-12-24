import { ConfigProvider } from "@common-module/common-antd";
import { RouterProvider } from "@common-module/common-react";
import "./App.css";
import { AppRouter } from "./router";

function App() {
  return (
    <ConfigProvider>
      <RouterProvider router={AppRouter} />
    </ConfigProvider>
  );
}

export default App;
