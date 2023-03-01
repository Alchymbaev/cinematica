package kg.megacom.cinematica.services;

import kg.megacom.cinematica.models.dtos.SeatScheduleDto;
import kg.megacom.cinematica.models.responses.SeatScheduleResponse;

import java.util.List;

public interface SeatScheduleService extends BaseService<SeatScheduleDto>{
    List<SeatScheduleResponse> getSetSchedule(Long roomMovieID);
}
