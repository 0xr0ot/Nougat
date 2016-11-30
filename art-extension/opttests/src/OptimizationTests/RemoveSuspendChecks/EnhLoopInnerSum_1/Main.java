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

package OptimizationTests.RemoveSuspendChecks.EnhLoopInnerSum_1;

public class Main {
    public static int testLoop() {
        int sum = 0;
        int[] arr1 = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[] arr2 = {90, 80, 70, 60, 50, 40, 30, 20, 10, 0};

        for (int i : arr1) {
            for (int j : arr2) {
                sum +=  i + j;
            }
        }
        return sum;
    }

    public void test() {
        System.out.println(testLoop());
    }

    public static void main(String[] args) {
        new Main().test();
    }
}


