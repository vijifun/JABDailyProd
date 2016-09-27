package iSAFE;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import Utilities.Common;

public class TestDriver extends ApplicationKeywords {

	public static void main(String[] args) {
		try {
			Common common = new Common();
			common.startup();
			TestNG testng = new TestNG();
			List<String> suites = new ArrayList<String>();
			suites.add("./Config/testng.xml");
			testng.setOutputDirectory(outputDirectory + "/testng");
			testng.setTestSuites(suites);
			testng.run();

		} catch (Exception e) {
			writeToLogFile("error", e.toString());
		} finally {
			try {
				report();
				cleanup();
			} catch (Exception e) {
				writeToLogFile("error", e.toString());
			} finally {
				writeToLogFile("INFO", "###################################");
				writeToLogFile("INFO", "Script Execution Complete");
				writeToLogFile("INFO", "####################################");

			}

		}
	}

}
