package axisimski.binaryconverter;
public class HexToBinDecClass {

    public String convert(String hex, Integer type, String invalidString){

        if(type.equals(0)&&hex.contains("-")){
            return invalidString;
        }

        Hex2Bin hex2Bin= new Hex2Bin();
        Bin2Dec bin2Dec= new Bin2Dec();

        String dec="", bin="";

        if(type.equals(0)){

             bin=hex2Bin.convert(hex);
             String bintemp=bin2Dec.twosComplementToDec(bin);
             Double tempDec=bin2Dec.ConvertToDecimal(bintemp);
             dec=tempDec.toString();
         }

         if(type.equals(1)){
             bin=hex2Bin.convert(hex);
             Double tempDec=bin2Dec.ConvertToDecimal(bin);
             dec=tempDec.toString();
         }

        return "Dec: "+dec+"\n\nBin: "+bin+"\n\nHex: "+hex;
    }


}
