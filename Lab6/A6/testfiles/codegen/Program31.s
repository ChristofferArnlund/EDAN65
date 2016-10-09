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

gcd1:
	pushq %rbp
	movq %rsp, %rbp
	subq $0,%rsp
gcd1_0_while_start:
	movq 16(%rbp), %rax
	pushq %rax
	movq 24(%rbp), %rax
	movq %rax, %rbx
	popq %rax
	cmp %rbx, %rax
JE gcd1_0_while_end
	movq 16(%rbp), %rax
	pushq %rax
	movq 24(%rbp), %rax
	movq %rax, %rbx
	popq %rax
	cmp %rbx, %rax
JLE gcd1_0_0_if_else
gcd1_0_0_if_then:
	movq 16(%rbp), %rax
	pushq %rax
	movq 24(%rbp), %rax
	movq %rax, %rbx
	popq %rax
	subq %rbx, %rax
	movq %rax, 16(%rbp)
	jmp gcd1_0_0_if_fi
gcd1_0_0_if_else:
	movq 24(%rbp), %rax
	pushq %rax
	movq 16(%rbp), %rax
	movq %rax, %rbx
	popq %rax
	subq %rbx, %rax
	movq %rax, 24(%rbp)
gcd1_0_0_if_fi:
	jmp gcd1_0_while_start
gcd1_0_while_end:
	movq 16(%rbp), %rax
	jmp gcd1_return
gcd1_return:
	addq $0,%rsp
	popq %rbp
	ret
gcd2:
	pushq %rbp
	movq %rsp, %rbp
	subq $0,%rsp
	movq 24(%rbp), %rax
	pushq %rax
	movq $0, %rax
	movq %rax, %rbx
	popq %rax
	cmp %rbx, %rax
JNE gcd2_0_if_else
gcd2_0_if_then:
	movq 16(%rbp), %rax
	jmp gcd2_return
	jmp gcd2_0_if_fi
gcd2_0_if_else:
gcd2_0_if_fi:
	movq 16(%rbp), %rax
	pushq %rax
	movq 24(%rbp), %rax
	movq %rax, %rbx
	popq %rax
	movq $0, %rdx
	idiv %rbx
	movq %rdx, %rax
	pushq %rax
	movq 24(%rbp), %rax
	pushq %rax
	call gcd2
	addq $16, %rsp
	jmp gcd2_return
gcd2_return:
	addq $0,%rsp
	popq %rbp
	ret
main:
	pushq %rbp
	movq %rsp, %rbp
	subq $24,%rsp
	movq $0, -8(%rbp)
	movq %rax, -8(%rbp)
	movq $0, -16(%rbp)
	movq %rax, -16(%rbp)
	movq $1814274, %rax
	movq %rax, -8(%rbp)
	movq $259896, %rax
	movq %rax, -16(%rbp)
	movq -16(%rbp), %rax
	pushq %rax
	movq -8(%rbp), %rax
	pushq %rax
	call gcd1
	addq $16, %rsp
	pushq %rax
	call print
	addq $8, %rsp
	movq -16(%rbp), %rax
	pushq %rax
	movq -8(%rbp), %rax
	pushq %rax
	call gcd2
	addq $16, %rsp
	pushq %rax
	call print
	addq $8, %rsp
	movq -16(%rbp), %rax
	pushq %rax
	movq -8(%rbp), %rax
	pushq %rax
	call gcd1
	addq $16, %rsp
	pushq %rax
	movq -16(%rbp), %rax
	pushq %rax
	movq -8(%rbp), %rax
	pushq %rax
	call gcd2
	addq $16, %rsp
	movq %rax, %rbx
	popq %rax
	subq %rbx, %rax
	movq %rax, -24(%rbp)
	movq -24(%rbp), %rax
	pushq %rax
	call print
	addq $8, %rsp
	movq $0, %rax
	jmp main_return
main_return:
	addq $24,%rsp
	popq %rbp
	ret
read:
	pushq %rbp
	movq %rsp, %rbp
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
	movq 16(%rbp), %rax
	movq $(buf+1023), %rsi
	movb $0x0a, (%rsi)
	movq $1, %rcx
print_itoa_loop:
	movq $10, %rbx
	movq $0, %rdx
	idivq %rbx
	addb $0x30, %dl
	decq %rsi
	movb %dl, (%rsi)
	incq %rcx
	cmpq $0, %rax
	jg print_itoa_loop
print_itoa_done:
	movq $1, %rdi
	movq %rcx, %rdx
	movq $1, %rax
	syscall
	popq %rbp
	ret
