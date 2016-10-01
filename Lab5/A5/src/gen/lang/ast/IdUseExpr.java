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
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:26
 * @production IdUseExpr : {@link Expr} ::= <span class="component">{@link IdUse}</span>;

 */
public class IdUseExpr extends Expr implements Cloneable {
  /**
   * @aspect ExprComputation
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:88
   */
  public int eval(ActivationRecord actRec) {
		return actRec.get(getIdUse().decl().uniqueName());
	}
  /**
   * @declaredat ASTNode:1
   */
  public IdUseExpr() {
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
  public IdUseExpr(IdUse p0) {
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
  public IdUseExpr clone() throws CloneNotSupportedException {
    IdUseExpr node = (IdUseExpr) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public IdUseExpr copy() {
    try {
      IdUseExpr node = (IdUseExpr) clone();
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
  public IdUseExpr fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:63
   */
  public IdUseExpr treeCopyNoTransform() {
    IdUseExpr tree = (IdUseExpr) copy();
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
  public IdUseExpr treeCopy() {
    IdUseExpr tree = (IdUseExpr) copy();
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
   * Replaces the IdUse child.
   * @param node The new node to replace the IdUse child.
   * @apilevel high-level
   */
  public void setIdUse(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the IdUse child.
   * @return The current node used as the IdUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdUse")
  public IdUse getIdUse() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the IdUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdUse child.
   * @apilevel low-level
   */
  public IdUse getIdUseNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
/** @apilevel internal */
protected boolean isCircular_visited = false;
  /**
   * @attribute syn
   * @aspect CircularDefinitions
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/CircularDefinitions.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/CircularDefinitions.jrag:6")
  public boolean isCircular() {
    if (isCircular_visited) {
      throw new RuntimeException("Circular definition of attribute IdUseExpr.isCircular().");
    }
    isCircular_visited = true;
    boolean isCircular_value = inExprOf(getIdUse().decl());
    isCircular_visited = false;
    return isCircular_value;
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/TypeAnalysis.jrag:19")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute IdUseExpr.type().");
    }
    type_visited = true;
    Type type_value = intType();
    type_visited = false;
    return type_value;
  }
  /**
   * @attribute inh
   * @aspect CircularDefinitions
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/CircularDefinitions.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/CircularDefinitions.jrag:9")
  public boolean inExprOf(IdDecl decl) {
    Object _parameters = decl;
    if (inExprOf_IdDecl_visited == null) inExprOf_IdDecl_visited = new java.util.HashSet(4);
    if (inExprOf_IdDecl_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdUseExpr.inExprOf(IdDecl).");
    }
    inExprOf_IdDecl_visited.add(_parameters);
    boolean inExprOf_IdDecl_value = getParent().Define_inExprOf(this, null, decl);
    inExprOf_IdDecl_visited.remove(_parameters);
    return inExprOf_IdDecl_value;
  }
/** @apilevel internal */
protected java.util.Set inExprOf_IdDecl_visited;
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Errors.jrag:40
    if (isCircular()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Errors.jrag:52
    if (!getIdUse().decl().isVariable() && !getIdUse().decl().isUnknown()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (isCircular()) {
      collection.add(error("Variable '" + getIdUse().getID() + " is circular!"));
    }
    if (!getIdUse().decl().isVariable() && !getIdUse().decl().isUnknown()) {
      collection.add(error("'" + getIdUse().getID() + "' is not a variable"));
    }
  }
}
