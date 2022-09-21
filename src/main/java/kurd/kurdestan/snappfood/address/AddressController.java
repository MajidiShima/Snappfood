package kurd.kurdestan.snappfood.address;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/address")
public class AddressController {
    private final IAddressService addressService;
    private AddressMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO) {
        Address address = mapper.toAddress(addressDTO);
        addressService.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/v1")
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        Address address  = mapper.toAddress(addressDTO);
        addressService.update(address);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1")
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<Address> address =addressService.getAll();
        List<AddressDTO> list = mapper.toAddressListDTO(address);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/v1/Title/{title}")
    public ResponseEntity<List<AddressDTO>> getAllByTitle(@PathVariable String title) {
        List<Address> addressList= addressService.getAllByTitle(title);
       List<AddressDTO> addressDTOList= mapper.toAddressListDTO(addressList);
        return ResponseEntity.ok(addressDTOList);
    }


    @GetMapping("/v1/id/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
        Address address = addressService.getById(id);
        AddressDTO addressDTO= mapper.toAddressDTO(address);
        return ResponseEntity.ok(addressDTO);
    }

    @GetMapping("/v1/get-by-user/{id}")
    public ResponseEntity<List<AddressDTO>> getAllByUserId(@PathVariable Long id) {

        List<Address> addressList = addressService.getAllByUserId(id);
        List<AddressDTO> addressDTOList = mapper.toAddressListDTO(addressList);
        return ResponseEntity.ok(addressDTOList);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private ResponseEntity delete(@PathVariable Long id){
      addressService.delete(id);
      return ResponseEntity.ok().build();
    }

}
