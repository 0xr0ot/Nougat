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

package OptimizationTests.ConstantCalculationSinking.TryCatchNestedLoopIntAddAfter_01;

/**
*
* Simplest case when optimization should be applied
*  1 sinking expected
*
**/

public class Main {                                                                                                                                                   
    final int iterations = 1100;

    final int testLoopAddInt() {
        int testVar = 100;
        int additionalVar = 10;

        for (int i = 0; i < iterations; i++) {
            additionalVar += i;
            for (int k = 0; k < iterations; k++) {
                additionalVar += k;
                testVar += 5;
            }
        }
        return testVar + additionalVar;
    }

    final int $noinline$testTryCatch() {
        int res = 0;
        try {
            throw new Exception("My exception"); 
        } catch (Exception e) {
        } finally {
        }
        res += testLoopAddInt();
        return res;
    }

    public static void main(String[] args) {
         System.out.println(new Main().$noinline$testTryCatch());
    }
}  

