
public class Test {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01234567890");
		
		sb.reverse();
		System.out.println(sb);
		
		sb.replace(2, 5, "ehpub");
		System.out.println(sb);

	}

}
