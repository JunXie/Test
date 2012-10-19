package com.hellomvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SameRandomViewImpl extends Composite 
implements SameRandomView 
{

  private static SameRandomViewImplUiBinder uiBinder = GWT.create(SameRandomViewImplUiBinder.class);

  interface SameRandomViewImplUiBinder extends UiBinder<Widget, SameRandomViewImpl>
  {
  }
 
  public SameRandomViewImpl()
  {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter listener) {
    // TODO Auto-generated method stub
    presenter = listener;
  }
  
  @Override
  public void setRandomNumber(int randomNumber) {
    this.randomNumber.setInnerText(randomNumber + "");
  }
  
  @UiField 
  DivElement randomNumber;
  
  @UiField 
  Button showRangeButton;
  
  @UiHandler("showRangeButton")
  void onClickShowRangeButton(ClickEvent e)
  {
    Window.alert(presenter.getRange() + "");
  }
  
  private Presenter presenter;
}
