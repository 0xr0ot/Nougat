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
	.hidden	count
	.global	count
	.data
	.align	2
	.type	count, %object
	.size	count, 4
count:
	.word	5
	.global	__sync_fetch_and_add_4
	.text
	.align	2
	.global	Java_OptimizationTests_AutoFastJNIDetection_LockPrefix_Main_nativeLockPrefix
	.type	Java_OptimizationTests_AutoFastJNIDetection_LockPrefix_Main_nativeLockPrefix, %function
Java_OptimizationTests_AutoFastJNIDetection_LockPrefix_Main_nativeLockPrefix:
	.fnstart
.LFB234:
	@ args = 0, pretend = 0, frame = 16
	@ frame_needed = 1, uses_anonymous_args = 0
	stmfd	sp!, {r4, r5, fp, lr}
	add	fp, sp, #12
	sub	sp, sp, #16
	str	r0, [fp, #-16]
	str	r1, [fp, #-20]
	strd	r2, [fp, #-28]
	ldr	r3, .L3
.LPIC0:
	add	r3, pc, r3
	ldr	r3, [r3]
	mov	r0, r3
	mov	r1, r0, asr #31
	ldrd	r2, [fp, #-28]
	adds	r4, r0, r2
	adc	r5, r1, r3
	ldr	r3, .L3+4
.LPIC1:
	add	r3, pc, r3
	mov	r0, r3
	mov	r1, #1
	bl	__sync_fetch_and_add_4(PLT)
	mov	r3, r0
	mov	r2, r3
	mov	r3, r2, asr #31
	adds	r2, r2, r4
	adc	r3, r3, r5
	mov	r0, r2
	mov	r1, r3
	sub	sp, fp, #12
	@ sp needed
	ldmfd	sp!, {r4, r5, fp, pc}
.L4:
	.align	2
.L3:
	.word	count-(.LPIC0+8)
	.word	count-(.LPIC1+8)
	.cantunwind
	.fnend
	.size	Java_OptimizationTests_AutoFastJNIDetection_LockPrefix_Main_nativeLockPrefix, .-Java_OptimizationTests_AutoFastJNIDetection_LockPrefix_Main_nativeLockPrefix
	.ident	"GCC: (GNU) 4.8"
	.section	.note.GNU-stack,"",%progbits
