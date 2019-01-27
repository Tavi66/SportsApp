package hack.sportsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class eventAdapter extends RecyclerView.Adapter<eventAdapter.eventViewHolder> {


    private Context mCtx;

    private List<event> eventList;

    public eventAdapter(Context mCtx, List<event> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @Override
    public eventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_items, null);
        return new eventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(eventViewHolder holder, int position) {

        event event = eventList.get(position);

        holder.textViewhere.setText(event.getWhere());
        holder.textViewho.setText(event.getWho());
        holder.textViewtime.setText(String.valueOf(event.getTime()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(event.getImage()));

    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }


    class eventViewHolder extends RecyclerView.ViewHolder {

        TextView textViewhere, textViewho, textViewtime;
        ImageView imageView;

        public eventViewHolder(View itemView) {
            super(itemView);

            textViewhere = itemView.findViewById(R.id.textViewhere);
            textViewtime = itemView.findViewById(R.id.textViewtime);
            textViewho = itemView.findViewById(R.id.textViewteam);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}