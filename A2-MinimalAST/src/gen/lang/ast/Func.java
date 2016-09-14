/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/a/dat13mro/git/EDAN65/A2-MinimalAST/src/jastadd/lang.ast:2
 * @production Func : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link IdDecl}*</span> <span class="component">{@link Stmt}*</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable {
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
    children = new ASTNode[2];
    setChild(new List(), 0);
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Func(String p0, List<IdDecl> p1, List<Stmt> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Func(beaver.Symbol p0, List<IdDecl> p1, List<Stmt> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
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
   * @declaredat ASTNode:62
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
   * @declaredat ASTNode:72
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
   * @declaredat ASTNode:92
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
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((Func) node).tokenString_ID);    
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the IdDecl list.
   * @param list The new list node to be used as the IdDecl list.
   * @apilevel high-level
   */
  public void setIdDeclList(List<IdDecl> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * @return Number of children in the IdDecl list.
   * @apilevel high-level
   */
  public int getNumIdDecl() {
    return getIdDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the IdDecl list.
   * @apilevel low-level
   */
  public int getNumIdDeclNoTransform() {
    return getIdDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the IdDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the IdDecl list.
   * @apilevel high-level
   */
  public IdDecl getIdDecl(int i) {
    return (IdDecl) getIdDeclList().getChild(i);
  }
  /**
   * Check whether the IdDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasIdDecl() {
    return getIdDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the IdDecl list.
   * @param node The element to append to the IdDecl list.
   * @apilevel high-level
   */
  public void addIdDecl(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getIdDeclListNoTransform() : getIdDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addIdDeclNoTransform(IdDecl node) {
    List<IdDecl> list = getIdDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the IdDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node, int i) {
    List<IdDecl> list = getIdDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="IdDecl")
  public List<IdDecl> getIdDeclList() {
    List<IdDecl> list = (List<IdDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the IdDecl list without
   * triggering rewrites.
   */
  public IdDecl getIdDeclNoTransform(int i) {
    return (IdDecl) getIdDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  public List<IdDecl> getIdDecls() {
    return getIdDeclList();
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclsNoTransform() {
    return getIdDeclListNoTransform();
  }
  /**
   * Replaces the Stmt list.
   * @param list The new list node to be used as the Stmt list.
   * @apilevel high-level
   */
  public void setStmtList(List<Stmt> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * @return Number of children in the Stmt list.
   * @apilevel high-level
   */
  public int getNumStmt() {
    return getStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Stmt list.
   * @apilevel low-level
   */
  public int getNumStmtNoTransform() {
    return getStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Stmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Stmt list.
   * @apilevel high-level
   */
  public Stmt getStmt(int i) {
    return (Stmt) getStmtList().getChild(i);
  }
  /**
   * Check whether the Stmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasStmt() {
    return getStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the Stmt list.
   * @param node The element to append to the Stmt list.
   * @apilevel high-level
   */
  public void addStmt(Stmt node) {
    List<Stmt> list = (parent == null) ? getStmtListNoTransform() : getStmtList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addStmtNoTransform(Stmt node) {
    List<Stmt> list = getStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Stmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setStmt(Stmt node, int i) {
    List<Stmt> list = getStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Stmt")
  public List<Stmt> getStmtList() {
    List<Stmt> list = (List<Stmt>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtListNoTransform() {
    return (List<Stmt>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Stmt list without
   * triggering rewrites.
   */
  public Stmt getStmtNoTransform(int i) {
    return (Stmt) getStmtListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   */
  public List<Stmt> getStmts() {
    return getStmtList();
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtsNoTransform() {
    return getStmtListNoTransform();
  }
}
