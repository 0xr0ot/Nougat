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

package OptimizationTests.ClassHierarchyAnalysis.Test_10_devirt;

public class B implements A {
    public int m1() {
        System.out.println("m1() from class B");
        return 256;
    }
    public int test1() {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += m1();
        }
        return total;
    }
}

