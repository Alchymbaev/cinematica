package kg.megacom.cinematica.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public interface MovieInfoResponse {
    Long getId();
    String getMovieName();
    String getDescription();
    int getPg();
    String getImage();
    Long getCinemaID();
    String getCinemaName();
    Long getRoomID();
    String getRoomName();
    Long getSessionID();
    double getStandartPrice();
    double getChildPrice();
    Date getStart_date_time();
}
