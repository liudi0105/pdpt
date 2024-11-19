package common.module.util;

import common.module.errors.AppError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppCodecs {

    public static String encodeMd5Hex(String data) {
        return DigestUtils.md5Hex(data);//NOSONAR
    }
    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AppError(e);
        }
    }

}
