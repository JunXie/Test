package com.hellomvp.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.hellomvp.client.ui.GoodbyeView;
import com.hellomvp.client.ui.GoodbyeViewImpl;
import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.HelloViewImpl;
import com.hellomvp.client.ui.SameRandomView;
import com.hellomvp.client.ui.SameRandomViewImpl;

public class ClientFactoryImpl implements ClientFactory {
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(
      eventBus);
  private static final HelloView helloView = new HelloViewImpl();
  private static final GoodbyeView goodbyeView = new GoodbyeViewImpl();
  private static final SameRandomView sameRandomView = new SameRandomViewImpl();

  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public HelloView getHelloView() {
    return helloView;
  }

  @Override
  public PlaceController getPlaceController() {
    return placeController;
  }

  @Override
  public GoodbyeView getGoodbyeView() {
    return goodbyeView;
  }

  @Override
  public SameRandomView getSameRandomView() {
    return sameRandomView;
  }

}
