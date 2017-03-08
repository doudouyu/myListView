package life.bean.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity {

    List<Integer> imgResIds = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        listView = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < 50; i++) {
            imgResIds.add(R.mipmap.ic_launcher);
        }
        listView.setAdapter(new OtherAdapter(imgResIds));
    }


    class OtherAdapter extends DefaultAdapter<Integer> {

        public OtherAdapter(List<Integer> datas) {
            super(datas);
        }

        @Override
        public BaseHolder<Integer> getHolder() {
            return new OtherHolder();
        }
    }


    class OtherHolder extends BaseHolder<Integer> {
        public ImageView imageView;


        @Override
        public View initView() {
            View contentView = View.inflate(OtherActivity.this, R.layout.item_img, null);
            imageView = (ImageView) contentView.findViewById(R.id.imageview);
            return contentView;
        }


        @Override
        public void refreshView(Integer imagRes) {
            this.imageView.setImageResource(imagRes);
        }
    }
}
