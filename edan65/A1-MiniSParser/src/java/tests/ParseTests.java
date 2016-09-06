package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles");// where test input files are
	}

	@Test
	public void all() {
		testValidSyntax("all.minis");
	}

	@Test
	public void shortest() {
		testValidSyntax("short.minis");
	}

	@Test
	public void parse() {
		testSyntaxError("parseerror.minis");
	}

	@Test
	public void scanerror() {
		testSyntaxError("scanerror.minis");
	}
}
