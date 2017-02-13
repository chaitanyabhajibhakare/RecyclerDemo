package app.techieni3.com.recyclerdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CHAITANYA-PC on 12/02/2017.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    String[] months;
    Context context;

    TextView textview;

    public MyRecyclerView(Context c,String[]array) {

        this.months = array;
        this.context = c;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
            textview = (TextView) view.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"clicked="+ months[getPosition()],Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(context,MainActivity.class);
                    context.startActivity(i);

                }
            });



        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_file,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        textview.setText(months[position]);
    }



    @Override
    public int getItemCount() {
        return months.length;
    }
}
