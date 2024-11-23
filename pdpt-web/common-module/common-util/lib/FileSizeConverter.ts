export class FileSizeConverter {
  constructor(private byte: number) {}

  private static RATE = 1024;

  static ofByte(byte: number) {
    return new FileSizeConverter(byte);
  }

  divide(size: number) {
    const s = size / FileSizeConverter.RATE;
    return Math.round(s * 100) / 100;
  }

  kb() {
    return this.divide(this.byte);
  }

  mb() {
    return this.divide(this.kb());
  }

  gb() {
    return this.divide(this.mb());
  }
}
