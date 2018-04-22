package axisimski.binaryconverter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ToHex {


    public String splitString (String num, int index){

        String[] parts = num.split("[.]");
        num = parts[index];

        return num;
    }

    //============================================================================
    public String convertParts(String num ){

        String whole=splitString(num,0);
        String fraction=splitString(num,1);

        Integer p1=Integer.parseInt(whole);
        Integer p2=Integer.parseInt(fraction);

        whole=Integer.toHexString(p1);
        fraction=Integer.toHexString(p2);

        String hexString="\nHex: "+whole+fraction;


        return hexString;
    }

    //=================================================================
    public String convert(String num){

        return convertParts(num);
    }





}
