package com.amadeus;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.urls.CheckinLinks;
import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.travel.analytics.FareSearches;
import com.amadeus.travel.analytics.airTraffic.Traveled;
import org.junit.Test;

public class NamespaceTest {
  @Test public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    assertNotNull(client.referenceData.urls.checkinLinks);
    assertNotNull(client.travel.analytics.airTraffic.traveled);
    assertNotNull(client.travel.analytics.fareSearches);
    assertNotNull(client.shopping.flightDates);
    assertNotNull(client.shopping.flightDestinations);
    assertNotNull(client.shopping.flightOffers);
  }

  @Test public void testGetMethods() throws ResponseException {
    Amadeus client = mock(Amadeus.class);
    Params params = Params.with("airline", "1X");

    when(client.get("/v2/reference-data/urls/checkin-links", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v2/reference-data/urls/checkin-links", params))
            .thenReturn(mock(Response.class));
    CheckinLinks checkinLinks = new CheckinLinks(client);
    assertTrue(checkinLinks.get() instanceof Response);
    assertTrue(checkinLinks.get(params) instanceof Response);

    when(client.get("/v1/travel/analytics/air-traffic/traveled", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/travel/analytics/air-traffic/traveled", params))
            .thenReturn(mock(Response.class));
    Traveled traveled = new Traveled(client);
    assertTrue(traveled.get() instanceof Response);
    assertTrue(traveled.get(params) instanceof Response);

    when(client.get("/v1/travel/analytics/fare-searches", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/travel/analytics/fare-searches", params))
            .thenReturn(mock(Response.class));
    FareSearches fareSearches = new FareSearches(client);
    assertTrue(fareSearches.get() instanceof Response);
    assertTrue(fareSearches.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-dates", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-dates", params))
            .thenReturn(mock(Response.class));
    FlightDates flightDates = new FlightDates(client);
    assertTrue(flightDates.get() instanceof Response);
    assertTrue(flightDates.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-destinations", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-destinations", params))
            .thenReturn(mock(Response.class));
    FlightDestinations flightDestinations = new FlightDestinations(client);
    assertTrue(flightDestinations.get() instanceof Response);
    assertTrue(flightDestinations.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-offers", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-offers", params))
            .thenReturn(mock(Response.class));
    FlightOffers flightOffers = new FlightOffers(client);
    assertTrue(flightOffers.get() instanceof Response);
    assertTrue(flightOffers.get(params) instanceof Response);
  }
}
