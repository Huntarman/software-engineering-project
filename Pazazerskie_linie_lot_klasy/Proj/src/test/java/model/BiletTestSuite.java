package model;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"model", "App"})
@IncludeTags("Bilet")
public class BiletTestSuite { }