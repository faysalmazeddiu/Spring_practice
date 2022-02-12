package compairable;

import java.util.Arrays;

public class InterfacePractice {
	People[] peoples= {
			
			new People("Mazed",27),
			new People("Anwar",30),
			new People("Mahabub",34)
	};
	Integer[] integers = {1,2,3,4,5};
	
    
	
}

class People implements Comparable<People>{
	String nameString;
	int age;
	People(){
		
	}
	People(String name,int id){
		this.nameString=name;
		this.age=id;
	}
	@Override
	public int compareTo(People o) {
//		if(nameString.compareTo(o.nameString)) {
//			
//		}
		return 1;
	}
	
}
