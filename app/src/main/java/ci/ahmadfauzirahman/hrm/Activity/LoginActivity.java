package ci.ahmadfauzirahman.hrm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ci.ahmadfauzirahman.hrm.Model.UserModel;
import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.UserResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText editTextKodeAkun, editTextPassword;
    Button cirLoginButton;
    String KodeAkun, Password;
    ProgressBar progressBar;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    SessionManager sessionManager;
    private String TAG = this.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);


        editTextKodeAkun = findViewById(R.id.editTextKodeAkun);
        editTextPassword = findViewById(R.id.editTextPassword);
        cirLoginButton = findViewById(R.id.cirLoginButton);

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KodeAkun = editTextKodeAkun.getText().toString();
                Password = editTextPassword.getText().toString();
                prosesLogin(KodeAkun, Password);

//                Toast.makeText(getApplicationContext(),"Kode A")
            }
        });

    }

    private void prosesLogin(String kodeAkun, String password) {
//        progressBar.setVisibility(View.VISIBLE);

        apiService.login(kodeAkun, password).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    Boolean success = response.body().getCon();
                    if (success) {
                        UserModel userModel = response.body().getResults();
                        sessionManager.createLoginSession(userModel);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
//                        progressBar.setVisibility(View.GONE);
                    } else {
                        Log.d(TAG, "onResponsePassword: Password Salah & Username Salah");
                        Toast.makeText(getApplicationContext(), "Password Atau Username Salah", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Log.d(TAG, "onResponsePassword: Password Salah & Username Salah");
                    Toast.makeText(getApplicationContext(), "Opps, Hubungi Admin!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anda Tidak Terhubung Kejaringan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });

    }


}
