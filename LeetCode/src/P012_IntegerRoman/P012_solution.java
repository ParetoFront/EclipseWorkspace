package P012_IntegerRoman;
//Given an integer, convert it to a roman numeral.
//Input is guaranteed to be within the range from 1 to 3999.

//1 I 2 II 3 III 4 IV 5 V 6 VI 7 VII 8 VIII 9 IX
//10 X 11 XI ...19 XIX
//20 XX 21 XXI ...
//30 XXX 31 XXXI ...
//40 XL 41 XLI ...
//50 L ...
//60 LX ...
//90 XC ...
//100 C ...
//500 D
//1000 M

public class P012_solution {
	public static void main(String[] args) {
		P012_solution ss=new P012_solution();
		System.out.println(ss.intToRoman(3009));
	}
	private String intToRoman(int num) {
		if(num==0||num>3999) {
			return "wrong argument";
		}
		String[] M= {"","M","MM","MMM"};
		String[] C= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[(num%10)];
	}
}
