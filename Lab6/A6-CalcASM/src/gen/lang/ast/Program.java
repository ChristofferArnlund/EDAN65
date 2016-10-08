/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/calc.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Expr}</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/CodeGen.jrag:6
   */
  public void genCode(PrintStream out) {
		out.println(".global _start");
		out.println(".data");
		out.println("ask_message: .ascii \"Please enter a number: \"");
		out.println("ask_msg_len: .quad 23");
		out.println("buf: .skip 1024");
		out.println();
		out.println(".text");
		out.println("_start:");

		// allocate space for local variables (bindings):
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        subq $" + (getExpr().numLocals()*8) + ", %rsp");

		getExpr().genEval(out);// stores result in RAX


		// print result:
		out.println("        pushq %rax");
		out.println("        call print");
		out.println("        addq $8, %rsp");

		// de-allocate local variables:
		out.println("        movq %rbp, %rsp");
		out.println("        popq %rbp");

		// call sys_exit:
		out.println("        movq $0, %rdi");
		out.println("        movq $60, %rax");
		out.println("        syscall"); // done!

		// helper functions
		out.println("# Procedure to read number from stdin");
		out.println("# C signature: long int read(void)");
		out.println("read:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $0, %rdi");
		out.println("        movq $buf, %rsi");
		out.println("        movq $1024, %rdx");
		out.println("        movq $0, %rax");
		out.println("        syscall                 # %rax = sys_read(0, buf, 1024)");
		out.println("        ### convert string to integer:");
		out.println("        ### %rax contains nchar");
		out.println("        ### %rsi contains ptr");
		out.println("        movq $0, %rdx           # sum = 0");
		out.println("atoi_loop:");
		out.println("        cmpq $0, %rax           # while (nchar > 0)");
		out.println("        jle atoi_done           # leave loop if nchar <= 0");
		out.println("        movzbq (%rsi), %rbx     # move byte, and sign extend to qword");
		out.println("        cmpq $0x30, %rbx        # test if < '0'");
		out.println("        jl atoi_done            # character is not numeric");
		out.println("        cmpq $0x39, %rbx        # test if > '9'");
		out.println("        jg atoi_done            # character is not numeric");
		out.println("        imulq $10, %rdx         # multiply sum by 10");
		out.println("        subq $0x30, %rbx        # value of character");
		out.println("        addq %rbx, %rdx         # add to sum");
		out.println("        incq %rsi               # step to next char");
		out.println("        decq %rax               # nchar--");
		out.println("        jmp atoi_loop           # loop back");
		out.println("atoi_done:");
		out.println("        movq %rdx, %rax         # return value in RAX");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("# Procedure to print number to stdout");
		out.println("# C signature: void print(long int)");
		out.println("print:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        ### convert integer to string");
		out.println("        movq 16(%rbp), %rax     # parameter");
		out.println("        movq $(buf+1023), %rsi  # write ptr (start from end of buf)");
		out.println("        movb $0x0a, (%rsi)      # insert newline");
		out.println("        movq $1, %rcx           # string length");
		out.println("itoa_loop:                      # do.. while (at least one iteration)");
		out.println("        movq $10, %rbx");
		out.println("        movq $0, %rdx");
		out.println("        idivq %rbx              # divide rdx:rax by 10");
		out.println("        addb $0x30, %dl         # remainder + '0'");
		out.println("        decq %rsi               # move string pointer");
		out.println("        movb %dl, (%rsi)");
		out.println("        incq %rcx               # increment string length");
		out.println("        cmpq $0, %rax");
		out.println("        jg itoa_loop            # produce more digits");
		out.println("itoa_done:");
		out.println("        movq $1, %rdi");
		out.println("        movq %rcx, %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("print_string:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $1, %rdi");
		out.println("        movq 16(%rbp), %rsi");
		out.println("        movq 24(%rbp), %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
	}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
  public Program(Expr p0) {
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
    localIndex_reset();
    unknownDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:90
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:104
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
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/Errors.jrag:26
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

/** @apilevel internal */
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * Local variable numbering.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/CodeGen.jrag:181
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/CodeGen.jrag:181")
  public int localIndex() {
    ASTNode$State state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = 0;
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTNode$State state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/NameAnalysis.jrag:26
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/NameAnalysis.jrag:34
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/marcus/git/EDAN65/Lab6/A6-CalcASM/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTNode$State state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

}
