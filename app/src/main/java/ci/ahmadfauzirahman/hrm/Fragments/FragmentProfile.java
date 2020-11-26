package ci.ahmadfauzirahman.hrm.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ci.ahmadfauzirahman.hrm.Activity.LoginActivity;
import ci.ahmadfauzirahman.hrm.Activity.Profile.ChangePasswordActivity;
import ci.ahmadfauzirahman.hrm.Activity.Profile.EditProfileActivity;
import ci.ahmadfauzirahman.hrm.Activity.Profile.ProfileDataPegawaiActivity;
import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SessionManager sessionManager;
    TextView editProfileLogin, profilePegawai,changePassword;
    ImageView editProfileLoginArrow;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    TextView mlogout, usernameTextView;
    String mNama;
    Intent intent;

    public FragmentProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        sessionManager = new SessionManager(getContext());

        //deklrasi id
        mlogout = view.findViewById(R.id.idLogout);
        usernameTextView = view.findViewById(R.id.usernameTextView);
        editProfileLogin = view.findViewById(R.id.editProfileLogin);
        editProfileLoginArrow = view.findViewById(R.id.editProfileLoginArrow);
        changePassword = view.findViewById(R.id.changePassword);
        profilePegawai = view.findViewById(R.id.profilePegawai);
        mNama = sessionManager.getUserDetail().get("nama").toString();
        usernameTextView.setText(mNama);

        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                sessionManager.logoutUser();
                Intent i = new Intent(getContext(), LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        editProfileLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), EditProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        editProfileLoginArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), EditProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        profilePegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), ProfileDataPegawaiActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), ChangePasswordActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        return view;
    }
}
