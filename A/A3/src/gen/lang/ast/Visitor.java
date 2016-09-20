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
 * @declaredat /Users/juliusbarendt/Desktop/A/A3/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Func node, Object data);

		 
		public Object visit(StmtBlock node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(While node, Object data);

		 
		public Object visit(If node, Object data);

		 
		public Object visit(Return node, Object data);

		 
		public Object visit(FuncCallStmt node, Object data);

		 
		public Object visit(Assign node, Object data);

		 
		public Object visit(FuncCall node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(Add node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Sub node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Mod node, Object data);

		 
		public Object visit(Equals node, Object data);

		 
		public Object visit(Not node, Object data);

		 
		public Object visit(Leq node, Object data);

		 
		public Object visit(Le node, Object data);

		 
		public Object visit(Geq node, Object data);

		 
		public Object visit(Ge node, Object data);
}
