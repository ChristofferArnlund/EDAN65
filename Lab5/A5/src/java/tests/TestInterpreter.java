package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;
import java.util.Set;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
/**
 * Tests name analysis
 */
@RunWith(Parameterized.class)
public class TestInterpreter extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/interpreter";

	/**
	 * Construct a new JastAdd test
	 * @param filename filename of test input file
	 */
	public TestInterpreter(String filename) {
		super(TEST_DIR, filename);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
		PrintStream out = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos)); //hijack
		StringBuilder sb = new StringBuilder();
		try{
			Program program = (Program) parse(inFile);
			Set<ErrorMessage> errors = program.errors();
			if(errors.size() == 0) { //no error detected in analysis continue
				program.eval();
			} else {
				sb.append("*************************************").append("\n");
				sb.append("* Interpreter halt, semantic error! *").append("\n");
				sb.append("*************************************").append("\n");
				for(ErrorMessage errorMsg : errors)
					sb.append(errorMsg).append("\n");
			}
		} catch (Exception e) {
			sb.append("***********************************************").append("\n");
			sb.append("* Interpreter halt, (scanning/parsing) error! *").append("\n");
			sb.append("***********************************************").append("\n");
			System.out.println(e.getMessage());
		}
		sb.append(baos.toString());
		compareOutput(sb.toString(), outFile, expectedFile);
		System.setOut(out);
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
