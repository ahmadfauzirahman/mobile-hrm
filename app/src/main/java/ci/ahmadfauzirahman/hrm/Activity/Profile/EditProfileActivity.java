package ci.ahmadfauzirahman.hrm.Activity.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;

public class EditProfileActivity extends AppCompatActivity {
    SessionManager sessionManager;
    String nip,nama,tanggal,role;
    EditText username,nama_lengkap,tanggal_pendaftaran,roleAplikasi,status_user;
    TextView usernameTextView,editProfileLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        sessionManager = new SessionManager(this);
        nama = sessionManager.getUserDetail().get("nama");
        nip = sessionManager.getUserDetail().get("username");
        tanggal = sessionManager.getUserDetail().get("tanggal_pendaftaran");
        role = sessionManager.getUserDetail().get("role");

        usernameTextView = findViewById(R.id.usernameTextView);
        editProfileLogin = findViewById(R.id.editProfileLogin);
        username = findViewById(R.id.username);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        tanggal_pendaftaran = findViewById(R.id.tanggal_pendaftaran);
        roleAplikasi = findViewById(R.id.role);
        status_user = findViewById(R.id.status_user);

        username.setText(nip);
        nama_lengkap.setText(nama);
        tanggal_pendaftaran.setText(tanggal);
        roleAplikasi.setText(role);

        usernameTextView.setText(nama);
        editProfileLogin.setText(nip);

    }
}