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
 * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/lang.ast:28
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public IdDecl(beaver.Symbol p0) {
    setID(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
   * @declaredat ASTNode:55
   */
  @Deprecated
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:65
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:85
   */
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:99
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((IdDecl) node).tokenString_ID);    
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
/** @apilevel internal */
protected boolean typeString_visited = false;
  /**
   * @attribute syn
   * @aspect ErrorContributions
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/Errors.jrag:34
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ErrorContributions", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/Errors.jrag:34")
  public String typeString() {
    if (typeString_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.typeString().");
    }
    typeString_visited = true;
    String typeString_value = isVariable() ? "Variable" : "Function";
    typeString_visited = false;
    return typeString_value;
  }
/** @apilevel internal */
protected boolean isMultiplyDeclared_visited = false;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:15")
  public boolean isMultiplyDeclared() {
    if (isMultiplyDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiplyDeclared().");
    }
    isMultiplyDeclared_visited = true;
    try {
    		IdDecl decl = lookup(getID());
    		return !decl.isUnknown() ? decl != this : false;
    	}
    finally {
      isMultiplyDeclared_visited = false;
    }
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/TypeAnalysis.jrag:18
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/TypeAnalysis.jrag:18")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.type().");
    }
    type_visited = true;
    Type type_value = intType();
    type_visited = false;
    return type_value;
  }
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;
    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect IdUseTypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/IdUseTypeAnalysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="IdUseTypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/IdUseTypeAnalysis.jrag:3")
  public boolean isFunction() {
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isFunction().");
    }
    isFunction_visited = true;
    boolean isFunction_value = getParent().Define_isFunction(this, null);
    isFunction_visited = false;
    return isFunction_value;
  }
/** @apilevel internal */
protected boolean isFunction_visited = false;
  /**
   * @attribute inh
   * @aspect IdUseTypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/IdUseTypeAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="IdUseTypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/IdUseTypeAnalysis.jrag:4")
  public boolean isVariable() {
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isVariable().");
    }
    isVariable_visited = true;
    boolean isVariable_value = getParent().Define_isVariable(this, null);
    isVariable_visited = false;
    return isVariable_value;
  }
/** @apilevel internal */
protected boolean isVariable_visited = false;
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/NameAnalysis.jrag:19")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
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
   * @aspect ParamChecker
   * @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/ParamChecker.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="ParamChecker", declaredAt="/home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/ParamChecker.jrag:3")
  public Func function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.function().");
    }
    function_visited = true;
    Func function_value = getParent().Define_function(this, null);
    function_visited = false;
    return function_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/marcus/git/EDAN65/Lab4P/A4_predef_type_more/src/jastadd/Errors.jrag:56
    if (isMultiplyDeclared()) {
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
    if (isMultiplyDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }
}
