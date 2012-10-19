package com.hellomvp.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface DBConnection extends RemoteService 
{
  public boolean AuthenticateUser(String user, 
                                  String pass);
}
