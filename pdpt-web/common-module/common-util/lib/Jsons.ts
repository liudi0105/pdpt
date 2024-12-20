export class Jsons {
  static parse = <T>(value: string) => JSON.parse(value) as T;
  static toStr = (value: any) => JSON.stringify(value);
}
