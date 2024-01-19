package com.example.sendsmsactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String phoneNumber = phoneNumberEditText.getText().toString();
        String message = messageEditText.getText().toString();

        if (!phoneNumber.isEmpty() && !message.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            Uri uri = Uri.parse("smsto:" + Uri.encode(phoneNumber));
            intent.setData(uri);
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }
    }
}
