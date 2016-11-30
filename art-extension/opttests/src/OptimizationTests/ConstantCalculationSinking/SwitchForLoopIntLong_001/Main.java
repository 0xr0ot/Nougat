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

package OptimizationTests.ConstantCalculationSinking.SwitchForLoopIntLong_001;

/**
  *
  * L: Expected result: no sinking because of switch statement within the loop;
  * L: Optimization will not be applied because MergeBlocks will not be applied to the method containing 'switch'
  * L: Separate post-processing script for this case: no 'Constant Calculation Sinking: try to optimize' messages
  * M: switch doesn't break optimization limitations, so sinking expected for all tests
  *
  **/

public class Main {                                                                                                                                                   
    final int iterations = 100;

    public int testLoopAddInt() {
        int testVar = 10;
        int additionalVar = 0;
        int setToConstantVar = 2;
        for (int i = -10; i < iterations; i++) {
            testVar += setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public int testLoopSubInt() {
        int testVar = 10;
        int additionalVar = 0;
        int setToConstantVar = 2;
        for (int i = -10; i < iterations; i++) {
            testVar -= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public long testLoopSubLong() {
        long testVar = 10;
        int additionalVar = 0;
        long setToConstantVar = 2;
        for (long i = -10; i < iterations; i++) {
            testVar -= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public int testLoopMulInt() {
        int testVar = 1;
        int additionalVar = 0;
        int setToConstantVar = 6;
        for (int i = -8; i < 2; i++) {
            testVar *= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public long testLoopMulLong() {
        long testVar = 1;
        int additionalVar = 0;
        long setToConstantVar = 6L;
        for (long i = -10; i < 2; i++) {
            testVar *= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public int testLoopDivInt() {
        int testVar = 10;
        int additionalVar = 0;
        int setToConstantVar = 2;
        for (int i = -10; i < iterations; i++) {
            testVar /= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public long testLoopDivLong() {
        long testVar = 10;
        int additionalVar = 0;
        long setToConstantVar = 2;
        for (long i = -10; i < iterations; i++) {
            testVar /= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public int testLoopRemInt() {
        int testVar = 10;
        int additionalVar = 0;
        int setToConstantVar = 2;
        for (int i = -10; i < iterations; i++) {
            testVar %= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public long testLoopRemLong() {
        long testVar = 10;
        int additionalVar = 0;
        long setToConstantVar = 2;
        for (long i = -10; i < iterations; i++) {
            testVar %= setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public long testLoopAddLong() {
        long testVar = 10;
        int additionalVar = 0;
        long setToConstantVar = 2;
        for (long i = -10; i < iterations; i++) {
            testVar += setToConstantVar;
            additionalVar += (i*2)%5;
	        switch (additionalVar) {
		    case 0:
		        additionalVar = additionalVar + 2 ;
		        break;
		    case 10:
		        additionalVar--;
		    default:
		        additionalVar++;
		        break; 
	        }
        }
        return testVar + additionalVar;
    }

    public static void main(String[] args)
    {
         System.out.println(new Main().testLoopAddInt());
System.out.println(new Main().testLoopAddLong());
System.out.println(new Main().testLoopRemLong());
System.out.println(new Main().testLoopRemInt());
System.out.println(new Main().testLoopDivLong());
System.out.println(new Main().testLoopDivInt());
System.out.println(new Main().testLoopMulLong());
System.out.println(new Main().testLoopMulInt());
System.out.println(new Main().testLoopSubLong());
System.out.println(new Main().testLoopSubInt());
    }

}  

