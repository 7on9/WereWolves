package com.vnbamboo.werewolves;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    public static List<Card> cards = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private byte numPlayer;
    public static byte total;
    public RecyclerViewAdapter(Context context, List<Card> cards, byte numPlayer){
        this.cards = cards;
        this.context = context;
        this.numPlayer = numPlayer;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public long getItemId( int position ) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

        @Override
    public RecyclerView.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder holder, int position ) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.bindData(position);
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumOrder;
        LinearLayout line;
        ImageView imgRole;
        TextView txtRole;
        Button btnPlus, btnSub;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtNumOrder = (TextView) itemView.findViewById(R.id.txtNumOrder);
            line = itemView.findViewById(R.id.line);
            txtRole = (TextView) itemView.findViewById(R.id.txtRole);
            imgRole = (ImageView) itemView.findViewById(R.id.imgRole);
            btnPlus = (Button) itemView.findViewById(R.id.btnPlus);
            btnSub = (Button) itemView.findViewById(R.id.btnSub);
        }
        void bindData( final int position){
            final int id = cards.get(position).getId();
            this.txtRole.setText(cards.get(id).getName());
            int idPath = context.getResources().getIdentifier("com.vnbamboo.werewolves:drawable/" + cards.get(position).getPath(), null, null);
            this.imgRole.setImageResource(idPath);
            txtNumOrder.setText(Byte.toString(cards.get(id).getNumOrder()));
            //Log.d("RecyclerView", "btn ：" + getAdapterPosition());
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( View v ) {
                    cards.get(id).setNumOrder((byte) (cards.get(id).getNumOrder() + 1));
                    txtNumOrder.setText(Integer.toString(cards.get(id).getNumOrder()));
                    total = 0;
                    for (Card temp:cards) {
                        total += temp.getNumOrder();
                    }
                    if (numPlayer > total)
                    {
                        final Toast toast = Toast.makeText(context, "Còn " + Integer.toString(numPlayer - total)+ " người chưa có vai trò!", Toast.LENGTH_SHORT);
                        toast.show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 750);
                    } else 
                        if (numPlayer == total){
                            final Toast toast = Toast.makeText(context, "Đã chọn đủ vai trò!", Toast.LENGTH_SHORT);
                            toast.show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    toast.cancel();
                                }
                            }, 750); 
                        } else {
                            final Toast toast = Toast.makeText(context, "Đã chọn dư " + Integer.toString(total - numPlayer)+ " vai trò!", Toast.LENGTH_SHORT);
                            toast.show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    toast.cancel();
                                }
                            }, 750);
                        }
                }
            });
            btnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( View v ) {
                    cards.get(id).setNumOrder((byte) Integer.max(cards.get(id).getNumOrder() - 1, 0));
                    txtNumOrder.setText(Integer.toString(cards.get(id).getNumOrder()));
                    total = 0;
                    for (Card temp:cards) {
                        total += temp.getNumOrder();
                    }
                    if (numPlayer > total) {
                        final Toast toast = Toast.makeText(context, "Còn " + Integer.toString(numPlayer - total)+ " người chưa có vai trò!", Toast.LENGTH_SHORT);
                        toast.show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 750);
                    } else 
                        if (numPlayer == total){
                        final Toast toast = Toast.makeText(context, "Đã chọn đủ vai trò!", Toast.LENGTH_SHORT);
                        toast.show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 750);
                    } else {
                        final Toast toast = Toast.makeText(context, "Đã chọn dư " + Integer.toString(total - numPlayer)+ " vai trò!", Toast.LENGTH_SHORT);
                        toast.show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 750);
                    }
                }
            });
        }
    }
}
