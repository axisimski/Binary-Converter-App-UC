package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output=(TextView) findViewById(R.id.output);
        input=(EditText)findViewById(R.id.input);
    }


    public void convert(View v){

        String value= input.getText().toString();
        int n=Integer.parseInt(value);

        String binary;

        binary=Integer.toBinaryString(n);

        output.setText(binary);
    }

}
