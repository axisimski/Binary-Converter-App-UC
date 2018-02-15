package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText binary;
    EditText decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binary=(EditText) findViewById(R.id.binary);
        decimal=(EditText)findViewById(R.id.decimal);
    }

    //Perform conversion
    public void convert(View v){

        String value= decimal.getText().toString();
        int n=Integer.parseInt(value);
        String binaryString;
        binaryString=Integer.toBinaryString(n);
        binary.setText(binaryString);
    }
    //====================================================================end of convert

}
