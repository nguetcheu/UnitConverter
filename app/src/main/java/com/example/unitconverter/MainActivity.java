package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText myEditText = findViewById(R.id.myEditText);
        TextView myTextView = findViewById(R.id.myTextView);
        Button myButton = findViewById(R.id.myButton);

        myTextView.setText("0");

        View.OnClickListener listerButton = new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                Button button = (Button) buttonView;
                String weight = myEditText.getText().toString();
                myTextView.setText(String.valueOf(weightToKg(weight)));
            }
        };

        myButton.setOnClickListener();
    }

    Double weightToKg(String weight){
        double result = Double.parseDouble(weight);
        // 1kg = 2.2 Ibs
        if (result == 0.0){
            return 0.0;
        }
        result *= 2.2;
        return result;
    };
}