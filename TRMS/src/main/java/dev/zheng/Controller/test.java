package dev.zheng.Controller;

import java.util.ArrayList;
import java.util.List;

public class test {

	static List<String> test = new ArrayList<String>();
	public static void main(String[] args) {
		String t ="passow";
		test.add("sadgh");
		test.add("jhdks");
		test.add("fsdhfk");
		test.add("passow");
		test.add("pass");
		test.add("rfesn");
		int id = 1;
		for(int i =0;i<test.size();i++) {
			if(test.get(i).equals(t)) {
				id++;
			}
		}
		System.out.println(id);
		
	}
}
