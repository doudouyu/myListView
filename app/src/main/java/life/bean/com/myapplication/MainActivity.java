package life.bean.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);


        for (int i = 0; i < 40; i++) {
            stringList.add("position = " + i);
        }

        listView.setAdapter(new MainAdapter(stringList));
    }

    public void click(View view) {
        startActivity(new Intent(this, OtherActivity.class));

    }

    class MainAdapter extends DefaultAdapter<String> {


        public MainAdapter(List<String> datas) {
            super(datas);
        }

        @Override
        public BaseHolder<String> getHolder() {
            return new MainHolder();
        }
    }

    public class MainHolder extends BaseHolder<String> {
        public TextView textView;

        @Override
        public View initView() {
            View contentView = View.inflate(MainActivity.this, R.layout.item_string, null);
            textView = (TextView) contentView.findViewById(R.id.textview);
            return contentView;
        }


        @Override
        public void refreshView(String s) {
            this.textView.setText(s);
        }
    }

}
