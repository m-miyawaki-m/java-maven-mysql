package com.mysql;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest {
    @Test
    public void testMain() {
        // mainメソッドがエラーをスローしないことを確認する
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}

