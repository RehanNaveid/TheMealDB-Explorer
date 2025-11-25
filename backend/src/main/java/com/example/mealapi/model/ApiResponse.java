package com.example.mealapi.model;

public class ApiResponse<T> {
    private String status;
    private boolean cached;
    private T data;

    public ApiResponse(String status, boolean cached, T data) {
        this.status = status;
        this.cached = cached;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data, boolean cached) {
        return new ApiResponse<>("ok", cached, data);
    }

    public static <T> ApiResponse<T> error(String message) {
        // For error, data could be null or an error object. Let's keep it simple.
        return new ApiResponse<>("error", false, null);
    }

    public String getStatus() {
        return status;
    }

    public boolean isCached() {
        return cached;
    }

    public T getData() {
        return data;
    }
}
