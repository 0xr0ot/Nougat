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

package OptimizationTests.ShortLeafMethodsInlining.InvokeVirtual_or_int_tc_007;
class Test {

    public int simple_method(int jj, int kk) throws Exception {
        if (kk % 2 == 0)
            throw new Exception("Test");
        jj = kk | jj;
        return jj;
    }

    public int simple_1method(int jj, int kk) {
        jj = kk | jj;
        return jj;
    }

    public int simple_2method(int jj, int kk) throws Exception {
        throw new Exception("Test");
    }

}
