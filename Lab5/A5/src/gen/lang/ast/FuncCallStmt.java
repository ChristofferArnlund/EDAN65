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
 * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:18
 * @production FuncCallStmt : {@link Stmt} ::= <span class="component">{@link FuncCall}</span>;

 */
public class FuncCallStmt extends Stmt implements Cloneable {
  /**
   * @aspect Interp
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:26
   */
  public void eval(ActivationRecord actRec) {
		getFuncCall().eval(actRec);
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncCallStmt() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public FuncCallStmt(FuncCall p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:17
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:21
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public FuncCallStmt clone() throws CloneNotSupportedException {
    FuncCallStmt node = (FuncCallStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public FuncCallStmt copy() {
    try {
      FuncCallStmt node = (FuncCallStmt) clone();
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
   * @declaredat ASTNode:53
   */
  @Deprecated
  public FuncCallStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:63
   */
  public FuncCallStmt treeCopyNoTransform() {
    FuncCallStmt tree = (FuncCallStmt) copy();
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
   * @declaredat ASTNode:83
   */
  public FuncCallStmt treeCopy() {
    FuncCallStmt tree = (FuncCallStmt) copy();
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
   * @declaredat ASTNode:97
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncCall child.
   * @param node The new node to replace the FuncCall child.
   * @apilevel high-level
   */
  public void setFuncCall(FuncCall node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncCall child.
   * @return The current node used as the FuncCall child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncCall")
  public FuncCall getFuncCall() {
    return (FuncCall) getChild(0);
  }
  /**
   * Retrieves the FuncCall child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncCall child.
   * @apilevel low-level
   */
  public FuncCall getFuncCallNoTransform() {
    return (FuncCall) getChildNoTransform(0);
  }
  /**
   * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:34
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncCallNoTransform()) {
      // @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:45
      return intType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
