
public class CorporationSalary {

	long[] salarys;
	public long totalSalary(String[] relations) {
		salarys = new long[relations.length];
		
		long total = 0;
		
		for (int i = 0; i < salarys.length; i++) {
			total += getSalary(relations, i);
		}
		
		return total;
	}
	
	public long getSalary(String[] relations, int i) {
		
		if (salarys[i] == 0) {
			for (int j = 0; j < salarys.length; j++) {
				if (relations[i].charAt(j) == 'Y') {
					salarys[i] += getSalary(relations, j);
				}
			}
			
			if (salarys[i] == 0) salarys[i] = 1;
		}
		return salarys[i];
	}
}
