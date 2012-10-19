package com.hellomvp.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SameRandomNumberPlace extends Place {

  public SameRandomNumberPlace(int range)
  {
    this.range = range;
  }
  
  public int getRange()
  {
    return range;
  }
  
  public static class Tokenizer implements PlaceTokenizer<SameRandomNumberPlace> {

    @Override
    public String getToken(SameRandomNumberPlace place) 
    {
      return place.getRange() + "";
    }

    @Override
    public SameRandomNumberPlace getPlace(String token) 
    {
      return new SameRandomNumberPlace(Integer.parseInt(token));
    }
  }

  private int range;
}
