package com.blanke.simplegank.core.main.presenter;

import com.blanke.simplegank.bean.CateGoryBean;
import com.blanke.simplegank.core.main.model.CateGoryModel;
import com.blanke.simplegank.core.main.view.CateGoryView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by Blanke on 16-1-19.
 */
public abstract class CateGoryPresenter extends MvpBasePresenter<CateGoryView> implements CateGoryModel.CallBack {
    protected CateGoryModel mCateGoryModel;

    public CateGoryPresenter(CateGoryModel mCateGoryModel) {
        this.mCateGoryModel = mCateGoryModel;
    }

    public abstract void loadGank(boolean pullToRefresh, CateGoryBean cateGory, int size, int page);

}
