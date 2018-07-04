package axisimski.binaryconverter;
public class DecToBinHexClass {

    public String convert(String dec, Integer type){

        String bin="", hex="";
        Dec2Bin dec2Bin=new Dec2Bin();
        Dec2Hex dec2Hex=new Dec2Hex();
        Dec2HexTwoComp dec2HexTwoComp=new Dec2HexTwoComp();

        if(type.equals(0)){

            if(dec.charAt(0)=='-'){
                String binTemp=dec2Bin.convert(Double.parseDouble(dec));
                bin=dec2Bin.toTwosComplement(binTemp);
                hex=dec2HexTwoComp.convert(dec);
            }

            else{
                bin=dec2Bin.convert(Double.parseDouble(dec));
                bin="0"+bin;
                hex=dec2Hex.convert(dec);
            }

        }

        else if(type.equals(1)){
           bin=dec2Bin.convert(Double.parseDouble(dec));
           hex=dec2Hex.convert(dec);

        }

        //Trim Bin (If it has two leading 00.01 zeros.


        if(bin.charAt(0)=='0'&&bin.charAt(1)=='0'){

            bin=bin.substring(1);
        }

        return "Dec: "+dec+"\n\nBin: "+bin+"\n\nHex: "+hex;
    }


}
