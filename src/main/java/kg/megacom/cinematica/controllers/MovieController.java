package kg.megacom.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.cinematica.exceptions.RoomMovieException;
import kg.megacom.cinematica.models.dtos.CinemaDto;
import kg.megacom.cinematica.models.dtos.MovieDto;
import kg.megacom.cinematica.models.responses.MovieInfoResponse;
import kg.megacom.cinematica.models.responses.MovieResponse;
import kg.megacom.cinematica.models.responses.SessionsResponse;
import kg.megacom.cinematica.services.CinemaService;
import kg.megacom.cinematica.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Api(tags = "Movie")
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody MovieDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всего")
    ResponseEntity<List<MovieDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getMovies")
    @ApiOperation("Вывод фильмов (limit, offset)")
    ResponseEntity<List<MovieResponse>> getMovies(@RequestParam int limit, @RequestParam int offset){
        return ResponseEntity.ok(service.getMovies(limit, offset));
    }


    @GetMapping("/getSessionsInfo")
    @ApiOperation("Вывод информации по фильму")
    ResponseEntity<SessionsResponse> getSessionsInfo(@RequestParam int id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        try {
            return new ResponseEntity(service.getSession(id, date), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
