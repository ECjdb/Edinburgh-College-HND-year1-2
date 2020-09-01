	.file	"fibonacci.c"
	.text
	.section .rdata,"dr"
.LC0:
	.ascii "%d \0"
	.text
	.globl	printFibonacci
	.def	printFibonacci;	.scl	2;	.type	32;	.endef
	.seh_proc	printFibonacci
printFibonacci:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$32, %rsp
	.seh_stackalloc	32
	.seh_endprologue
	movl	%ecx, 16(%rbp)
	cmpl	$0, 16(%rbp)
	jle	.L3
	movl	n1.2975(%rip), %edx
	movl	n2.2976(%rip), %eax
	addl	%edx, %eax
	movl	%eax, n3.2977(%rip)
	movl	n2.2976(%rip), %eax
	movl	%eax, n1.2975(%rip)
	movl	n3.2977(%rip), %eax
	movl	%eax, n2.2976(%rip)
	movl	n3.2977(%rip), %eax
	movl	%eax, %edx
	leaq	.LC0(%rip), %rcx
	call	printf
	movl	16(%rbp), %eax
	subl	$1, %eax
	movl	%eax, %ecx
	call	printFibonacci
.L3:
	nop
	addq	$32, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
	.align 8
.LC1:
	.ascii "Enter the number of elements: \0"
.LC2:
	.ascii "%d\0"
.LC3:
	.ascii "Fibonacci Series: \0"
.LC4:
	.ascii "%d %d \0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$48, %rsp
	.seh_stackalloc	48
	.seh_endprologue
	call	__main
	leaq	.LC1(%rip), %rcx
	call	printf
	leaq	-4(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC2(%rip), %rcx
	call	scanf
	leaq	.LC3(%rip), %rcx
	call	printf
	movl	$1, %r8d
	movl	$0, %edx
	leaq	.LC4(%rip), %rcx
	call	printf
	movl	-4(%rbp), %eax
	subl	$2, %eax
	movl	%eax, %ecx
	call	printFibonacci
	movl	$0, %eax
	addq	$48, %rsp
	popq	%rbp
	ret
	.seh_endproc
.lcomm n1.2975,4,4
	.data
	.align 4
n2.2976:
	.long	1
.lcomm n3.2977,4,4
	.ident	"GCC: (GNU) 7.4.0"
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	scanf;	.scl	2;	.type	32;	.endef
