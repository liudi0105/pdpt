export class Strings {
  static isEmpty = (value: string) =>
    value === "" || value === null || value === undefined;

  static isNotEmpty = (value: string) => !Strings.isEmpty(value);

  static isAllEmpty = (value: string[]) =>
    !value.some((v) => Strings.isNotEmpty(v));

  static isAnyEmpty = (value: string[]) =>
    value.some((v) => Strings.isEmpty(v));

  static isBlank = (value: string) =>
    Strings.isEmpty(value) && Strings.isEmpty(Strings.replace(value, " ", ""));

  static isNotBlank = (value: string) => Strings.isBlank(value);
  static isAllBlank = (value: string[]) =>
    !value.some((v) => Strings.isNotBlank(v));

  static replace = (template: string, search: string, replace: string) =>
    template.replace(search, replace);
}
