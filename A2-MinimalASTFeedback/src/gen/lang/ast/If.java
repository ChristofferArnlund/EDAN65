/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/A2-MinimalAST/src/jastadd/lang.ast:8
 * @production If : {@link Stmt} ::= <span class="component">{@link Expr}</span> <span class="component">Do:{@link Stmt}*</span> <span class="component">Else:{@link Stmt}*</span>;

 */
public class If extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public If() {
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
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public If(Expr p0, List<Stmt> p1, List<Stmt> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public If clone() throws CloneNotSupportedException {
    If node = (If) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public If copy() {
    try {
      If node = (If) clone();
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
   * @declaredat ASTNode:57
   */
  @Deprecated
  public If fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:67
   */
  public If treeCopyNoTransform() {
    If tree = (If) copy();
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
   * @declaredat ASTNode:87
   */
  public If treeCopy() {
    If tree = (If) copy();
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
   * @declaredat ASTNode:101
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
   * Replaces the Do list.
   * @param list The new list node to be used as the Do list.
   * @apilevel high-level
   */
  public void setDoList(List<Stmt> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Do list.
   * @return Number of children in the Do list.
   * @apilevel high-level
   */
  public int getNumDo() {
    return getDoList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Do list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Do list.
   * @apilevel low-level
   */
  public int getNumDoNoTransform() {
    return getDoListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Do list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Do list.
   * @apilevel high-level
   */
  public Stmt getDo(int i) {
    return (Stmt) getDoList().getChild(i);
  }
  /**
   * Check whether the Do list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDo() {
    return getDoList().getNumChild() != 0;
  }
  /**
   * Append an element to the Do list.
   * @param node The element to append to the Do list.
   * @apilevel high-level
   */
  public void addDo(Stmt node) {
    List<Stmt> list = (parent == null) ? getDoListNoTransform() : getDoList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addDoNoTransform(Stmt node) {
    List<Stmt> list = getDoListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Do list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDo(Stmt node, int i) {
    List<Stmt> list = getDoList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Do list.
   * @return The node representing the Do list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Do")
  public List<Stmt> getDoList() {
    List<Stmt> list = (List<Stmt>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Do list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Do list.
   * @apilevel low-level
   */
  public List<Stmt> getDoListNoTransform() {
    return (List<Stmt>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Do list without
   * triggering rewrites.
   */
  public Stmt getDoNoTransform(int i) {
    return (Stmt) getDoListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Do list.
   * @return The node representing the Do list.
   * @apilevel high-level
   */
  public List<Stmt> getDos() {
    return getDoList();
  }
  /**
   * Retrieves the Do list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Do list.
   * @apilevel low-level
   */
  public List<Stmt> getDosNoTransform() {
    return getDoListNoTransform();
  }
  /**
   * Replaces the Else list.
   * @param list The new list node to be used as the Else list.
   * @apilevel high-level
   */
  public void setElseList(List<Stmt> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Else list.
   * @return Number of children in the Else list.
   * @apilevel high-level
   */
  public int getNumElse() {
    return getElseList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Else list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Else list.
   * @apilevel low-level
   */
  public int getNumElseNoTransform() {
    return getElseListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Else list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Else list.
   * @apilevel high-level
   */
  public Stmt getElse(int i) {
    return (Stmt) getElseList().getChild(i);
  }
  /**
   * Check whether the Else list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasElse() {
    return getElseList().getNumChild() != 0;
  }
  /**
   * Append an element to the Else list.
   * @param node The element to append to the Else list.
   * @apilevel high-level
   */
  public void addElse(Stmt node) {
    List<Stmt> list = (parent == null) ? getElseListNoTransform() : getElseList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addElseNoTransform(Stmt node) {
    List<Stmt> list = getElseListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Else list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setElse(Stmt node, int i) {
    List<Stmt> list = getElseList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Else list.
   * @return The node representing the Else list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Else")
  public List<Stmt> getElseList() {
    List<Stmt> list = (List<Stmt>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Else list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Else list.
   * @apilevel low-level
   */
  public List<Stmt> getElseListNoTransform() {
    return (List<Stmt>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Else list without
   * triggering rewrites.
   */
  public Stmt getElseNoTransform(int i) {
    return (Stmt) getElseListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Else list.
   * @return The node representing the Else list.
   * @apilevel high-level
   */
  public List<Stmt> getElses() {
    return getElseList();
  }
  /**
   * Retrieves the Else list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Else list.
   * @apilevel low-level
   */
  public List<Stmt> getElsesNoTransform() {
    return getElseListNoTransform();
  }
}
