package businessentities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import nl.fontys.sebivenlo.sebiannotations.ID;

/**
 *
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
public class Flight implements Serializable {

    @ID
    String flightid;
    Airport departure_iata;
    Airport arrives_iata;
    LocalDateTime estimatedDeparture;
    LocalDateTime estimatedArival;
    String airplaneModel;

    public Flight( String flightid, Airport departure_iata, Airport arrives_iata,
                   LocalDateTime estimatedDeparture,
                   LocalDateTime estimatedArival ) {
        this.flightid = flightid;
        this.departure_iata = departure_iata;
        this.arrives_iata = arrives_iata;
        this.estimatedDeparture = estimatedDeparture;
        this.estimatedArival = estimatedArival;
    }

    public String getFlightid() {
        return flightid;
    }

    public Airport getDeparture_iata() {
        return departure_iata;
    }

    public Airport getArrives_iata() {
        return arrives_iata;
    }

    public LocalDateTime getEstimatedDeparture() {
        return estimatedDeparture;
    }

    public LocalDateTime getEstimatedArival() {
        return estimatedArival;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode( this.flightid );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Flight other = (Flight) obj;
        if ( !Objects.equals( this.flightid, other.flightid ) ) {
            return false;
        }
        return true;
    }

}
