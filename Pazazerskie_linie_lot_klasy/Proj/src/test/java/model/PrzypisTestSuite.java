package model;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("model")
@IncludeTags("Przypis")
public class PrzypisTestSuite { }