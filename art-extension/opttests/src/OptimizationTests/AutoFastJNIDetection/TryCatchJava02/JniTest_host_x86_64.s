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
	.globl	Java_OptimizationTests_AutoFastJNIDetection_TryCatchJava02_Main_nativeTryCatchJava02
	.type	Java_OptimizationTests_AutoFastJNIDetection_TryCatchJava02_Main_nativeTryCatchJava02, @function
Java_OptimizationTests_AutoFastJNIDetection_TryCatchJava02_Main_nativeTryCatchJava02:
.LFB237:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movl	%edx, -20(%rbp)
	movl	%ecx, -24(%rbp)
	movl	%r8d, -28(%rbp)
	movl	-24(%rbp), %eax
	movl	-20(%rbp), %edx
	addl	%edx, %eax
	addl	-28(%rbp), %eax
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE237:
	.size	Java_OptimizationTests_AutoFastJNIDetection_TryCatchJava02_Main_nativeTryCatchJava02, .-Java_OptimizationTests_AutoFastJNIDetection_TryCatchJava02_Main_nativeTryCatchJava02
	.ident	"GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3"
	.section	.note.GNU-stack,"",@progbits
