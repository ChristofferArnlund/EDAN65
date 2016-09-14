package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	@Test
	public void SimplefunDecls() {
		testValidSyntax("SimplefunDecls.lang");
	}
	@Test
	public void IdUseIdDecl() {
		testValidSyntax("IdUseIdDecl.lang");
	}
	@Test
	public void AddnMul() {
		testValidSyntax("AddnMul.lang");
	}
	@Test
	public void SubnDiv() {
		testValidSyntax("SubnDiv.lang");
	}
	@Test
	public void LogicComps() {
		testValidSyntax("LogicComps.lang");
	}
	@Test
	public void WhileTest() {
		testValidSyntax("WhileTest.lang");
	}
	@Test
	public void SimpleFuncCall() {
		testValidSyntax("SimpleFuncCall.lang");
	}
	@Test
	public void Program31() {
		testValidSyntax("Program31.lang");
	}

}
