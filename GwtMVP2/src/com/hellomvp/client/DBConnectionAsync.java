package com.hellomvp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DBConnectionAsync 
{
  void AuthenticateUser(String user, 
                        String pass,
                        AsyncCallback<Boolean> callback);

}
