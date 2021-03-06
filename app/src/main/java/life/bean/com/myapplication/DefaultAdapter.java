package life.bean.com.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wangx on 2016/7/7.
 */
public abstract class DefaultAdapter<T> extends BaseAdapter {
    private List<T> datas;

    public DefaultAdapter(List<T> datas){

        this.datas = datas;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> holder = null;
        if (convertView == null) {
            holder = getHolder();
        } else {
            holder = (BaseHolder<T>) convertView.getTag();
        }
        T t = datas.get(position);
        holder.setData(t);
        return holder.getContentView();
    }

    /**
     * 返回holder
     * @return
     */
    public abstract BaseHolder<T> getHolder();
}
