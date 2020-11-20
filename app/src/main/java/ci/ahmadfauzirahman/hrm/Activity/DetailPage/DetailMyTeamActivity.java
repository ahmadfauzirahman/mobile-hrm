package ci.ahmadfauzirahman.hrm.Activity.DetailPage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.Objects;

import ci.ahmadfauzirahman.hrm.Adapters.PegawaiAdapter;
import ci.ahmadfauzirahman.hrm.Model.ModelPegawai;
import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.PegawaiResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMyTeamActivity extends AppCompatActivity {
    private static final String TAG = DetailMyTeamActivity.class.getSimpleName();
    SwipeRefreshLayout swipeRefreshLayout;
    PegawaiAdapter pegawaiAdapter;
    SessionManager sessionManager;
    String kode;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    Intent intent;
    private ShimmerFrameLayout mShimmerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_my_team);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        sessionManager = new SessionManager(getApplicationContext());
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swpPegawai);

        kode = sessionManager.getUserDetail().get("username").toString();
        // Find the toolbar view inside the activity layout
        getStrukturPegawai(kode);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getStrukturPegawai(kode);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void getStrukturPegawai(String kode) {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reyPegawaiList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<PegawaiResponse> call = apiService.getStrukturInstansi(kode);
        call.enqueue(new Callback<PegawaiResponse>() {
            @Override
            public void onResponse(Call<PegawaiResponse> call, Response<PegawaiResponse> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    List<ModelPegawai> modelPegawais = response.body().getResults();
                    pegawaiAdapter = new PegawaiAdapter(modelPegawais, R.layout.list_pegawai, getApplicationContext());
                    recyclerView.setAdapter(pegawaiAdapter);
                    // stop animating Shimmer and hide the layout
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                } else {
                    Toast.makeText(getApplicationContext(), "Upps, Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PegawaiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Upps, Something Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pegawaiAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }


}
