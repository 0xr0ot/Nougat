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

package OptimizationTests.ValuePropagationThroughHeap.EnhForLoop_01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * Simplest case when optimization should be applied: 'enhanced for' loop
 *
 **/

public class Main {                                                                                                                                                   
    final int iterations = 1100;
    int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    MyClass c_field = new MyClass(100);

    int count = 0;
    double d = 0;
    double[] y = new double[iterations];
    double w = 1.0d;
    double v = 1.0d;

    class MyClass {
        int value = 0;
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int[] arr;
        public MyClass(int x) {
            value = x;
            value1 = x/2;
            value2 = x*3;
            value3 = x%4;
            arr = new int[x];
            for (int i = 0; i < x; i++) {
                arr[i] = i*x/2;
            }
        }

        int[] getArr() {
            return arr;
        }

        int[] modifyAndGetArr() {
            arr[0] = 100;
            return arr;
        }
    }

    /* Positive: simple test, loop is not affected by other optimization */
    public int test1(int n) {
        this.y[0] = 1.0D; this.w = 1.0D; this.v = 1.0D;
        this.d = 1;
        for (int i : arr1)
        { 
            //inlined method call to a(this.v, this.w, this.y);
            double d1= 0.499975D * (this.w + this.v);
            this.y[0]= ((d1 + 0.499975D * (d1 + this.w)) / 2.0D);
        } 
        return (int)this.y[0];
    }


/*    private void a(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
*    {
*        double d1 = 0.499975D * (paramDouble1 + paramDouble2);
*        paramArrayOfDouble[0] = ((d1 + 0.499975D * (d1 + paramDouble2)) / 2.0D);
*    }
*
*/

    /* Positive: iterator start value is unkown */
    public double test2(int n) {
        int k = n;
        double s = 0.0d;
        c_field.value = 1;
        this.y[0] = 1.0D; this.w = 1.0D; this.v = 1.0D;
        for (int i : arr1)
        {
            //inlined method call to a(this.v, this.w, this.y);

            //double d1= 0.499975D * (this.w + this.v);
            double d1= 0.499975D  + c_field.value;

           // this.y[0]= ((d1 + 0.499975D * (d1 + this.w)) / 2.0D);
           s += ((d1 + 0.499975D * (d1 + this.w)) / 2.0D);
        }
        //return this.y[0] + n + k;
        return s + n + k;
    }

    public int test3(int n) {
        this.y[0] = 1.0D; this.w = 1.0D; this.v = 2.0D;
        double s = 0d;
        this.d = 1;
        for (int i : arr1)
        { 
            //inlined method call to a(this.v, this.w, this.y);
            double d1= 0.499975D * (this.w + this.v);
            s = ((d1 + 0.499975D * (d1 + this.w)) / 2.0D);
        } 
        return (int)this.y[0] + (int)this.v + (int)this.w;
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
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Main().runTests();
    }
}  

