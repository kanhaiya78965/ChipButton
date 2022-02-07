package luttipur.kanhaiya.ooappoo.chipbutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RevAdapter extends RecyclerView.Adapter<RevAdapter.RevViewHolder> {
    Context context;
    List<Contact> contactList;
    private RevItemSelectListener listener;

    public RevAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
        listener = (ChipButtonActivity)context;
    }

    @NonNull
    @Override
    public RevViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rev_sample_item,parent,false);
        return new RevViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevViewHolder holder, int position) {
//        holder.profilePic.setImageDrawable(ContextCompat.getDrawable(context,contactList.get(position).getPicId()));
        holder.profilePic.setImageResource(contactList.get(position).getPicId());
        holder.profileName.setText(contactList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class RevViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         CircleImageView profilePic;
         TextView profileName;
        LinearLayoutCompat rootViewLayout;


        public RevViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.profileName);
            profilePic = itemView.findViewById(R.id.profile_image);
            rootViewLayout = itemView.findViewById(R.id.rootView);

            rootViewLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemSelected(contactList.get(getAdapterPosition()));
        }
/*
        public void updateList(List<Contact> contactList1){
            contactList.clear();
            contactList.addAll(contactList1);
            notifyDataSetChanged();
        }

 */
    }


}
