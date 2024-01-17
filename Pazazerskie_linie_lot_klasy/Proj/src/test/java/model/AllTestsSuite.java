package model;

import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"model", "App"})
@ExcludeClassNamePatterns({"^.*TestMocked?$"})
public class AllTestsSuite { }