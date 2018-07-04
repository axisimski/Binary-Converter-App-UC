package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;
    private RadioButton twosComplement;
    private RadioButton signedNum;
    private Button fromHex_btn, fromDec_btn, fromBin_btn;
    private CheckInput check=new CheckInput();
    static String makeSelection, mustBeBinary, invalidNumber, inputTooLarge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        input =findViewById(R.id.input);
        output =  findViewById(R.id.output);
        twosComplement =  findViewById(R.id.twosComplement);
        signedNum = findViewById(R.id.signeNum);

        fromHex_btn=findViewById(R.id.hexToBinDec_btn);
        fromBin_btn=findViewById(R.id.binToDecHex_btn);
        fromDec_btn=findViewById(R.id.decToBinHex_btn);

        //get data from String resources for errors/messages
        makeSelection = getResources().getString(R.string.makeSelection);
        mustBeBinary = getResources().getString(R.string.mustBeBinary);
        invalidNumber = getResources().getString(R.string.notvalid);
        inputTooLarge=getResources().getString(R.string.inputTooLarge);

        //user actions
        userInput();

    }
//==========================================================================================End of OnCreate

    //User input; Button onClickListeners
    private void userInput(){

        fromDec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromDecimal();
            }
        });

        fromBin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromBinary();
            }
        });

        fromHex_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromHex();
            }
        });
    }
    //=========================================================================================end userInput


    /*This function determines whether the user want's two's complement or a regular signed conversion.
    It will return 0 if two's complement is checked, 1 for
    signed num and zero if neither. (May be amended latter to make use of a
    settings Menu */
    public Integer conversionType(){
        if(twosComplement.isChecked()){return 0;}
        else if(signedNum.isChecked()){return 1;}
        else return 2;
    }
    //============================================================================================End of Conversion Type

    /*Takes the user input and populates the output TextBox*/
    public void fromDecimal(){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }

        String dec=input.getText().toString();
        String ch=check.validInput(dec, 2, this);

        if(!ch.equals("OK")){
            output.setText(ch);
        }

        else {
            DecToBinHexClass fromDecimal = new DecToBinHexClass();
            String result = fromDecimal.convert(dec, conversionType());
            output.setText(result);
        }

    }
    //===============================================================================================End of convert from Decimal

    public void fromBinary(){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }
        String bin=input.getText().toString();
        String ch=check.validInput(bin, 1, this);

        if(!ch.equals("OK")){
            output.setText(ch);
        }

        else {
            BinToHexDecClass fromBinary = new BinToHexDecClass();
            String result = fromBinary.convert(bin, conversionType(), invalidNumber);
            output.setText(result);
        }
    }
    //===============================================================================================End of convert from Binary

    public void fromHex(){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }

        String hex=input.getText().toString();
        String ch=check.validInput(hex, 0, this);

        if(!ch.equals("OK")){
            output.setText(ch);
        }

        else {
            HexToBinDecClass fromHex = new HexToBinDecClass();
            String result = fromHex.convert(hex, conversionType(), invalidNumber);
            output.setText(result);
        }
    }

    //===============================================================================================End of convert from Hex
}