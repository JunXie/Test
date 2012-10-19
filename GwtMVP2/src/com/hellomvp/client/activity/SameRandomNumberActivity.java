package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.ClientFactory;
import com.hellomvp.client.place.SameRandomNumberPlace;
import com.hellomvp.client.ui.SameRandomView;

public class SameRandomNumberActivity extends AbstractActivity 
implements SameRandomView.Presenter 
{
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    // TODO Auto-generated method stub
    SameRandomView sameRandomView = clientFactory.getSameRandomView();
    sameRandomView.setRandomNumber(getRandomNumber());
    sameRandomView.setPresenter(this);
    panel.setWidget(sameRandomView.asWidget());
    
//    SameRandomView sameRandomView = clientFactory.getSameRandomView();
//    sameRandomView.setPresenter(this);
//    int sameRandom = getSameRandomNumber();
//    sameRandomView.setSameRandom(sameRandom);
//    containerWidget.setWidget(sameRandomView.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

  @Override
  public int getRange() {
    return range;
  }

  public SameRandomNumberActivity(SameRandomNumberPlace sameRandomNumberPlace,
                                  ClientFactory clientFactory)
  {
    this.range = sameRandomNumberPlace.getRange();
    this.clientFactory = clientFactory;
    this.hasBeenGenerated = false;
  }
  
  public int getRandomNumber()
  {
    if (!hasBeenGenerated)
    {
      hasBeenGenerated = true;
      randomNumber = (int)(Math.random()*range);
    }
    return randomNumber;
  }
  
  private int randomNumber;
  private boolean hasBeenGenerated;
  private int range;
  private ClientFactory clientFactory;
}
