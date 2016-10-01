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
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:11
 * @production UnknownFunc : {@link Func};

 */
public class UnknownFunc extends Func implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownFunc() {
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
  public UnknownFunc(IdDecl p0, List<FuncParam> p1, StmtBlock p2) {
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
  public UnknownFunc clone() throws CloneNotSupportedException {
    UnknownFunc node = (UnknownFunc) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public UnknownFunc copy() {
    try {
      UnknownFunc node = (UnknownFunc) clone();
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
  public UnknownFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public UnknownFunc treeCopyNoTransform() {
    UnknownFunc tree = (UnknownFunc) copy();
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
  public UnknownFunc treeCopy() {
    UnknownFunc tree = (UnknownFunc) copy();
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
  public void setFuncParamsList(List<FuncParam> list) {
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
  public FuncParam getFuncParams(int i) {
    return (FuncParam) getFuncParamsList().getChild(i);
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
  public void addFuncParams(FuncParam node) {
    List<FuncParam> list = (parent == null) ? getFuncParamsListNoTransform() : getFuncParamsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncParamsNoTransform(FuncParam node) {
    List<FuncParam> list = getFuncParamsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the FuncParams list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFuncParams(FuncParam node, int i) {
    List<FuncParam> list = getFuncParamsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FuncParams")
  public List<FuncParam> getFuncParamsList() {
    List<FuncParam> list = (List<FuncParam>) getChild(1);
    return list;
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<FuncParam> getFuncParamsListNoTransform() {
    return (List<FuncParam>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the FuncParams list without
   * triggering rewrites.
   */
  public FuncParam getFuncParamsNoTransform(int i) {
    return (FuncParam) getFuncParamsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  public List<FuncParam> getFuncParamss() {
    return getFuncParamsList();
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<FuncParam> getFuncParamssNoTransform() {
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
/** @apilevel internal */
protected boolean isUnknownFunc_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/UnknownFunc.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/UnknownFunc.jrag:7")
  public boolean isUnknownFunc() {
    if (isUnknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Func.isUnknownFunc().");
    }
    isUnknownFunc_visited = true;
    boolean isUnknownFunc_value = true;
    isUnknownFunc_visited = false;
    return isUnknownFunc_value;
  }
}
