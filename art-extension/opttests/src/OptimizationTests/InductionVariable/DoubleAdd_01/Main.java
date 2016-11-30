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

package OptimizationTests.InductionVariable.DoubleAdd_01;

/**
 * Simple BIV test: add-double/2addr.
 */
public class Main {
    
    static double threshold = 10;

	/**
	 * Simple test add-double/2addr 
	 */
	public void $noinline$test() {
		double i = 0;
		while ( i < threshold ) {
			i = i + 2.234;
		}
        System.out.println(i);
    }

	public static void main(String[] args) {
        if (args.length != 0) {
            threshold = new Double(args[0]).doubleValue();
        }
        new Main().$noinline$test();
    }
}