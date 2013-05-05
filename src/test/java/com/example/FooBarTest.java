package com.example;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FooBarTest {
  
  @Test
  public void foo_shouldPrint() {
    fail("This will always run");
  }
  
  @Test( groups = {"slow"} )
  public void foo_shouldNotPrint() {
    fail("Won't see this when 'slow' group is excluded");
  }

}
