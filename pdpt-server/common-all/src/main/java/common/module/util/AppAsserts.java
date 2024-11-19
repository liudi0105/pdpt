package common.module.util;

import common.module.errors.AppError;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class AppAsserts {
    private AppAsserts() {
    }

    public static <T> void assertEqual(T a, T b, String msg) {
        if (!Objects.equals(a, b)) {
            throw new AppError(msg);
        }
    }

    public static void failFastDev(BooleanSupplier supplier, String msg) {
        if (supplier.getAsBoolean()) {
            throw new AppError(msg);
        }
    }

}
