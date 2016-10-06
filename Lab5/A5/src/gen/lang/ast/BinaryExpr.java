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
import java.util.Scanner;
/**
 * @ast node
 * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:31
 * @production BinaryExpr : {@link Expr} ::= <span class="component">Left:{@link Expr}</span> <span class="component">Right:{@link Expr}</span>;

 */
public abstract class BinaryExpr extends Expr implements Cloneable {
  /**
   * @aspect ExprComputation
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:101
   */
  public int eval(ActivationRecord actRec) {
		return evalOp(getLeft().eval(actRec), getRight().eval(actRec));
	}
  /**
   * @aspect ExprComputation
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:106
   */
  public abstract int evalOp(int l, int r);
  /**
   * @declaredat ASTNode:1
   */
  public BinaryExpr() {
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
  public BinaryExpr(Expr p0, Expr p1) {
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
  public BinaryExpr clone() throws CloneNotSupportedException {
    BinaryExpr node = (BinaryExpr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:41
   */
  @Deprecated
  public abstract BinaryExpr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:49
   */
  public abstract BinaryExpr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:57
   */
  public abstract BinaryExpr treeCopy();
  /**
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public void setLeft(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Expr getLeft() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Expr getLeftNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public void setRight(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Expr getRight() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Expr getRightNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:23
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:23")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute BinaryExpr.type().");
    }
    type_visited = true;
    Type type_value = intType();
    type_visited = false;
    return type_value;
  }
  /**
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:34
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
