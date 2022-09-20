package kurd.kurdestan.snappfood.user;

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
    public ResponseEntity save(@RequestBody UserDTO userDTO) {

        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        service.update(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/title/{title}")
    public ResponseEntity<UserDTO> getAllByName(@PathVariable String title){
       User user  = (User) service.getAllByName(title);
        UserDTO  userDTO=mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
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
