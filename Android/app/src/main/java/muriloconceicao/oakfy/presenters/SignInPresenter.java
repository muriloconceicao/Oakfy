package muriloconceicao.oakfy.presenters;

import muriloconceicao.oakfy.bases.BasePresenter;
import muriloconceicao.oakfy.views.SignInView;

public interface SignInPresenter extends BasePresenter<SignInView> {
    void login(String email, String password);
}