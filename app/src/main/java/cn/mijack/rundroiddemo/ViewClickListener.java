package cn.mijack.rundroiddemo;

import android.view.View;
import android.widget.EditText;

import java.util.Random;

/**
 * @author Mi&Jack
 */
public class ViewClickListener implements View.OnClickListener {
    private final EditText editText1;
    private final EditText editText2;

    public ViewClickListener(EditText editText1, EditText editText2) {
        this.editText1 = editText1;
        this.editText2 = editText2;
    }

    @Override
    public void onClick(View v) {
        com.mijack.Xlog.logMethodEnter("void cn.mijack.rundroiddemo.ViewClickListener.onClick(android.view.View)",this,v);try{int x = readX();
        int y = readY();
        if (x > 0) {
            if (y < 0) {
                y = 2;
            }
            if (y > 0) {
                RunThread runThread = new RunThread(y);
                runThread.start();
            }
        }com.mijack.Xlog.logMethodExit("void cn.mijack.rundroiddemo.ViewClickListener.onClick(android.view.View)",this);}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.mijack.rundroiddemo.ViewClickListener.onClick(android.view.View)",this,throwable);throw throwable;}
    }

    private int readX() {
        com.mijack.Xlog.logMethodEnter("int cn.mijack.rundroiddemo.ViewClickListener.readX()",this);try{int random = new Random().nextInt(10);
        if (random > 100) {
            {com.mijack.Xlog.logMethodExit("int cn.mijack.rundroiddemo.ViewClickListener.readX()",this,1);return -1;}
        }
        {com.mijack.Xlog.logMethodExit("int cn.mijack.rundroiddemo.ViewClickListener.readX()",this,2);return Integer.parseInt(editText1.getText().toString());}}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("int cn.mijack.rundroiddemo.ViewClickListener.readX()",this,throwable);throw throwable;}
    }

    private int readY() {
        com.mijack.Xlog.logMethodEnter("int cn.mijack.rundroiddemo.ViewClickListener.readY()",this);try{int random = new Random().nextInt(10);
        if (random > 100) {
            {com.mijack.Xlog.logMethodExit("int cn.mijack.rundroiddemo.ViewClickListener.readY()",this,1);return -1;}
        }
        {com.mijack.Xlog.logMethodExit("int cn.mijack.rundroiddemo.ViewClickListener.readY()",this,2);return Integer.parseInt(editText2.getText().toString());}}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("int cn.mijack.rundroiddemo.ViewClickListener.readY()",this,throwable);throw throwable;}
    }
}
