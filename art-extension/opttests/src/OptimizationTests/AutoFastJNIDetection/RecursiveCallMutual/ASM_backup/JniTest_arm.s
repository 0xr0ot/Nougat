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

	.arch armv5te
	.fpu softvfp
	.eabi_attribute 20, 1
	.eabi_attribute 21, 1
	.eabi_attribute 23, 3
	.eabi_attribute 24, 1
	.eabi_attribute 25, 1
	.eabi_attribute 26, 2
	.eabi_attribute 30, 6
	.eabi_attribute 34, 0
	.eabi_attribute 18, 4
	.file	"JniTest.cpp"
	.text
	.align	2
	.global	_Z3fooii
	.hidden	_Z3fooii
	.type	_Z3fooii, %function
_Z3fooii:
	.fnstart
.LFB234:
	@ args = 0, pretend = 0, frame = 8
	@ frame_needed = 1, uses_anonymous_args = 0
	stmfd	sp!, {fp, lr}
	.save {fp, lr}
	.setfp fp, sp, #4
	add	fp, sp, #4
	.pad #8
	sub	sp, sp, #8
	str	r0, [fp, #-8]
	str	r1, [fp, #-12]
	ldr	r3, [fp, #-8]
	cmp	r3, #0
	ble	.L2
	ldr	r3, [fp, #-8]
	sub	r2, r3, #100
	ldr	r3, [fp, #-12]
	add	r3, r3, #5
	mov	r0, r2
	mov	r1, r3
	bl	_Z3barii(PLT)
	mov	r3, r0
	b	.L3
.L2:
	ldr	r3, [fp, #-12]
.L3:
	mov	r0, r3
	sub	sp, fp, #4
	@ sp needed
	ldmfd	sp!, {fp, pc}
	.fnend
	.size	_Z3fooii, .-_Z3fooii
	.align	2
	.global	_Z3barii
	.hidden	_Z3barii
	.type	_Z3barii, %function
_Z3barii:
	.fnstart
.LFB235:
	@ args = 0, pretend = 0, frame = 8
	@ frame_needed = 1, uses_anonymous_args = 0
	stmfd	sp!, {fp, lr}
	.save {fp, lr}
	.setfp fp, sp, #4
	add	fp, sp, #4
	.pad #8
	sub	sp, sp, #8
	str	r0, [fp, #-8]
	str	r1, [fp, #-12]
	ldr	r3, [fp, #-8]
	cmp	r3, #1
	ble	.L5
	ldr	r3, [fp, #-8]
	sub	r2, r3, #200
	ldr	r3, [fp, #-12]
	sub	r3, r3, #2
	mov	r0, r2
	mov	r1, r3
	bl	_Z3fooii(PLT)
	mov	r3, r0
	b	.L6
.L5:
	ldr	r3, [fp, #-12]
	sub	r3, r3, #1
.L6:
	mov	r0, r3
	sub	sp, fp, #4
	@ sp needed
	ldmfd	sp!, {fp, pc}
	.fnend
	.size	_Z3barii, .-_Z3barii
	.align	2
	.global	Java_OptimizationTests_AutoFastJNIDetection_RecursiveCallMutual_Main_nativeRecursiveCallMutual
	.type	Java_OptimizationTests_AutoFastJNIDetection_RecursiveCallMutual_Main_nativeRecursiveCallMutual, %function
Java_OptimizationTests_AutoFastJNIDetection_RecursiveCallMutual_Main_nativeRecursiveCallMutual:
	.fnstart
.LFB236:
	@ args = 4, pretend = 0, frame = 16
	@ frame_needed = 1, uses_anonymous_args = 0
	stmfd	sp!, {fp, lr}
	.save {fp, lr}
	.setfp fp, sp, #4
	add	fp, sp, #4
	.pad #16
	sub	sp, sp, #16
	str	r0, [fp, #-8]
	str	r1, [fp, #-12]
	str	r2, [fp, #-16]
	str	r3, [fp, #-20]
	ldr	r2, [fp, #-16]
	ldr	r3, [fp, #-20]
	add	r3, r2, r3
	ldr	r0, [fp, #4]
	mov	r1, r3
	bl	_Z3fooii(PLT)
	mov	r3, r0
	mov	r0, r3
	sub	sp, fp, #4
	@ sp needed
	ldmfd	sp!, {fp, pc}
	.fnend
	.size	Java_OptimizationTests_AutoFastJNIDetection_RecursiveCallMutual_Main_nativeRecursiveCallMutual, .-Java_OptimizationTests_AutoFastJNIDetection_RecursiveCallMutual_Main_nativeRecursiveCallMutual
	.ident	"GCC: (GNU) 4.8"
	.section	.note.GNU-stack,"",%progbits
