When you simply run:

    gradle test

the test in the `slow` group won't be run. To run all tests, use:

    gradle testAll
    
To declare a test belongs to a group:

    @Test( groups = {"slow"} )
    public void foo_shouldNotPrint() {
      fail("Won't see this when 'slow' group is excluded");
    }
    
This is the relevant `build.gradle` for convenience:
```
test {
  useTestNG() {
    excludeGroups 'slow'
  }
}

task testAll(type: Test) {
  useTestNG()
}
```
Obviously this can be configured with XML too, when running tests without Gradle:

```
<!-- testng-fast.xml -->
<test name="FooBarFastTests">
  <groups>
    <run>
      <exclude name="slow"/>
    </run>
  </groups>
  <classes>
    <class name="com.example.FooBarTest"/>
  </classes>
</test>
```
Useful links:
- [TestNG doc](http://testng.org/doc/documentation-main.html#test-groups)
- [Gradle doc](http://www.gradle.org/docs/current/groovydoc/org/gradle/api/tasks/testing/testng/TestNGOptions.html#excludeGroups)
