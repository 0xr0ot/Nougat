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

package OptimizationTests.ShortMethodsInliningNonVirtualInvokes.InvokeSuperRangeAThrowBoundGet_001_tryCatch2;
// The test checks that stack after ArrayIndexOutOfBoundsException occurs is correct despite inlining
class Test extends SuperTest {

    Test(int iterations) {
        super(iterations);
    }

    public int getThingies(int[] arr, int i, char c1, char c2, char c3, char c4, char c5, char c6) {
        return super.getThingies(arr, i, c1, c2, c3, c4, c5, c6);
    }

    public void setThingies(int[] arr, int newThingy, int i, char c1, char c2, char c3, char c4, char c5, char c6) {
        super.setThingies(arr, newThingy, i, c1, c2, c3, c4, c5, c6);
    }
}

