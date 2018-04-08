package P006_ZigZagConversion;

public class P006_solution {
    public static void main(String[] args) {
        String newstr= new P006_solution().convert("PAYPALISHIRING",3);
        System.out.println(newstr);
    }

    private String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) {
            sb[i]=new StringBuffer();
        }
        int i=0;
        while(i<len){
            for(int idown=0;idown<nRows&&i<len;idown++){
                sb[idown].append(c[i++]);
            }
            for(int iup=nRows-2;iup>=1&&i<len;iup--){
                sb[iup].append(c[i++]);
            }
        }
        for(int isb=1;isb<nRows;isb++){
            sb[0].append(sb[isb]);
        }
        return sb[0].toString();

    }
}
