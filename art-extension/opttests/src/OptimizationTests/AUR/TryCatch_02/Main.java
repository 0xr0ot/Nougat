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

package OptimizationTests.AUR.TryCatch_02;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.io.*;
import OptimizationTests.AUR.shared.*;

public class Main {

    public int field = 5;
    
    private int getSum(int arg) {
        return arg + 20;
    }



    // simple AUR example for try-catch block with DivZeroCheck in try section and in catch section: 
    // environment of DivZeroCheck is not removed from try block but is removed from catch block;
    // Div, Mul, Rem, Loadexception instructions inside catch block are also removed because they have no more users after environments removal
    public int runTest (int n, Main m, Main other, Main unused) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        try {

           // n - 10 == 0 : EXCEPTION!
           sum1 += unused.field % 3;
           other.field += 100;
           sum2 = 100/(n - 10);
           m.field -= 10000;

        } catch (ArithmeticException ae) {
            sum3 += unused.field % 3;
            other.field += 1;
            sum4 = n*100/(n - 11);
            m.field -= 1000;
        }
        return other.field;

    }

    // wrapper method for runTest
    public int test(int n) {
        Main m = new Main();
        Main other = new Main();
        Main unused = new Main();
        return runTest(n, m, other, unused);
    }

    // wrapper method for runTest with GC stress threads running
    public String testWithGCStress(int n) {
        String res = "";
        Thread t = new Thread(new Runnable(){
                public void run() {
                new StressGC().stressGC();
                }
                });

        t.start();
        try {
            res += test(n);
        } catch (Throwable e) {
            res += e;
        }
        try {
            t.join();
        } catch (InterruptedException ie) {
        }
        return res;
    }

    public void runTests() {
        Class c = new Main().getClass();
        Method[] methods = c.getDeclaredMethods();
        Method tempMethod;
        for (int i = 1; i < methods.length; i++) {
            int j = i;
            while (j > 0 &&  methods[j-1].getName().compareTo(methods[j].getName()) > 0) {
                tempMethod = methods[j];
                methods[j] = methods[j-1];
                methods[j-1] = tempMethod;
                j = j - 1;
            }
        }

        Object[] arr = {null};
        for (Method m: methods){
            if (m.getName().startsWith("test")){
                try {
                    String names[] = c.getPackage().getName().split("\\.");
                    String testName = names[names.length-1];
                    System.out.println("Test "+testName+"; Subtest "+m.getName()+"; Result: "+ m.invoke(this, 10));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    StringWriter sw = new StringWriter();
                    StackTraceElement[] ste = e.getCause().getStackTrace();
                    System.out.println(e.getCause());
                    for (int i = 0; i < ((ste.length < 2)?ste.length:2); i++) {
                        System.out.println(ste[i]);
                    }

                }
            }
        }



    }

    public static void main(String[] args)
    {
        new Main().runTests();
    }

}


