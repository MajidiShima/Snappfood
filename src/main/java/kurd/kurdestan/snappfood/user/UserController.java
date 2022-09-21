package kurd.kurdestan.snappfood.user;

import kurd.kurdestan.snappfood.food.Food;
import kurd.kurdestan.snappfood.food.FoodDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/")
public class UserController {

    private IUserService service;
    private UserMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {

        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        service.update(user);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = (User) service.getById(id);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/v1/title/{name}")
    public ResponseEntity<UserDTO> getAllByName(@PathVariable String name) {
        User user = (User) service.getAllByName(name);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-by-phone/{phone}")
    public ResponseEntity<UserDTO> getByPhone(@PathVariable Long phone) {
        User user = service.getByPhone(phone);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


}
