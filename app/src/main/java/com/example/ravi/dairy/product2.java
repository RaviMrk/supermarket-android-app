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

import java.util.Objects;

public class product2 extends AppCompatActivity {
    int[] image = {R.drawable.amul, R.drawable.cheesepac, R.drawable.cheeseprod, R.drawable.curdprod,R.drawable.buttermilk,R.drawable.paneer,R.drawable.ghee};
    String[] name = {"Milk", "Cheese", "Butter", "curd","buttermilk","paneer","Ghee"};
    String[] price = {"Rs 62","Rs 108","Rs 92","Rs 25","Rs 80","Rs 200","Rs 560"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        final EditText search=(EditText)findViewById(R.id.dsearch);

        final Button btnsearch=(Button)findViewById(R.id.btndsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             final String earch = search.getText().toString();

                                             if (Objects.equals("milk", earch)) {

                                                 Intent myintend = new Intent(product2.this, Milk.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("cheese", earch)) {

                                                 Intent myintend = new Intent(product2.this, Cheese.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("butter", earch)) {

                                                 Intent myintend = new Intent(product2.this, Butter.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("curd", earch)) {

                                                 Intent myintend = new Intent(product2.this, Curd.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("ghee", earch)) {

                                                 Intent myintend = new Intent(product2.this, ghee.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("butermilk", earch)) {

                                                 Intent myintend = new Intent(product2.this, buttermilk.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }
                                             if (Objects.equals("paneer", earch)) {

                                                 Intent myintend = new Intent(product2.this, paneer.class);
                                                 myintend.putExtra("name", name);
                                                 product2.this.startActivity(myintend);
                                             }

                                         }

                                     });
        ListView listView=(ListView) findViewById(R.id.list);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final String name2=name;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent myintend=new Intent(view.getContext(),Milk.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,0);

                }
                if(position==1){
                    Intent myintend=new Intent(view.getContext(),Cheese.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,1);

                }
                if(position==2){
                    Intent myintend=new Intent(view.getContext(),Butter.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,2);

                }
                if(position==3){
                    Intent myintend=new Intent(view.getContext(),Curd.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,3);

                }

                if(position==4){
                    Intent myintend=new Intent(view.getContext(),buttermilk.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,4);

                }

                if(position==5){
                    Intent myintend=new Intent(view.getContext(),paneer.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,5);

                }

                if(position==6){
                    Intent myintend=new Intent(view.getContext(),ghee.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,6);

                }




            }
        });




    }
    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return image.length;
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
            view=getLayoutInflater().inflate(R.layout.list_item,null);

            ImageView imageView1=(ImageView)view.findViewById(R.id.imageView30);
            TextView textView_name=(TextView)view.findViewById(R.id.textViewfruits_name);
            TextView textView_price=(TextView)view.findViewById(R.id.textView38);
            imageView1.setImageResource(image[i]);
            textView_name.setText(name[i]);
            textView_price.setText(price[i]);


            return view;
        }
    }


}
