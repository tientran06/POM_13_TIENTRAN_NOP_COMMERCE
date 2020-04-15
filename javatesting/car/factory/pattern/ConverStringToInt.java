package car.factory.pattern;

public class ConverStringToInt {
	public static void main(String args[]) {
        String s = "100";
        int i = Integer.parseInt(s);
        // 10050 vì + là thao tác nối string
        System.out.println(s + 50);
        // 150 vì + là thao tác cộng số nguyên
        System.out.println(i + 50);
    }

}
