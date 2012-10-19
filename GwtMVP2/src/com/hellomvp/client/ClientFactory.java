package com.hellomvp.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.hellomvp.client.ui.GoodbyeView;
import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.SameRandomView;

public interface ClientFactory {
  EventBus getEventBus();

  PlaceController getPlaceController();

  HelloView getHelloView();

  GoodbyeView getGoodbyeView();
  
  SameRandomView getSameRandomView();
}
