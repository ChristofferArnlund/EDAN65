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
 * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/lang.ast:4
 * @production StmtBlock : {@link ASTNode} ::= <span class="component">{@link Stmt}*</span>;

 */
public class StmtBlock extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/CodeGen.jrag:40
   */
  public void genCode(PrintStream out) {
		for(Stmt stmt : getStmts())
			stmt.genCode(out);
	}
  /**
   * @aspect Interp
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Interp.jrag:47
   */
  public void eval(ActivationRecord actRec) throws ReturnException {
		for(Stmt stmt : getStmts())
			stmt.eval(actRec);
	}
  /**
   * @declaredat ASTNode:1
   */
  public StmtBlock() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public StmtBlock(List<Stmt> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 1;
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
  public StmtBlock clone() throws CloneNotSupportedException {
    StmtBlock node = (StmtBlock) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public StmtBlock copy() {
    try {
      StmtBlock node = (StmtBlock) clone();
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
  public StmtBlock fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:64
   */
  public StmtBlock treeCopyNoTransform() {
    StmtBlock tree = (StmtBlock) copy();
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
  public StmtBlock treeCopy() {
    StmtBlock tree = (StmtBlock) copy();
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
   * Replaces the Stmt list.
   * @param list The new list node to be used as the Stmt list.
   * @apilevel high-level
   */
  public void setStmtList(List<Stmt> list) {
    setChild(list, 0);
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
    List<Stmt> list = (List<Stmt>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtListNoTransform() {
    return (List<Stmt>) getChildNoTransform(0);
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
/** @apilevel internal */
protected java.util.Set localLookup_String_int_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:35")
  public IdDecl localLookup(String name, int until) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(name);
    _parameters.add(until);
    if (localLookup_String_int_visited == null) localLookup_String_int_visited = new java.util.HashSet(4);
    if (localLookup_String_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute StmtBlock.localLookup(String,int).");
    }
    localLookup_String_int_visited.add(_parameters);
    try {
    		for(int i = 0; i <= until; i++) {
    			Stmt stmt = getStmt(i);
    			IdDecl idDecl = stmt.localLookup(name); //Do not ask up
    			if(!idDecl.isUnknown()) 
    				return idDecl;
    		}
    		return unknownDecl();
    	}
    finally {
      localLookup_String_int_visited.remove(_parameters);
    }
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:32
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:32")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute StmtBlock.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @attribute inh
   * @aspect uniqueIdDeclName
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:12
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="uniqueIdDeclName", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:12")
  public String uniqueNamePrefix() {
    if (uniqueNamePrefix_visited) {
      throw new RuntimeException("Circular definition of attribute StmtBlock.uniqueNamePrefix().");
    }
    uniqueNamePrefix_visited = true;
    String uniqueNamePrefix_value = getParent().Define_uniqueNamePrefix(this, null);
    uniqueNamePrefix_visited = false;
    return uniqueNamePrefix_value;
  }
/** @apilevel internal */
protected boolean uniqueNamePrefix_visited = false;
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:19
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:26
      int index = _callerNode.getIndexOfChild(_childNode);
      {
      		IdDecl idDecl = localLookup(name, index);
      		return !idDecl.isUnknown() ? idDecl : lookup(name); 
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:6
   * @apilevel internal
   */
  public String Define_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:8
      int index = _callerNode.getIndexOfChild(_childNode);
      {
      		return uniqueNamePrefix() + index + "_";
      	}
    }
    else {
      return getParent().Define_uniqueNamePrefix(this, _callerNode);
    }
  }
  protected boolean canDefine_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
