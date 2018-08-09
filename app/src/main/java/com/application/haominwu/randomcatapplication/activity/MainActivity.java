package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.component.DaggerMainComponent;
import com.application.haominwu.randomcatapplication.contract.CatDisplayContract;
import com.application.haominwu.randomcatapplication.module.MainModule;
import com.application.haominwu.randomcatapplication.presenter.CatImagePresenter;
import com.application.haominwu.randomcatapplication.util.Util;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements CatDisplayContract.View {

    @BindView(R.id.iv_cat)
    ImageView imageViewCat;

    @BindView(R.id.pb)
    ProgressBar pb;

    @OnClick(R.id.btn_random_cat)
    public void onBtnRandomCatClick(View view) {
        basePresenter.fetchARandomCat();
    }

    @Inject
    public CatImagePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
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
        basePresenter.dropView();
    }
}
