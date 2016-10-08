.global _start
.data
message: .ascii "Hello edan65!\n"
.text
_start: pushq $14
	pushq $message
	call print_string
	addq $16, %rsp
	movq $0, %rdi
	movq $60, %rax
	syscall

print_string:
pushq %rbp
movq %rsp, %rbp
movq $1, %rdi
movq 16(%rbp), %rsi
movq 24(%rbp), %rdx
movq $1, %rax
syscall
popq %rbp
ret 
