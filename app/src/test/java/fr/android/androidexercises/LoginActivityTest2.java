package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

/**
 * Created by ludovic on 21/02/2017.
 */

@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest2 {

    LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception{
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception{
        //Given
        //When
        loginActivity.logged();

        //Then
        Assertions.assertThat(loginActivity.loginLayout).isGone();
        Assertions.assertThat(loginActivity.loggedText).isVisible();
    }

    @Test
    public void should_set_not_logged_state() throws Exception{
        //Given
        //When
        loginActivity.notLogged();

        //Then
        Assertions.assertThat(loginActivity.loginLayout).isVisible();
        Assertions.assertThat(loginActivity.loggedText).isGone();
    }
}
