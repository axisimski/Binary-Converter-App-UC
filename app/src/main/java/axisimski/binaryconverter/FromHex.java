package axisimski.binaryconverter;

import java.math.BigInteger;

public class FromHex {


    public String convert(String hex){

        Boolean negative=false;
        if(hex.charAt(0)=='-'){
            negative=true;
           hex= hex.substring(1);
        }

        String whole=splitString(hex, 0);
        String fraction=splitString(hex, 1);


        Integer p1=Integer.parseInt(whole,16);
        String ws=Integer.toBinaryString(p1);

        Integer p2=Integer.parseInt(fraction,16);
        String fs=Integer.toBinaryString(p2);

        fs=addZeros(fs);

        if(negative==true){
            ws="-"+ws;
        }

        return ws+"."+fs;

    }//end Convert

    //---------------------------------------------------------------------

    public String splitString (String bin, int index){

        String[] parts = bin.split("[.]");

        if(index>=parts.length){
            return "0";
        }

        if(parts[index].isEmpty()){
            return "0";
        }
        bin = parts[index];

        return bin;
    } //end SplitString

    //---------------------------------------------------------------------
    public String addZeros(String fs){

        while(fs.length()%4!=0){
            fs="0"+fs;
        }

        return fs;

    } //end AddZeros





}
