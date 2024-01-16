package model;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({SamolotTestSuite.class})
@IncludeTags("Samolot")
@ExcludeTags("Przypis")
public class BaseSamolotTestSuite {}