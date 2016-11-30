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

package OptimizationTests.LoadHoistStoreSink.ChangedArrayPointer;

public class Main
{
    public class A 
    {
        public int []value = new int[3];
    }

    public class A_1 extends A
    {
       public int []value = new int[3];
    }

    public int testLoop()
    {
        A x;
        x = new A();
        A_1 y;
        y = new A_1();

        int a0[] = {0x7, 0x77, 0x707};
        int b = 0x7007;	

        for (int i = 0; i < 10; i++)
        {
            b ++;
            if (i%2 == 0)
            {
                x = y; 
            }
            x.value = a0;
        }
        return x.value[0] + y.value[0];
	}

    public void test()
    {
        System.out.println(testLoop());
    }

    public static void main(String[] args)
    {
        new Main().test();        
    }    
}
