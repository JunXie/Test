package com.hellomvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.SameRandomNumberPlace;

public class HelloViewImpl extends Composite implements HelloView
{
	private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

	interface HelloViewImplUiBinder extends UiBinder<Widget, HelloViewImpl>
	{
	}

	@UiField SpanElement nameSpan;
	@UiField Anchor goodbyeLink;
	@UiField Anchor sameRandomNumber;
	@UiField Button generateRandomNumberButton;
	@UiField TextBox userName;
	@UiField TextBox password;
	@UiField Button LoginButton;
	
	private Presenter presenter;
	private String name;

	public HelloViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
		nameSpan.setInnerText(name);
	}

	@UiHandler("goodbyeLink")
	void onClickGoodbye(ClickEvent e)
	{
		presenter.goTo(new GoodbyePlace(name));
	}
	
	@UiHandler("LoginButton")
  void onClickLoginButton(ClickEvent e)
  {
	  presenter.AuthenticateUser(userName.getText(), password.getText());
  }
	
	@UiHandler("sameRandomNumber")
	void onClickSameRandomNumber(ClickEvent e)
  {
    presenter.goTo(new SameRandomNumberPlace(presenter.getRange()));
  }
	
	
	@UiHandler("generateRandomNumberButton")
  void onClickGenerateRandomNumber(ClickEvent e)
  {
	  Window.alert("Random number is: " + presenter.showRandomNumber());
  }

	@Override
	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}
}
