package de.workshop.client;

import com.google.gwt.core.client.EntryPoint;

import de.workshop.client.presenter.SamplePresenter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtEditor implements EntryPoint {

  public void onModuleLoad() {
      SamplePresenter presenter = new SamplePresenter();
  }
}
