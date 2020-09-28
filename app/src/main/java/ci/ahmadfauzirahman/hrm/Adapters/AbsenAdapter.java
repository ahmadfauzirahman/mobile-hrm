package ci.ahmadfauzirahman.hrm.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ci.ahmadfauzirahman.hrm.Model.LogAbsensiModel;
import ci.ahmadfauzirahman.hrm.R;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.AdapterViewHolder> {

    private List<LogAbsensiModel> logAbsensiModels;
    private int rowLayout;
    private Context context;

    public AbsenAdapter(List<LogAbsensiModel> logAbsensiModels, int rowLayout, Context context) {
        this.logAbsensiModels = logAbsensiModels;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.midTbAbsensi.setText(logAbsensiModels.get(position).getIdAbsensi());
        holder.id_pegawai.setText(logAbsensiModels.get(position).getIdPegawai());
        holder.nipPegawai.setText(logAbsensiModels.get(position).getNip());
        holder.lat.setText(logAbsensiModels.get(position).getLat());
        holder.lng.setText(logAbsensiModels.get(position).getLong());
        holder.status.setText(logAbsensiModels.get(position).getStatusMasuk());
        holder.hari_masuk.setText(logAbsensiModels.get(position).getHari() + "," + logAbsensiModels.get(position).getTanggalMasuk());
        holder.status_hadir.setText(logAbsensiModels.get(position).getStatusMasuk());
        holder.jam_masuk.setText(logAbsensiModels.get(position).getJamMasuk());

    }

    @Override
    public int getItemCount() {
        return logAbsensiModels.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView midTbAbsensi, id_pegawai, nipPegawai, lat, lng, status, hari_masuk, status_hadir,jam_masuk;
        LinearLayout lnLogAbsensi;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            lnLogAbsensi = itemView.findViewById(R.id.lnLogAbsensi);
            midTbAbsensi = itemView.findViewById(R.id.midTbAbsensi);
            id_pegawai = itemView.findViewById(R.id.id_pegawai);
            nipPegawai = itemView.findViewById(R.id.nipPegawai);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
            jam_masuk = itemView.findViewById(R.id.jam_masuk);
            status = itemView.findViewById(R.id.status);
            hari_masuk = itemView.findViewById(R.id.hari_masuk);
            status_hadir = itemView.findViewById(R.id.status_hadir);
        }
    }
}
