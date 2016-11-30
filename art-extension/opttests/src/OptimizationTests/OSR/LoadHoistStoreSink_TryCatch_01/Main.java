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

package OptimizationTests.OSR.LoadHoistStoreSink_TryCatch_01;

public class Main
{
    public class A 
    {
        public int value = 1000;
    }
    public int field = 0;


    public void inlineMe(A x) {
        int j = 0;
        // set/get pair will be hoisted/sunk out of the loop
        do  {     
            x.value++;
//            x.value /= 2;
        } while ( j++ < 30*1000);


    }

    // After inlining we will have outer loop handled by OSR and inner loop will have LHSS applied 
    // According to QA doc: * OSR injections will not be done to Try block. - but in this case OSR is applied w/o silver optimizations to outer loop only
    public int testLoop()
    {
        A x;
        x = new A();
        int a0 = 0x70000007;
        int j = 0;


        try {
            do  {
                inlineMe(x);
            } while (j++ < 30*10*1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        return x.value;
    }


    public static void main(String[] args)
    {
        System.out.println(new Main().testLoop());        
    }    
}
