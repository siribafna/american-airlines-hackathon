package com.improving.service;

import com.improving.util.TimeUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeUtilTest {

    @Test
    public void testAfter(){
        boolean result = TimeUtil.timeIsBefore("2019-12-09T02:50:17.142-06:00", "2019-12-09T02:51:17.142-06:00");
        assertTrue(result);

    }

    @Test
    public void testBefore(){
        boolean result = TimeUtil.timeIsBefore("2019-12-09T02:50:17.142-06:00", "2019-12-09T02:01:17.142-06:00");
        assertFalse(result);

    }
}
