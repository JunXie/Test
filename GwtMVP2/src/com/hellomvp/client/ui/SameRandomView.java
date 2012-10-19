package com.hellomvp.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface SameRandomView extends IsWidget{
  
  void setRandomNumber(int randomNumber);
  void setPresenter(Presenter listener);
  
  public interface Presenter
  {
    void goTo(Place place);
    int getRange();
  }

}
