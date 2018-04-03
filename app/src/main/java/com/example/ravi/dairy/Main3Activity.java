package com.example.ravi.dairy;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;



public class Main3Activity extends AppCompatActivity {

    int[] image1={R.drawable.dairy,R.drawable.fruits,R.drawable.vegi};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");

        ListView listView=(ListView) findViewById(R.id.list1);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final String name2=name;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent myintend=new Intent(view.getContext(),product2.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,0);

                }
                if(position==1){
                    Intent myintend=new Intent(view.getContext(),fruits.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,1);

                }
                if(position==2){
                    Intent myintend=new Intent(view.getContext(),vegi.class);
                    myintend.putExtra("name",name2);
                    startActivityForResult(myintend,2);

                }

            }
        });





    }
    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return image1.length;
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
            view=getLayoutInflater().inflate(R.layout.list,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView80);

            imageView.setImageResource(image1[i]);



            return view;
        }
    }


}
