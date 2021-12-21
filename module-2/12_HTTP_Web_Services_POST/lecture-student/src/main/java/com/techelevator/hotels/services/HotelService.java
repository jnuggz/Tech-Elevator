package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */


  public Reservation addReservation(String newReservation) {
    //build the reservation object
    Reservation reservation = makeReservation(newReservation);
    if(reservation == null) {
      return null;
    }
    //set up the http header for the request
    HttpHeaders headers = new HttpHeaders();
    //set the content type
    headers.setContentType(MediaType.APPLICATION_JSON);
    //use http header to build the HttpEntity reservation object with the reservation object and header
    HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers);
    //try the request http://localhost:3000/reservations
    /*
      First possible problem: error status code like 4xx or 5xx (RestClientResponseException)
        -got a response but also an error
      Second possible problem: can't connect to API (ResourceAccessException)
        -couldn't get a response ("Connection refused")
     */
    try {
      reservation = restTemplate.postForObject(BASE_URL + "reservations", entity, Reservation.class);
    } catch (RestClientResponseException e) {
      console.printError(e.getRawStatusCode() + " : " + e.getStatusText());
    } catch (ResourceAccessException e) {
      console.printError(e.getMessage());
    }
    return reservation;
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param CSV
   * @return
   */

  public Reservation updateReservation(String CSV) {
    //build the reservation object
    Reservation reservation = makeReservation(CSV);
    //build the header and set content type
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    //build the entity - give it the object and the info regarding the request
    HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers);
    //make request at endpoint http://localhost:3000/reservations/{id}
    int reservationId = reservation.getId();
    try{
      restTemplate.put(BASE_URL + "reservations/" + reservationId, entity);
    } catch (RestClientResponseException e) {
      console.printError(e.getRawStatusCode() + ":" + e.getStatusText());
    } catch (ResourceAccessException e) {
      console.printError(e.getMessage());
    }
    return reservation;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    //endpoint for delete http://localhost:3000/reservations/{id}
    try {
      restTemplate.delete(BASE_URL + "reservations/" + id);
    } catch (RestClientResponseException e) {
      console.printError(e.getRawStatusCode() + ":" + e.getStatusText());
    } catch (ResourceAccessException e) {
      console.printError(e.getMessage());
    }
  }

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    /*
      First possible problem: error status code like 4xx or 5xx (RestClientResponseException)
        -got a response but also an error
      Second possible problem: can't connect to API (ResourceAccessException)
        -couldn't get a response ("Connection refused")
     */
    Hotel[] hotels = null;

    try{
      hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException e) {
      console.printError(e.getRawStatusCode() + " : " + e.getStatusText());
    } catch (ResourceAccessException e) {
      console.printError(e.getMessage());
    }


    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    /*
      Error status code (404, 500)
      Cannot connect
     */
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException e) {
      //Occurs when you get a 4xx or 5xx status code
      //getRawStatusCode gets just the code ie. 404
      //getStatusText gets the string ie Bad Request, Not Found
      console.printError(e.getRawStatusCode() + " : " + e.getStatusText());
    } catch (ResourceAccessException e) {
      //Occurs when a connection cannot be made
      console.printError("Could not connect to APU");
    }

    return hotel;
  }




    /* DON'T MODIFY ANY METHODS BELOW */
  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
