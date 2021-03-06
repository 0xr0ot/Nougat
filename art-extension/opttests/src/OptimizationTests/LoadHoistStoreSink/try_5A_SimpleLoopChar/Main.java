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

package OptimizationTests.LoadHoistStoreSink.try_5A_SimpleLoopChar;

public class Main
{
    public class A 
    {
        public char value;
    }

    public char testLoop()
    {
        A x;
        x = new A();
        char a0 = 'a';
        try { throw new Exception();}
        catch (Exception e){ x.value++; }
        finally { x.value-=1; }

        for (int i = 0; i < 60; i++)
        {
            a0 ++;
            x.value = a0;
        }



        return x.value;
    }

    public void test()
    {
        System.out.println(String.format ("\\u%04x", (int)testLoop()));
//        System.out.println(testLoop());
    }
    
    public static void main(String[] args)
    {
		new Main().test();        
    }    
}
