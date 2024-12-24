import { Ant } from "@common-module/common-antd";
import { registerConfig } from "@common-module/common-api";
import { createBrowserRouter } from "@common-module/common-react";
import {
  FetchRequestProvider,
  HttpClient,
  Jsons,
  ResponseEntity,
} from "@common-module/common-util";
import * as dayjs from "dayjs";

export const init = (router: ReturnType<typeof createBrowserRouter>) => {
  dayjs.locale("zh-cn");

  registerConfig({
    httpClient: new HttpClient(
      new FetchRequestProvider(),
      (value: ResponseEntity) => {
        if (!value.appSucceed) {
          const error: { message: string } = Jsons.parse(value.payloadText);
          Ant.message.warning(error.message);
        }
        if (value.httpStatus === 403) {
          router.navigate("/login");
        }
      }
    ),
    apiUrl: "/api",
  });
};
