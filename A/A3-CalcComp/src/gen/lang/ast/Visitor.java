package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast interface
 * @aspect Visitor
 * @declaredat /Users/juliusbarendt/Desktop/A/A3-CalcComp/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(Let node, Object data);

		 
		public Object visit(Binding node, Object data);

		 
		public Object visit(Ask node, Object data);
}
