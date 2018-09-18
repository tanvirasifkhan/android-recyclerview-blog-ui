package com.example.asifkhan.androidrecyclerviewblog.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.asifkhan.androidrecyclerviewblog.R;
import com.example.asifkhan.androidrecyclerviewblog.adapters.BlogAdapter;
import com.example.asifkhan.androidrecyclerviewblog.models.Blog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Blog> blogs;
    private RecyclerView show_blogs;
    private LinearLayoutManager linearLayoutManager;
    private BlogAdapter blogAdapter;

    private String[] titles={
           "PHP for the beginners","iOS developer tutorial","Learn Java for free","Become Android programmer","Python for data analysis",
            "PHP for the beginners","iOS developer tutorial","Learn Java for free","Become Android programmer","Python for data analysis",
            "PHP for the beginners","iOS developer tutorial","Learn Java for free","Become Android programmer","Python for data analysis",
            "PHP for the beginners","iOS developer tutorial","Learn Java for free","Become Android programmer","Python for data analysis",
            "PHP for the beginners","iOS developer tutorial","Learn Java for free","Become Android programmer","Python for data analysis"
    };
    private String[] authors={
            "Asif Khan","Tanvir Ahmed","Nafis Iqbal","Rahim Islam","Abir Hasan",
            "Asif Khan","Tanvir Ahmed","Nafis Iqbal","Rahim Islam","Abir Hasan",
            "Asif Khan","Tanvir Ahmed","Nafis Iqbal","Rahim Islam","Abir Hasan",
            "Asif Khan","Tanvir Ahmed","Nafis Iqbal","Rahim Islam","Abir Hasan",
            "Asif Khan","Tanvir Ahmed","Nafis Iqbal","Rahim Islam","Abir Hasan"
    };
    private int[] photos={
            R.drawable.sample_5,R.drawable.sample_1,R.drawable.sample_6,R.drawable.sample_5,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_5,R.drawable.sample_2,
            R.drawable.sample_6,R.drawable.sample_1,R.drawable.sample_4,R.drawable.sample_6,R.drawable.sample_4,
            R.drawable.sample_0,R.drawable.sample_3,R.drawable.sample_3,R.drawable.sample_5,R.drawable.sample_4,
            R.drawable.sample_7,R.drawable.sample_1,R.drawable.sample_5,R.drawable.sample_5,R.drawable.sample_0
    };

    private int[] likes={10,20,30,40,50,60,15,22,55,33,11,41,75,10,32,17,22,55,33,11,41,75,10,32,17};
    private int[] comments={10,20,30,40,50,60,15,22,55,33,11,41,75,10,32,17,22,55,33,11,41,75,10,32,17};
    private int[] shares={10,20,30,40,50,60,15,22,55,33,11,41,75,10,32,17,22,55,33,11,41,75,10,32,17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        blogs=new ArrayList<>();
        show_blogs=(RecyclerView)findViewById(R.id.blog);
        linearLayoutManager=new LinearLayoutManager(this);
        blogAdapter=new BlogAdapter(blogs,this);
        show_blogs.setAdapter(blogAdapter);
        show_blogs.setLayoutManager(linearLayoutManager);
        getBlogs();
    }

    // getting all the blogs
    private void getBlogs() {
        for(int count=0;count<titles.length;count++){
            blogs.add(new Blog(titles[count],authors[count],likes[count],comments[count],shares[count],photos[count]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
