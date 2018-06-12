package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;



public class MainActivity extends AppCompatActivity {

    static EditText input;
    static TextView output;
    static RadioButton twosComplement;
    static RadioButton signedNum;
    private AdView mAdView;
    static String makeSelection, mustBeBinary, invalidNumber, inputTooLarge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*AdMob Code*/
        //Banner Ads

        MobileAds.initialize(this,
                "ca-app-pub-8271447368800027~5220336665");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        twosComplement = (RadioButton) findViewById(R.id.twosComplement);
        signedNum = (RadioButton) findViewById(R.id.signeNum);

        makeSelection = getResources().getString(R.string.makeSelection);
        mustBeBinary = getResources().getString(R.string.mustBeBinary);
        invalidNumber = getResources().getString(R.string.notvalid);
        inputTooLarge=getResources().getString(R.string.inputTooLarge);


    }
//==========================================================================================End of OnCreate

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
    public void fromDecimal(View v){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }

        String dec=input.getText().toString();
        FromDecimal fromDecimal=new FromDecimal();

        String result=fromDecimal.convert(dec, conversionType());

        output.setText(result);

    }
    //===============================================================================================End of convert from Decimal

    public void fromBinary(View v){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }

        String bin=input.getText().toString();
        FromBinary fromBinary= new FromBinary();

        String result=fromBinary.convert(bin, conversionType());
        output.setText(result);
    }
    //===============================================================================================End of convert from Binary


    public void fromHex(View v){

        if(conversionType().equals(2)){
            Toast.makeText(this,makeSelection,Toast.LENGTH_SHORT).show();
            return;
        }

        String hex=input.getText().toString();
        FromHex fromHex= new FromHex();


        String result=fromHex.convert(hex, conversionType());
        output.setText(result);

    }

    //===============================================================================================End of convert from Hex
}