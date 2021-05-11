package businessentities;

import java.io.Serializable;
import java.util.Objects;
import nl.fontys.sebivenlo.sebiannotations.ID;

/**
 *
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
public class Airport implements Serializable {

    @ID
    Integer id;
    String ident;
    String type;
    String name;
    String latitude_deg;
    String longitude_deg;
    String elevation_ft;
    String continent;
    String iso_country;
    String iso_region;
    String municipality;
    String scheduled_service;
    String gps_code;
    String iata_code;
    String local_code;
    String home_link;
    String wikipedia_link;
    String keywords;

    public Airport( Integer id, String ident, String type, String name, String latitude_deg, String longitude_deg, String elevation_ft, String continent, String iso_country, String iso_region, String municipality, String scheduled_service, String gps_code, String iata_code, String local_code, String home_link, String wikipedia_link, String keywords ) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.latitude_deg = latitude_deg;
        this.longitude_deg = longitude_deg;
        this.elevation_ft = elevation_ft;
        this.continent = continent;
        this.iso_country = iso_country;
        this.iso_region = iso_region;
        this.municipality = municipality;
        this.scheduled_service = scheduled_service;
        this.gps_code = gps_code;
        this.iata_code = iata_code;
        this.local_code = local_code;
        this.home_link = home_link;
        this.wikipedia_link = wikipedia_link;
        this.keywords = keywords;
    }

    public Integer getId() {
        return id;
    }

    public String getIdent() {
        return ident;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getLatitude_deg() {
        return latitude_deg;
    }

    public String getLongitude_deg() {
        return longitude_deg;
    }

    public String getElevation_ft() {
        return elevation_ft;
    }

    public String getContinent() {
        return continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getScheduled_service() {
        return scheduled_service;
    }

    public String getGps_code() {
        return gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public String getHome_link() {
        return home_link;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode( this.iata_code );
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
        final Airport other = (Airport) obj;
        if ( !Objects.equals( this.iata_code, other.iata_code ) ) {
            return false;
        }
        return true;
    }
}
