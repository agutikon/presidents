package com.presidents.controller;

import com.presidents.model.dto.PresidentDto;
import com.presidents.service.president.PresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping("presidents")
@RestController
@RequiredArgsConstructor
public class PresidentsController {
    private final PresidentService presidentService;

    @GetMapping("all")
    public List<PresidentDto> getAll() {
        return presidentService.getAllPresidents();
    }

    @GetMapping("/all-paginated")
    public List<PresidentDto> getPresidentsPaginated(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return presidentService.getAllPresidentsPaginated(pageNumber, pageSize).getContent();
    }

    @GetMapping("find/{name}")
    public Set<PresidentDto> findPresidentsByName(@PathVariable String name){
        return presidentService.findPresidentsByName(name);
    }

    @GetMapping("find-by-party/{party}")
    public Set<PresidentDto> findPresidentsByParty(@PathVariable String party ){
       return presidentService.findPresidentsByParty(party);
    }


    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public PresidentDto save(@Valid @RequestBody PresidentDto presidentDto) {
        return presidentService.savePresident(presidentDto);
    }
    @PutMapping("update")
    public PresidentDto update(@Valid @RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresident(presidentDto);
    }
//    Wyjątek ogarnięty w celach dydaktycznych, finalnie zrobione inną metodą
//    @ExceptionHandler({RuntimeException.class, IllegalAccessError.class})
//    public final ResponseEntity<Object> handleExceptions(Exception ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @PatchMapping("update")
    public PresidentDto updatePartial(@RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresidentPartial(presidentDto);
    }
    @DeleteMapping("delete/{id}")
    public void deleteByName(@PathVariable Long id){
     presidentService.deletePresident(id);
    }

}


//    @PutMapping("update")
//    public String updateWithBodyOnly(@RequestBody President president) {
//        if (PresidentsDB.presidentsRepository.size() - 1 < president.getId()) {
//            president.setId(Integer.valueOf(PresidentsDB.presidentsRepository.size()).longValue());
//            PresidentsDB.presidentsRepository.add(president);
//        } else {
//            PresidentsDB.presidentsRepository.set(president.getId().intValue(), president);
//        }
//        return "Updated";
//    }

//    @PutMapping("update/{id}")
//    public String update(@PathVariable("id") Long id,
//                         @RequestBody President president) {
//        PresidentsDB.presidentsRepository.set(Math.toIntExact(id), president);
//
//        return "updated by id";
//    }
//    @PutMapping("update")
//    public String updateWithBodyOnly(@RequestBody President president) {
//        if (PresidentsDB.presidentsRepository.size() - 1 < president.getId()){
//           president.setId((long) PresidentsDB.presidentsRepository.size());
//            PresidentsDB.presidentsRepository.add(president);
//        }else {
//            PresidentsDB.presidentsRepository.set(Math.toIntExact(president.getId()), president);
//        }
//        PresidentsDB.presidentsRepository.set(Math.toIntExact(president.getId()), president);
//        return "updated with body only";
//    }
//    @PatchMapping("partial-update")
//    public String updatedPartial(@RequestBody President president){
//        President p = PresidentsDB.presidentsRepository.get(Math.toIntExact(president.getId()));
//
//        if(president.getName() != null) p.setName(president.getName());
//        if(president.getSurname() != null) p.setSurname(president.getSurname());
//
//        return "updated partial patch";
//    }


