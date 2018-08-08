package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.presenter.CatImagePresenter;
import com.application.haominwu.randomcatapplication.util.Util;
import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements CatImageDisplayView {

    @BindView(R.id.iv_cat)
    ImageView imageViewCat;

    @BindView(R.id.pb)
    ProgressBar pb;

    @OnClick(R.id.btn_random_cat)
    public void onBtnRandomCatClick(View view) {
        basePresenter.fetchARandomCat();
    }

    public CatImagePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter = new CatImagePresenter(this);
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
                pb.setVisibility(View.GONE);
                Picasso.get().load(url).resize(Util.convertDipOrPx(MainActivity.this, 200), Util.convertDipOrPx(MainActivity.this, 200)).centerCrop().into(imageViewCat);
            }
        });
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.onDestroy();
    }
}
