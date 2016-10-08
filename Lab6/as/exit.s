.global _start
.text
_start:
	movq $13, %rdi
	movq $60, %rax
	syscall
