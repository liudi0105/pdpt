import { HttpClient } from "@common-module/common-util";

export type AppConfig = {
  apiUrl: string;
  httpClient: HttpClient;
};

const config: {
  current: AppConfig | null;
} = {
  current: null,
};

export const registerConfig = (appConfig: Partial<AppConfig>) => {
  const { httpClient = new HttpClient(), apiUrl = "/api" } = appConfig;
  config.current = {
    httpClient,
    apiUrl,
  };
};

export const getConfig = () => {
  if (!config.current) {
    throw new Error("config not found");
  }
  return config.current;
};
