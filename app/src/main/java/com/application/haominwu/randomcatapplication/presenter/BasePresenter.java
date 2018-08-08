package com.application.haominwu.randomcatapplication.presenter;

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
