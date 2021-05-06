package uz.instat.footballmatch.ui.match;

public abstract class MyCallBack<T> {

    public abstract void onSuccess(T t);

    public abstract void onError(String message);
}
