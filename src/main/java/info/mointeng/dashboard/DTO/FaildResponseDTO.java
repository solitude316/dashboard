package info.mointeng.dashboard.DTO;

public record FaildResponseDTO<T> (
    boolean success,
    T data
) { }