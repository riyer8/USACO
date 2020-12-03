import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class measurement {
	public static class cow implements Comparable<cow>{
		int day;
		String name;
		int milk;
		
		public cow(String a) {
			String[] arr = a.split(" ");
			day = Integer.parseInt(arr[0]);
			name = arr[1];
			milk = Integer.parseInt(arr[2]);
		}
		public int compareTo(cow c) {
			return day-c.day;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("measurement.in"));
		PrintWriter pw = new PrintWriter(new File("measurement.out"));
		int times = sc.nextInt();
		sc.nextLine();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("Mildred", 7);
		map.put("Bessie", 7);
		map.put("Elsie", 7);
		ArrayList<cow> input = new ArrayList<cow>();
		for (int i = 0; i<times; i++) {
			String s = sc.nextLine().trim();
			input.add(new cow(s));
		}
		Collections.sort(input);
		System.out.println(input);
		
		String lead = "Bessie Elsie Mildred";
		int count = 0;
		
		for (int i = 0; i<times; i++) {
			int w1 = input.get(i).day;
			int w = input.get(i).milk;
			map.put(input.get(i).name, map.get(input.get(i).name) + w);
			/*
			for (int j = i+1;j<times; j++) {
				String[] arr1 = input.get(j).split(" ");
				int w3 = Integer.parseInt(arr1[0]);
				int w4 = Integer.parseInt(arr1[2]);
				if (!(w3==w1)) break;
				map.put(arr1[1], map.get(arr1[1])+w4);
				i++;
			}
		*/
			System.out.println(map);
			String e = lead;
			int max = Integer.MIN_VALUE;
			for (String s: map.keySet()) {
				if (map.get(s)>max) {
					max = map.get(s);
					lead = s;
				}
				else if (map.get(s) == max) {
					lead = lead + " "+ s;
				}
			}
			System.out.println(e + " " +lead);
			if (!(e.equals(lead))) count++;
		}
		
		System.out.println(count);
		pw.println(count);
		
		pw.close();
	}
	
}