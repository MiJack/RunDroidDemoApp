package cn.mijack.rundroiddemo;

/**
 * @author Mi&Jack
 */
public class RunThread extends Thread {

    private int num;

    public RunThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        com.mijack.Xlog.logMethodEnter("void cn.mijack.rundroiddemo.RunThread.run()",this);try{System.out.println(num + num);com.mijack.Xlog.logMethodExit("void cn.mijack.rundroiddemo.RunThread.run()",this);}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.mijack.rundroiddemo.RunThread.run()",this,throwable);throw throwable;}
    }
}
