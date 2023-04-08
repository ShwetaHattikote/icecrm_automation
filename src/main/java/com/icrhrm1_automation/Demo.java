package com.icrhrm1_automation;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths math = new Maths(){          //this is anonymous class creating with referance to interface	
			public int add(int a, int b) {     //so it provides body to abstract methods without any implements word
				int resultadd=a+b;            // Here we are creating instance of Interface to identify anonymous class.
				// TODO Auto-generated method stub
				return resultadd;
			}
			public int substract(int a, int b) {
				int resultsub=a-b;
				// TODO Auto-generated method stub
				return resultsub;
			}
			public int multiplication(int c, int d) {
				int resultmult=c*d;
				// TODO Auto-generated method stub
				return resultmult;
			}
			public int division(int d, int e) {
				int resultdiv = d/e;
				// TODO Auto-generated method stub
				return resultdiv;
			}
			};
			int result1=math.add(10,20);
			int result2 = math.division(20, 5);
			int result3= math.substract(30, 10);
			int result4 = math.multiplication(6,6);
			System.out.println(result1);	
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			
			
			
			
			

}
	}
