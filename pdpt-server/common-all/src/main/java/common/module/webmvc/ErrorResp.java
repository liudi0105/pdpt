package common.module.webmvc;

import common.module.errors.AppError;
import common.module.errors.AppWarning;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResp {
    private String code;
    private String msg;

    public ErrorResp(Throwable e) {
        if (e instanceof AppWarning) {
            AppWarning er = (AppWarning) e;
            this.code = er.getCode();
            this.msg = er.getMsg();
        } else if (e instanceof AppError) {
            AppError er = (AppError) e;
            this.code = er.getCode();
            this.msg = er.getMsg();
        } else {
            this.code = "UNKNOWN_ERROR";
            this.msg = e.getMessage();
        }
    }

    public ErrorResp(String msg) {
        this.code = "UNKNOWN_ERROR";
        this.msg = msg;
    }

    public ErrorResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
