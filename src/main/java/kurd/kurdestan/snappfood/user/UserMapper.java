package kurd.kurdestan.snappfood.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<User> toUserList(List<UserDTO> userDTOList);
    List<UserDTO> toUserDTOList(List<User> userList);

}
