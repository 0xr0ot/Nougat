/*
 * Copyright (C) 2016 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include "OptimizationTests_AutoFastJNIDetection_NestedCalls_Main.h"

// Test nested calls: depth 3 is OK, depth 4 should be rejected
extern "C" JNIEXPORT jint JNICALL Java_OptimizationTests_AutoFastJNIDetection_NestedCalls_Main_nativeNestedCallsDepth3 (JNIEnv *env, jobject myobject, jint a, jint b, jint c) {
    return foo1(a + b, c);

    }
extern "C" JNIEXPORT jint JNICALL Java_OptimizationTests_AutoFastJNIDetection_NestedCalls_Main_nativeNestedCallsDepth4 (JNIEnv *env, jobject myobject, jint a, jint b, jint c) {
    return foo2(c, a, b);

    }


 int foo(int a) {
    return a + 5;
}

  int foo1(int a, int b) {
    return foo(a) + foo(b);
}

 int foo2(int a, int b, int c) {
    return foo1(a + c, b*2) - foo1(a*c, b - c);
}

