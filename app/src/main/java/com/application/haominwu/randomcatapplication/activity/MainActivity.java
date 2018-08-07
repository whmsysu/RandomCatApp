package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.presenter.BasePresenter;
import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements CatImageDisplayView {

    @BindView(R.id.iv_cat)
    ImageView imageViewCat;

    @OnClick(R.id.btn_random_cat)
    public void onBtnRandomCatClick(View view) {
        basePresenter.fetchARandomCat();
    }

    private BasePresenter basePresenter = new BasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter.createPresenter(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
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
