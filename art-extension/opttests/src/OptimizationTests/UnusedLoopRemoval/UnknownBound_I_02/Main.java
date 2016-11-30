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

package OptimizationTests.UnusedLoopRemoval.UnknownBound_I_02;

public class Main {

    // Test a loop that does not have a known number of iterations


    public int loop(int n) {
        int res = 0;
        for (int i = 0; i < n*1000; i++) {
            ;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Main().loop(10);
        System.out.println(res);
    }
}