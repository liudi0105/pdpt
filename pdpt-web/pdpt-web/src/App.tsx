import { FloatButtonGroup } from "@common-module/common-antd";
import {
  createBrowserRouter,
  createGlobalStyle,
  RouterProvider,
} from "@common-module/common-react";
import { ConfigProvider, theme } from "antd";
import "./App.css";
import { Layout } from "./pages/Home";
import { LoginPage } from "./pages/LoginPage";

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
    element: <LoginPage />,
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
        algorithm: [theme.compactAlgorithm],
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
