package zjm.cst.dhu.hotfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    public TestActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        TextView tv=(TextView) findViewById(R.id.text);
        tv.setText("is a test");
        System.out.println("==========start===============");
        new Test();
        System.out.println("==========end===============");
    }
}
