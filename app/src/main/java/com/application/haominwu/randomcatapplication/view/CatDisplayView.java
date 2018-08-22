package com.application.haominwu.randomcatapplication.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.contract.CatDisplayContract;
import com.application.haominwu.randomcatapplication.presenter.CatDisplayPresenter;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

public class CatDisplayView implements CatDisplayContract.View {

    private CatDisplayPresenter catImagePresenter;

    private ImageView imageViewCat;

    private ProgressBar pb;

    private Button oneByOneButton;

    private Button twoApiCallButton;


    public CatDisplayView(View view) {

        imageViewCat = view.findViewById(R.id.iv_cat);
        pb = view.findViewById(R.id.pb);
        oneByOneButton = view.findViewById(R.id.btn_random_cat_one_by_one);
        twoApiCallButton = view.findViewById(R.id.btn_random_cat_two_api_call);

        RxView.clicks(oneByOneButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (NetworkUtils.isConnected()) {
                        if (catImagePresenter != null) catImagePresenter.fetchARandomCatOneByOne();
                    }

                });

        RxView.clicks(twoApiCallButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (NetworkUtils.isConnected()) {
                        if (catImagePresenter != null)
                            catImagePresenter.fetchARandomCatByTwoApiCall();
                    }
                });
    }

    @Override
    public void updateCatImage(String url) {
        pb.setVisibility(View.GONE);
        Picasso.get().load(url).resize(ConvertUtils.dp2px(200), ConvertUtils.dp2px(200)).centerCrop().into(imageViewCat);
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    public void setPresenter(CatDisplayPresenter presenter) {
        this.catImagePresenter = presenter;
    }

}
