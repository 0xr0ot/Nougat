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

package OptimizationTests.ShortMethodsInliningNonVirtualInvokes.InvokeStaticRangeIWide_001;
class Test {
    double thingies = 0.0;

    static double getThingies(Test t, double d1, double d2, double d3, double d4, double d5, double d6) {
        return t.thingies;
    }

    static void setThingies(Test t, double j, double d1, double d2, double d3, double d4, double d5, double d6) {
        t.thingies = j;
    }
}

