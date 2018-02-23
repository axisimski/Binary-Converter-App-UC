package axisimski.binaryconverter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Alex on 2/18/2018.
 */

public class ToBinary {


        public String convert(double number) {
            int n = 10;
            BigDecimal bd = new BigDecimal(number);
            BigDecimal mult = new BigDecimal(2).pow(n);
            bd = bd.multiply(mult);
            BigInteger bi = bd.toBigInteger();
            StringBuilder str = new StringBuilder(bi.toString(2));
            while (str.length() < n+1) {
                str.insert(0, "0");
            }
            str.insert(str.length()-n, ".");
            return str.toString();
        }


        public String flip(String n){

            char[] myNameChars = n.toCharArray();

            for(int i=0;i<n.length();i++){

                if(n.charAt(i)=='0'){
                     myNameChars[i]='1';
                }
            }

            n = String.valueOf(myNameChars);


            return n;
        }

        public String toTwosComplement(String  bin){


        Character n=bin.charAt(0);

        if(n!='-'){

            bin = "0"+bin;
        }

         else if(n=='-'){

            bin = "00"+bin;
          bin= flip(bin);
            return bin;

        }


            return  bin;
        }


}



