package ci.ahmadfauzirahman.hrm.Activity.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.UserResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {

    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    SessionManager sessionManager;
    private String TAG = this.getClass().getName();
    EditText password_lama, password_baru, password_confirm;
    ProgressBar progressBar;
    Button btn_change;
    String username, nPasswordLama, nPasswordBaru, nPassworConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        sessionManager = new SessionManager(this);
        username = sessionManager.getUserDetail().get("username");

        password_lama = findViewById(R.id.password_lama);
        password_baru = findViewById(R.id.password_baru);
        password_confirm = findViewById(R.id.password_confirm);
        progressBar = findViewById(R.id.progressBar);
        btn_change = findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nPasswordLama = password_lama.getText().toString();
                nPasswordBaru = password_confirm.getText().toString();
                nPassworConfirm = password_confirm.getText().toString();
                changePassword(username, nPasswordLama, nPasswordBaru, nPassworConfirm);
            }
        });

    }

    private void changePassword(String username, String nPasswordLama, String nPasswordBaru, String nPassworConfirm) {
        progressBar.setVisibility(View.VISIBLE);
        apiService.changePassword(username, nPasswordLama, nPasswordBaru, nPassworConfirm).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Tidak Behasil Merubah Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps", Toast.LENGTH_SHORT).show();
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