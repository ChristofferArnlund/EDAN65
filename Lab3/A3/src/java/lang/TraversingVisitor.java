package lang;

import lang.ast.*;

public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected Object visitChildren(ASTNode node, Object data) {
		for(int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
		return data;
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Program node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Assign node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(StmtBlock node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Func node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(IdDecl node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(While node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(If node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Return node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(FuncCall node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(FuncCallStmt node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Numeral node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Add node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Mul node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Sub node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Div node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Mod node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Equals node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Not node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Leq node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Le node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Geq node, Object data) {
		return visitChildren(node, data);		
	}

	public Object visit(Ge node, Object data) {
		return visitChildren(node, data);		
	}
}
