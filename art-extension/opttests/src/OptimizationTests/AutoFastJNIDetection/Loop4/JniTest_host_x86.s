#
# Copyright (C) 2016 Intel Corporation
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

	.file	"JniTest.cpp"
	.text
	.globl	Java_OptimizationTests_AutoFastJNIDetection_Loop4_Main_nativeLoop4
	.type	Java_OptimizationTests_AutoFastJNIDetection_Loop4_Main_nativeLoop4, @function
Java_OptimizationTests_AutoFastJNIDetection_Loop4_Main_nativeLoop4:
.LFB238:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	cmpl	$11, 20(%ebp)
	jne	.L2
.L5:
	cmpl	$-8, 16(%ebp)
	je	.L6
.L3:
	subl	$1, 16(%ebp)
	cmpl	$-8, 16(%ebp)
	je	.L7
.L4:
	cmpl	$-9, 16(%ebp)
	setge	%al
	testb	%al, %al
	jne	.L5
	jmp	.L2
.L6:
	nop
	jmp	.L2
.L7:
	nop
.L2:
	movl	24(%ebp), %eax
	movl	20(%ebp), %edx
	movl	%edx, %ecx
	subl	%eax, %ecx
	movl	%ecx, %eax
	addl	%eax, 16(%ebp)
	movl	20(%ebp), %eax
	imull	16(%ebp), %eax
	movl	24(%ebp), %edx
	movl	%edx, %ecx
	subl	%eax, %ecx
	movl	%ecx, %eax
	popl	%ebp
	.cfi_def_cfa 4, 4
	.cfi_restore 5
	ret
	.cfi_endproc
.LFE238:
	.size	Java_OptimizationTests_AutoFastJNIDetection_Loop4_Main_nativeLoop4, .-Java_OptimizationTests_AutoFastJNIDetection_Loop4_Main_nativeLoop4
	.ident	"GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3"
	.section	.note.GNU-stack,"",@progbits
