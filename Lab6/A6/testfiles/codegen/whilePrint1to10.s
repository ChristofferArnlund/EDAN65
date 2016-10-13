.global _start
.data
	ask_message: .ascii "Plz enter a number: "
	ask_msg_len: .quad 20
	buf: .skip 1024
.text
_start:
	call main
	movq %rax, %rdi
	movq $60, %rax
	syscall

main:
	pushq %rbp
	movq %rsp, %rbp
	subq $8,%rsp
	movq $1, %rax
	movq %rax, -8(%rbp)
main_1_while_start:
	movq -8(%rbp), %rax
	pushq %rax
	movq $10, %rax
	movq %rax, %rbx
	popq %rax
	cmp %rbx, %rax
JG main_1_while_end
	movq -8(%rbp), %rax
	pushq %rax
	call print
	addq $8, %rsp
	movq -8(%rbp), %rax
	pushq %rax
	movq $1, %rax
	movq %rax, %rbx
	popq %rax
	addq %rbx, %rax
	movq %rax, -8(%rbp)
	jmp main_1_while_start
main_1_while_end:
	movq $0, %rax
	jmp main_return
main_return:
	addq $8,%rsp
	popq %rbp
	ret
read:
	pushq %rbp
	movq %rsp, %rbp
	movq $1, %rdi		#stdout
	movq $ask_message, %rsi #msg
	movq $20, %rdx #msglen
	movq $1, %rax		#syswrite
	syscall
	movq $0, %rdi
	movq $buf, %rsi
	movq $1024, %rdx
	movq $0, %rax
	syscall
	movq $0, %rdx
read_atoi_loop:
	cmpq $0, %rax
	jle read_atoi_done
	movzbq (%rsi), %rbx
	cmpq $0x30, %rbx
	jl read_atoi_done
	cmpq $0x39, %rbx
	jg read_atoi_done
	imulq $10, %rdx
	subq $0x30, %rbx
	addq %rbx, %rdx
	incq %rsi
	decq %rax
	jmp read_atoi_loop
read_atoi_done:
	movq %rdx, %rax
	popq %rbp
	ret

print:
	pushq %rbp
	movq %rsp, %rbp
	### convert integer to string
	movq 16(%rbp), %rax # parameter
	movq $(buf+1023), %rsi # write ptr (start from end of buf)
	movb $0x0a, (%rsi) # insert newline
	movq $1, %rcx # string length
	movq $0x8000000000000000, %r9		#mask
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
	incq %rcx # increment string length
skip_sign:				#skip to if not signed
	movq $1, %rdi
	movq %rcx, %rdx
	movq $1, %rax
	syscall
	popq %rbp
	ret
