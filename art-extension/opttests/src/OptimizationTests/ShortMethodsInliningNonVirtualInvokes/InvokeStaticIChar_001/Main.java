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

package OptimizationTests.ShortMethodsInliningNonVirtualInvokes.InvokeStaticIChar_001;
class Main {
    final static int iterations = 10;
    
    public static void main(String[] args) {
        Test test = new Test();
        char nextThingy = 'b';

        System.out.println("Initial nextThingy unicode value is " + String.format ("\\u%04x", (int)nextThingy));
        System.out.println("Initial nextThingy byte value is " + (byte) nextThingy);

        for(int i = 0; i < iterations; i++) {
            nextThingy = (char)(Test.getThingies(test) + i);
            Test.setThingies(test, nextThingy);
        }

        System.out.println("Final nextThingy unicode value is " + String.format ("\\u%04x", (int)nextThingy));
        System.out.println("Final nextThingy byte value is " + (byte) nextThingy);

    }
}
