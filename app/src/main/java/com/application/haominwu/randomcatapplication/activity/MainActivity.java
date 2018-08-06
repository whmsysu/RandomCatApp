package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;
import com.application.haominwu.randomcatapplication.presenter.BasePresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements CatImageDisplayView {

    @BindView(R.id.iv_cat)
    ImageView imageViewCat;

    @BindView(R.id.btn_random_cat)
    Button buttonFetchACat;

    private BasePresenter basePresenter = new BasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        basePresenter.createPresenter(this);
        buttonFetchACat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basePresenter.fetchARandomCat();
            }
        });
    }

    @Override
    public void updateImage(final String url) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(url).into(imageViewCat);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.onDestroy();
    }
}
