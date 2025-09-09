package info.mointeng.dashboard.Model;

import java.util.UUID;

public record UserDTO(
    UUID id,
    String account,
    String password
) {

}