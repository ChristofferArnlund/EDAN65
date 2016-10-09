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
	subq $0,%rsp
	movq $5, %rax
	pushq %rax
	movq $3, %rax
	movq %rax, %rbx
	popq %rax
	cmp %rbx, %rax
JLE main_0_if_else
main_0_if_then:
	movq $1, %rax
	pushq %rax
	call print
	addq $8, %rsp
	jmp main_0_if_fi
main_0_if_else:
main_0_if_fi:
	movq $0, %rax
	jmp main_return
main_return:
	addq $0,%rsp
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
