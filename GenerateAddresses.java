import java.util.Scanner;

public class GenerateAddresses {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ip = s.next();
		s.close();
		getAddresses(ip);
	}
	
	public static void getAddresses(String ip) {
		for (int i=1; i<=3; i++) {
			if (ip.length() - i >= 3 && ip.length() - i <= 9) { //check first dot placement
				for (int j=i+1; j<=i+3; j++) {
					if (ip.length() - j >= 2 && ip.length() - j <= 6) { //check second dot placement
						for (int k=j+1; k<=j+3; k++) {
							if (ip.length() - k >= 1 && ip.length() - k <= 3) { //check third dot placement
								String part1 = ip.substring(0, i);
								String part2 = ip.substring(i, j);
								String part3 = ip.substring(j, k);
								String part4 = ip.substring(k);
								if (validNum(part1, part2, part3, part4)) {
									System.out.println(part1 + "." + part2 + "." + part3 + "." + part4);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean validNum(String part1, String part2, String part3, String part4){
		String[] checkThese = {part1, part2, part3, part4};
		for (int i = 0; i < checkThese.length; i++) {
			if (checkThese[i].length()>0){
				  if (checkThese[i].charAt(0) == '0'){ //no starting 0
					  return false;
				  }
				  if (Integer.parseInt(checkThese[i]) > 255){ //too big
					  return false;
				  }
			  }
		}
		  return true;
	  }

}
