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

        public String toTwosComplement(StringBuffer  str){

            int n = str.length();

            // Traverse the string to get first '1' from
            // the last of string
            int i;
            for (i = n-1 ; i >= 0 ; i--)
                if (str.charAt(i) == '1')
                    break;

            // If there exists no '1' concat 1 at the
            // starting of string
            if (i == 0)
                return "1" + str;

            // Continue traversal after the position of
            // first '1'
            for (int k = i-1 ; k >= 0; k--)
            {
                //Just flip the values
                if (str.charAt(k) == '1')
                    str.replace(k, k+1, "0");
                else
                    str.replace(k, k+1, "1");
            }

            // return the modified string
            return str.toString();
        }


}



