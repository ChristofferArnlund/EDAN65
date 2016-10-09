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
 * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/lang.ast:29
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
    IdDecl_idUses_visited = false;
    IdDecl_idUses_computed = false;
    
    IdDecl_idUses_value = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
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
   * @declaredat ASTNode:59
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
   * @declaredat ASTNode:69
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
   * @declaredat ASTNode:89
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
   * @declaredat ASTNode:103
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:34
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ErrorContributions", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:34")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:15")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:18
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:18")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;
    isUnknown_visited = false;
    return isUnknown_value;
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /**
   * @attribute syn
   * @aspect VarParamAddressing
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VarParamAddressing", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:3")
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    int localIndex_value = (isFunction() || isFunctionParam()) ? prevNode().localIndex() : prevNode().localIndex() + 1;
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean address_visited = false;
  /**
   * @attribute syn
   * @aspect VarParamAddressing
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:24
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VarParamAddressing", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:24")
  public String address() {
    if (address_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.address().");
    }
    address_visited = true;
    try {
    		if(isFunctionParam()) {
    			/*
    				+1 because of old base pointer and return address.
    				First param will have localIndex 1 so we will skip 2.
    			*/
    			return ((paramIndex() + 1)*8)+"(%rbp)";
    		} else {
    			return "-" + ((localIndex())*8)+"(%rbp)";
    		}
    	}
    finally {
      address_visited = false;
    }
  }
/** @apilevel internal */
protected boolean uniqueName_visited = false;
  /**
   * @attribute syn
   * @aspect uniqueIdDeclName
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="uniqueIdDeclName", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:2")
  public String uniqueName() {
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueName().");
    }
    uniqueName_visited = true;
    try {
    		return uniqueNamePrefix() + getID();
    	}
    finally {
      uniqueName_visited = false;
    }
  }
  /**
   * @attribute inh
   * @aspect IdUseTypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="IdUseTypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:3")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="IdUseTypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:4")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:19")
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/ParamChecker.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="ParamChecker", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/ParamChecker.jrag:3")
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
  /**
   * @attribute inh
   * @aspect VarParamAddressing
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:13
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VarParamAddressing", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:13")
  public boolean isFunctionParam() {
    if (isFunctionParam_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isFunctionParam().");
    }
    isFunctionParam_visited = true;
    boolean isFunctionParam_value = getParent().Define_isFunctionParam(this, null);
    isFunctionParam_visited = false;
    return isFunctionParam_value;
  }
/** @apilevel internal */
protected boolean isFunctionParam_visited = false;
  /**
   * @attribute inh
   * @aspect VarParamAddressing
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:20
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VarParamAddressing", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:20")
  public int paramIndex() {
    if (paramIndex_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.paramIndex().");
    }
    paramIndex_visited = true;
    int paramIndex_value = getParent().Define_paramIndex(this, null);
    paramIndex_visited = false;
    return paramIndex_value;
  }
/** @apilevel internal */
protected boolean paramIndex_visited = false;
  /**
   * @attribute inh
   * @aspect uniqueIdDeclName
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="uniqueIdDeclName", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:6")
  public String uniqueNamePrefix() {
    if (uniqueNamePrefix_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueNamePrefix().");
    }
    uniqueNamePrefix_visited = true;
    String uniqueNamePrefix_value = getParent().Define_uniqueNamePrefix(this, null);
    uniqueNamePrefix_visited = false;
    return uniqueNamePrefix_value;
  }
/** @apilevel internal */
protected boolean uniqueNamePrefix_visited = false;
/** @apilevel internal */
protected boolean IdDecl_idUses_visited = false;
  /**
   * @attribute coll
   * @aspect UnusedVars
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="UnusedVars", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:8")
  public Set<IdUseExpr> idUses() {
    ASTNode$State state = state();
    if (IdDecl_idUses_computed) {
      return IdDecl_idUses_value;
    }
    if (IdDecl_idUses_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.idUses().");
    }
    IdDecl_idUses_visited = true;
    state().enterLazyAttribute();
    IdDecl_idUses_value = idUses_compute();
    IdDecl_idUses_computed = true;
    state().leaveLazyAttribute();
    IdDecl_idUses_visited = false;
    return IdDecl_idUses_value;
  }
  /** @apilevel internal */
  private Set<IdUseExpr> idUses_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_IdDecl_idUses();
    Set<IdUseExpr> _computedValue = new HashSet<IdUseExpr>();
    if (root.contributorMap_IdDecl_idUses.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_IdDecl_idUses.get(this)) {
        contributor.contributeTo_IdDecl_idUses(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean IdDecl_idUses_computed = false;

  /** @apilevel internal */
  protected Set<IdUseExpr> IdDecl_idUses_value;

  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:56
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
  protected void collect_contributors_Program_unusedVars(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:16
    if (idUses().size() == 0 && isVariable()) {
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
    super.collect_contributors_Program_unusedVars(_root, _map);
  }
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (isMultiplyDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }
  protected void contributeTo_Program_unusedVars(Set<IdDecl> collection) {
    super.contributeTo_Program_unusedVars(collection);
    if (idUses().size() == 0 && isVariable()) {
      collection.add(this);
    }
  }
}
