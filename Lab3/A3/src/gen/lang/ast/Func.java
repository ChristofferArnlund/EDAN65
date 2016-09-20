/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab3/A3/src/jastadd/lang.ast:2
 * @production Func : {@link ASTNode} ::= <span class="component">FuncName:{@link IdDecl}</span> <span class="component">FuncParams:{@link IdDecl}*</span> <span class="component">{@link StmtBlock}</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab3/A3/src/jastadd/NameAnalysis.jrag:54
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
		getFuncName().checkNames(err, symbols);
		symbols = symbols.push();
		for(int i = 0; i < getNumFuncParams(); ++i) 
			getFuncParams(i).checkNames(err, symbols);
		getStmtBlock().checkNames(err, symbols);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/marcus/git/EDAN65/Lab3/A3/src/jastadd/PrettyPrint.jrag:40
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print("int " + getFuncName().getID() + "(");
		for(int i = 0; i < getNumFuncParams(); ++i) {
			out.print("int " + getFuncParams(i).getID());
			if(i < getNumFuncParams() - 1)
				out.print(", ");
		}
		out.print(")");
		getStmtBlock().prettyPrint(out, ind + "");
		out.println();
	}
  /**
   * @aspect Visitor
   * @declaredat /home/marcus/git/EDAN65/Lab3/A3/src/jastadd/Visitor.jrag:55
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Func() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[3];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Func(IdDecl p0, List<IdDecl> p1, StmtBlock p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:24
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public Func copy() {
    try {
      Func node = (Func) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:56
   */
  @Deprecated
  public Func fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public Func treeCopyNoTransform() {
    Func tree = (Func) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public Func treeCopy() {
    Func tree = (Func) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:100
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncName child.
   * @param node The new node to replace the FuncName child.
   * @apilevel high-level
   */
  public void setFuncName(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncName child.
   * @return The current node used as the FuncName child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncName")
  public IdDecl getFuncName() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the FuncName child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncName child.
   * @apilevel low-level
   */
  public IdDecl getFuncNameNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the FuncParams list.
   * @param list The new list node to be used as the FuncParams list.
   * @apilevel high-level
   */
  public void setFuncParamsList(List<IdDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the FuncParams list.
   * @return Number of children in the FuncParams list.
   * @apilevel high-level
   */
  public int getNumFuncParams() {
    return getFuncParamsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FuncParams list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FuncParams list.
   * @apilevel low-level
   */
  public int getNumFuncParamsNoTransform() {
    return getFuncParamsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FuncParams list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FuncParams list.
   * @apilevel high-level
   */
  public IdDecl getFuncParams(int i) {
    return (IdDecl) getFuncParamsList().getChild(i);
  }
  /**
   * Check whether the FuncParams list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFuncParams() {
    return getFuncParamsList().getNumChild() != 0;
  }
  /**
   * Append an element to the FuncParams list.
   * @param node The element to append to the FuncParams list.
   * @apilevel high-level
   */
  public void addFuncParams(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getFuncParamsListNoTransform() : getFuncParamsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncParamsNoTransform(IdDecl node) {
    List<IdDecl> list = getFuncParamsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the FuncParams list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFuncParams(IdDecl node, int i) {
    List<IdDecl> list = getFuncParamsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FuncParams")
  public List<IdDecl> getFuncParamsList() {
    List<IdDecl> list = (List<IdDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<IdDecl> getFuncParamsListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the FuncParams list without
   * triggering rewrites.
   */
  public IdDecl getFuncParamsNoTransform(int i) {
    return (IdDecl) getFuncParamsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  public List<IdDecl> getFuncParamss() {
    return getFuncParamsList();
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<IdDecl> getFuncParamssNoTransform() {
    return getFuncParamsListNoTransform();
  }
  /**
   * Replaces the StmtBlock child.
   * @param node The new node to replace the StmtBlock child.
   * @apilevel high-level
   */
  public void setStmtBlock(StmtBlock node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the StmtBlock child.
   * @return The current node used as the StmtBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="StmtBlock")
  public StmtBlock getStmtBlock() {
    return (StmtBlock) getChild(2);
  }
  /**
   * Retrieves the StmtBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the StmtBlock child.
   * @apilevel low-level
   */
  public StmtBlock getStmtBlockNoTransform() {
    return (StmtBlock) getChildNoTransform(2);
  }
}
