package common.module.webmvc;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GlobalExceptionHandlerAdapter extends GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ErrorResp constraintViolationException(ConstraintViolationException e) {
        log.warn(e.getMessage(), e);
        Map<Path, String> map = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        return new ErrorResp(map.toString());
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = HandlerMethodValidationException.class)
//    public ErrorResp handlerMethodValidationException(HandlerMethodValidationException e) {
//        log.warn(e.getMessage(), e);
//        List<MessageSourceResolvable> list = e.getAllValidationResults().stream().flatMap(v -> v.getResolvableErrors().stream())
//                .toList();
//        if (list.size() == 1) {
//            return new ErrorResp(e.getMessage().replace("\"", "'") + ": " + list.get(0).getDefaultMessage());
//        }
//        return new ErrorResp(e.getMessage());
//    }
}
