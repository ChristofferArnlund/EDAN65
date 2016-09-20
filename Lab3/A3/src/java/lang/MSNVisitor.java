package lang;

import lang.ast.*;

public class MSNVisitor extends TraversingVisitor {
	public static int result(ASTNode n) {
		MSNVisitor v = new MSNVisitor();
		n.accept(v, 0);
		return v.maxMSN;
	}

	private int maxMSN;

	public Object visit(StmtBlock node, Object data) {
		int newMSN = ((Integer)data + 1);
		if(newMSN > maxMSN)
			maxMSN = newMSN;
		visitChildren(node, newMSN);
		return newMSN;
	}
}
