/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:15
 * @production While : {@link Stmt} ::= <span class="component">{@link Expr}</span> <span class="component">{@link StmtBlock}</span>;

 */
public class While extends Stmt implements Cloneable {
  /**
   * @aspect Interp
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:68
   */
  public void eval(ActivationRecord actRec) throws ReturnException {
		while(getExpr().eval(actRec) == 1)
			getStmtBlock().eval(actRec);
	}
  /**
   * @declaredat ASTNode:1
   */
  public While() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  public While(Expr p0, StmtBlock p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public While clone() throws CloneNotSupportedException {
    While node = (While) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public While copy() {
    try {
      While node = (While) clone();
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
   * @declaredat ASTNode:54
   */
  @Deprecated
  public While fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:64
   */
  public While treeCopyNoTransform() {
    While tree = (While) copy();
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
   * @declaredat ASTNode:84
   */
  public While treeCopy() {
    While tree = (While) copy();
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
   * @declaredat ASTNode:98
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the StmtBlock child.
   * @param node The new node to replace the StmtBlock child.
   * @apilevel high-level
   */
  public void setStmtBlock(StmtBlock node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the StmtBlock child.
   * @return The current node used as the StmtBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="StmtBlock")
  public StmtBlock getStmtBlock() {
    return (StmtBlock) getChild(1);
  }
  /**
   * Retrieves the StmtBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the StmtBlock child.
   * @apilevel low-level
   */
  public StmtBlock getStmtBlockNoTransform() {
    return (StmtBlock) getChildNoTransform(1);
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:34
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:39
      return boolType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
