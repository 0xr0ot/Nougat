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

package OptimizationTests.ShortMethodsInliningNonVirtualInvokes.InvokeDirectRangeIBoolean_001;
class Test {
    boolean thingies = false;

    private boolean getThingies(int i1, int i2, int i3, int i4, int i5, int i6) {
        return thingies;
    }

    private void setThingies(boolean newThingies, int i1, int i2, int i3, int i4, int i5, int i6) {
        thingies = newThingies;
    }

    public boolean gimme(int i1, int i2, int i3, int i4, int i5, int i6) {
       return getThingies(i1, i2, i3, i4, i5, i6);
    }

    public void hereyouare(boolean newThingies, int i1, int i2, int i3, int i4, int i5, int i6) {
        setThingies(newThingies, i1, i2, i3, i4, i5, i6);
    }
}

