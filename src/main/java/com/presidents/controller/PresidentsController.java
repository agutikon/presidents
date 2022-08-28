package com.presidents.controller;


import com.presidents.model.President;
import com.presidents.repository.PresidentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("presidents")
@RestController
@RequiredArgsConstructor
public class PresidentsController {

    private final PresidentsRepository presidentsRepository;
    @GetMapping("/all")
    public List<President> getAll() {
        return presidentsRepository.findAll();
    }
//
//    @PostMapping("save")
//    public President save(@RequestBody President president) {
//        PresidentsDB.presidentsRepository.add(president);
//        return president;
//    }
//
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
//    @DeleteMapping("delete/{id}")
//    public String deleteById(@PathVariable Long id){
//        PresidentsDB.presidentsRepository.remove(id);
//        return "deleted";
//    }
}


