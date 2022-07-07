package com.indra.utils;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestLinkIntegration {
    //docker
    public static int result =0;
    public static final String TESTLINK_KEY="a02d7567fcab66d25dbb13536019a4f6";
    public static final String TESTLINK_URL="http://localhost/lib/api/xmlrpc/v1/xmlrpc.php";
    public static final String TEST_PROJECT_NAME="SanityFull";
    public static final String TEST_PLAN_NAME="SampleTestPlan";
    public static final String BUILD_NAME="SampleBuild";


    public static void updateResults(String testCaseName, String exception,String results) throws TestLinkAPIException {
        TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY,TESTLINK_URL);
        testLink.reportTestCaseResult(TEST_PROJECT_NAME,TEST_PLAN_NAME,testCaseName,BUILD_NAME,exception,results);
        System.out.println( testLink.about());;
    }

    public static void logicUpdateTestCaseResult(String testCaseName) throws TestLinkAPIException {
        if(result == 1){
            updateResults(testCaseName, "Ejecucion Exitosa", TestLinkAPIResults.TEST_PASSED);
        }
        else{
            updateResults(testCaseName, "Ejecucion Fallida", TestLinkAPIResults.TEST_FAILED);
        }
    }
}
