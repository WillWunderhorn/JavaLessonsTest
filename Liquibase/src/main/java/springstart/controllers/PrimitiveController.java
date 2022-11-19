package springstart.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springstart.models.PrimitiveInfo;
import springstart.repo.PrimitiveInfoRepo;

import java.util.List;

@AllArgsConstructor
@RestController
public class PrimitiveController {

    PrimitiveInfo objects;

    private final PrimitiveInfoRepo repo;

    @GetMapping("/primitiveInfo")
    List<PrimitiveInfo> all(){
        return objects.findAll();
    }
    @PostMapping("/primitiveInfo")
    PrimitiveInfo newInfo(@RequestBody PrimitiveInfo newInfo){
        return repo.save(newInfo);
    }
    @PutMapping("/primitiveInfo/{id}")
    PrimitiveInfo replaceInfo(@RequestBody PrimitiveInfo newInfo, @PathVariable Long id) {
        return repo.findById(id).map(info -> {
            info.setMessage(newInfo.getMessage());
            return repo.save(info);
        }).orElseGet(() -> {
            newInfo.setId(id);
            return repo.save(newInfo);
        });
    }
    @DeleteMapping("/primitiveInfo/{id}")
    void delInfo(@PathVariable Long id){
        repo.deleteById(id);
    }

}
