package ru.stqa.pft.rest;

import org.testng.annotations.Test;


public class ExcludedRestTests extends TestBase {

    private int id = 7;

    @Test
    public void testExcludeRest() {
        skipIfNotFixed(id);
        System.out.println("test");
    }
}
