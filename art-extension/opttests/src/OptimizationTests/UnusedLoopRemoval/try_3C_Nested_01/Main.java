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

package OptimizationTests.UnusedLoopRemoval.try_3C_Nested_01;

public class Main {

    // Test not a simple loop: nested
    // M: inner loops are now supported

    public int loop() {
        int sum = 0;
        try { throw new Exception();}
        catch (Exception e)
        {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                sum += 5;
            }
        }
        sum++;
        }
        finally { sum-=2; }

        return sum;
    }

    public static void main(String[] args) {
        int res = new Main().loop();
        System.out.println(res);
    }
}
