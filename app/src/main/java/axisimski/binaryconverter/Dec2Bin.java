package axisimski.binaryconverter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Dec2Bin {

//Convert to regular binary number
    public String convert(double number) {

        Boolean negative=false;
        if(number<0){
            negative=true;
            number=number*-1;
        }

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

        String ret= str.toString();

        if(negative==true){
            ret="-"+ret;
        }


        return ret;
    }


    //=============================================================================Convert to twos complement

    public String toTwosComplement(String  bin){

        Bin2TwosComp TwosComp=new Bin2TwosComp();
        bin=TwosComp.toTwosComplement(bin);
        return bin;
    }


}



