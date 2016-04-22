package com.pru.shifty.api.util;

import java.util.concurrent.TimeUnit;

public final class TimeUtils {
    public static final long hoursToMillis(int hours) {
        return TimeUnit.HOURS.toMillis(hours);
    }
}
