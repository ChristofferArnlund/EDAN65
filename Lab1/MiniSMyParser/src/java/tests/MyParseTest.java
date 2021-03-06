package tests;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Assert.*;
import myParser.RecursiveDescentCompiler;

public class MyParseTest {
	private static final String TEST_DIR = "testfiles/";

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
	
	private void testSyntaxError(String file) {
		String[] args = new String[1];
		args[0] = TEST_DIR+file;
		try{
			RecursiveDescentCompiler.main(args);
			fail("Should return exception of some kind!");
		} catch (Exception e) {
			
		}
	}
	
	private void testValidSyntax(String file) {
		String[] args = new String[1];
		args[0] = TEST_DIR+file;
		try{
			RecursiveDescentCompiler.main(args);
		} catch (Exception e) {
			fail("Should NOT return exception of some kind!");
		}
	}
}
