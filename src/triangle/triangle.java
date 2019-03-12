package triangle;

import java.util.ArrayList;
import java.util.List;

public class triangle {
	//private int wanted;
	//public triangle (int a) {
	//	wanted = a;
	//}
	
	public void listCreate(List strList) {
		
		strList.add(50);
		strList.add(20);
		strList.add(5);
		strList.add(5);
		strList.add(1);
		strList.add(1);
		strList.add(1);
	}
	public boolean judgement(int wanted) {
			boolean a = true;
			if(wanted > 83)
				a = false;
			if(wanted >= 50) {
				wanted -= 50;
			}
			if(wanted >= 20) {
				wanted -= 20;
			}
			if(wanted >= 10) {
				wanted -= 10;
				if(wanted > 3) 
					a = false;
				else a = true;
			}
			else if (wanted >= 5) {
				wanted -= 5;
				if(wanted > 3)
					a = false;
				else a = true;
			}
			if (wanted > 3){
				a = false;
			}else a = true;
			return a;
	}
	public boolean judgement2(int wanted) {
		
		boolean ju = true;
		if(wanted < 0) {
			ju = false;
		}
		List<Integer> strList = new ArrayList<Integer>();
		listCreate(strList);
		int b = 0;
		while(wanted > 0) {
			b = findTheMax(wanted,strList);
			if(b > 0) {
				wanted -= b;
				
			}
			else break;
		}
		if(wanted > 0 && b == 0) {
			ju = false;
		}
		return ju;
	}
	public int findTheMax(int a,List list) {
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			if(a>= (Integer)list.get(i)) {
				int b = (Integer)list.get(i);
				list.remove(i);
				return b;
			}
		}
		return 0;
	}
}
