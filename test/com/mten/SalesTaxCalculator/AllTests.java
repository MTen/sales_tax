package com.mten.SalesTaxCalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AbsInputMatcherTest.class, TransactionTest.class,
		UserInputTest.class, BatchTest.class,})
public class AllTests {

}
