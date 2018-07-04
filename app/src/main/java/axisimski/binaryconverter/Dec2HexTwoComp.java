package axisimski.binaryconverter;
public class Dec2HexTwoComp {

    public String convert(String dec){

        Dec2Bin dec2Bin=new Dec2Bin();
        Dec2Hex dec2Hex=new Dec2Hex();
        Bin2Dec bin2Dec=new Bin2Dec();
        String hex="", bin="", decimal="",bin2c="";

        bin=dec2Bin.convert(Double.parseDouble(dec));


        bin2c=dec2Bin.toTwosComplement(bin);
        Double decDouble=bin2Dec.ConvertToDecimal(bin2c);
        dec=decDouble.toString();
        hex=dec2Hex.convert(dec);

        return hex;

    }



}
