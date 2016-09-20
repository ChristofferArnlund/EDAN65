package lang;

import lang.ast.*;

public class MSNVisitor extends TraversingVisitor {

	private int maxCount;// = 0;
	
	public static int result(ASTNode n) {
		MSNVisitor v = new MSNVisitor();
		n.accept(v, 0);
		return v.maxCount;
	}
	
	public Object visit(StmtBlock node, Object data){
		int count = ((Integer)data + 1);
		if(count > maxCount)
			maxCount = count;
		visitChildren(node, count);
		return count;
	}
}
