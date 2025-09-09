package info.mointeng.dashboard.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import info.mointeng.dashboard.Entity.UserEntity;
import info.mointeng.dashboard.Repository.UserRepository;
import info.mointeng.dashboard.Model.UserDTO;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserByID(String strId) {
        UUID id = UUID.fromString(strId);
        return userRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        UserEntity user = convertToEntity(userDto);
        UserEntity savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(String strId, UserDTO userDto) {
        UUID id = UUID.fromString(strId);
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setAccount(userDto.account());
        user.setPassword(userDto.password());
        UserEntity savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    private UserDTO convertToDTO(UserEntity user) {
        return new UserDTO(
                user.getId(), 
                user.getAccount(),
                user.getPassword()
            );
    }

    private UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity entity = new UserEntity();
        entity.setAccount(userDTO.account());
        entity.setId(userDTO.id());
        entity.setPassword(userDTO.password());
        return entity;
    }
}