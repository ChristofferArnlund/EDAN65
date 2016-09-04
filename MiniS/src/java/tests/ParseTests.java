package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles");// where test input files are
	}

	@Test
	public void program31() {
		testValidSyntax("program31.minis");
	}

	@Test
	public void emptyProgram() {
		testSyntaxError("emptyProgram.minis");
	}

	@Test
	public void syntaxError() {
		testSyntaxError("syntaxError.minis");
	}

	@Test
	public void scanningError() {
		testSyntaxError("scanningError.minis");
	}
}
