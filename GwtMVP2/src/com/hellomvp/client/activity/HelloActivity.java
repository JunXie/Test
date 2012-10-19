package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.ClientFactory;
import com.hellomvp.client.DBConnection;
import com.hellomvp.client.DBConnectionAsync;
import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.ui.HelloView;

public class HelloActivity extends AbstractActivity implements
    HelloView.Presenter {
  // Used to obtain views, eventBus, placeController
  // Alternatively, could be injected via GIN
  private ClientFactory clientFactory;
  // Name that will be appended to "Hello,"
  private String name;
  private int randomNumber;
  private int range;
  private boolean hasBeenGenerated;
  private DBConnectionAsync rpc;
  
  public HelloActivity(HelloPlace place, ClientFactory clientFactory) {
    this.name = place.getHelloName();
    this.clientFactory = clientFactory;
    this.randomNumber = 0;
    this.range = 20;
    this.hasBeenGenerated = false;
    
    rpc = (DBConnectionAsync) GWT.create(DBConnection.class);
    ServiceDefTarget target = (ServiceDefTarget) rpc;
    // The path 'MySQLConnection' is determined in ./public/LoginScreen.gwt.xml
    // This path directs Tomcat to listen for this context on the server side,
    // thus intercepting the rpc requests.
    String moduleRelativeURL = GWT.getModuleBaseURL() + "MySQLConnection";
    target.setServiceEntryPoint(moduleRelativeURL);
  }
  
  /**
   * Invoked by the ActivityManager to start a new Activity
   */
  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    HelloView helloView = clientFactory.getHelloView();
    helloView.setName(name);
    helloView.setPresenter(this);
    containerWidget.setWidget(helloView.asWidget());
  }

  /**
   * Ask user before stopping this activity
   */
  @Override
  public String mayStop() {
    return "Please hold on. This activity is stopping.";
  }

  /**
   * Navigate to a new Place in the browser
   */
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
  
  /**
   * Generate a random number for the first time and 
   * show the same number if called for later calls 
   */
  public int showRandomNumber()
  {
    if (!hasBeenGenerated)
    {
      hasBeenGenerated = true;
      randomNumber = (int)(Math.random()*100);
    }
    return randomNumber;
  }
  
  public int getRange()
  {
    return range;
  }

  @Override
  public void AuthenticateUser(String user, String pass) 
  {
    rpc.AuthenticateUser(user, pass, new AsyncCallback<Boolean>()
        {

          @Override
          public void onFailure(Throwable caught) {
            Window.alert("Wrong user name and or password");
          }

          @Override
          public void onSuccess(Boolean result) {
            // TODO Auto-generated method stub
            Window.alert("Login success!");
          }
        });
  }
}
