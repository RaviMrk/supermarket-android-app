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

public class fruits extends AppCompatActivity {
    int[] imagef = {R.drawable.orange,R.drawable.apple,R.drawable.strawberry,R.drawable.grapes,R.drawable.bannana};
    String[] namef = {"Orange","Apple","strawberry","Grapes","Banana"};
    String[] pricef = {"Rs 30","RS 60","Rs 80","Rs 40","Rs 20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");


        final EditText search=(EditText)findViewById(R.id.fsearch);

        final Button btnsearch=(Button)findViewById(R.id.btnfsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String earch = search.getText().toString();

                if (Objects.equals("orange", earch)) {

                    Intent myintend = new Intent(fruits.this, orange.class);
                    myintend.putExtra("name", name);
                    fruits.this.startActivity(myintend);
                }
                if (Objects.equals("apple", earch)) {

                    Intent myintend = new Intent(fruits.this, apple.class);
                    myintend.putExtra("name", name);
                    fruits.this.startActivity(myintend);
                }
                if (Objects.equals("straberry", earch)) {

                    Intent myintend = new Intent(fruits.this, strawberry.class);
                    myintend.putExtra("name", name);
                    fruits.this.startActivity(myintend);
                }
                if (Objects.equals("grapes", earch)) {

                    Intent myintend = new Intent(fruits.this, Grapes.class);
                    myintend.putExtra("name", name);
                    fruits.this.startActivity(myintend);
                }
                if (Objects.equals("banana", earch)) {

                    Intent myintend = new Intent(fruits.this, Bannana.class);
                    myintend.putExtra("name", name);
                    fruits.this.startActivity(myintend);
                }


            }

        });


        ListView listView=(ListView) findViewById(R.id.fruitslist);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final String name2=name;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent myintend=new Intent(view.getContext(),orange.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,0);

                }
                if(position==1){
                    Intent myintend=new Intent(view.getContext(),apple.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,1);

                }
                if(position==2){
                    Intent myintend=new Intent(view.getContext(),strawberry.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,2);

                }
                if(position==3){
                    Intent myintend=new Intent(view.getContext(),Grapes.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,3);

                }
                if(position==4){
                    Intent myintend=new Intent(view.getContext(),Bannana.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,4);

                }

            }
        });


    }

    class CustomAdaptor extends BaseAdapter {
        @Override
        public int getCount() {
            return imagef.length;
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
            view=getLayoutInflater().inflate(R.layout.fruitlist,null);

            ImageView imageView1=(ImageView)view.findViewById(R.id.imageViewfruits);
            TextView textView_name=(TextView)view.findViewById(R.id.textViewfruits_name);
            TextView textView_price=(TextView)view.findViewById(R.id.textViewfruit_price);
            imageView1.setImageResource(imagef[i]);
            textView_name.setText(namef[i]);
            textView_price.setText(pricef[i]);


            return view;
        }
    }
}
