package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	
	@Test
	public void BadSyntax() {
		testSyntaxError("BadSyntax.lang");
	}
	@Test
	public void Comment() {
		testValidSyntax("Comment.lang");
	}
	@Test
	public void FuncCall() {
		testValidSyntax("FuncCall.lang");
	}
	@Test
	public void If() {
		testValidSyntax("If.lang");
	}
	@Test
	public void ParamDecl() {
		testValidSyntax("ParamDecl.lang");
	}
	@Test
	public void Parens() {
		testValidSyntax("Parens.lang");
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
