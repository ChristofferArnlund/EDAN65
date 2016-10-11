.global _start
.data
buf: .skip 1024
.text

_start:
	movq $3, %rax
	movq $4, %rbx
	subq %rbx, %rax
	pushq %rax
	call print
	addq $8, %rsp
	movq $0, %rdi
	movq $60, %rax
	syscall

print:
	pushq %rbp
	movq %rsp, %rbp
	### convert integer to string
	movq 16(%rbp), %rax # parameter
	movq $(buf+1023), %rsi # write ptr (start from end of buf)
	movb $0x0a, (%rsi) # insert newline
	movq $1, %rcx # string length
	movq $0xF000000000000000, %r9		#mask
	movq %r9, %r8  				#mask for signbit
	and  %rax, %r8				#maskout signbit
	cmpq %r9, %r8				#check if signed
	jne itoa_loop				#if not signed skip
	not %rax				#invert
	addq $1, %rax				#add one to rax
	itoa_loop: # do.. while (at least one iteration)
	movq $10, %rbx
	movq $0, %rdx
	idivq %rbx # divide rdx:rax by 10
	addb $0x30, %dl # remainder + ’0’
	decq %rsi # move string pointer
	movb %dl, (%rsi)
	incq %rcx # increment string length
	cmpq $0, %rax
	jg itoa_loop # produce more digits
	itoa_done:
	cmpq %r9, %r8				#check if signed
	jne skip_sign				#if not signed skip
	decq %rsi # move string pointer		#move string pointer
	movb $0x2D, (%rsi) 			#insert - sign
	skip_sign:				#skip to if not signed	
	movq $1, %rdi
	movq %rcx, %rdx
	movq $1, %rax
	syscall
	popq %rbp
	ret
