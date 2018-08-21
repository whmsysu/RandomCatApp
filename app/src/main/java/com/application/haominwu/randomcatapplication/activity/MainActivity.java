package com.application.haominwu.randomcatapplication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.component.DaggerMainComponent;
import com.application.haominwu.randomcatapplication.contract.CatDisplayContract;
import com.application.haominwu.randomcatapplication.module.MainModule;
import com.application.haominwu.randomcatapplication.presenter.CatImagePresenter;
import com.application.haominwu.randomcatapplication.util.Util;
import com.blankj.utilcode.util.NetworkUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements CatDisplayContract.View {

    @BindView(R.id.iv_cat)
    ImageView imageViewCat;

    @BindView(R.id.pb)
    ProgressBar pb;

    @BindView(R.id.btn_random_cat_one_by_one)
    Button oneByOneButton;

    @BindView(R.id.btn_random_cat_two_api_call)
    Button twoApiCallButton;

    @Inject
    public CatImagePresenter basePresenter;


    @Override
    protected void init() {
        super.init();
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);


        RxView.clicks(oneByOneButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (NetworkUtils.isConnected()){
                        basePresenter.fetchARandomCatOneByOne();
                    }

                });

        RxView.clicks(twoApiCallButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (NetworkUtils.isConnected()){
                        basePresenter.fetchARandomCatByTwoApiCall();
                    }
                });

    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void updateImage(final String url) {
        runOnUiThread(() -> {
            pb.setVisibility(View.GONE);
            Picasso.get().load(url).resize(Util.convertDipOrPx(MainActivity.this, 200), Util.convertDipOrPx(MainActivity.this, 200)).centerCrop().into(imageViewCat);
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
