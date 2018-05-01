package cn.mijack.rundroiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * @author Mi&Jack
 */
public class MainActivity extends Activity {

    EditText editText1;
    EditText editText2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        com.mijack.Xlog.logMethodEnter("void cn.mijack.rundroiddemo.MainActivity.onCreate(android.os.Bundle)",this,savedInstanceState);try{super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btn = findViewById(R.id.btn);
        int randon = new Random().nextInt(10);
        if (randon < 1000) {
            btn.setOnClickListener(new NothingClickListener());
        }
        if (randon < 100) {
            btn.setOnClickListener(new ViewClickListener(editText1, editText2));
        }com.mijack.Xlog.logMethodExit("void cn.mijack.rundroiddemo.MainActivity.onCreate(android.os.Bundle)",this);}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.mijack.rundroiddemo.MainActivity.onCreate(android.os.Bundle)",this,throwable);throw throwable;}
    }
}
