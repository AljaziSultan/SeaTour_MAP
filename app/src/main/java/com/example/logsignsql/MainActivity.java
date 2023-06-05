package com.example.logsignsql;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnsignin;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin = (Button) findViewById(R.id.btn_signin);
        btnsignup = (Button) findViewById(R.id.btn_signup);

        TextView txt_toGuest = findViewById(R.id.txt_guest);
        String txtGuest = "Continue as Guest";
        SpannableString SS = new SpannableString(txtGuest);
        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // CHANGE THIS TO HOME PAGE - Aljazi
                startActivity(intent);
            }
        };

        SS.setSpan(cs, 0, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_toGuest.setText(SS);
        txt_toGuest.setMovementMethod(LinkMovementMethod.getInstance());

        btnsignin.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                             Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

        btnsignup.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

    }

}