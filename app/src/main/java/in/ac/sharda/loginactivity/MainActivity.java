package in.ac.sharda.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName,textPassword;
    Button btnSubmit;
    AsyncHttpClient client;
    RequestParams params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        textPassword=(EditText)findViewById(R.id.editTextPassword);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextUserName.getText().toString()))
                {
                    editTextUserName.setError("Entre Name");
                }
                else if (TextUtils.isEmpty(textPassword.getText().toString())){
                    textPassword.setError("Enter Password");
                }
                else
                {
                    client=new AsyncHttpClient();
                    params=new RequestParams();

                    params.put("userName",editTextUserName.getText().toString());
                    params.put("password",textPassword.getText().toString());
// https://developer.android.com/studio/run/emulator-networking.html
                    client.post("http://10.0.2.2:8080/login", params,
                            new AsyncHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode,
                                                      Header[] headers, byte[] responseBody) {

                                }
                                @Override
                                public void onFailure(int statusCode,
                                                      Header[] headers, byte[] responseBody,
                                                      Throwable error) {
                                }
                            });
                }
            }
        });

    }
}