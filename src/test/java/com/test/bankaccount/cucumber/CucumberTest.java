package com.test.bankaccount.cucumber;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("com/test/bankaccount/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.test.bankaccount.cucumber.stepdefs")
public class CucumberTest {
}
