import { FloatButtonGroup } from "@common-module/common-antd";
import {
  createBrowserRouter,
  createGlobalStyle,
  RouterProvider,
} from "@common-module/common-react";
import { ConfigProvider } from "antd";
import "./App.css";
import { Layout } from "./pages/Home";

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

const AppRouter = createBrowserRouter([
  {
    path: "login",
    element: "login",
  },
  {
    path: "/",
    element: <Layout />,
  },
  {
    path: "home",
    element: <Layout />,
  },
]);

function App() {
  return (
    <ConfigProvider
      theme={{
        algorithm: [],
        token: {},
        components: {
          Button: {},
        },
      }}
    >
      <RouterProvider router={AppRouter} />
      <SGlobalStyle />
      <FloatButtonGroup />
    </ConfigProvider>
  );
}

export default App;
