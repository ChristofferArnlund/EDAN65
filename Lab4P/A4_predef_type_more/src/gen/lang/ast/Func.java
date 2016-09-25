/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/lang.ast:2
 * @production Func : {@link ASTNode} ::= <span class="component">FuncName:{@link IdDecl}</span> <span class="component">FuncParams:{@link IdDeclStmt}*</span> <span class="component">{@link StmtBlock}</span>;

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
    children = new ASTNode[3];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Func(IdDecl p0, List<IdDeclStmt> p1, StmtBlock p2) {
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
  public void setFuncParamsList(List<IdDeclStmt> list) {
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
  public IdDeclStmt getFuncParams(int i) {
    return (IdDeclStmt) getFuncParamsList().getChild(i);
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
  public void addFuncParams(IdDeclStmt node) {
    List<IdDeclStmt> list = (parent == null) ? getFuncParamsListNoTransform() : getFuncParamsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncParamsNoTransform(IdDeclStmt node) {
    List<IdDeclStmt> list = getFuncParamsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the FuncParams list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFuncParams(IdDeclStmt node, int i) {
    List<IdDeclStmt> list = getFuncParamsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FuncParams")
  public List<IdDeclStmt> getFuncParamsList() {
    List<IdDeclStmt> list = (List<IdDeclStmt>) getChild(1);
    return list;
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<IdDeclStmt> getFuncParamsListNoTransform() {
    return (List<IdDeclStmt>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the FuncParams list without
   * triggering rewrites.
   */
  public IdDeclStmt getFuncParamsNoTransform(int i) {
    return (IdDeclStmt) getFuncParamsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  public List<IdDeclStmt> getFuncParamss() {
    return getFuncParamsList();
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<IdDeclStmt> getFuncParamssNoTransform() {
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
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/UnknownFunc.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/UnknownFunc.jrag:7")
  public boolean isUnknownFunc() {
    if (isUnknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Func.isUnknownFunc().");
    }
    isUnknownFunc_visited = true;
    boolean isUnknownFunc_value = false;
    isUnknownFunc_visited = false;
    return isUnknownFunc_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:65
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:65")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:15
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:17
      return true;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:16
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:18
      return false;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:22
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getStmtBlockNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:55
      {
      		for(int i = 0; i < getNumFuncParams(); i++) {
      			IdDecl decl = getFuncParams(i).getIdDecl();
      			if(decl.getID().equals(name))
      				return decl;
      		}
      		return lookup(name);
      	}
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/ParamChecker.jrag:3
   * @apilevel internal
   */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/ParamChecker.jrag:9
      return this;
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
