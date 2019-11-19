package com.clinton;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void getArea() {
        int w = 4;
        int h = 5;

        Rectangle rectangle = new Rectangle(h, w);
        Assertions.assertThat(rectangle.getArea()).isEqualTo(20);
    }

    @Test
    public void getPerimeter() {
        int w = 4;
        int h = 5;

        Rectangle rectangle = new Rectangle(h, w);
        Assertions.assertThat(rectangle.getPerimeter()).isEqualTo(18);
    }
}