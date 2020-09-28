package ci.ahmadfauzirahman.hrm.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.LogAbsensiResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogAbsensi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogAbsensi extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private String TAG = this.getClass().getName();
    SessionManager sessionManager;
    String kode;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    Intent intent;

    public FragmentLogAbsensi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLogAbsensi.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLogAbsensi newInstance(String param1, String param2) {
        FragmentLogAbsensi fragment = new FragmentLogAbsensi();
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
        view = inflater.inflate(R.layout.fragment_log_absensi, container, false);
        System.out.println("Ini Log Absensi");
        sessionManager = new SessionManager(getContext());
        kode = sessionManager.getUserDetail().get("username").toString();


        swipeRefreshLayout = view.findViewById(R.id.swpLogAbsensi);
        recyclerView = (RecyclerView) view.findViewById(R.id.reyLogAbsensi);


        getAllLogAbsensi(kode);
        return view;
    }

    private void getAllLogAbsensi(String kode) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.reyLogAbsensi);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        apiService.list_absensi(kode).enqueue(new Callback<LogAbsensiResponse>() {
            @Override
            public void onResponse(Call<LogAbsensiResponse> call, Response<LogAbsensiResponse> response) {

            }

            @Override
            public void onFailure(Call<LogAbsensiResponse> call, Throwable t) {

            }
        });
    }
}
