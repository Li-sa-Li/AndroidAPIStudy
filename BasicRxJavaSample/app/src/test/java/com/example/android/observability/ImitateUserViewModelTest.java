package com.example.android.observability;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.android.observability.demoTest.ImitateUserDataSource;
import com.example.android.observability.demoTest.persisitence.ImitateUser;
import com.example.android.observability.demoTest.ui.ImitateUserViewModel;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Completable;
import io.reactivex.Flowable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImitateUserViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private ImitateUserDataSource imitateUserDataSource;

    @Captor
    private ArgumentCaptor<ImitateUser> imitateUserArgumentCaptor;

    private ImitateUserViewModel imitateUserViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        imitateUserViewModel = new ImitateUserViewModel(imitateUserDataSource);
    }

    @Test
    public void getUserName_whenNoUserSaved() {
        when(imitateUserDataSource.getUser()).thenReturn(Flowable.empty());
        imitateUserViewModel.getUserName().test().assertNoValues();
    }

    @Test
    public void getUserName_whenUserSaved() {
        ImitateUser imitateUser = new ImitateUser("li li");
        when(imitateUserDataSource.getUser()).thenReturn(Flowable.just(imitateUser));
        imitateUserViewModel.getUserName().test().assertValue("li li");
    }

    @Test
    public void updateUserName_updatesNameInDataSource() {
        when(imitateUserDataSource.insertOrUpdateUser(any())).thenReturn(Completable.complete());
        imitateUserViewModel.setUserName("li sa li").test().assertComplete();

        verify(imitateUserDataSource).insertOrUpdateUser(imitateUserArgumentCaptor.capture());
        assertThat(imitateUserArgumentCaptor.getValue().getUserName(), Matchers.is("li sa li"));
    }
}
