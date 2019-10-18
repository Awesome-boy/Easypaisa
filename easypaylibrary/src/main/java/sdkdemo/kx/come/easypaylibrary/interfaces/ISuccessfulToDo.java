package sdkdemo.kx.come.easypaylibrary.interfaces;


import sdkdemo.kx.come.easypaylibrary.bean.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.RedirectBean;

public interface ISuccessfulToDo {

    void toDoSomething(RedirectBean redirectBean, String data);
}
