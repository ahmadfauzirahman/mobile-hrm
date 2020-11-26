package ci.ahmadfauzirahman.hrm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ci.ahmadfauzirahman.hrm.Model.ModelPegawai;
import ci.ahmadfauzirahman.hrm.R;

public class PegawaiAdapter extends RecyclerView.Adapter<PegawaiAdapter.AdapterViewHolder> implements Filterable {

    private List<ModelPegawai> mFilteredList;
    private List<ModelPegawai> mArrayList;
    private int rowLayout;
    private Context context;

    public PegawaiAdapter(List<ModelPegawai> modelPegawais, int rowLayout, Context context) {
        this.mArrayList = modelPegawais;
        this.mFilteredList = modelPegawais;
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
        holder.mnamaPegawai.setText(mFilteredList.get(position).getNamaLengkap());
        holder.mNipNikPegawai.setText(mFilteredList.get(position).getIdNipNrp());
        System.out.println(mFilteredList.get(position).getJenisKelamin() + "Jenis Kelamin");
        String Laki = "Laki-Laki";
        String Hasil = mFilteredList.get(position).getJenisKelamin();
        if (Laki.equals(Hasil)) {
            holder.thumbnail.setBackgroundResource(R.drawable.user);
        } else {
            holder.thumbnail.setBackgroundResource(R.drawable.women);

        }
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    mFilteredList = mArrayList;
                } else {
                    ArrayList<ModelPegawai> filteredList = new ArrayList<>();
                    for (ModelPegawai modelPegawai : mArrayList) {
                        if (modelPegawai.getNamaLengkap().toLowerCase().contains(charString) || modelPegawai.getIdNipNrp().toLowerCase().contains(charString)) {
                            filteredList.add(modelPegawai);
                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFilteredList = (ArrayList<ModelPegawai>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout lnPegawai;
        TextView mnamaPegawai, mNipNikPegawai;
        ImageView thumbnail;

        public AdapterViewHolder(@NonNull View itemView) {

            super(itemView);
            lnPegawai = itemView.findViewById(R.id.lnPegawai);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            mnamaPegawai = itemView.findViewById(R.id.mnamaPegawai);
            mNipNikPegawai = itemView.findViewById(R.id.mNipNikPegawai);
        }

    }
}
