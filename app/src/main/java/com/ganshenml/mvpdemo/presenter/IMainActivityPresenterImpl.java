package com.ganshenml.mvpdemo.presenter;

import com.ganshenml.mvpdemo.model.NumEntity;
import com.ganshenml.mvpdemo.view.IMainActivityView;

/**
 * Created by Administrator on 2017/8/31.
 */

public class IMainActivityPresenterImpl implements IMainActivityPresenter {
    private IMainActivityView iMainActivityView;
    private NumEntity numEntity;//Model层数据

    public IMainActivityPresenterImpl(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
        initNumEntity();
    }

    @Override
    public void addNum() {
        if (!judgeCanOperation()) {
            return;
        }
        numEntity.setNum(numEntity.getNum() + 1);
        iMainActivityView.showAddNumView(numEntity.getNum());
    }

    @Override
    public void minusNum() {
        if (!judgeCanOperation()) {
            return;
        }
        numEntity.setNum(numEntity.getNum() - 1);
        iMainActivityView.showMinusNumView(numEntity.getNum());
    }

    //可以理解为初始化（传递过来的值或者本地赋值）；也可以理解此处为进行网络请求
    private void initNumEntity() {
        numEntity = new NumEntity();
    }

    //判断网络请求或界面本地初始化是否完毕，从而允许进行其他的操作（如点击操作等）
    private boolean judgeCanOperation() {
        if (numEntity == null) {
            return false;
        }
        return true;
    }
}
