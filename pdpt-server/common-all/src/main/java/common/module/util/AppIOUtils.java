package common.module.util;

import common.module.errors.AppError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppIOUtils {

    public static String readPathAsString(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        try {
            return FileUtils.readFileToString(fileSystemResource.getFile(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new AppError(e);
        }
    }

    public static InputStream classpathInputStream(String path) {
        try {
            return new ClassPathResource(path).getInputStream();
        } catch (IOException e) {
            throw new AppError(e);
        }
    }

    public static void o2i(Consumer<OutputStream> oconsumer, Consumer<InputStream> iconsumer) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        oconsumer.accept(byteArrayOutputStream);
        InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        iconsumer.accept(inputStream);
    }
}
