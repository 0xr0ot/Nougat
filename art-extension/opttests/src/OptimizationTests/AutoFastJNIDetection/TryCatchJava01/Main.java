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

package OptimizationTests.AutoFastJNIDetection.TryCatchJava01;


/* Test add */
public class Main {

    public  final int iterations = 5000;
    static
    {
        System.loadLibrary("JniTest");
    }

    public native int nativeTryCatchJava01(int a, int b, int c); 

    public int inlineNativeCall(int a, int b, int c) {
        return nativeTryCatchJava01(a, b, c);
    }

    // Test case harnesses
    public int PleaseInlineMe() {
        int sum = 1000;
        for (int i = 0; i < iterations; i++) {
            try {
            Thread.currentThread().sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                sum /= inlineNativeCall(1 - i, 2, i);
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }
        return sum;
    }




    public static void main(String[] args)
    {
        Main test = new Main();
        System.out.println("result: " + test.PleaseInlineMe());
        System.out.println("Test completed");
    }

}
