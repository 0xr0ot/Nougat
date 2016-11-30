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

package OptimizationTests.UnusedLoopRemoval.try_2T_Inlining_I_01;
//disabled
public class Main {

    // Test a loop with expected inlining

    public static int getValue() {
        return 5;
    }

    public static int loop() {
        int res = 0;
        try {        for (int i = 0; i < 10000; i++) {
            res += getValue() * 2;
        }
 throw new Exception();}
        catch (Exception e){ res++; }
        finally { res-=2; }

        return res;
    }

    public static void main(String[] args) {
        int res = new Main().loop();
        System.out.println(res);
    }
}
