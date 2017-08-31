package com.ganshenml.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ganshenml.mvpdemo.R;
import com.ganshenml.mvpdemo.presenter.IMainActivityPresenter;
import com.ganshenml.mvpdemo.presenter.IMainActivityPresenterImpl;

public class MainActivity extends AppCompatActivity implements IMainActivityView, View.OnClickListener {
    private TextView contentTv;
    private Button addBtn, minusBtn;
    private IMainActivityPresenter iMainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentTv = (TextView) findViewById(R.id.contentTv);
        addBtn = (Button) findViewById(R.id.addBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);

        addBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        iMainActivityPresenter = new IMainActivityPresenterImpl(this);//此处相当于将本类中实现的IMainActivityView接口对象传递给IMainActivityPresenterImpl，
        // 从而在IMainActivityPresenterImpl中调用IMainActivityView的对象方法时，会反映至本类里面（之前写过一篇博客，自定义了一个名词“规则的移植复用”，
        // 可以讨论下：http://blog.csdn.net/ganshenml/article/details/76242175）
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBtn:
                iMainActivityPresenter.addNum();
                break;
            case R.id.minusBtn:
                iMainActivityPresenter.minusNum();
                break;
            default:
                break;
        }
    }

    @Override
    public void showAddNumView(int num) {
        contentTv.setText(num + "");
    }

    @Override
    public void showMinusNumView(int num) {
        contentTv.setText(num + "");
    }
}
