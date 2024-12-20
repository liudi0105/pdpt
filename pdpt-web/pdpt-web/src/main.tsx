import { Ant } from "@common-module/common-antd";
import { registerConfig } from "@common-module/common-api";
import {
  FetchRequestProvider,
  HttpClient,
  Jsons,
  ResponseEntity,
} from "@common-module/common-util";
import { createRoot } from "react-dom/client";
import App, { AppRouter } from "./App.tsx";
import "./index.css";

registerConfig({
  httpClient: new HttpClient(
    new FetchRequestProvider(),
    (value: ResponseEntity) => {
      if (!value.appSucceed) {
        const error: { message: string } = Jsons.parse(value.payloadText);
        Ant.message.warning(error.message);
      }
      if (value.httpStatus === 403) {
        AppRouter.navigate("/login");
      }
    }
  ),
  apiUrl: "/api",
});

createRoot(document.getElementById("root")!).render(<App />);
