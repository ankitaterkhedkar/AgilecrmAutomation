package com.agileCrmAutomation;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
public class TestListeners extends BaseClass implements ITestListener,ISuiteListener{
	public void onStart(ISuite suite)
	{
		System.out.println("This is onstart method of suite");
	}
	public void onFinish(ISuite suite)
	{
		System.out.println("This is onfinish method of suite");
	}
	public void onStart(ITestContext context)
	{
		System.out.println("This is onstart method of Test");
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("This is onFinish method of Test");
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("This is onTest start");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("This is on test success");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("This is on test failure");
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("This is on test skipped");
	}
	
	
}
