package org.techtown.smsdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() { // 리스너 이용. 텍스트 변환 감지.
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bytesCounter(s); // CharSequence를 매개변수로 이용.
            }

            @Override
            public void afterTextChanged(Editable s) {            }
        });
    }

    public void onButton1Clicked(View v){
        Toast.makeText(this,editText.getText(),Toast.LENGTH_LONG).show();
    }

    public void bytesCounter(CharSequence s){
        textView.setText(""+s.toString().getBytes().length + " / 80 바이트");
    }

}


