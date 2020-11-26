package ci.ahmadfauzirahman.hrm.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import ci.ahmadfauzirahman.hrm.Activity.DetailPage.DetailMyTeamActivity;
import ci.ahmadfauzirahman.hrm.Activity.IKI.IkiActivity;
import ci.ahmadfauzirahman.hrm.Activity.ModulAbsensi.OptionsAbsenActivity;
import ci.ahmadfauzirahman.hrm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDashboard extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CardView cardAmbilAbsensi, cardStruktur, cardIki;
    LinearLayout logo;

    public FragmentDashboard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDashboard.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDashboard newInstance(String param1, String param2) {
        FragmentDashboard fragment = new FragmentDashboard();
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
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        cardAmbilAbsensi = view.findViewById(R.id.cardAmbilAbsensi);
        cardStruktur = view.findViewById(R.id.cardStruktur);
//        cardIki = view.findViewById(R.id.cardIki);
        System.out.println("Ini Dashboard");


//        cardIki.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), IkiActivity.class);
//                startActivity(intent);
//            }
//        });
        cardStruktur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailMyTeamActivity.class);
                startActivity(intent);
            }
        });

        cardAmbilAbsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OptionsAbsenActivity.class);
                startActivity(intent);
            }
        });
        if (isMockSettingsON(getContext())) {
            Toast.makeText(getContext(), "Aplikasi Mendeteksi Adanya Fake GPS Atau Mock Location Dalam Kondisi Enable", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(getContext(), String.valueOf(isMockSettingsON(getContext())) + "Ini", Toast.LENGTH_SHORT).show();
            System.out.println("Tidak Aktif");
        }

        return view;
    }

    public static boolean isMockSettingsON(Context context) {
        // returns true if mock location enabled, false if not enabled.
        if (Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION).equals("0"))
            return false;
        else
            return true;
    }
}
