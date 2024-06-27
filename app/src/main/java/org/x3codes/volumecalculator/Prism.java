package org.x3codes.volumecalculator;

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

public class Prism extends AppCompatActivity {

    EditText editTextHeight, editTextWidth, editTextLength;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.btn1);
        editTextWidth = findViewById(R.id.editText_width);
        editTextLength = findViewById(R.id.editText_length);
        editTextHeight = findViewById(R.id.editText_height);
        result = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String length = editTextLength.getText().toString();
                String height = editTextHeight.getText().toString();
                String width = editTextWidth.getText().toString();
                int l = Integer.parseInt(length);
                int h = Integer.parseInt(height);
                int w = Integer.parseInt(width);

                double volume = l * h * w;

                result.setText(String.format("V = %s m^3", volume));
            }
        });

    }
}