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

package OptimizationTests.ShortLeafMethodsInlining.InvokeStatic_mul_long_tc_008;
class Main {
    final static int iterations = 10;

    public static long simple_method(long jj, long ii) throws Exception {
        throw new Exception("Test");
    }

    public static long simple_1method(long jj, long ii) {
        jj = ii * jj;
        return jj;
    }

    public static long simple_2method(long jj, long ii) throws Exception {
        try {
            return simple_method(jj, ii);
        } catch (Exception e) {
            return simple_method(jj, ii);
        } finally {
            return simple_method(jj, ii);
        }
    }

    public static void main(String[] args) {
        long workJ = 2;
        long workK = 3;

        System.out.println("Initial workJ value is " + workJ);

        try {
            workJ = simple_2method(workJ, workK);
        } catch (Exception e) {
            workJ++;
        }

        workJ--;

        for(long i = 0; i < iterations; i++) {
            try {
                workJ = simple_method(workJ, workK) + i;
            } catch (Exception e) {
                workJ = simple_1method(workJ, workK) + i;
            }
        }

        System.out.println("Final workJ value is " + workJ);
    }
}