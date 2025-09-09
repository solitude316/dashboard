package info.mointeng.dashboard.DTO;

public record SuccessResponseDTO<T>(
    boolean success,
    T data
) {
    
}
