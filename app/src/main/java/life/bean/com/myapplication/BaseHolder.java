package life.bean.com.myapplication;

import android.view.View;

/**
 * Created by wangx on 2016/7/7.
 */
public abstract class BaseHolder<T> {
    private final View contentView;

    private T t;

    public BaseHolder() {
        contentView = initView();
        contentView.setTag(this);
    }


    public View getContentView() {
        return contentView;
    }

    public void setData(T t) {

        this.t = t;
        refreshView(t);
    }


    /**
     * 1. 创建view对象
     * 2. view初始化 (findviewById)
     *
     * @return
     */
    public abstract View initView();

    /**
     * 将数据显示到界面上
     *
     * @param t
     */
    public abstract void refreshView(T t);
}
