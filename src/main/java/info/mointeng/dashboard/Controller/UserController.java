package info.mointeng.dashboard.Controller;

import info.mointeng.dashboard.Model.UserDTO;
import info.mointeng.dashboard.Service.UserService;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import info.mointeng.dashboard.DTO.SuccessResponseDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public SuccessResponseDTO<List<UserDTO>> getAllUsers() {
        List<UserDTO> list = this.userService.getAllUsers();
        return new SuccessResponseDTO<List<UserDTO>>(true, list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> updateProduct(@PathVariable String id, @RequestBody UserDTO userDto) {
        Optional<UserDTO> user = userService.getUserByID(id);
        if (user.isPresent()) {
            return new SuccessResponseDTO<UserDTO>(
                true,
                user.get()
            );
        } else {
            throw new NotFoundException(id);
        }

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
