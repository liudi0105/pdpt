package common.module.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppEncodings {
    public static String encodeBase64(String code) {
        if (StringUtils.isBlank(code)) {
            return code;
        }
        return new String(Base64.encodeBase64(code.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decodeBase64(String code) {
        if (StringUtils.isBlank(code)) {
            return code;
        }
        return new String(Base64.decodeBase64(code.getBytes(StandardCharsets.UTF_8)));
    }

    public static byte[] decodeBase64Bytes(String code) {
        if (code == null) {
            return null;
        }
        return Base64.decodeBase64(code.getBytes(StandardCharsets.UTF_8));
    }
}
