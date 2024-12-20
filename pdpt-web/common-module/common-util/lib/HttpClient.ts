export interface RequestConfig {
  url: string;
  method: "GET" | "POST";
  headers: Object;
  body: Object | undefined;
}

export type RequestProvider = {
  request(config: RequestConfig): Promise<ResponseEntity>;
};

export interface ResponseEntity {
  httpStatus: number;
  appSucceed: boolean;
  appErrorMessage?: string;
  appStatusCode?: string;
  payloadText: string;
  payload: any;
}

export class FetchRequestProvider implements RequestProvider {
  request = async (config: RequestConfig): Promise<ResponseEntity> => {
    config.headers = {
      ...config.headers,
    };

    console.log(config.url);

    const resp = await fetch(config.url, {
      method: config.method,
      mode: "cors",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
      body: config.body ? JSON.stringify(config.body) : undefined,
    });
    return {
      httpStatus: resp.status,
      appSucceed: resp.status < 400,
      payloadText: await resp.text(),
      payload: "",
    };
  };
}

export type ApiErrorHandler = (v: ResponseEntity) => void;

export class HttpClient {
  constructor(
    private provider: RequestProvider = new FetchRequestProvider(),
    private apiErrorHandler: ApiErrorHandler = () => {}
  ) {}

  postJsonForString = async (url: string, data?: object): Promise<string> => {
    const resp = await this.request({
      url: url,
      body: data,
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    return resp.payloadText;
  };

  postJsonForJson = async <T>(url: string, data?: object): Promise<T> => {
    const resp = await this.postJsonForString(url, data);
    return this.extractJson(resp);
  };

  protected extractJson = async (text: string) => {
    return text ? JSON.parse(text) : null;
  };

  request = async (config: RequestConfig): Promise<ResponseEntity> => {
    const resp = await this.provider.request(config);
    this.apiErrorHandler(resp);
    return resp;
  };
}
