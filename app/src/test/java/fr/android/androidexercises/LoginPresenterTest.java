package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginActivity activity;

    @InjectMocks LoginPresenter loginPresenter;

    @Test
    public void password_should_be_valid() throws Exception {
        loginPresenter.checkCredentials("password");

        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void password_should_be_null() throws Exception {
        loginPresenter.checkCredentials(null);

        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void password_should_be_too_short() throws Exception {
        loginPresenter.checkCredentials("ae");

        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

}
