package info.mointeng.dashboard.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import info.mointeng.dashboard.Model.UserDTO;

@Service
public interface UserService {

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserByID(String id);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(String id, UserDTO userDTO);

    // void deleteUser(UUID id);
}
