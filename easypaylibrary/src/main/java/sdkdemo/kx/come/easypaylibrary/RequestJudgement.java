package sdkdemo.kx.come.easypaylibrary;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sdkdemo.kx.come.easypaylibrary.httpService.HttpResponse;

public class RequestJudgement {
    public static <T> ObservableTransformer<T, T> transformerToMain() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static<T > ObservableTransformer<T, T> respFilter() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io()).onErrorResumeNext(
                        err -> {
                            return Observable.just((T) new HttpResponse<>(HttpResponse.NOT_FOUND, err.getMessage()));
                        }
                ).observeOn(AndroidSchedulers.mainThread()).filter(resp -> {

                    return true;
                }).observeOn(AndroidSchedulers.mainThread());
    }

    public static  <T extends HttpResponse> ObservableTransformer<T, T> respFilterWithoutTips() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io()).onErrorResumeNext(
                        err -> {
                            return Observable.just((T) new HttpResponse<>(HttpResponse.NOT_FOUND, err.getMessage()));
                        }
                ).filter(resp -> {

                        return true;

                }).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T extends HttpResponse> ObservableTransformer<T, T> respFilterIgnore() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io()).onErrorResumeNext(
                        err -> {
                            return Observable.just((T) new HttpResponse<>(HttpResponse.NOT_FOUND, err.getMessage()));
                        }
                ).observeOn(AndroidSchedulers.mainThread());
    }
}
