package common.module.webmvc;

import common.module.errors.AppError;
import common.module.errors.AppWarning;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(-1)
@ConditionalOnWebApplication
public class AppExceptionHandler {

    @Autowired
    private HttpServletRequest appWebRequest;

    @ExceptionHandler(value = AppError.class)
    public ErrorResp handleAppError(AppError e) {
        log.error(e.getMsg(), e);
        return new ErrorResp(e);
    }

    @ExceptionHandler(value = AppWarning.class)
    public ErrorResp handleAppWarning(AppWarning e) {
        log.warn(e.getMsg(), e);
        return new ErrorResp(e);
    }
}
