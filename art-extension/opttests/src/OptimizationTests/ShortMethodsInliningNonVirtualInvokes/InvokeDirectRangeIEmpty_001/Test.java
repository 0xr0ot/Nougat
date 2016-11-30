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

package OptimizationTests.ShortMethodsInliningNonVirtualInvokes.InvokeDirectRangeIEmpty_001;
class Test {
    int thingies = 0;

    private int getThingies(char c1, char c2, char c3, char c4, char c5, char c6) {
        return thingies;
    }

    private void setThingies(int newThingies, char c1, char c2, char c3, char c4, char c5, char c6) {
// empty method
    }

    public int gimme(char c1, char c2, char c3, char c4, char c5, char c6) {
       return getThingies(c1, c2, c3, c4, c5, c6);
    }

    public void hereyouare(int newThingies, char c1, char c2, char c3, char c4, char c5, char c6) {
        setThingies(newThingies, c1, c2, c3, c4, c5, c6);
    }
}

