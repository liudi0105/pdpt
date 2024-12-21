import { HappyProvider } from "@ant-design/happy-work-theme";
import { FloatButtonGroup } from "@common-module/common-antd";
import { createGlobalStyle, RouterProvider } from "@common-module/common-react";
import { ConfigProvider, theme } from "antd";
import "./App.css";
import { AppRouter } from "./router";

const SGlobalStyle = createGlobalStyle`
  html, body, #root {
    height: 100%;
    width: 100%;
    margin: 0;
    padding: 0;
  }

  pre {
    font-family: 'Cascadia Mono', 'Consolas', 'Courier New', Courier, monospace;
    margin: 0;
  }
`;

function App() {
  return (
    <ConfigProvider
      theme={{
        algorithm: [theme.compactAlgorithm],
        token: {
          colorPrimary: "#14598D",
        },
      }}
    >
      <HappyProvider>
        <RouterProvider router={AppRouter} />
        <SGlobalStyle />
        <FloatButtonGroup />
      </HappyProvider>
    </ConfigProvider>
  );
}

export default App;
