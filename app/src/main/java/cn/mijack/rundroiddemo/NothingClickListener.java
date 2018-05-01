package cn.mijack.rundroiddemo;

import android.view.View;
import android.widget.EditText;

/**
 * @author Mi&Jack
 */
class NothingClickListener implements View.OnClickListener {
    public NothingClickListener() {
    }

    @Override
    public void onClick(View v) {
        com.mijack.Xlog.logMethodEnter("void cn.mijack.rundroiddemo.NothingClickListener.onClick(android.view.View)",this,v);try{ int i=0;
        i++;com.mijack.Xlog.logMethodExit("void cn.mijack.rundroiddemo.NothingClickListener.onClick(android.view.View)",this);}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.mijack.rundroiddemo.ViewClickListener.onClick(android.view.View)",this,throwable);throw throwable;}
    }
}
