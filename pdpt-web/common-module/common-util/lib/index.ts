export function joinPath(...path: string[]) {
  return path
    .filter((v) => v != undefined)
    .map((v) => v.replace(/^\/+$/g, ""))
    .join("/");
}

export function lastElement<T>(arr: T[]) {
  return arr[arr.length - 1];
}

export function deepCopy<T>(obj: T): T {
  return JSON.parse(JSON.stringify(obj));
}

export * from "./HttpClient";
export * from "./FileSizeConverter";
