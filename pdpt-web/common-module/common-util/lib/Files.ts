export class Files {
  static formatFileSize = (sizeInBytes: number): string => {
    if (sizeInBytes < 0) {
      throw new Error("Size cannot be negative");
    }

    // 定义文件大小单位
    const units = ["B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"];

    let unitIndex = 0;
    let size = sizeInBytes;

    // 根据大小调整单位
    while (size >= 1024 && unitIndex < units.length - 1) {
      size /= 1024;
      unitIndex++;
    }

    // 返回格式化后的文件大小
    return `${size.toFixed(2)} ${units[unitIndex]}`;
  };
}
