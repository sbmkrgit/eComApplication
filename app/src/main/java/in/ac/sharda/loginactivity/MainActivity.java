package in.ac.sharda.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                    editTextUserName.setError("Enter Name");
                }
                else if (TextUtils.isEmpty(textPassword.getText().toString())){
                    textPassword.setError("Enter Password");
                }
                else
                {
                    client=new AsyncHttpClient();
                    params=new RequestParams();
                    client.get("https://jsonplaceholder.typicode.com/posts", new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String data=new String(responseBody);
                            Log.d("arvind",data);
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers,
                                              byte[] responseBody, Throwable error) {
                            Toast.makeText(MainActivity.this,
                                    error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });




                }
            }
        });

    }
}