package com.mten.SalesTaxCalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InputMatcherTest.class, TransactionTest.class,
		UserInputTest.class })
public class AllTests {

}