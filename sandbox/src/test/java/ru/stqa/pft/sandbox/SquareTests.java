package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ilya on 23.07.2017.
 */

public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5);
        // assert s.area() == 25;
        Assert.assertEquals(s.area(), 25.0);

    }
}
