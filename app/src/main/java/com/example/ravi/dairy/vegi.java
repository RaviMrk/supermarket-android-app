package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class vegi extends AppCompatActivity {
    int[] imagev = {R.drawable.tomato, R.drawable.onion, R.drawable.potato, R.drawable.graddish, R.drawable.cabbage};
    String[] namev = {"Tomato", "Onion", "Potato", "Radish", "Cabbage"};
    String[] pricev = {"Rs 30", "RS 30", "Rs 40", "Rs 40", "Rs 20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegi);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        final EditText search=(EditText)findViewById(R.id.searchvegi);

        final Button btnsearch=(Button)findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String earch=search.getText().toString();

                if(Objects.equals("tomato", earch))
                {

                    Intent myintend=new Intent(vegi.this,tomato.class);
                    myintend.putExtra("name",name);
                    vegi.this.startActivity(myintend);
                }
                if(Objects.equals("onion", earch))
                {

                    Intent myintend=new Intent(vegi.this,onione.class);
                    myintend.putExtra("name",name);
                    vegi.this.startActivity(myintend);
                }
                if(Objects.equals("potato", earch))
                {

                    Intent myintend=new Intent(vegi.this,Potato.class);
                    myintend.putExtra("name",name);
                    vegi.this.startActivity(myintend);
                }
                if(Objects.equals("radish", earch))
                {

                    Intent myintend=new Intent(vegi.this,graddish.class);
                    myintend.putExtra("name",name);
                    vegi.this.startActivity(myintend);
                }
                if(Objects.equals("cabbage", earch))
                {

                    Intent myintend=new Intent(vegi.this,cabbage.class);
                    myintend.putExtra("name",name);
                    vegi.this.startActivity(myintend);
                }

            }
        });



       // Intent intent=getIntent();
       // final String name=intent.getStringExtra("name");

        ListView listView=(ListView) findViewById(R.id.vegilist);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final String name2=name;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent myintend=new Intent(view.getContext(),tomato.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,0);

                }
                if(position==1){
                    Intent myintend=new Intent(view.getContext(),onione.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,1);

                }
                if(position==2){
                    Intent myintend=new Intent(view.getContext(),Potato.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,2);

                }
                if(position==3){
                    Intent myintend=new Intent(view.getContext(),graddish.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,3);

                }
                if(position==4){
                    Intent myintend=new Intent(view.getContext(),cabbage.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,4);

                }

            }
        });







    }

    class CustomAdaptor extends BaseAdapter {
        @Override
        public int getCount() {
            return imagev.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.vlist,null);
            ImageView imageView1=(ImageView)view.findViewById(R.id.imageViewvegi);
            TextView textView_name=(TextView)view.findViewById(R.id.textViewvegi_name);
            TextView textView_price=(TextView)view.findViewById(R.id.textViewvegi_price);
            imageView1.setImageResource(imagev[i]);
            textView_name.setText(namev[i]);
            textView_price.setText(pricev[i]);


            return view;
        }
    }
}
